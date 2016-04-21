/**
 * 
 */
package testes;


import java.sql.Timestamp;
import hurrybus.dao.EventoDao;
import hurrybus.model.Evento;
import hurrybus.model.Usuario;

/**
 * @author Arthur Silveira
 *
 */
public class TestaEvento {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evento evt = new Evento();
		Timestamp hora = new Timestamp(System.currentTimeMillis());
		
		evt.setId(18);
		
		Usuario u = new Usuario();
		u.setId(23);
		
		evt.setUsuario(u);
		evt.setNota(10);
		evt.setTAG("legal");
		evt.setEmb_lat(487);
		evt.setEmb_lon(10029);
		evt.setDesemb_lat(000123);
		evt.setDesemb_lon(000415);
		evt.setHora_desembarque(hora.toString());
		evt.setHora_embarque(hora.toString());
		
		EventoDao dao = new EventoDao();
		//System.out.println(evt.toString());
		//dao.insereEvento(evt);
		
		//dao.excluiEvento(evt);
		
		//dao.mostrarEvento();
		
		//---------busca----------
		//Evento busca = new Evento();
		//busca=dao.buscaEvento(20);
		//System.out.println(busca.toString());
		
		//---------Atualiza----------
		//evt.setTAG("atualizado");
		//evt.setHora_desembarque(hora.toString());
		//evt.setHora_embarque(hora.toString());
		//dao.updateEvento(evt);
		
		//----teste JSON
		System.out.println(evt.toString());
		
		evt.setTAG("update");
		
		String json_string = dao.toJson(evt);
		System.out.println("Obj to String JSON="+json_string);
		EventoJson json = new EventoJson();
		
		//json.insereJson(json_string);
		//json.updateJson(json_string);
		//json.excluiJson(json_string);
		
		//----Strin Json para ObjJson
		Evento e = new Evento();
		//e=dao.fromJson(json_string);		
		//System.out.println(e.toString());
	}

}
