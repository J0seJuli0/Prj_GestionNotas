package Model;

public class Cursos {
	private int idCurso;
	private String nombreCurso;
	private String descripcion;
	private Docentes docente;
	
	//CONSTRUCTOR CON PARAMETROS
	public Cursos(int idCurso, String nombreCurso, String descripcion, Docentes docente) {
		//super();
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
		this.descripcion = descripcion;
		this.docente = docente;
	}

	//CONSTRUCTOR VACIO
	public Cursos() {
		//super();
	}
	
	//GET AND SET
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Docentes getDocente() {
		return docente;
	}
	public void setDocente(Docentes docente) {
		this.docente = docente;
	}
}
