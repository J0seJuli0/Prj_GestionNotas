package Test;

import Dao.PadresDao;
import Model.Padre;

import java.util.List;

public class PadresTest {

    public static void main(String[] args) {
        PadresDao padresDao = new PadresDao();
        
        System.out.println("Listado de Padres:");
        List<Padre> padres = padresDao.ListadoPadres();
        if (padres != null && !padres.isEmpty()) {
            for (Padre padre : padres) {
                System.out.println("ID Padre: " + padre.getIdPadre());
                System.out.println("Nombre: " + padre.getNombre());
                System.out.println("DNI: " + padre.getDni());
                System.out.println("Teléfono: " + padre.getTelefono());
                System.out.println("Correo: " + padre.getCorreo());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No se encontraron padres.");
        }
    }
}
