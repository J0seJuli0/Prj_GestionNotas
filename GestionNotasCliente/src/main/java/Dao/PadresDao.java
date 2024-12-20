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

    // Metodo para obtener el listado de padres
    public List<Padre> ListadoPadres() {
        Response response = null;
        WebTarget webtarget;
		Client cliente = ClientBuilder.newClient();
        List<Padre> lista = null;
        String responsejson = null;
		ObjectMapper objmap = new ObjectMapper();
        try {
        	webtarget = cliente.target("http://localhost:8080/GestionNotasService/Padres/ModuloPadres/ListadoPadres");
            // Realiza una solicitud GET al endpoint de listado de padres
        	Invocation.Builder invocationbuilder=webtarget.request(MediaType.APPLICATION_JSON);
			response = invocationbuilder.get();
			if(response.getStatus()!=200) {
				System.out.println("fuera de rango");
			}
			responsejson = response.readEntity(String.class);
			lista = objmap.readValue(responsejson, new TypeReference<List<Padre>>() {});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        return lista;
    }

    // Metodo para registrar un nuevo padre
    public void RegistrarPadre(Padre padre) {
    	Client clienteJersey = ClientBuilder.newClient();
        WebTarget webTarget = clienteJersey.target("http://localhost:8080/GestionNotasService/Padres/ModuloPadreshttp://localhost:8080/GestionNotasService/Padres/ModuloPadres/RegistrarPadre");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Realiza una solicitud POST para registrar un nuevo padre
            String clienteJson = objectMapper.writeValueAsString(padre);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(clienteJson));

            if (response.getStatus() == 200) {
                System.out.println("Padre creado exitosamente");
            } else {
                System.out.println("Error al crear el padre. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    // Mettodo para actualizar un padre
    public void ActualizarPadre(Padre padre) {
    	Client clienteJersey = ClientBuilder.newClient();
        WebTarget webTarget = clienteJersey.target("http://localhost:8080/GestionNotasService/Padres/ModuloPadres/ActualizarPadres");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String clienteJson = objectMapper.writeValueAsString(padre);
            Response response = webTarget.request().put(Entity.json(clienteJson));

            if (response.getStatus() == 200) {
                System.out.println("Padre actualizado exitosamente");
            } else {
                System.out.println("Error al actualizar el padre. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    // MÃ©todo para buscar un padre por su ID
    public Padre BuscarPadre(int idPadre) {
    	Client clienteJersey = ClientBuilder.newClient();
        WebTarget webTarget = clienteJersey.target("http://localhost:8080/GestionNotasService/Padres/ModuloPadreshttp://localhost:8080/GestionNotasService/Padres/ModuloPadres/BuscarPadre/" + idPadre);

        try {
            Response response = webTarget.request().get();

            if (response.getStatus() == 200) {
                String clienteJson = response.readEntity(String.class);
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(clienteJson, Padre.class);
            } else {
                System.out.println("Padre no encontrado. Código de estado: " + response.getStatus());
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
            return null;
        }
    }
}
