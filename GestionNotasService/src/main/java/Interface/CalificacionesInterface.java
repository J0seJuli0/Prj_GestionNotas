package Interface;

import java.util.List;

import Model.Calificaciones;

public interface CalificacionesInterface {
	public void RegistrarCalificacion(Calificaciones cal);
	public void ActualizarCalificacion(Calificaciones cal);
	public List<Calificaciones> ListadoCalificaciones();
}
