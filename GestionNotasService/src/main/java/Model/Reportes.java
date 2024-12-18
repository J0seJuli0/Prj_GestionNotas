package Model;

import java.util.Date;

public class Reportes {
	private int idReporte;
	private int idEstudiante;
	private Date fecha;
	private String rendimiento;
	
	
	
	public Reportes(int idReporte, int idEstudiante, Date fecha, String rendimiento) {
		//super();
		this.idReporte = idReporte;
		this.idEstudiante = idEstudiante;
		this.fecha = fecha;
		this.rendimiento = rendimiento;
	}

	public Reportes() {
		//super();
	}
	
	public int getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}
	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getRendimiento() {
		return rendimiento;
	}
	public void setRendimiento(String rendimiento) {
		this.rendimiento = rendimiento;
	}
	
	
	
}
