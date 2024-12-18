package TestImp;

import java.util.List;
import java.util.Date;

import Implement.CalificacionesImplement;
import Model.Calificaciones;
import Model.Cursos;
import Model.Estudiantes;

public class TestCalificaciones {

    public static void main(String[] args) {

        CalificacionesImplement impl = new CalificacionesImplement();

        /* TEST REGISTRAR
        Calificaciones nuevaCalificacion = new Calificaciones();
        nuevaCalificacion.setNota(9.5);
        nuevaCalificacion.setComentarios("Muy bien, excelente desempe�o.");
        nuevaCalificacion.setTipoEvaluacion("Parcial");
        nuevaCalificacion.setFecha(new Date());  // Fecha actual
        
        Estudiantes estudiante = new Estudiantes();
        estudiante.setIdEstudiante(1);  // Asignamos un estudiante por ID
        nuevaCalificacion.setEstudiantes(estudiante);
        nuevaCalificacion.setTipoEvaluacion("Otro");
        Cursos curso = new Cursos();
        curso.setIdCurso(1);  // Asignamos un curso por ID
        nuevaCalificacion.setCursos(curso);

        System.out.println("Registrando nueva calificaci�n...");
        impl.RegistrarCalificacion(nuevaCalificacion);
         
         */
        
        
        
        /* TEST ACTUALIZAR  
        Calificaciones calificacionActualizar = new Calificaciones();
        calificacionActualizar.setIdCalificacion(1);  // ID de la calificaci�n a actualizar
        
        Estudiantes estudianteActualizar = new Estudiantes();
        estudianteActualizar.setIdEstudiante(2);  // Estudiante actualizado
        calificacionActualizar.setEstudiantes(estudianteActualizar);
        
        Cursos cursoActualizar = new Cursos();
        cursoActualizar.setIdCurso(2);  // Curso actualizado
        calificacionActualizar.setCursos(cursoActualizar);
        
        calificacionActualizar.setNota(8.0);
        calificacionActualizar.setComentarios("Calificaci�n ajustada.");
        calificacionActualizar.setTipoEvaluacion("Otro");
        calificacionActualizar.setFecha(new Date());  // Fecha actual
        
        

        System.out.println("Actualizando calificaci�n...");
        impl.ActualizarCalificacion(calificacionActualizar);
         */

        
        
        /* TEST LISTAR*/
        System.out.println("Listando calificaciones...");
        List<Calificaciones> calificaciones = impl.ListadoCalificaciones();

        // Verificar si la lista no est� vac�a
        if (calificaciones != null && !calificaciones.isEmpty()) {
            for (Calificaciones calificacion : calificaciones) {
                // Imprimir los detalles de cada calificaci�n, incluyendo el nombre del curso y el estudiante
                System.out.println("ID Calificaci�n: " + calificacion.getIdCalificacion());
                System.out.println("Estudiante: " + calificacion.getEstudiantes().getNombre());
                System.out.println("Curso: " + calificacion.getCursos().getNombreCurso());
                System.out.println("Nota: " + calificacion.getNota());
                System.out.println("Fecha: " + calificacion.getFecha());
                System.out.println("Comentarios: " + calificacion.getComentarios());
                System.out.println("Tipo Evaluaci�n: " + calificacion.getTipoEvaluacion());
                System.out.println("=================================");
            }
        } else {
            System.out.println("No se encontraron calificaciones.");
        }
        
        
    }
}
