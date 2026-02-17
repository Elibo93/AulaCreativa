package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.FindAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.FindInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.FindTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ThymTemplates;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(WebRoutes.HOME)
public class HomeViewController {

    private final FindAlumnoService findAlumnoService;
    private final FindTallerService findTallerService;
    private final FindProfesorService findProfesorService;
    private final FindInscripcionService findInscripcionService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute(ModelAttribute.ALUMNO_LIST.getName(), findAlumnoService.findAll());
        model.addAttribute(ModelAttribute.TALLER_LIST.getName(), findTallerService.findAll());
        model.addAttribute(ModelAttribute.PROFESOR_LIST.getName(), findProfesorService.findAll());
        model.addAttribute(ModelAttribute.INSCRIPCION_LIST.getName(), findInscripcionService.findAll());
        return ThymTemplates.HOME_VIEW.getPath();
    }
}
