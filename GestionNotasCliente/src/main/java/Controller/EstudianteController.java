package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EstudiantesDao;
import Model.Estudiantes;

/**
 * Servlet implementation class EstudianteController
 */
public class EstudianteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudianteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Listado Clientes
	    EstudiantesDao clienteDao = new EstudiantesDao();
	    List<Estudiantes> clientes = clienteDao.ListadoEstudiantes();
	    
	    
	 // Buscar por id
	    String buscarId = request.getParameter("codigoCliente");
	    if (buscarId != null && !buscarId.isEmpty()) {
	        int idCliente = Integer.parseInt(buscarId);
	        Estudiantes cliente = clienteDao.BuscarEstudiante(idCliente);
	        if (cliente != null) {
	            clientes.clear();
	            clientes.add(cliente);
	        } else { 
	        	request.setAttribute("mensaje", "Swal.fire({ title: 'Cliente no encontrado', icon: 'error', confirmButtonColor: '#d33' })");
	        }
	    }
	    
	 // Capturar datos para Actualizar
	    String accionEditar = request.getParameter("accion");
	    if (accionEditar != null && accionEditar.equals("editar")) {
	        int idCliente = Integer.parseInt(request.getParameter("id"));
	        Estudiantes cliente = clienteDao.BuscarEstudiante(idCliente);
	        if (cliente != null) {
	            request.setAttribute("cliente", cliente);
	            request.getRequestDispatcher("clientesUpd.jsp").forward(request, response);
	            return;
	        } else {
	            System.out.println("No se encontraron datos");
	        }
	    }
	    
	    request.setAttribute("clientes", clientes);
	    request.getRequestDispatcher("clientes.jsp").forward(request, response);
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
