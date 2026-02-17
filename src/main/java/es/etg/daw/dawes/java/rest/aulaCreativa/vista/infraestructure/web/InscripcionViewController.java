package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web;

import java.io.OutputStream;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InscripcionViewController {

    private final FindInscripcionService findInscripcionService;
    private final CreateInscripcionService createInscripcionService;
    private final DeleteInscripcionService deleteInscripcionService;
    private final FindAlumnoService findAlumnoService;
    private final FindTallerService findTallerService;

    private final TemplateEngine templateEngine; // Motor de Thymeleaf

    @GetMapping(WebRoutes.INSCRIPCIONES_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        // Obtengo los datos
        List<Inscripcion> inscripciones = findInscripcionService.findAll();

        // Preparar el contexto de Thymeleaf
        Context context = new Context();
        context.setVariable("inscripciones", inscripciones);

        // Mapas para resolver nombres en el PDF
        java.util.Map<Integer, Alumno> alumnosMap = findAlumnoService
                .findAll().stream()
                .collect(java.util.stream.Collectors.toMap(a -> a.getId().getValue(), a -> a));

        java.util.Map<Integer, Taller> talleresMap = findTallerService
                .findAll().stream()
                .collect(java.util.stream.Collectors.toMap(t -> t.getId().getValue(), t -> t));

        context.setVariable("alumnos", alumnosMap);
        context.setVariable("talleres", talleresMap);

        // Generar el HTML procesado
        String htmlContent = templateEngine.process(ThymTemplates.INSCRIPCION_LIST_PDF.getPath(), context);

        // Preparar la respuesta para PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=inscripciones.pdf");

        // Generar el PDF final
        OutputStream outputStream = response.getOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }

    @GetMapping(WebRoutes.INSCRIPCIONES_BASE)
    public String listar(Model model, @RequestParam(required = false) String successMessage) {
        model.addAttribute(ModelAttribute.INSCRIPCION_LIST.getName(), findInscripcionService.findAll());

        // Mapas para resolver nombres en la vista desde los IDs
        java.util.Map<Integer, Alumno> alumnosMap = findAlumnoService
                .findAll().stream()
                .collect(java.util.stream.Collectors.toMap(a -> a.getId().getValue(), a -> a));

        java.util.Map<Integer, Taller> talleresMap = findTallerService
                .findAll().stream()
                .collect(java.util.stream.Collectors.toMap(t -> t.getId().getValue(), t -> t));

        model.addAttribute("alumnos", alumnosMap);
        model.addAttribute("talleres", talleresMap);

        // Listas para los desplegables del modal de edición
        model.addAttribute("listaAlumnos", findAlumnoService.findAll());
        model.addAttribute("listaTalleres", findTallerService.findAll());

        if (successMessage != null) {
            model.addAttribute("successMessage", successMessage);
        }

        return ThymTemplates.INSCRIPCION_LIST.getPath();
    }

    @GetMapping(WebRoutes.INSCRIPCIONES_NUEVA)
    public String formulario(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_INSCRIPCION.getName(), Inscripcion.builder().build());
        model.addAttribute(ModelAttribute.ALUMNO_LIST.getName(), findAlumnoService.findAll());
        model.addAttribute(ModelAttribute.TALLER_LIST.getName(), findTallerService.findAll());
        return ThymTemplates.INSCRIPCION_FORM.getPath();
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
    public String borrar(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

        deleteInscripcionService.delete(new InscripcionId(id));

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Inscripcion eliminada correctamente");

        return "redirect:" + WebRoutes.INSCRIPCIONES_BASE;
    }
}
