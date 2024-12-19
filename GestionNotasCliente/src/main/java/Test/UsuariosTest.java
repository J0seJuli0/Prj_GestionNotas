package Test;

import java.util.List;

import Dao.UsuarioDao;
import Model.Usuarios;

public class UsuariosTest {

	public static void main(String[] args) {
		UsuarioDao usuariosDao = new UsuarioDao();

		/*
		List<Usuarios> usuarios = usuariosDao.ListadoUsuarios();
		if (usuarios != null) {
		    for (Usuarios usuario : usuarios) {
		        System.out.println("ID: " + usuario.getIdUsuario());
		        System.out.println("Usuario: " + usuario.getUsuario());
		        System.out.println("Tipo Usuario: " + usuario.getTipoUsuario());
		        System.out.println("-----------------------------");
		    }
		}
		*/
		 String usuario = "admin";
	        String password = "123456";

	        // Llamamos al método de iniciar sesión
	        boolean sessionIniciada = usuariosDao.IniciarSession(usuario, password);

	        // Comprobamos el resultado
	        if (sessionIniciada) {
	            System.out.println("Inicio de sesión exitoso.");
	        } else {
	            System.out.println("Error en el inicio de sesión.");
	        }
	}

}
