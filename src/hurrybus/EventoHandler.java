package hurrybus;

import java.sql.Timestamp;
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

import hurrybus.dao.EventoDao;
import hurrybus.dao.UsuarioDao;
import hurrybus.model.Evento;
import hurrybus.model.Usuario;

/**
 *	Classe que recebe as requisições das páginas Web
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */

@Path("/eventos")
public class EventoHandler {
	 	/**
	    * Insere um novo Evento na tabela Eventos
	    * 
	    * @param StringJSON  	String com os dados do Evento
	    * @return    			Retorna um Response para página jsp
	    * @see EventoDao
	    */
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response insereEvento(String StringJSON){
			Timestamp hora = new Timestamp(System.currentTimeMillis());
			EventoDao dao = new EventoDao();
			Evento evento = new Evento();
			
			evento = dao.fromJson(StringJSON);
			evento.setEmbarqueHora(hora);
			evento.setDesembarqueHora(hora);
			dao.insereEvento(evento);
			//apagar
			System.out.println("ok");
			return Response.ok().build();
		}
		
		/**
		* Busca todos os eventos cadastrados na tabela eventos
	 	* 
	    * @return    			Retorna um Response com JSONArray para página jsp com todos os eventos
	    * @see EventoDao
	    */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getEventos() {
			EventoDao dao = new EventoDao();
			
			Collection<Evento> ListaEventos = new ArrayList<Evento>();
			ListaEventos=dao.buscaTodosEventos();

			JSONArray ListaJson = new JSONArray();			
			ListaJson.put(ListaEventos);
			
			JSONObject obj = new JSONObject();
			obj.put("Eventos", ListaJson);
			return Response.ok().entity(obj.toString()).build();
			//return Response.ok().entity(ListaJson.toString()).build();
		}
		
		/**
		* Atualiza um Evento na tabela Eventos
		* 
		* @param StringJSON  	String com os dados do evento
		* @return    			Retorna um Response para página jsp
		* @see EventoDao
		*/
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response atualizaEvento(String StringJSON){
			EventoDao dao = new EventoDao();
			Evento evento = new Evento();
			
			evento = dao.fromJson(StringJSON);
			dao.atualizarEvento(evento);
			
			System.out.println(evento.toString());
			
			return Response.ok().build();	
			}
		
		/**
		* Remove um Evento da tabela Eventos
		* 
		* @param id		  	Um inteiro com o id do Evento a ser deletado
		* @return    		Retorna um Response para página jsp
		* @see UsuarioDao
		*/
			@DELETE
		    @Path("/{id}")
		    @Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.APPLICATION_JSON)
		    public Response excluiEvento(@PathParam("id") Integer id) {
				EventoDao dao = new EventoDao();
				Evento evento = dao.buscaEventoPorId(id);
				
				dao.excluiEvento(evento);
				System.out.println("ok"+id);
				return Response.ok().build();	
			}
}
