package Dao;

import Model.Padre;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class PadresDao {

    private static final String BASE_URI = "http://localhost:8080/GestionNotasService/Padres/ModuloPadres"; 
    private Client client;
    private WebTarget webTarget;

    public PadresDao() {
        this.client = ClientBuilder.newClient();
        this.webTarget = client.target(BASE_URI);
    }

    // Método para obtener el listado de padres
    public List<Padre> ListadoPadres() {
        Response response = null;
        List<Padre> lista = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Realiza una solicitud GET al endpoint de listado de padres
            response = webTarget.path("/ListadoPadres").request(MediaType.APPLICATION_JSON).get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String responseJson = response.readEntity(String.class);
                lista = objectMapper.readValue(responseJson, new TypeReference<List<Padre>>() {});
            } else {
                System.out.println("Error al obtener los padres: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return lista;
    }

    // Método para registrar un nuevo padre
    public Padre RegistrarPadre(Padre padre) {
        Response response = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Realiza una solicitud POST para registrar un nuevo padre
            String padreJson = objectMapper.writeValueAsString(padre);
            response = webTarget.path("/RegistrarPadre")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(padreJson, MediaType.APPLICATION_JSON));

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                return response.readEntity(Padre.class);
            } else {
                System.out.println("Error al registrar el padre: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    // Método para actualizar un padre
    public Padre ActualizarPadre(Padre padre) {
        Response response = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Realiza una solicitud PUT para actualizar un padre
            String padreJson = objectMapper.writeValueAsString(padre);
            response = webTarget.path("/ActualizarPadres")
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.entity(padreJson, MediaType.APPLICATION_JSON));

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                return response.readEntity(Padre.class);
            } else {
                System.out.println("Error al actualizar el padre: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

    // Método para buscar un padre por su ID
    public Padre BuscarPadre(int idPadre) {
        Response response = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Realiza una solicitud GET para buscar un padre por ID
            response = webTarget.path("/BuscarPadre/{cod}")
                    .resolveTemplate("cod", idPadre)
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String responseJson = response.readEntity(String.class);
                return objectMapper.readValue(responseJson, Padre.class);
            } else {
                System.out.println("Padre no encontrado o error en la solicitud: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }
}
