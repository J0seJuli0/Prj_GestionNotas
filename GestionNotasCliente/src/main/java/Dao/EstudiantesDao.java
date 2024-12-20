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

import Model.Estudiantes;

public class EstudiantesDao {

    private static final String BASE_URL = "http://localhost:8080/GestionNotasService/Estudiantes/ModuloEstudiantes";

    // Método para listar todos los estudiantes
    public List<Estudiantes> ListadoEstudiantes() {
        Response response = null;
        WebTarget webTarget;
        Client cliente = ClientBuilder.newClient();
        List<Estudiantes> lista = null;
        String responseJson = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            webTarget = cliente.target(BASE_URL + "/ListadoEstudiantes");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            response = invocationBuilder.get();

            if (response.getStatus() != 200) {
                System.out.println("Error al obtener la lista de estudiantes. Código de estado: " + response.getStatus());
            } else {
                responseJson = response.readEntity(String.class);
                lista = objectMapper.readValue(responseJson, new TypeReference<List<Estudiantes>>() {});
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return lista;
    }

    // Método para registrar un nuevo estudiante
    public void RegistrarEstudiante(Estudiantes estudiante) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/RegistrarEsutudiante");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String estudianteJson = objectMapper.writeValueAsString(estudiante);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(estudianteJson));

            if (response.getStatus() == 200) {
                System.out.println("Estudiante registrado exitosamente.");
            } else {
                System.out.println("Error al registrar el estudiante. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    // Método para buscar un estudiante por su código
    public Estudiantes BuscarEstudiante(int cod) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/BuscarEstudiante/" + cod);
        Estudiantes estudiante = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

            if (response.getStatus() == 200) {
                String responseJson = response.readEntity(String.class);
                estudiante = objectMapper.readValue(responseJson, Estudiantes.class);
            } else {
                System.out.println("Error al buscar el estudiante. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return estudiante;
    }

    // Método para actualizar un estudiante existente
    public void ActualizarEstudiante(Estudiantes estudiante) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/ActualizarEstudiantes");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String estudianteJson = objectMapper.writeValueAsString(estudiante);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).put(Entity.json(estudianteJson));

            if (response.getStatus() == 200) {
                System.out.println("Estudiante actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el estudiante. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
