package Interface;

import Model.Usuarios;

public interface UsuarioInterface {
	public void RegistrarUsuarios(Usuarios usu);
	public boolean IniciarSession(String usu, String pass);
}
