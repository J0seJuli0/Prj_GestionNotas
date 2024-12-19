package Model;

public class Docentes {
	private int idDocente;
	private String nombre;
	private String dni;
	private String telefono;
	private String correo;
	private String especialidad;
	
	
	//CONSTRUCTOR CON PARAMETROS
	public Docentes(int idDocente, String nombre, String dni, String telefono, String correo, String especialidad) {
		//super();
		this.idDocente = idDocente;
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.especialidad = especialidad;
	}

	//CONSTRUCTOR VACIO
	public Docentes() {
		//super();
	}
	
	//GET AND SET
	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
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
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}
