package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web;

import java.io.OutputStream;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.inscripcion.CreateInscripcionCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.FindAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.CreateInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.DeleteInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.FindInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.FindTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ThymTemplates;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.FragmentoContenido;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InscripcionViewController {

        private final FindInscripcionService findInscripcionService;
        private final CreateInscripcionService createInscripcionService;
        private final DeleteInscripcionService deleteInscripcionService;
        private final FindAlumnoService findAlumnoService;
        private final FindTallerService findTallerService;

        private final TemplateEngine templateEngine;

        @GetMapping(WebRoutes.INSCRIPCIONES_PDF)
        public void exportarPDF(HttpServletResponse response) throws Exception {
                List<Inscripcion> inscripciones = findInscripcionService.findAll();
                Context context = new Context();
                context.setVariable("inscripciones", inscripciones);
                java.util.Map<Integer, Alumno> alumnosMap = findAlumnoService
                                .findAll().stream()
                                .collect(java.util.stream.Collectors.toMap(a -> a.getId().getValue(), a -> a));

                java.util.Map<Integer, Taller> talleresMap = findTallerService
                                .findAll().stream()
                                .collect(java.util.stream.Collectors.toMap(t -> t.getId().getValue(), t -> t));

                context.setVariable("alumnos", alumnosMap);
                context.setVariable("talleres", talleresMap);
                String htmlContent = templateEngine.process(ThymTemplates.INSCRIPCION_LIST_PDF.getPath(), context);
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=inscripciones.pdf");
                OutputStream outputStream = response.getOutputStream();
                ITextRenderer renderer = new ITextRenderer();
                renderer.setDocumentFromString(htmlContent);
                renderer.layout();
                renderer.createPDF(outputStream);

                outputStream.close();
        }

        @GetMapping(WebRoutes.INSCRIPCIONES_BASE)
        public String listar(Model model,
                        @RequestParam(required = false) Integer alumnoId,
                        @RequestParam(required = false) Integer tallerId,
                        @RequestParam(required = false) String successMessage) {

                List<Inscripcion> inscripciones = findInscripcionService.findByCriteria(alumnoId, tallerId);
                model.addAttribute(ModelAttribute.INSCRIPCION_LIST.getName(), inscripciones);
                model.addAttribute("selectedAlumnoId", alumnoId);
                model.addAttribute("selectedTallerId", tallerId);
                java.util.Map<Integer, Alumno> alumnosMap = findAlumnoService
                                .findAll().stream()
                                .collect(java.util.stream.Collectors.toMap(a -> a.getId().getValue(), a -> a));

                java.util.Map<Integer, Taller> talleresMap = findTallerService
                                .findAll().stream()
                                .collect(java.util.stream.Collectors.toMap(t -> t.getId().getValue(), t -> t));

                model.addAttribute("alumnos", alumnosMap);
                model.addAttribute("talleres", talleresMap);
                model.addAttribute("listaAlumnos", findAlumnoService.findAll());
                model.addAttribute("listaTalleres", findTallerService.findAll());

                if (successMessage != null) {
                        model.addAttribute("successMessage", successMessage);
                }

                model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(),
                                FragmentoContenido.INSCRIPCION_LIST.getPath());
                return ThymTemplates.MAIN_LAYOUT.getPath();
        }

        @GetMapping(WebRoutes.INSCRIPCIONES_NUEVA)
        public String formulario(Model model) {
                model.addAttribute(ModelAttribute.SINGLE_INSCRIPCION.getName(), Inscripcion.builder().build());
                model.addAttribute(ModelAttribute.ALUMNO_LIST.getName(), findAlumnoService.findAll());
                model.addAttribute(ModelAttribute.TALLER_LIST.getName(), findTallerService.findAll());
                model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(),
                                FragmentoContenido.INSCRIPCION_FORM.getPath());
                return ThymTemplates.MAIN_LAYOUT.getPath();
        }

        @PostMapping(WebRoutes.INSCRIPCIONES_NUEVA)
        public String crearInscripcion(@RequestParam Integer idAlumno,
                        @RequestParam Integer idTaller,
                        RedirectAttributes redirectAttributes) {

                createInscripcionService.createInscripcion(
                                new CreateInscripcionCommand(new AlumnoId(idAlumno), new TallerId(idTaller)));

                redirectAttributes.addFlashAttribute(
                                "successMessage",
                                "Inscripcion creada correctamente");

                return "redirect:" + WebRoutes.INSCRIPCIONES_BASE;
        }

        @PostMapping(WebRoutes.INSCRIPCIONES_ELIMINAR)
        @ResponseBody
        public ResponseEntity<String> borrar(@PathVariable Integer id, RedirectAttributes redirectAttributes,
                        HttpServletRequest request) {

                deleteInscripcionService.delete(new InscripcionId(id));

                if ("true".equals(request.getHeader("HX-Request"))) {
                        return ResponseEntity.ok("");
                }

                redirectAttributes.addFlashAttribute(
                                "successMessage",
                                "Inscripcion eliminada correctamente");

                return ResponseEntity.status(302)
                                .header("Location", WebRoutes.INSCRIPCIONES_BASE)
                                .build();
        }
}
