package Interface;

import java.util.List;

import Model.Estudiantes;

public interface EstudiantesInterface {
	public void RegistrarEstudiantes(Estudiantes est);
	public void ActualizarEstudiantes(Estudiantes est);
	public Estudiantes BuscarEstudiantes(Estudiantes est);
	public List<Estudiantes> ListarEstudiantes();
}
