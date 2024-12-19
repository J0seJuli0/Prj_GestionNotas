package Model;

import java.util.Date;

public class Estudiantes {
	private int idEstudiante;
	private String nombre;
	private String dni;
	private Date fechaNacimiento;
	private String genero;
	private String direccion;
	private String telefono;
	private String correo;
	private Padre padre;
	
	//CONSTRUCTOR CON PARAMETROS
	public Estudiantes(int idEstudiante, String nombre, String dni, Date fechaNacimiento, String genero,
			String direccion, String telefono, String correo, Padre padre) {
		//super();
		this.idEstudiante = idEstudiante;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.padre = padre;
	}
	
	//CONSTRUCTOR VACIO
	public Estudiantes() {
		//super();
	}
	
	//GET AND SET
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public Padre getPadre() {
		return padre;
	}
	public void setPadre(Padre padre) {
		this.padre = padre;
	}
	
	
	
	
}
