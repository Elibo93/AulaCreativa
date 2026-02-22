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

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.CreateProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.DeleteProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.EditProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ThymTemplates;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.FragmentoContenido;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfesorViewController {

    private final FindProfesorService findProfesorService;
    private final CreateProfesorService createProfesorService;
    private final DeleteProfesorService deleteProfesorService;
    private final EditProfesorService editProfesorService;

    private final TemplateEngine templateEngine;

    @GetMapping(WebRoutes.PROFESORES_BASE)
    public String listar(Model model) {
        model.addAttribute(ModelAttribute.PROFESOR_LIST.getName(), findProfesorService.findAll());
        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.PROFESOR_LIST.getPath());
        return ThymTemplates.MAIN_LAYOUT.getPath();
    }

    @GetMapping(WebRoutes.PROFESORES_NUEVO)
    public String formulario(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_PROFESOR.getName(), Profesor.builder().build());
        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.PROFESOR_FORM.getPath());
        return ThymTemplates.MAIN_LAYOUT.getPath();
    }

    @PostMapping(WebRoutes.PROFESORES_NUEVO)
    public String crearProfesor(@RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String especialidad,
            @RequestParam String email,
            @RequestParam String telefono,
            RedirectAttributes redirectAttributes) {

        createProfesorService.createProfesor(
                new CreateProfesorCommand(nombre, apellido, especialidad, email, telefono));

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Profesor creado correctamente");

        return "redirect:" + WebRoutes.PROFESORES_BASE;
    }

    @PostMapping(WebRoutes.PROFESORES_EDITAR)
    public String editarProfesor(@PathVariable Integer id,
            @RequestParam String especialidad,
            @RequestParam String email,
            @RequestParam String telefono,
            RedirectAttributes redirectAttributes) {
        editProfesorService.update(
                new EditProfesorCommand(new ProfesorId(id), especialidad, email, telefono));

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Profesor editado correctamente");

        return "redirect:" + WebRoutes.PROFESORES_BASE;
    }

    @PostMapping(WebRoutes.PROFESORES_ELIMINAR)
    @ResponseBody
    public ResponseEntity<String> borrar(@PathVariable Integer id, RedirectAttributes redirectAttributes,
            HttpServletRequest request) {

        try {
            deleteProfesorService.delete(new ProfesorId(id));

            if ("true".equals(request.getHeader("HX-Request"))) {
                return ResponseEntity.ok("");
            }

            redirectAttributes.addFlashAttribute("successMessage", "Profesor eliminado correctamente");
        } catch (Exception e) {
            if ("true".equals(request.getHeader("HX-Request"))) {
                return ResponseEntity.unprocessableEntity()
                        .body("<div class='toast error'><span>No se puede eliminar: tiene talleres asignados.</span></div>");
            }
            redirectAttributes.addFlashAttribute("errorMessage",
                    "No se puede eliminar el profesor porque tiene talleres asignados.");
        }

        return ResponseEntity.status(302)
                .header("Location", WebRoutes.PROFESORES_BASE)
                .build();
    }

    @GetMapping(WebRoutes.PROFESORES_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {
        List<Profesor> profesores = findProfesorService.findAll();
        Context context = new Context();
        context.setVariable("profesores", profesores);
        String htmlContent = templateEngine.process(ThymTemplates.PROFESOR_LIST_PDF.getPath(), context);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=profesores.pdf");
        OutputStream outputStream = response.getOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
