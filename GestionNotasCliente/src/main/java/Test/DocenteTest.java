package Test;

import java.util.List;

import Dao.DocentesDao;
import Model.Docentes;

public class DocenteTest {

    public static void main(String[] args) {
        DocentesDao docentesDao = new DocentesDao();

        System.out.println("Listado de Docentes:");
        List<Docentes> docentes = docentesDao.ListadoDocentes();

        if (docentes != null && !docentes.isEmpty()) {
            for (Docentes docente : docentes) {
                System.out.println("ID: " + docente.getIdDocente());
                System.out.println("Nombre: " + docente.getNombre());
                System.out.println("DNI: " + docente.getDni());
                System.out.println("Teléfono: " + docente.getTelefono());
                System.out.println("Correo: " + docente.getCorreo());
                System.out.println("Especialidad: " + docente.getEspecialidad());
                System.out.println("-----------------------------");
            }
        } else if (docentes == null) {
            System.out.println("No se pudo obtener el listado de docentes.");
        } else {
            System.out.println("No hay docentes registrados.");
        }
    }
}
