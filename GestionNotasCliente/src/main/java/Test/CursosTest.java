package Test;

import java.util.List;

import Dao.CursosDao;
import Model.Cursos;

public class CursosTest {

    public static void main(String[] args) {
        CursosDao cursosDao = new CursosDao();

        System.out.println("Listado de Cursos:");
        List<Cursos> cursos = cursosDao.ListadoCursos();
        if (cursos != null) {
            for (Cursos curso : cursos) {
                System.out.println("ID: " + curso.getIdCurso());
                System.out.println("Nombre: " + curso.getNombreCurso());
                System.out.println("Descripción: " + curso.getDescripcion());
                if (curso.getDocente() != null) {
                    System.out.println("Docente: " + curso.getDocente().getNombre());
                }
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No se pudo obtener el listado de cursos.");
        }
    }
}
