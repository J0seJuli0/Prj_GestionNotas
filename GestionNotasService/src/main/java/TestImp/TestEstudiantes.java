package TestImp;

import java.util.List;

import Implement.EstudiantesImplement;
import Model.Estudiantes;

public class TestEstudiantes {

    public static void main(String[] args) {

        EstudiantesImplement impl = new EstudiantesImplement();

        /* TEST REGISTRAR 
        Estudiantes nuevoEstudiante = new Estudiantes();
        nuevoEstudiante.setNombre("Juan Perez");
        nuevoEstudiante.setDni("12345678");
        nuevoEstudiante.setFechaNacimiento(java.sql.Date.valueOf("2000-01-01"));
        nuevoEstudiante.setGenero("M");
        nuevoEstudiante.setDireccion("Av. Siempre Viva 742");
        nuevoEstudiante.setTelefono("987654321");
        nuevoEstudiante.setCorreo("juan.perez@example.com");
        nuevoEstudiante.setPadre(new Model.Padre());
        nuevoEstudiante.getPadre().setIdPadre(14);
        System.out.println("ID Padre: " + nuevoEstudiante.getPadre().getIdPadre());

        System.out.println("Registrando nuevo estudiante...");
        impl.RegistrarEstudiantes(nuevoEstudiante);
		*/
        
        
        
        
        /* TEST ACTUALIZAR 
        Estudiantes estudianteActualizar = new Estudiantes();
        estudianteActualizar.setIdEstudiante(2);
        estudianteActualizar.setNombre("Juan Perez");
        estudianteActualizar.setDni("87654321");
        estudianteActualizar.setFechaNacimiento(java.sql.Date.valueOf("2000-01-01"));
        estudianteActualizar.setGenero("M");
        estudianteActualizar.setDireccion("Av. Modificada 123");
        estudianteActualizar.setTelefono("987654322");
        estudianteActualizar.setCorreo("juan.modificado@example.com");
        estudianteActualizar.setPadre(new Model.Padre());
        estudianteActualizar.getPadre().setIdPadre(2);

        System.out.println("Actualizando estudiante...");
        impl.ActualizarEstudiantes(estudianteActualizar);
			*/
        
        
        
        /* TEST BUSCAR  
        Estudiantes estudianteBuscar = new Estudiantes();
        estudianteBuscar.setIdEstudiante(2);

        System.out.println("Buscando estudiante...");
        Estudiantes estudianteEncontrado = impl.BuscarEstudiantes(estudianteBuscar);

        if (estudianteEncontrado.getIdEstudiante() != 0) {
            System.out.println("Estudiante encontrado:");
            System.out.println("ID: " + estudianteEncontrado.getIdEstudiante());
            System.out.println("Nombre: " + estudianteEncontrado.getNombre());
            System.out.println("DNI: " + estudianteEncontrado.getDni());
            System.out.println("Fecha de nacimiento: " + estudianteEncontrado.getFechaNacimiento());
            System.out.println("G�nero: " + estudianteEncontrado.getGenero());
            System.out.println("Direcci�n: " + estudianteEncontrado.getDireccion());
            System.out.println("Tel�fono: " + estudianteEncontrado.getTelefono());
            System.out.println("Correo: " + estudianteEncontrado.getCorreo());
        } else {
            System.out.println("No se encontr� el estudiante.");
        }
        */
        
        
        
        /* TEST LISTAR */
        System.out.println("Listando estudiantes...");
        List<Estudiantes> listaEstudiantes = impl.ListarEstudiantes();

        if (listaEstudiantes != null && !listaEstudiantes.isEmpty()) {
            for (Estudiantes est : listaEstudiantes) {
                System.out.println("ID: " + est.getIdEstudiante());
                System.out.println("Nombre: " + est.getNombre());
                System.out.println("DNI: " + est.getDni());
                System.out.println("Fecha de nacimiento: " + est.getFechaNacimiento());
                System.out.println("Género: " + est.getGenero());
                System.out.println("Dirección: " + est.getDireccion());
                System.out.println("Teléfono: " + est.getTelefono());
                System.out.println("Correo: " + est.getCorreo());
                System.out.println("Nombre del Padre: " + (est.getPadre() != null ? est.getPadre().getNombre() : "Sin asignar"));
                System.out.println("----------------------------------");
            }
        } else {
            System.out.println("No se encontraron estudiantes.");
        }
    	     
    }
}
