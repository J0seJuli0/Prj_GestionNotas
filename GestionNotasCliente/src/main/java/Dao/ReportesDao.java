package Dao;

import Model.Reportes;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class ReportesDao {

    private static final String BASE_URL = "http://localhost:8080/GestionNotasService/Reportes/ModuloReportes";
    private Client client;
    private WebTarget webTarget;

    public ReportesDao() {
        this.client = ClientBuilder.newClient();
        this.webTarget = client.target(BASE_URL);
    }

    // Método para listar todos los reportes
    public List<Reportes> ListadoReportes() {
        try {
            // Realiza una solicitud GET al endpoint de listado de reportes
            Response response = webTarget.path("/ListadoReportes").request(MediaType.APPLICATION_JSON).get();
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                // Convertir el cuerpo de la respuesta en una lista de Reportes
                String responseJson = response.readEntity(String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(responseJson, new TypeReference<List<Reportes>>() {});
            } else {
                System.out.println("Error al obtener los reportes: " + response.getStatus());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para registrar un nuevo reporte
    public void RegistrarReporte(Reportes reporte) {
        try {
            // Realiza una solicitud POST para registrar un nuevo reporte
            ObjectMapper objectMapper = new ObjectMapper();
            String reporteJson = objectMapper.writeValueAsString(reporte);
            Response response = webTarget.path("/RegistrarReporte")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(reporteJson));

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Reporte registrado exitosamente.");
            } else {
                System.out.println("Error al registrar el reporte: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un reporte
    public void ActualizarReporte(Reportes reporte) {
        try {
            // Realiza una solicitud PUT para actualizar un reporte
            ObjectMapper objectMapper = new ObjectMapper();
            String reporteJson = objectMapper.writeValueAsString(reporte);
            Response response = webTarget.path("/ActualizarReporte")
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.json(reporteJson));

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Reporte actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el reporte: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un reporte por su ID
    public void EliminarReporte(int cod) {
        try {
            // Realiza una solicitud DELETE para eliminar un reporte
            Response response = webTarget.path("/EliminarReporte")
                    .queryParam("cod", cod)
                    .request(MediaType.APPLICATION_JSON)
                    .delete();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Reporte eliminado exitosamente.");
            } else {
                System.out.println("Error al eliminar el reporte: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un reporte por su ID
    public Reportes BuscarReporte(int cod) {
        try {
            // Realiza una solicitud GET para buscar un reporte por ID
            Response response = webTarget.path("/BuscarReporte/{cod}")
                    .resolveTemplate("cod", cod)
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String responseJson = response.readEntity(String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(responseJson, Reportes.class);
            } else {
                System.out.println("Reporte no encontrado o error en la solicitud: " + response.getStatus());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
