package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.PadresDao;
import Model.Padre;

/**
 * Servlet implementation class PadreController
 */
public class PadreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PadreController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Listado Clientes
	    PadresDao clienteDao = new PadresDao();
	    List<Padre> clientes = clienteDao.ListadoPadres();
	    
	 // Buscar por id
	    String buscarId = request.getParameter("codigoCliente");
	    if (buscarId != null && !buscarId.isEmpty()) {
	        int idCliente = Integer.parseInt(buscarId);
	        Padre cliente = clienteDao.BuscarPadre(idCliente);
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
	        Padre cliente = clienteDao.BuscarPadre(idCliente);
	        if (cliente != null) {
	            request.setAttribute("cliente", cliente);
	            request.getRequestDispatcher("clientesUpd.jsp").forward(request, response);
	            return;
	        } else {
	            System.out.println("No se encontraron datos");
	        }
	    }
	    
	    request.setAttribute("clientes", clientes);
	    request.getRequestDispatcher("padres.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
