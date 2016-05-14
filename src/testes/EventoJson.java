/**
 * 
 */
package testes;

import org.json.JSONObject;

import hurrybus.dao.EventoDao;
import hurrybus.dao.UsuarioDao;
import hurrybus.model.Evento;
import hurrybus.model.Usuario;

/**
 * @author Blackbeard
 *
 */
public class EventoJson {
	
    public void insereJson(String json){
    	
    	JSONObject my_obj = new JSONObject(json);
    	Evento evt = new Evento();
    	
    	evt.setId(my_obj.getInt("ID"));
    	UsuarioDao usuarioDao = new UsuarioDao();
    	Usuario usuario = usuarioDao.buscaUsuarioPorId(my_obj.getInt("ID_USUARIO"));
    	
    	evt.setUsuario(usuario);
    	
    	//evt.setDesembarqueHora(my_obj.getString("HORA_DESEMBARQUE"));; // Não aparece a hora na String Json
    	//evt.setEmbarqueHora(my_obj.getString("HORA_EMBARQUE"));;
    	
    	evt.setTAG(my_obj.getString("TAG"));
    	evt.setNota(my_obj.getInt("NOTA"));
    	evt.setEmbarqueLatitude(my_obj.getInt("EMB_LAT"));
    	evt.setEmbarqueLongitude(my_obj.getInt("EMB_LONG"));
    	evt.setDesembarqueLatitude(my_obj.getInt("DES_LAT"));
    	evt.setDesembarqueLongitude(my_obj.getInt("DES_LONG"));

		EventoDao dao = new EventoDao();
		dao.insereEvento(evt);
    }

    
	
    public void excluiJson(String json){
    	
    	JSONObject my_obj = new JSONObject(json);
    	Evento evt = new Evento();
    	
    	evt.setId(my_obj.getInt("ID"));
    	UsuarioDao usuarioDao = new UsuarioDao();
    	Usuario usuario = usuarioDao.buscaUsuarioPorId(my_obj.getInt("ID_USUARIO"));
    	
    	evt.setUsuario(usuario);
    	
    	//evt.setDesembarqueHora(my_obj.getString("HORA_DESEMBARQUE"));
    	//evt.setEmbarqueHora(my_obj.getString("HORA_EMBARQUE"));
    	
    	evt.setTAG(my_obj.getString("TAG"));
    	evt.setNota(my_obj.getInt("NOTA"));
    	evt.setEmbarqueLatitude(my_obj.getInt("EMB_LAT"));
    	evt.setEmbarqueLongitude(my_obj.getInt("EMB_LONG"));
    	evt.setDesembarqueLatitude(my_obj.getInt("DES_LAT"));
    	evt.setDesembarqueLongitude(my_obj.getInt("DES_LONG"));

		EventoDao dao = new EventoDao();
		dao.excluiEvento(evt);
    }
    
    
	
    public void updateJson(String json){
    	
    	JSONObject my_obj = new JSONObject(json);
    	Evento evt = new Evento();
    	
    	evt.setId(my_obj.getInt("ID"));
    	
    	UsuarioDao usuarioDao = new UsuarioDao();
    	Usuario usuario = usuarioDao.buscaUsuarioPorId(my_obj.getInt("ID_USUARIO"));
    	
    	evt.setUsuario(usuario);
    	
    	//evt.setDesembarqueHora(my_obj.getString("HORA_DESEMBARQUE")); // Não aparece a hora na String Json
    	//evt.setEmbarqueHora(my_obj.getString("HORA_EMBARQUE"));
    	
    	evt.setTAG(my_obj.getString("TAG"));
    	evt.setNota(my_obj.getInt("NOTA"));
    	evt.setEmbarqueLatitude(my_obj.getInt("EMB_LAT"));
    	evt.setEmbarqueLongitude(my_obj.getInt("EMB_LONG"));
    	evt.setDesembarqueLatitude(my_obj.getInt("DES_LAT"));
    	evt.setDesembarqueLongitude(my_obj.getInt("DES_LONG"));

		EventoDao dao = new EventoDao();
		dao.atualizarEvento(evt);
    }
}
