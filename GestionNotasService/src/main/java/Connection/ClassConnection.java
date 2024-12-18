package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConnection {

	// Librería de MySQL
    public static String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public static String database = "bd_gestionacademica?serverTimezone=UTC";

    // Host
    public static String hostname = "localhost";

    // Puerto
    public static String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

    // Nombre de usuario
    public static String username = "root";

    // Clave de usuario
    public static String password = "mysql";

    public static Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            //aplicamos una condicion ...
            if(conn!=null)System.out.println("Conexion correcta con el Servidor.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return conn;
    }
}
