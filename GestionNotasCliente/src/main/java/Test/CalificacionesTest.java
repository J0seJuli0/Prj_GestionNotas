package Test;

import java.util.List;

import Dao.CalificacionesDao;
import Model.Calificaciones;

public class CalificacionesTest {

    public static void main(String[] args) {
        CalificacionesDao calificacionesDao = new CalificacionesDao();

        // Test para obtener el listado de calificaciones
        System.out.println("Listado de Calificaciones:");
        List<Calificaciones> calificaciones = calificacionesDao.ListadoCalificaciones();

        if (calificaciones != null && !calificaciones.isEmpty()) {
            for (Calificaciones calificacion : calificaciones) {
                System.out.println("ID Calificación: " + calificacion.getIdCalificacion());
                System.out.println("Estudiante: " + calificacion.getEstudiantes().getNombre());
                System.out.println("Curso: " + calificacion.getCursos().getNombreCurso());
                System.out.println("Nota: " + calificacion.getNota());
                System.out.println("Fecha: " + calificacion.getFecha());
                System.out.println("Comentarios: " + calificacion.getComentarios());
                System.out.println("Tipo de Evaluación: " + calificacion.getTipoEvaluacion());
                System.out.println("-----------------------------");
            }
        } else if (calificaciones == null) {
            System.out.println("No se pudo obtener el listado de calificaciones.");
        } else {
            System.out.println("No hay calificaciones registradas.");
        }
    }
}
