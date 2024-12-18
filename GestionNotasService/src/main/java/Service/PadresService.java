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

import Implement.PadreImplement;
import Model.Padre;

@Path("ModuloPadres")
public class PadresService {

	PadreImplement impl = new PadreImplement();
	
	@GET
	@Path("/ListadoPadres")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoPadres(){
		List<Padre> lista = impl.ListadoPadres();
		return Response.ok(lista).build();
	}
	
	@POST
	@Path("/RegistrarPadre")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarPadre(Padre pad){
		impl.RegistrarPadres(pad);
		return Response.ok(impl).build();
	}
	
	@PUT
	@Path("/ActualizarPadres")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarPadres(Padre pad){
		int idPad = 0;
		for (Padre listado:impl.ListadoPadres()){
			if (listado.getIdPadre() == pad.getIdPadre()) {
				idPad = listado.getIdPadre();
			}
		}
		if (idPad==0) {
			return Response.status(Status.BAD_REQUEST).entity("Padre no encontrado.").build();
		}else {
			impl.ActualizarPadres(pad);
			List<Padre> nuevaLista = impl.ListadoPadres();
			return Response.ok(nuevaLista).build();
		}
	}
	
	@GET
	@Path("/BuscarPadre/{cod}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarPadre(@PathParam("cod") int cod){
		Padre pad = new Padre();
		pad.setIdPadre(cod);
		int idCod = 0;
		List<Padre> list = impl.ListadoPadres();
		for (Padre listar:list) {
			if (listar.getIdPadre() == pad.getIdPadre()){
				idCod = listar.getIdPadre();
			}
		}
		if (idCod ==0) {
			return Response.status(Status.BAD_REQUEST).entity("Padre no encontrado").build();
		}else {
			Padre padr = impl.BuscarPadre(pad);
			return Response.ok(padr).build();
		}
	}
}
