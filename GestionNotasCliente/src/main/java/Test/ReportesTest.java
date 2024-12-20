package Test;

import java.util.List;
import Dao.ReportesDao;
import Model.Reportes;

public class ReportesTest {

    public static void main(String[] args) {
        // Crear instancia del DAO para interactuar con los reportes
        ReportesDao reportesDao = new ReportesDao();

        System.out.println("Listado de Reportes:");    
        // Llamar al método ListadoReportes de la instancia
        List<Reportes> reportes = reportesDao.ListadoReportes();
        if (reportes != null) {
            for (Reportes reporte : reportes) {
            	System.out.println("ID Estudiante: " + reporte.getIdEstudiante());
				System.out.println("Fecha: " + reporte.getFecha());
				System.out.println("Reporte: " + reporte.getRendimiento());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No se pudo obtener el listado de reportes.");
        }
    }
}
