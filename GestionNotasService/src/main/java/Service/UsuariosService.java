package Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Implement.UsuariosImplement;
import Model.Usuarios;

@Path("/MOduloUsuarios")
public class UsuariosService {
	UsuariosImplement usuImpl = new UsuariosImplement();
	
	@GET
	@Path("/ListadoUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListadoUsuarios(){
		List<Usuarios> lista = usuImpl.ListarUsuarios();
		return Response.ok(lista).build();
	}
	
	@POST
	@Path("/RegistrarUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response CrearUsuario(Usuarios usu){
		usuImpl.RegistrarUsuarios(usu);
		return Response.ok(usuImpl).build();
	}
	
	@GET
	@Path("/Acceso")
	@Produces(MediaType.APPLICATION_JSON)
	public Response IniciarSession(@QueryParam("user") String user, @QueryParam("password") String password){
		if (usuImpl.IniciarSession(user, password)) {
			return Response.ok().build();
		}else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Credenciales Incorrectas")
						.build();
		}
	}
}
