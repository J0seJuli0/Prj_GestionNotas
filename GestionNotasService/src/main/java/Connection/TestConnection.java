package Connection;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		 Connection connection = ClassConnection.conectarMySQL();
		 
		 if (connection!=null) {
			 System.out.println("Conexion Existosa.");
		}else {
			System.out.println("Conexion Fallida.");
		}
		
	}

}
