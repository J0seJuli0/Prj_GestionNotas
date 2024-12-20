package Dao;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Cursos;

public class CursosDao {

    private static final String BASE_URL = "http://localhost:8080/GestionNotasService/Cursos/ModuloCursos";

    // Método para listar todos los cursos
    public List<Cursos> ListadoCursos() {
        Response response = null;
        WebTarget webTarget;
        Client cliente = ClientBuilder.newClient();
        List<Cursos> lista = null;
        String responseJson = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            webTarget = cliente.target(BASE_URL + "/ListadoCursos");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            response = invocationBuilder.get();

            if (response.getStatus() != 200) {
                System.out.println("Error al obtener la lista de cursos. Código de estado: " + response.getStatus());
            } else {
                responseJson = response.readEntity(String.class);
                lista = objectMapper.readValue(responseJson, new TypeReference<List<Cursos>>() {});
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return lista;
    }

    // Método para registrar un nuevo curso
    public void RegistrarCurso(Cursos curso) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/RegistrarCursos");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String cursoJson = objectMapper.writeValueAsString(curso);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(cursoJson));

            if (response.getStatus() == 200) {
                System.out.println("Curso registrado exitosamente.");
            } else {
                System.out.println("Error al registrar el curso. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    // Método para buscar un curso por su código
    public Cursos BuscarCurso(int cod) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/BuscarCursos/" + cod);
        Cursos curso = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

            if (response.getStatus() == 200) {
                String responseJson = response.readEntity(String.class);
                curso = objectMapper.readValue(responseJson, Cursos.class);
            } else {
                System.out.println("Error al buscar el curso. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return curso;
    }

    // Método para actualizar un curso existente
    public void ActualizarCurso(Cursos curso) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/ActualizarCursos");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String cursoJson = objectMapper.writeValueAsString(curso);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).put(Entity.json(cursoJson));

            if (response.getStatus() == 200) {
                System.out.println("Curso actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el curso. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
