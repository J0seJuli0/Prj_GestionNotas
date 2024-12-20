package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EstudiantesDao;
import Model.Estudiantes;
import Model.Padre;

/**
 * Servlet implementation class EstudianteRegistro
 */
public class EstudianteRegistro extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudianteRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
    	String nombre = request.getParameter("nombre");
	    String dni = request.getParameter("dni");
	    String fechaStr = request.getParameter("fecha"); // Fecha en formato String
	    String genero = request.getParameter("genero");
	    String direccion = request.getParameter("direccion");
	    String telefono = request.getParameter("telefono");
	    String correo = request.getParameter("correo");

	    // Datos del padre
	    String padreNombre = request.getParameter("padreNombre"); // Nombre del padre
	    String padreDni = request.getParameter("padreDni"); // DNI del padre
	    String padreTelefono = request.getParameter("padreTelefono"); // Teléfono del padre
	    String padreCorreo = request.getParameter("padreCorreo"); // Correo del padre

	    // Convertir la cadena de fecha a Date
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato esperado (año-mes-día)
	    Date fecha = null;
	    try {
	        fecha = sdf.parse(fechaStr); // Convertir la cadena a Date
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    // Crear el objeto Padre con los datos recibidos
	    Padre padre = new Padre(0, padreNombre, padreDni, padreTelefono, padreCorreo);

	    // Crear el objeto Estudiantes con los valores del formulario
	    Estudiantes cliente = new Estudiantes();
	    cliente.setNombre(nombre);
	    cliente.setDni(dni);
	    cliente.setFechaNacimiento(fecha); // Asignar el objeto Date
	    cliente.setGenero(genero);
	    cliente.setDireccion(direccion);
	    cliente.setTelefono(telefono);
	    cliente.setCorreo(correo);
	    cliente.setPadre(padre); // Asignar el objeto Padre

	    // Llamar al DAO para actualizar los datos
	    EstudiantesDao clienteDao = new EstudiantesDao();
	    clienteDao.ActualizarEstudiante(cliente);

	    // Redirigir a la lista de estudiantes
	    response.sendRedirect(request.getContextPath() + "/EstudianteController");
    }
}
