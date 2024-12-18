package Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Implement.DocentesImplement;
import Model.Docentes;

@Path("/ModuloDocentes")
public class DocentesService {

	DocentesImplement impl = new DocentesImplement();
	
	@POST
	@Path("/RegistrarDocente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarDocente(Docentes doce){
		impl.RegistrarDocentes(doce);
		return Response.ok(impl).build();
	}
	
	
	@PUT
	@Path("/ActualizarDocentes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarDocentes(Docentes doce){
		int idDoce = 0;
		for (Docentes listado:impl.ListarDocentes()){
			if (listado.getIdDocente() == doce.getIdDocente()) {
				idDoce= listado.getIdDocente();
			}
		}
		if (idDoce==0) {
			return Response.status(Status.BAD_REQUEST).entity("Docentes no encontrado.").build();
		}else {
			impl.ActualizarDocentes(doce);
			List<Docentes> nuevaLista = impl.ListarDocentes();
			return Response.ok(nuevaLista).build();
		}
	}
	
	
	@GET
	@Path("/BuscarDocentes/{cod}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarDocentes(@PathParam("cod") int cod){
		Docentes estu = new Docentes();
		estu.setIdDocente(cod);
		int idCod = 0;
		List<Docentes> list = impl.ListarDocentes();
		for (Docentes listar:list) {
			if (listar.getIdDocente() == estu.getIdDocente()){
				idCod = listar.getIdDocente();
			}
		}
		if (idCod ==0) {
			return Response.status(Status.BAD_REQUEST).entity("Docente no encontrado").build();
		}else {
			Docentes docent= impl.BuscarDocentes(estu);
			return Response.ok(docent).build();
		}
	}

	@GET
	@Path("/ListadoDocentes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoDocentes(){
		List<Docentes> lista = impl.ListarDocentes();
		return Response.ok(lista).build();
	}

}
