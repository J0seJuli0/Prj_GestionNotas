package Interface;

import java.util.List;

import Model.Reportes;

public interface ReportesInterface {
	public void RegistrarReportes(Reportes rep);
	public void ActualizarReportes(Reportes rep);
	public void EliminarReportes(Reportes rep);
	public Reportes BuscarReportes(Reportes rep);
	public List<Reportes> ListarReportes();
}
