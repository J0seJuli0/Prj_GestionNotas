package TestImp;

import java.util.List;

import Implement.UsuariosImplement;
import Model.Usuarios;

public class TestUsuarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuariosImplement impl = new UsuariosImplement();
		
		/*TEST LISTAR
		List<Usuarios> usu = impl.ListarUsuarios();
		
		if (usu!= null && !usu.isEmpty()) {
			for (Usuarios usua : usu ){
				System.out.println("Usuario: " + usua.getUsuario());
				System.out.println("Tipo Usuario: " + usua.getTipoUsuario());
			}
		}else {
			System.out.println("No se encontraron usuarios.");
		}
		
		*/
		
		/* TEST REGISTRAR
		Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setUsuario("nuevo_usuario2");
        nuevoUsuario.setContrasena("password123");
        nuevoUsuario.setTipoUsuario("admin");

        // Intentar registrar el usuario
        System.out.println("Registrando nuevo usuario...");
        impl.RegistrarUsuarios(nuevoUsuario);
		*/
        
		
		/*TEST ACTUALIZAR
		 Usuarios usuarioActualizar = new Usuarios();
	        usuarioActualizar.setIdUsuario(3);  // Asumimos que el id del usuario a actualizar es 1
	        usuarioActualizar.setUsuario("PEPE");
	        usuarioActualizar.setContrasena("123"); // Nueva contrase�a
	        usuarioActualizar.setTipoUsuario("docente"); // Tipo de usuario actualizado
	        
	        // Llamar al m�todo de actualizaci�n
	        System.out.println("Actualizando usuario...");
	        impl.ActualizarUsuarios(usuarioActualizar);
   		*/
    
		/*TEST ELIMINAR
		Usuarios usuarioEliminar = new Usuarios();
        usuarioEliminar.setIdUsuario(5);  // Asumimos que el ID del usuario que deseas eliminar es 1
        
        // Llamar al m�todo de eliminaci�n
        System.out.println("Eliminando usuario...");
        impl.EliminarUsuarios(usuarioEliminar);
    	*/
    
		/*TEST BUSCAR
		 Usuarios usuarioBuscar = new Usuarios();
	        usuarioBuscar.setIdUsuario(1);  // Asumimos que el ID del usuario que deseas buscar es 1
	        
	        // Llamar al m�todo BuscarUsuarios
	        System.out.println("Buscando usuario...");
	        Usuarios usuarioEncontrado = impl.BuscarUsuarios(usuarioBuscar);
	        
	        // Verificar si se encontr� el usuario
	        if (usuarioEncontrado.getIdUsuario() != 0) {
	            // Si el id_usuario no es 0, significa que se encontr� el usuario
	            System.out.println("Usuario encontrado:");
	            System.out.println("ID Usuario: " + usuarioEncontrado.getIdUsuario());
	            System.out.println("Usuario: " + usuarioEncontrado.getUsuario());
	            System.out.println("Tipo de Usuario: " + usuarioEncontrado.getTipoUsuario());
	        } else {
	            // Si el id_usuario sigue siendo 0, el usuario no fue encontrado
	            System.out.println("No se encontr� el usuario.");
	        }
    	*/
		
		/*TEST LOGUEO*/
		String usuario = "juan@example.com"; // Reemplaza con un usuario que exista en la base de datos
        String contrasena = "123";    // Reemplaza con la contrase�a que quieras probar
        
        // Llamar al m�todo IniciarSession
        System.out.println("Iniciando sesi�n...");
        boolean sesionIniciada = impl.IniciarSession(usuario, contrasena);
        
        // Verificar si el inicio de sesi�n fue exitoso
        if (sesionIniciada) {
            System.out.println("�Inicio de sesi�n exitoso!");
        } else {
            System.out.println("Error: Las credenciales no son correctas.");
        }
        
    }
}
