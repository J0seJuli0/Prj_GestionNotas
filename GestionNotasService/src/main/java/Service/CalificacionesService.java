package Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Implement.CalificacionesImplement;
import Model.Calificaciones;

@Path("/ModuloCalificaciones")
public class CalificacionesService {

	CalificacionesImplement impl = new CalificacionesImplement();
	
	@POST
	@Path("/RegistrarCalificacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarCalificacion(Calificaciones cal){
		impl.RegistrarCalificacion(cal);
		return Response.ok(impl).build();
	}
	
	@PUT
	@Path("/ActualizarCalificacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarCalificaciones(Calificaciones cal){
		int idCal = 0;
		for (Calificaciones listado:impl.ListadoCalificaciones()){
			if (listado.getIdCalificacion() == cal.getIdCalificacion()) {
				idCal= listado.getIdCalificacion();
			}
		}
		if (idCal==0) {
			return Response.status(Status.BAD_REQUEST).entity("Calificacion no encontrado.").build();
		}else {
			impl.ActualizarCalificacion(cal);
			List<Calificaciones> nuevaLista = impl.ListadoCalificaciones();
			return Response.ok(nuevaLista).build();
		}
	}
	
	@GET
	@Path("/ListadoCalificaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoCalificaciones(){
		List<Calificaciones> lista = impl.ListadoCalificaciones();
		return Response.ok(lista).build();
	}
}
