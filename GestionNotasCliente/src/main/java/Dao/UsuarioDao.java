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

import Model.Usuarios;

public class UsuarioDao {

    private static final String BASE_URL = "http://localhost:8080/GestionNotasService/Usuarios/MOduloUsuarios";

    public List<Usuarios> ListadoUsuarios() {
        Response response = null;
        WebTarget webTarget;
        Client cliente = ClientBuilder.newClient();
        List<Usuarios> lista = null;
        String responseJson = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            webTarget = cliente.target(BASE_URL + "/ListadoUsuarios");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            response = invocationBuilder.get();

            if (response.getStatus() != 200) {
                System.out.println("Error al obtener la lista de usuarios. Código de estado: " + response.getStatus());
            } else {
                responseJson = response.readEntity(String.class);
                lista = objectMapper.readValue(responseJson, new TypeReference<List<Usuarios>>() {});
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
        return lista;
    }

    public void RegistrarUsuario(Usuarios usuario) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/RegistrarUsuarios");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String usuarioJson = objectMapper.writeValueAsString(usuario);
            Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(usuarioJson));

            if (response.getStatus() == 200) {
                System.out.println("Usuario registrado exitosamente.");
            } else {
                System.out.println("Error al registrar el usuario. Código de estado: " + response.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
        }
    }

    public boolean IniciarSession(String user, String password) {
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target(BASE_URL + "/Acceso")
                .queryParam("user", user)
                .queryParam("password", password);

        try {
            Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

            if (response.getStatus() == 200) {
                System.out.println("Inicio de sesión exitoso.");
                return true;
            } else {
                System.out.println("Error al iniciar sesión. Código de estado: " + response.getStatus());
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la solicitud: " + e.getMessage());
            return false;
        }
    }
}
