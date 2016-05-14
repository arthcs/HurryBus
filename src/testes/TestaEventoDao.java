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
public class TestaEventoDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evento evt = new Evento();
		Timestamp hora = new Timestamp(System.currentTimeMillis());
		
		evt.setId(26);
		
		Usuario u = new Usuario();
		u.setId(24);
		
		evt.setUsuario(u);
		evt.setNota(10);
		evt.setTAG("legal");
		evt.setEmbarqueLatitude(487);
		evt.setEmbarqueLongitude(10029);
		evt.setDesembarqueLatitude(000123);
		evt.setDesembarqueLongitude(000415);
		evt.setDesembarqueHora(hora);
		evt.setEmbarqueHora(hora);
		
		EventoDao dao = new EventoDao();
		System.out.println(evt.toString());
		//dao.insereEvento(evt);
		
		//dao.excluiEvento(evt);
		
		//dao.buscaTodosEventos();
		
		//---------busca----------
//		Evento busca = new Evento();
//		busca=dao.buscaEvento(23);
//		System.out.println(busca.toString());
		
		//---------Atualiza----------
		evt.setTAG("atualizado");
		evt.setDesembarqueHora(hora);
		dao.atualizarEvento(evt); //problemas pois no banco é Timestamp esta passando uma string
		
		//----teste JSON
//		System.out.println(evt.toString());
//		
//		evt.setTAG("update");
//		
//		String json_string = dao.toJson(evt);
//		System.out.println("Obj to String JSON="+json_string);
//		EventoJson json = new EventoJson();
		
		//json.insereJson(json_string);
		//json.updateJson(json_string);
		//json.excluiJson(json_string);
		
		//----Strin Json para ObjJson
		//Evento e = new Evento();
		//e=dao.fromJson(json_string);		
		//System.out.println(e.toString());
	}

}
