package Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Implement.ReportesImplement;
import Model.Reportes;

@Path("/ModuloReportes")
public class ReportesService {

	ReportesImplement impl = new ReportesImplement();
	
	@GET
	@Path("/ListadoReportes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoReportes(){
		List<Reportes> lista = impl.ListarReportes();
		return Response.ok(lista).build();
	}
	
	@POST
	@Path("/RegistrarReporte")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarReporte(Reportes repo){
		impl.RegistrarReportes(repo);
		return Response.ok(impl).build();
	}
	
	@PUT
	@Path("/ActualizarReporte")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarReportes(Reportes repo){
		int idRep = 0;
		for (Reportes listado:impl.ListarReportes()) {
			if (listado.getIdReporte() == repo.getIdReporte()) {
				idRep = listado.getIdReporte();
			}
		}
		if (idRep==0) {
			return Response.status(Status.BAD_REQUEST).entity("Reporte no encontrado.").build();
		}else {
			impl.ActualizarReportes(repo);
			List<Reportes> nuevaLista = impl.ListarReportes();
			return Response.ok(nuevaLista).build();
		}
	}
	
	@DELETE
	@Path("/EliminarReporte")
	@Produces(MediaType.APPLICATION_JSON)
	public Response EliminarReporte(@PathParam("cod") int cod){
		Reportes repo = new Reportes();
		repo.setIdReporte(cod);
		int idCod = 0;
		List<Reportes> lista = impl.ListarReportes();
		for (Reportes list:lista) {
			if (list.getIdReporte() == repo.getIdReporte()) {
				idCod = list.getIdReporte();
			}
		}
		if (idCod == 0) {
			return Response.status(Status.BAD_REQUEST).entity("Reporte no encontrado").build();
		}else {
			impl.EliminarReportes(repo);
			List<Reportes> newList = impl.ListarReportes();
			return Response.ok(newList).build();
		}
	}
	
	@GET
	@Path("/BuscarReporte/{cod}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarCliente(@PathParam("cod") int cod){
		Reportes repo = new Reportes();
		repo.setIdReporte(cod);
		int idCod = 0;
		List<Reportes> list = impl.ListarReportes();
		for (Reportes listar:list) {
			if (listar.getIdReporte() == repo.getIdReporte()) {
				idCod = listar.getIdReporte();
			}
		}
		if (idCod ==0) {
			return Response.status(Status.BAD_REQUEST).entity("Reporte no encontrado").build();
		}else {
			Reportes repos = impl.BuscarReportes(repo);
			return Response.ok(repos).build();
		}
	}
	
	
	
}
