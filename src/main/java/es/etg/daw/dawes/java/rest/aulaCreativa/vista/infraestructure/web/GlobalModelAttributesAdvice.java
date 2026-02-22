package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants.WebRoutes;

@ControllerAdvice
public class GlobalModelAttributesAdvice {

    @ModelAttribute("currentUri")
    public String currentUri(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @ModelAttribute("showBack")
    public boolean showBack(HttpServletRequest request) {
        String uri = request.getRequestURI();
        // Solo ocultamos el botón de volver en la home
        return !WebRoutes.HOME.equals(uri) && !"/".equals(uri);
    }
}
