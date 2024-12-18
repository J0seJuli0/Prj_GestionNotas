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

import Implement.CursosImplement;
import Model.Cursos;

@Path("/ModuloCursos")
public class CursosService {

	CursosImplement impl= new CursosImplement();
	
	@POST
	@Path("/RegistrarCursos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response RegistrarCursos(Cursos curs){
		impl.RegistrarCursos(curs);
		return Response.ok(impl).build();
	}
	
	@PUT
	@Path("/ActualizarCursos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response ActualizarCursos(Cursos curs){
		int idCurs = 0;
		for (Cursos listado:impl.ListarCursos()){
			if (listado.getIdCurso() == curs.getIdCurso()) {
				idCurs= listado.getIdCurso();
			}
		}
		if (idCurs==0) {
			return Response.status(Status.BAD_REQUEST).entity("Curso no encontrado.").build();
		}else {
			impl.ActualizarCursos(curs);
			List<Cursos> nuevaLista = impl.ListarCursos();
			return Response.ok(nuevaLista).build();
		}
	}
	
	@GET
	@Path("/BuscarCursos/{cod}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response BuscarCursos(@PathParam("cod") int cod){
		Cursos estu = new Cursos();
		estu.setIdCurso(cod);
		int idCod = 0;
		List<Cursos> list = impl.ListarCursos();
		for (Cursos listar:list) {
			if (listar.getIdCurso() == estu.getIdCurso()){
				idCod = listar.getIdCurso();
			}
		}
		if (idCod ==0) {
			return Response.status(Status.BAD_REQUEST).entity("Curso no encontrado").build();
		}else {
			Cursos curso= impl.BuscarCurso(estu);
			return Response.ok(curso).build();
		}
	}

	
	@GET
	@Path("/ListadoCursos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoCursos(){
		List<Cursos> lista = impl.ListarCursos();
		return Response.ok(lista).build();
	}
}
