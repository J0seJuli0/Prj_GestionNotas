package Model;

public class Padre {
	private int idPadre;
	private String nombre;
	private String dni;
	private String telefono;
	private String correo;
	
	
	//Constructor con datos
	public Padre(int idPadre, String nombre, String dni, String telefono, String correo) {
		//super();
		this.idPadre = idPadre;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	//Constructor vacio
	public Padre() {
		//super();
	}
	
	
	//Get and Set
	public int getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
