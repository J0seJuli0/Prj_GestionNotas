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

import Model.Docentes;

public class DocentesDao {

    private static final String BASE_URL = "http://localhost:8080/GestionNotasService/Docentes/ModuloDocentes";

    // Método para listar todos los docentes
    public List<Docentes> ListadoDocentes() {
        Response response = null;
        WebTarget webTarget;
        Client cliente = ClientBuilder.newClient();
        List<Docentes> lista = null;
        String responseJson = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            webTarget = cliente.target(BASE_URL + "/ListadoDocentes");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            response = invocationBuilder.get();

            if (response.getStatus() != 200) {
                System.out.println("Error al obtener la lista de docentes. Código de estado: " + response.getStatus());
            } else {
                responseJson = response.readEntity(String.class);
                lista = objectMapper.readValue(responseJson, new TypeReference<List<Docentes>>() {});
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return lista;
    }

    // Método para registrar un nuevo docente
    public void RegistrarDocente(Docentes docente) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/RegistrarDocente");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String docenteJson = objectMapper.writeValueAsString(docente);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(docenteJson));

            if (response.getStatus() == 200) {
                System.out.println("Docente registrado exitosamente.");
            } else {
                System.out.println("Error al registrar el docente. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    // Método para buscar un docente por su código
    public Docentes BuscarDocente(int cod) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/BuscarDocentes/" + cod);
        Docentes docente = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

            if (response.getStatus() == 200) {
                String responseJson = response.readEntity(String.class);
                docente = objectMapper.readValue(responseJson, Docentes.class);
            } else {
                System.out.println("Error al buscar el docente. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return docente;
    }

    // Método para actualizar un docente existente
    public void ActualizarDocente(Docentes docente) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/ActualizarDocentes");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String docenteJson = objectMapper.writeValueAsString(docente);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).put(Entity.json(docenteJson));

            if (response.getStatus() == 200) {
                System.out.println("Docente actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el docente. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
