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

import Model.Calificaciones;

public class CalificacionesDao {

    private static final String BASE_URL = "http://localhost:8080/GestionNotasService/Calificaciones/ModuloCalificaciones";

    // Método para listar todas las calificaciones
    public List<Calificaciones> ListadoCalificaciones() {
        Response response = null;
        WebTarget webTarget;
        Client cliente = ClientBuilder.newClient();
        List<Calificaciones> lista = null;
        String responseJson = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            webTarget = cliente.target(BASE_URL + "/ListadoCalificaciones");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            response = invocationBuilder.get();

            if (response.getStatus() != 200) {
                System.out.println("Error al obtener la lista de calificaciones. Código de estado: " + response.getStatus());
            } else {
                responseJson = response.readEntity(String.class);
                lista = objectMapper.readValue(responseJson, new TypeReference<List<Calificaciones>>() {});
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return lista;
    }

    // Método para registrar una nueva calificación
    public void RegistrarCalificacion(Calificaciones calificacion) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/RegistrarCalificacion");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String calificacionJson = objectMapper.writeValueAsString(calificacion);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(calificacionJson));

            if (response.getStatus() == 200) {
                System.out.println("Calificación registrada exitosamente.");
            } else {
                System.out.println("Error al registrar la calificación. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    // Método para buscar una calificación por su ID
    public Calificaciones BuscarCalificacion(int idCalificacion) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/BuscarCalificacion/" + idCalificacion);
        Calificaciones calificacion = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

            if (response.getStatus() == 200) {
                String responseJson = response.readEntity(String.class);
                calificacion = objectMapper.readValue(responseJson, Calificaciones.class);
            } else {
                System.out.println("Error al buscar la calificación. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return calificacion;
    }

    // Método para actualizar una calificación existente
    public void ActualizarCalificacion(Calificaciones calificacion) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/ActualizarCalificacion");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String calificacionJson = objectMapper.writeValueAsString(calificacion);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).put(Entity.json(calificacionJson));

            if (response.getStatus() == 200) {
                System.out.println("Calificación actualizada exitosamente.");
            } else {
                System.out.println("Error al actualizar la calificación. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
