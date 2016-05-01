package hurrybus;

/**
 * @author Blackbeard
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import hurrybus.model.Usuario;
import hurrybus.dao.UsuarioDao;


@Path("/usuarios")
public class UsuarioHandler {
	UsuarioDao dao = new UsuarioDao();
	Usuario user = new Usuario();
	
	@GET
	public Response getMethod() {
		System.out.println("get metodo");
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUsuario(String StringJSON){
		  
		System.out.println(StringJSON+"ola?");
		
		//adiciona no banco de dados
		user = dao.fromJson(StringJSON);
		dao.insereUsuario(user);
		
		//Object createdContent = StringJSON;
	    //return createdContent;
		
		return Response.ok().entity(StringJSON).build();
	    
		//servletResponse.sendRedirect("../CRUD/ok.jsp");
		//return "200 - ok";
	  }
}