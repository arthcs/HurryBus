package hurrybus;

/**
 * @author Blackboard
 *
 */

import java.util.ArrayList;
import java.util.Collection;

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

import org.json.JSONArray;

import hurrybus.model.Usuario;
import hurrybus.dao.UsuarioDao;


@Path("/usuarios")
public class UsuarioHandler {
	UsuarioDao dao = new UsuarioDao();
	Usuario user = new Usuario();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response InsereUsuario(String StringJSON){
		System.out.println(StringJSON);
		
		//adiciona no banco de dados
		user = dao.fromJson(StringJSON);
		System.out.println(user.toString());
		
		dao.insereUsuario(user);
		
		return Response.ok(200).entity(StringJSON).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario() {
		Collection<Usuario> ListaUsers = new ArrayList<Usuario>();
		ListaUsers=dao.buscarTodosUsuarios();
		
		JSONArray ListaJson = new JSONArray();
		ListaJson.put(ListaUsers);
		
		System.out.println(ListaJson.toString());

		return Response.ok(200).entity(ListaJson.toString()).build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateUsuario(String StringJSON){
		user = dao.fromJson(StringJSON);
		
		//System.out.println(StringJSON);
		//System.out.println(user.toString());
		
		dao.atualizaUsuario(user);
		
		return Response.ok(200).entity("Usuario "+user.getName()+" atualizado").build();	
	}
	
	
	@DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response DeletaUsuario(@PathParam("id") Integer id) {
		user = dao.buscaUsuarioPorId(id);
		//System.out.println(user.toString());
		dao.excluiUsuario(user);
		return Response.ok(200).entity("Usuario "+user.getName()+" deletado").build();	
	}
	
	@GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public Response BuscaUsuarioId(@PathParam("id") Integer id) {
		
		user=dao.buscaUsuarioPorId(id);
		String StringJSON = dao.toJson(user);
		System.out.println(StringJSON);
		return Response.ok(200).entity(StringJSON).build();
	}

}