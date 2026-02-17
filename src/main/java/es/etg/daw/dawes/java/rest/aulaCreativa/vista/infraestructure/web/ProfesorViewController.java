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
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfesorViewController {

    private final FindProfesorService findProfesorService;
    private final CreateProfesorService createProfesorService;
    private final DeleteProfesorService deleteProfesorService;
    private final EditProfesorService editProfesorService;

    private final TemplateEngine templateEngine; // Motor de Thymeleaf

    @GetMapping(WebRoutes.PROFESORES_BASE)
    public String listar(Model model) {
        model.addAttribute(ModelAttribute.PROFESOR_LIST.getName(), findProfesorService.findAll());
        return ThymTemplates.PROFESOR_LIST.getPath();
    }

    @GetMapping(WebRoutes.PROFESORES_NUEVO)
    public String formulario(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_PROFESOR.getName(), Profesor.builder().build());
        return ThymTemplates.PROFESOR_FORM.getPath();
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

        // Solo permitimos editar campos específicos como especialidad, email o teléfono
        editProfesorService.update(
                new EditProfesorCommand(new ProfesorId(id), especialidad, email, telefono));

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Profesor editado correctamente");

        return "redirect:" + WebRoutes.PROFESORES_BASE;
    }

    @PostMapping(WebRoutes.PROFESORES_ELIMINAR)
    public String borrar(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

        try {
            deleteProfesorService.delete(new ProfesorId(id));
            redirectAttributes.addFlashAttribute("successMessage", "Profesor eliminado correctamente");
        } catch (Exception e) {
            // Capturamos el error genérico (suele ser por claves foráneas) para mostrar un
            // mensaje amigable al usuario
            redirectAttributes.addFlashAttribute("errorMessage",
                    "No se puede eliminar el profesor porque tiene talleres asignados.");
        }

        return "redirect:" + WebRoutes.PROFESORES_BASE;
    }

    @GetMapping(WebRoutes.PROFESORES_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        // Obtengo los datos
        List<Profesor> profesores = findProfesorService.findAll();

        // Preparar el contexto de Thymeleaf
        Context context = new Context();
        context.setVariable("profesores", profesores);

        // Generar el HTML procesado
        String htmlContent = templateEngine.process(ThymTemplates.PROFESOR_LIST_PDF.getPath(), context);

        // Preparar la respuesta para PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=profesores.pdf");

        // Generar el PDF final
        OutputStream outputStream = response.getOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
