package Model;

import java.util.Date;

public class Calificaciones {
	private int idCalificacion;
	private Estudiantes estudiantes;
	private Cursos cursos;
	private double nota;
	private Date fecha;
	private String comentarios;
	private String tipoEvaluacion;
	
	//CONSTRUCTOR CON PARAMETROS
	public Calificaciones(int idCalificacion, Estudiantes estudiantes, Cursos cursos, double nota, Date fecha,
			String comentarios, String tipoEvaluacion) {
		//super();
		this.idCalificacion = idCalificacion;
		this.estudiantes = estudiantes;
		this.cursos = cursos;
		this.nota = nota;
		this.fecha = fecha;
		this.comentarios = comentarios;
		this.tipoEvaluacion = tipoEvaluacion;
	}

	//CONSTRUCTOR VACIO
	public Calificaciones() {
		//super();
	}
	
	//GET AND SET
	public int getIdCalificacion() {
		return idCalificacion;
	}
	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}
	public Estudiantes getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(Estudiantes estudiantes) {
		this.estudiantes = estudiantes;
	}
	public Cursos getCursos() {
		return cursos;
	}
	public void setCursos(Cursos cursos) {
		this.cursos = cursos;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
}
