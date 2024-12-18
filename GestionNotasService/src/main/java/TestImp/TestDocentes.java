package TestImp;

import java.util.List;

import Implement.DocentesImplement;
import Model.Docentes;

public class TestDocentes {

    public static void main(String[] args) {
        
        DocentesImplement impl = new DocentesImplement();
        
        /* TEST REGISTRAR 
        Docentes nuevoDocente = new Docentes();
        nuevoDocente.setNombre("Juan P�rez");
        nuevoDocente.setDni("12345678");
        nuevoDocente.setTelefono("987654321");
        nuevoDocente.setCorreo("juan.perez@email.com");
        nuevoDocente.setEspecialidad("Matem�ticas");

        System.out.println("Registrando nuevo docente...");
        impl.RegistrarDocentes(nuevoDocente);
        */
        
        
        /* TEST ACTUALIZAR 
        Docentes docenteActualizar = new Docentes();
        docenteActualizar.setIdDocente(1); 
        docenteActualizar.setNombre("Juan P�rez Actualizado");
        docenteActualizar.setDni("87654321");
        docenteActualizar.setTelefono("987654322");
        docenteActualizar.setCorreo("juan.perez.actualizado@email.com");
        docenteActualizar.setEspecialidad("F�sica");

        System.out.println("Actualizando docente...");
        impl.ActualizarDocentes(docenteActualizar);
         
        */
        
        /* TEST BUSCAR  
        Docentes docenteBuscar = new Docentes();
        docenteBuscar.setIdDocente(1); // Aseg�rate de que el ID exista
        
        System.out.println("Buscando docente...");
        Docentes docenteEncontrado = impl.BuscarDocentes(docenteBuscar);
        
        if (docenteEncontrado.getIdDocente() != 0) {
            System.out.println("Docente encontrado:");
            System.out.println("ID Docente: " + docenteEncontrado.getIdDocente());
            System.out.println("Nombre: " + docenteEncontrado.getNombre());
            System.out.println("DNI: " + docenteEncontrado.getDni());
            System.out.println("Tel�fono: " + docenteEncontrado.getTelefono());
            System.out.println("Correo: " + docenteEncontrado.getCorreo());
            System.out.println("Especialidad: " + docenteEncontrado.getEspecialidad());
        } else {
            System.out.println("No se encontr� el docente.");
        }
        */
        
        
        
        /* TEST LISTAR */
        List<Docentes> docentes = impl.ListarDocentes();
        
        if (docentes != null && !docentes.isEmpty()) {
            for (Docentes doc : docentes) {
                System.out.println("ID Docente: " + doc.getIdDocente());
                System.out.println("Nombre: " + doc.getNombre());
                System.out.println("DNI: " + doc.getDni());
                System.out.println("Tel�fono: " + doc.getTelefono());
                System.out.println("Correo: " + doc.getCorreo());
                System.out.println("Especialidad: " + doc.getEspecialidad());
            }
        } else {
            System.out.println("No se encontraron docentes.");
        }
        
    }
}
