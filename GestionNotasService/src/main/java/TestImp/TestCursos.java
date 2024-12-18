package TestImp;

import java.util.List;

import Implement.CursosImplement;
import Model.Cursos;
import Model.Docentes;

public class TestCursos {

    public static void main(String[] args) {

        CursosImplement impl = new CursosImplement();

        /* TEST REGISTRAR
        Cursos nuevoCurso = new Cursos();
        nuevoCurso.setNombreCurso("Matem�ticas");
        nuevoCurso.setDescripcion("Curso de matem�ticas avanzadas");
        
        Docentes docente = new Docentes();
        docente.setIdDocente(1);  // Asignamos un docente por ID
        nuevoCurso.setDocente(docente);

        System.out.println("Registrando nuevo curso...");
        impl.RegistrarCursos(nuevoCurso);
       */

        /* TEST ACTUALIZAR
        Cursos cursoActualizar = new Cursos();
        cursoActualizar.setIdCurso(4);  // ID del curso a actualizar
        cursoActualizar.setNombreCurso("Ciencias");
        cursoActualizar.setDescripcion("Curso de ciencias naturales");

        Docentes docenteActualizar = new Docentes();
        docenteActualizar.setIdDocente(1); 
        cursoActualizar.setDocente(docenteActualizar);

        System.out.println("Actualizando curso...");
        impl.ActualizarCursos(cursoActualizar);
       */
        
        /* TEST BUSCAR
        Cursos cursoBuscar = new Cursos();
        cursoBuscar.setIdCurso(1);  // ID del curso a buscar
        
        System.out.println("Buscando curso...");
        Cursos cursoEncontrado = impl.BuscarCurso(cursoBuscar);
        
        if (cursoEncontrado.getIdCurso() != 0) {
            System.out.println("Curso encontrado:");
            System.out.println("ID Curso: " + cursoEncontrado.getIdCurso());
            System.out.println("Nombre Curso: " + cursoEncontrado.getNombreCurso());
            System.out.println("Descripci�n: " + cursoEncontrado.getDescripcion());
            
            if (cursoEncontrado.getDocente() != null) {
                System.out.println("Docente: " + cursoEncontrado.getDocente().getNombre());
            } else {
                System.out.println("No hay docente asignado.");
            }
            
        } else {
            System.out.println("No se encontr� el curso.");
        }
        */

        /* TEST LISTAR */
        System.out.println("Listando cursos...");
        List<Cursos> cursos = impl.ListarCursos();
        
        // Verificar si la lista de cursos no est� vac�a
        if (cursos != null && !cursos.isEmpty()) {
            for (Cursos curso : cursos) {
                // Imprimir la informaci�n de cada curso
                System.out.println("ID Curso: " + curso.getIdCurso());
                System.out.println("Nombre Curso: " + curso.getNombreCurso());
                System.out.println("Descripci�n: " + curso.getDescripcion());
                System.out.println("Docente: " + curso.getDocente().getNombre()); // Imprimir nombre del docente
                System.out.println("=================================");
            }
        } else {
            System.out.println("No se encontraron cursos.");
        }
        
    }
}
