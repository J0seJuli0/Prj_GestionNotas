package TestImp;

import java.util.List;

import Implement.PadreImplement;
import Model.Padre;
import Model.Reportes;
import Model.Usuarios;

public class TestPadres {

	public static void main(String[] args) {

		PadreImplement impl = new PadreImplement();

		
		// TEST REGISTRAR
		 Padre padre = new Padre();
	        padre.setNombre("Perez");
	        padre.setDni("146524");
	        padre.setTelefono("98765421");
	        padre.setCorreo("juan@gmail.com");

	        // Configurar la contraseña del usuario
	        String passBc = "123";

	        // Llamar al método para registrar al padre y al usuario
	        try {
	            impl.RegistrarPadres(padre, passBc);
	            System.out.println("Prueba exitosa: El registro se completó correctamente.");
	        } catch (Exception e) {
	            System.out.println("Prueba fallida: " + e.getMessage());
	        }


		/*TEST ACTUALIZAR 
		 Reportes reportesActualizar = new Reportes();
		 reportesActualizar.setIdReporte(3);  
		 reportesActualizar.setIdEstudiante(1);
		 reportesActualizar.setRendimiento("Bajo");
	        
	        // Llamar al método de actualización
	        System.out.println("Actualizando reporte...");
	        impl.ActualizarReportes(reportesActualizar);
	     */
		
		/*TEST ELIMINAR
		Reportes reporteEliminar = new Reportes();
        reporteEliminar.setIdReporte(2);
        
        // Llamar al método de eliminación
        System.out.println("Eliminando reporte...");
        impl.EliminarReportes(reporteEliminar);
    	*/
	
		
		/*TEST BUSCAR 
		 Reportes reporteBuscar = new Reportes();
	        reporteBuscar.setIdReporte(1);
	        
	        System.out.println("Buscando reporte...");
	        Reportes reporteEncontrado = impl.BuscarReportes(reporteBuscar);
	        
	        if (reporteEncontrado.getIdReporte() != 0) {
	            
	            System.out.println("Reporte encontrado:");
	            System.out.println("ID Reporte: " + reporteEncontrado.getIdReporte());
	            System.out.println("ID estudiante: " + reporteEncontrado.getIdEstudiante());
	            System.out.println("Fecha Reporte " + reporteEncontrado.getFecha());
	            System.out.println("Rendimiento: " + reporteEncontrado.getRendimiento());
	        } else {
	            System.out.println("No se encontró el reporte.");
	        }
		*/
		
		/*TEST LISTAR
		List<Reportes> rep = impl.ListarReportes();
		
		if (rep!= null && !rep.isEmpty()) {
			for (Reportes repo : rep){
				System.out.println("ID Estudiante: " + repo.getIdEstudiante());
				System.out.println("Fecha: " + repo.getFecha());
				System.out.println("Reporte: " + repo.getRendimiento());
			}
		}else {
			System.out.println("No se encontraron reportes.");
		}
		*/
	}

}
