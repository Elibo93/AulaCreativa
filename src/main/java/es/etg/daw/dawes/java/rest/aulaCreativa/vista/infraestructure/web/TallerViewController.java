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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.CreateTallerCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.CreateTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.FindTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ThymTemplates;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TallerViewController {

    private final FindTallerService findTallerService;
    private final CreateTallerService createTallerService;
    private final FindProfesorService findProfesorService; // Para el desplegable de profesores

    private final TemplateEngine templateEngine; // Motor de Thymeleaf

    @GetMapping(WebRoutes.TALLERES_BASE)
    public String listar(Model model) {
        model.addAttribute(ModelAttribute.TALLER_LIST.getName(), findTallerService.findAll());
        return ThymTemplates.TALLER_LIST.getPath();
    }

    @GetMapping(WebRoutes.TALLERES_NUEVO)
    public String formulario(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_TALLER.getName(), Taller.builder().build());
        // Pasamos la lista de profesores para asignar responsable
        model.addAttribute(ModelAttribute.PROFESOR_LIST.getName(), findProfesorService.findAll());
        return ThymTemplates.TALLER_FORM.getPath();
    }

    @PostMapping(WebRoutes.TALLERES_NUEVO)
    public String crearTaller(@RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam Integer idProfesor,
            @RequestParam String horaInicio,
            @RequestParam String horaFin,
            @RequestParam Integer aforoMaximo,
            RedirectAttributes redirectAttributes) {

        createTallerService.createTaller(
                new CreateTallerCommand(nombre, descripcion, new ProfesorId(idProfesor), horaInicio, horaFin,
                        aforoMaximo));

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Taller creado correctamente");

        return "redirect:" + WebRoutes.TALLERES_BASE;
    }

    @GetMapping(WebRoutes.TALLERES_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        // Obtengo los datos
        List<Taller> talleres = findTallerService.findAll();

        // Preparar el contexto de Thymeleaf
        Context context = new Context();
        context.setVariable("talleres", talleres);

        // Generar el HTML procesado
        String htmlContent = templateEngine.process(ThymTemplates.TALLER_LIST_PDF.getPath(), context);

        // Preparar la respuesta para PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=talleres.pdf");

        // Generar el PDF final
        OutputStream outputStream = response.getOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
