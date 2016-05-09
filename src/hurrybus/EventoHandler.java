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

import hurrybus.dao.EventoDao;
import hurrybus.model.Evento;

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
			
			System.out.println(StringJSON);
			
			EventoDao dao = new EventoDao();
			Evento evento = new Evento();
			evento = dao.fromJson(StringJSON);
			dao.insereEvento(evento);
			return Response.ok().build();
		}
}
