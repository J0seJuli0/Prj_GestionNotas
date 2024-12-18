package Interface;

import java.util.List;

import Model.Usuarios;

public interface UsuarioInterface {
	public void RegistrarUsuarios(Usuarios usu);
	public List<Usuarios> ListarUsuarios();
	public boolean IniciarSession(String usu, String pass);
}
