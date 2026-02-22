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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.DeleteTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import org.springframework.web.bind.annotation.PathVariable;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.CreateTallerCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.CreateTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.FindTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ThymTemplates;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.FragmentoContenido;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TallerViewController {

    private final FindTallerService findTallerService;
    private final CreateTallerService createTallerService;
    private final DeleteTallerService deleteTallerService;
    private final FindProfesorService findProfesorService;

    private final TemplateEngine templateEngine;

    @GetMapping(WebRoutes.TALLERES_BASE)
    public String listar(Model model, @RequestParam(required = false) String successMessage) {
        model.addAttribute(ModelAttribute.TALLER_LIST.getName(), findTallerService.findAll());
        model.addAttribute(ModelAttribute.PROFESOR_LIST.getName(), findProfesorService.findAll());
        if (successMessage != null) {
            model.addAttribute("successMessage", successMessage);
        }
        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.TALLER_LIST.getPath());
        return ThymTemplates.MAIN_LAYOUT.getPath();
    }

    @GetMapping(WebRoutes.TALLERES_NUEVO)
    public String formulario(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_TALLER.getName(), Taller.builder().build());
        model.addAttribute(ModelAttribute.PROFESOR_LIST.getName(), findProfesorService.findAll());
        model.addAttribute(ModelAttribute.FRAGMENTO_CONTENIDO.getName(), FragmentoContenido.TALLER_FORM.getPath());
        return ThymTemplates.MAIN_LAYOUT.getPath();
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

    @PostMapping(WebRoutes.TALLERES_ELIMINAR)
    @ResponseBody
    public ResponseEntity<String> borrar(@PathVariable Integer id, RedirectAttributes redirectAttributes,
            HttpServletRequest request) {

        deleteTallerService.delete(new TallerId(id));

        if ("true".equals(request.getHeader("HX-Request"))) {
            return ResponseEntity.ok("");
        }

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Taller eliminado correctamente");

        return ResponseEntity.status(302)
                .header("Location", WebRoutes.TALLERES_BASE)
                .build();
    }

    @GetMapping(WebRoutes.TALLERES_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {
        List<Taller> talleres = findTallerService.findAll();
        Context context = new Context();
        context.setVariable("talleres", talleres);
        String htmlContent = templateEngine.process(ThymTemplates.TALLER_LIST_PDF.getPath(), context);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=talleres.pdf");
        OutputStream outputStream = response.getOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }
}
