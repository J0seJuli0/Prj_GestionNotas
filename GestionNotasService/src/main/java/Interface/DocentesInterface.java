package Interface;

import java.util.List;

import Model.Docentes;

public interface DocentesInterface {
	public void RegistrarDocentes(Docentes doc);
	public void ActualizarDocentes(Docentes doc);
	public Docentes BuscarDocentes(Docentes doc);
	public List<Docentes> ListarDocentes();
}
