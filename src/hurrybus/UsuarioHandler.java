package hurrybus;

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
import org.json.JSONObject;

import hurrybus.model.Evento;
import hurrybus.model.Usuario;
import hurrybus.dao.EventoDao;
import hurrybus.dao.UsuarioDao;


/**
 *	Classe que recebe as requisições das páginas Web
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */

@Path("/usuarios")
public class UsuarioHandler {
	
   /**
    * Insere um novo Usuário na tabela Usuarios
    * 
    * @param usuarioJson  	String com os dados do usuáio
    * @return    			Retorna um Response para página jsp
    * @see UsuarioDao
    */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insereUsuario(String usuarioJson){
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.fromJson(usuarioJson);
		dao.insereUsuario(user);
		return Response.ok().build();
	}
	
	
   /**
	* Busca todos os usuário cadastrados na tabela Usuarios
 	* 
    * @return    			Retorna um Response com JSONArray para página jsp com todos os usuários
    * @see UsuarioDao
    */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarios() {

		Collection<Usuario> listaUsers = UsuarioDao.buscarTodosUsuarios();
		JSONArray listaJson = new JSONArray();				

		for (Usuario user : listaUsers)	 {
			listaJson.put(UsuarioDao.toJson(user));
			}
		return Response.ok().entity(listaJson.toString()).build();
	}
	
   /**
    * Atualiza um Usuário na tabela Usuarios
    * 
    * @param usuarioJson  	String com os dados do usuáio
    * @return    			Retorna um Response para página jsp
    * @see UsuarioDao
    */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaUsuario(String usuarioJson){
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.fromJson(usuarioJson);
		dao.atualizaUsuario(user);
		return Response.ok().build();
	}
	
   /**
    * Remove um Usuário da tabela Usuarios
    * 
    * @param id		  	Um inteiro com o id do usuario a ser deletado
    * @return    		Retorna um Response para página jsp com o nomo do usuario deletado
    * @see UsuarioDao
    */
	@DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response excluiUsuario(@PathParam("id") Integer id) {
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.buscaUsuarioPorId(id);
		dao.excluiUsuario(user);
		return Response.ok().build();
	}
	
   /**
    * Busca um Usuário na tabela Usuarios
    * 
    * @param id		  	Um inteiro com o id do usuario a ser buscado
    * @return    		Retorna um Response para página jsp com uma StringJSON do usuário
    * @see UsuarioDao
    */
	@GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public Response buscaUsuarioId(@PathParam("id") Integer id) {
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.buscaUsuarioPorId(id);
		JSONObject StringJSON = UsuarioDao.toJson(user);
		return Response.ok().entity(StringJSON.toString()).build();
	}

	
	/**
	* Verifica um usuario no banco de dados
	* 
	* @param usuarioJson 	String com os dados do usuáio
	* @return    			Retorna um Response para página jsp
	* @see UsuarioDao
	*/
	//TODO renomear StringJson para usuarioJson
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response verificaUsuario(String usuarioJson) {
		System.out.println(usuarioJson.toString());
		
		UsuarioDao dao = new UsuarioDao();
		Usuario user = dao.loginJson(usuarioJson);
		
		if (dao.verificaUsuario(user) != null){
		    user = dao.verificaUsuario(user);
		    JSONObject StringJSON = UsuarioDao.toJson(user);
		    
		    System.out.println(StringJSON.toString());
		    return Response.ok().entity(StringJSON.toString()).build();
		    //return Response.status(200).build();
	
		} else {
			System.out.println("error");
		    return Response.status(404).build();		
			}
	}

}