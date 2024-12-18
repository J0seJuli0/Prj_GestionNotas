package Interface;

import java.util.List;

import Model.Cursos;

public interface CursosInterface {
	public void RegistrarCursos(Cursos cur);
	public void ActualizarCursos(Cursos cur);
	public Cursos BuscarCurso(Cursos cur);
	public List<Cursos> ListarCursos();
}
