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

import Implement.EstudiantesImplement;
import Model.Estudiantes;

@Path("/ModuloEstudiantes")
public class EstudiantesService {

	EstudiantesImplement impl = new EstudiantesImplement();
	
	@POST
	@Path("/RegistrarEsutudiante")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarEstudiante(Estudiantes estu){
		impl.RegistrarEstudiantes(estu);
		return Response.ok(impl).build();
	}
	
	@PUT
	@Path("/ActualizarEstudiantes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarEstudiantes(Estudiantes estu){
		int idEstu = 0;
		for (Estudiantes listado:impl.ListarEstudiantes()){
			if (listado.getIdEstudiante() == estu.getIdEstudiante()) {
				idEstu= listado.getIdEstudiante();
			}
		}
		if (idEstu==0) {
			return Response.status(Status.BAD_REQUEST).entity("Estudiante no encontrado.").build();
		}else {
			impl.ActualizarEstudiantes(estu);
			List<Estudiantes> nuevaLista = impl.ListarEstudiantes();
			return Response.ok(nuevaLista).build();
		}
	}
	
	@GET
	@Path("/BuscarEstudiante/{cod}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarEstudiantes(@PathParam("cod") int cod){
		Estudiantes estu = new Estudiantes();
		estu.setIdEstudiante(cod);
		int idCod = 0;
		List<Estudiantes> list = impl.ListarEstudiantes();
		for (Estudiantes listar:list) {
			if (listar.getIdEstudiante() == estu.getIdEstudiante()){
				idCod = listar.getIdEstudiante();
			}
		}
		if (idCod ==0) {
			return Response.status(Status.BAD_REQUEST).entity("Estudiante no encontrado").build();
		}else {
			Estudiantes estud= impl.BuscarEstudiantes(estu);
			return Response.ok(estud).build();
		}
	}

	@GET
	@Path("/ListadoEstudiantes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoEstudiantes(){
		List<Estudiantes> lista = impl.ListarEstudiantes();
		return Response.ok(lista).build();
	}

}
