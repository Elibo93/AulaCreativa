package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.rest;



import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.alumno.AlumnoFactory;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno.AlumnoRequest;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno.AlumnoResponse;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AlumnoControllerTest {

    public static String ENDPOINT = "/api/v1/alumnos";

    // Json
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<AlumnoRequest> jsonAlumnoRequest;

    @Autowired
    private JacksonTester<AlumnoResponse> jsonAlumnoResponse;


    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    
    @Test
    @Order(1)
    public void When_Get_AllAlumnos_Expect_Lista() throws Exception {

        int numAlumnos = AlumnoFactory.getDemoData().values().size();

        MockHttpServletResponse response = mockMvc.perform(
                get(ENDPOINT).accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<AlumnoResponse> res = mapper.readValue(response.getContentAsString(),
                mapper.getTypeFactory().constructCollectionType(List.class, AlumnoResponse.class));

        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.OK.value()),
                () -> assertTrue(res.size() == numAlumnos));
    }

    @Test
    @Order(10)
    public void When_Post_CreateAlumno() throws Exception {
        Alumno nuevo = AlumnoFactory.create();

        AlumnoRequest req = new AlumnoRequest(nuevo);

         MockHttpServletResponse response = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        // Le paso el body
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

            AlumnoResponse res =mapper.readValue(response.getContentAsString(), AlumnoResponse.class);


        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.CREATED.value()),
                () -> assertEquals(res.nombre(), nuevo.getNombre()),
                () -> assertEquals(res.apellido(), nuevo.getApellido()),
                () -> assertEquals(res.email(), nuevo.getEmail()),
                () -> assertTrue(res.id()> 0)
        );
    }

    
    @Test
    @Order(11)
    public void Error_Validation_When_CreateAlumno_EmptyNombre() throws Exception {
        Alumno nuevo = AlumnoFactory.create();  

        nuevo.setNombre(null);

        AlumnoRequest req = new AlumnoRequest(nuevo);
               
        MockHttpServletResponse response = mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    
    @Order(20)
    public void When_Put_EditAlumno() throws Exception {

        Alumno editado = AlumnoFactory.create();
        editado.setId(new AlumnoId(1)); // Indicamos que editamos el alumno 1

        AlumnoRequest req = new AlumnoRequest(editado);

         MockHttpServletResponse response = mockMvc.perform(
                put(ENDPOINT + "/" + editado.getId().getValue())
                        .contentType(MediaType.APPLICATION_JSON)
                        // Le paso el body
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

            AlumnoResponse res = mapper.readValue(response.getContentAsString(), AlumnoResponse.class);
        

        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatus()),
                () -> assertEquals(res.nombre(), req.nombre()),
                () -> assertEquals(res.apellido(), req.apellido()),
                () -> assertEquals(res.email(), req.email()),
                () -> assertEquals(res.id(), editado.getId().getValue()));
        
    }

    @Test
    @Order(30)
    public void When_Delete_DeleteAlumno() throws Exception {

        Alumno nuevo = AlumnoFactory.create();
        nuevo.setId(new AlumnoId(1)); 

        AlumnoRequest req = new AlumnoRequest(nuevo);

        MockHttpServletResponse response = mockMvc.perform(
                delete(ENDPOINT + "/" + nuevo.getId().getValue())
                        .contentType(MediaType.APPLICATION_JSON)
                        // Le paso el body
                        .content(jsonAlumnoRequest.write(req).getJson())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.NO_CONTENT.value());
    }
}

