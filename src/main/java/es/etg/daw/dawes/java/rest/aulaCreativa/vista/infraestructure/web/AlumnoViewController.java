package es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web;

import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.FindAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;

import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.aulaCreativa.vista.infraestructure.web.enums.ThymTemplates;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@RequestMapping(WebRoutes.PRODUCTOS_BASE)
public class AlumnoViewController {
    
    private final FindAlumnoService findAlumnoService;
    private final CreateAlumnoService createAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;

    private final TemplateEngine templateEngine; // Motor de Thymeleaf

    // Carga la vista de la lista de alumnos http://localhost:8082/web/alumnos
    @GetMapping(WebRoutes.ALUMNOS_BASE)
    public String listar(Model model) {
        model.addAttribute(ModelAttribute.ALUMNO_LIST.getName(), findAlumnoService.findAll());
        return ThymTemplates.ALUMNO_LIST.getPath(); // Busca alumnos-lista.html
    }

    // Carga la vista del formulario http://localhost:8082/web/alumnos/nuevo
    @GetMapping(WebRoutes.ALUMNOS_NUEVO)
    public String formulario(Model model) {

        model.addAttribute(ModelAttribute.SINGLE_ALUMNO.getName(), new Alumno());
        
        return ThymTemplates.ALUMNO_FORM.getPath(); //Devuelvo la vista que carga el formulario
    }

    // Este método crea el alumno y devuelve la vista del mensaje de creado
    @PostMapping(WebRoutes.ALUMNOS_NUEVO)
    public String crearAlumno(@RequestParam String dni,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String email,
            @RequestParam String telefono,
            @RequestParam String direccion,
            @RequestParam String fechaNacimiento,
            Model model){
            
            createAlumnoService.createAlumno(new CreateAlumnoCommand(dni, nombre, apellido, email, telefono, direccion, fechaNacimiento));
        
        return ThymTemplates.ALUMNO_CREATED.getPath();
    }

    // Carga la vista del formulario http://localhost:8082/web/alumnos/eliminar
    @GetMapping(WebRoutes.ALUMNOS_ELIMINAR)
    public String formularioDelete(Model model) {

        // Agrego un atributo con el nombre "alumno" y con los datos vacíos, este alumno se rellenará con los datos de la vista.
        // es necesario que Alumno tenga el constructor vacío: @NoArgsConstructor
        model.addAttribute(ModelAttribute.SINGLE_ALUMNO.getName(), new Alumno());

        return ThymTemplates.ALUMNO_FORM_DELETE.getPath(); //Devuelvo la vista que carga el formulario
    }

    // Este método elimina un alumno y devuelve la vista del mensaje eliminado
    @PostMapping(WebRoutes.ALUMNOS_ELIMINAR)
    public String borrar(@RequestParam Integer id, Model model) {
        deleteAlumnoService.delete(new AlumnoId(id));
        return ThymTemplates.ALUMNO_DELETED.getPath();
    }

     //Listado de Alumnos http://localhost:8082/web/alumnos/pdf
    @GetMapping(WebRoutes.ALUMNOS_PDF)
    public void exportarPDF(HttpServletResponse response) throws Exception {

        //Obtengo los datos
        List<Alumno> alumnos = findAlumnoService.findAll();

        //Preparar el contexto de Thymeleaf
        Context context = new Context();
        context.setVariable("alumnos", alumnos);

        //Ya tengo los datos en el contexto de Thymeleaf, ahora le doy la plantilla para que me devuelva
        //  la plantilla con los datos rellenos (el mismo html que estamos devolviendo al usuario pero ahora lo meto en un String).
        String htmlContent = templateEngine.process(ThymTemplates.ALUMNO_LIST_PDF.getPath(), context);

        //Preparo la respuesta diciendole que voy a devolver un pdf
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=alumnos.pdf");

        //Llamo a Flying Saurce y le paso el html para que lo transforme en pdf
        //  el html tiene que estar bien formado (xhtml) o fallará el proceso, cuidado con la plantilla
        OutputStream outputStream = response.getOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent); //Le paso además donde están los archivos css (ruta a la carpeta static)
        renderer.layout();
        renderer.createPDF(outputStream);
        
        outputStream.close();
    }
}
