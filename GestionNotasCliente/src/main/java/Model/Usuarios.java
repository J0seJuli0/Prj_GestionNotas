package Model;

public class Usuarios {
	private int idUsuario;
	private String usuario;
	private String contrasena;
	private String tipoUsuario;
	
	//Constructor con Parametros
	public Usuarios(int idUsuario, String usuario, String contrasena, String tipoUsuario) {
		//super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
	}
	
	//Constructor vacio
	public Usuarios() {
		//super();
	}
	
	//Get and Set
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
}
