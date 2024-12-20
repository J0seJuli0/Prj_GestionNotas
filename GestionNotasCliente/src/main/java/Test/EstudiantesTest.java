package Test;

import java.util.Date;
import java.util.List;

import Dao.EstudiantesDao;
import Model.Estudiantes;
import Model.Padre;

public class EstudiantesTest {

    public static void main(String[] args) {
        EstudiantesDao estudiantesDao = new EstudiantesDao();

        // Test: Listado de estudiantes
        System.out.println("Listado de Estudiantes:");
        List<Estudiantes> estudiantes = estudiantesDao.ListadoEstudiantes();
        if (estudiantes != null) {
            for (Estudiantes estudiante : estudiantes) {
                System.out.println("ID Estudiante: " + estudiante.getIdEstudiante());
                System.out.println("Nombre: " + estudiante.getNombre());
                System.out.println("DNI: " + estudiante.getDni());
                System.out.println("Fecha Nacimiento: " + estudiante.getFechaNacimiento());
                System.out.println("Género: " + estudiante.getGenero());
                System.out.println("Dirección: " + estudiante.getDireccion());
                System.out.println("Teléfono: " + estudiante.getTelefono());
                System.out.println("Correo: " + estudiante.getCorreo());
                if (estudiante.getPadre() != null) {
                    System.out.println("Padre: " + estudiante.getPadre().getNombre());
                }
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No se pudo obtener el listado de estudiantes.");
        }
    }
}