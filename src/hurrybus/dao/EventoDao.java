package hurrybus.dao;
import hurrybus.dao.banco.ConectionFactory;
import hurrybus.model.Evento;
import hurrybus.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 *	Esta classe é responsavel por todas as requisições e persistencias
 * nescessárias na tabela Evento do banco de dados.
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class EventoDao {
   
    /**
     * Mostra todos os eventos cadastrados
     * 
     * @return	Retorna um List com todos os eventos
     */
    public List<Evento> buscaTodosEventos() {
    	
    	ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
        	Connection con;
            Statement stmt = null;
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM evento;");
            UsuarioDao dao = new UsuarioDao();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("id_usuario");
                Timestamp horaEmbarque = rs.getTimestamp("hora_embarque");
                Timestamp horaDesembarque = rs.getTimestamp("hora_desembarque");
                String tag = rs.getString("tag");
                int nota = rs.getInt("nota");
                double embarqueLatitude = rs.getDouble("emb_lat");
                double embarqueLongitude = rs.getDouble("emb_long");
                double destinoLatitude = rs.getDouble("des_lat");
                double destinoLongitude = rs.getDouble("des_long");
                Usuario usuario = dao.buscaUsuarioPorId(userId);
                                
                Evento evento = new Evento();
                evento.setDesembarqueLatitude(destinoLatitude);
                evento.setDesembarqueLongitude(destinoLongitude);
                evento.setDesembarqueHora(horaDesembarque);
                evento.setEmbarqueHora(horaEmbarque);
                evento.setNota(nota);
                evento.setEmbarqueLatitude(embarqueLatitude);
                evento.setEmbarqueLongitude(embarqueLongitude);
                evento.setTAG(tag);
                evento.setId(id);
                evento.setUsuario(usuario);                
                
                eventos.add(evento);
            }
            stmt.close();

        } catch (Exception e) {        	
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
        return eventos;
    }

    /**
 	* Exclui Evento cadastrado no banco de dados
 	* 
 	* @param evento  Objeto Evento que será removido
 	*/
    public void excluiEvento(Evento evento) {
        try {
            Connection con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM evento WHERE id = '" + evento.getId() + "';";
            stmt.executeUpdate(sql);
            con.commit();
            con.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
    }

    /**
     * Cadastra novo evento na Tabela Evento
     * 
     * @param evento  Objeto do tipo Evento com o evento que será cadastrado
     */
    public void insereEvento(Evento evento) {
    	// TODO mover connection e statement para dentro do try
    	Connection con;
        Statement stmt = null;
        try {
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String sql = "INSERT INTO EVENTO (ID_USUARIO,HORA_EMBARQUE,HORA_DESEMBARQUE,TAG,NOTA,EMB_LAT,EMB_LONG,DES_LAT,DES_LONG) "
					+ "VALUES ('"
            		+evento.getUsuario().getId()
					+"','"
					+evento.getEmbarqueHora()
					+"', '"
					+evento.getDesembarqueHora()
					+"', '"
					+evento.getTAG()
					+"', '"
					+evento.getNota()
					+"', '"
					+evento.getEmbarqueLatitude()
					+"', '"
					+evento.getEmbarqueLongitude()
					+"', '"
					+evento.getDesembarqueLatitude()
					+"', '"
					+evento.getDesembarqueLongitude()
					+"');";

            stmt.executeUpdate(sql);
            con.commit();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
    }
    
    /**
     * Busca Evento cadastrado na tabela Eventos por Id
     * 
     * @param id  Um inteiro com o id do Evento a ser buscado
     * @return    Retorna um Objeto do tipo Evento com o evento buscado
     */
    public Evento buscaEventoPorId(int id){
    	Connection con;
        Statement stmt = null;
    	con = new ConectionFactory().getConnetion();
    	try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM EVENTO WHERE id = '" + id + "';");
	        rs.next();
	    
	        UsuarioDao usuarioDao = new UsuarioDao();
	        Usuario usuario = usuarioDao.buscaUsuarioPorId(rs.getInt("id_usuario"));
	        
	        Evento evento = new Evento();
	        evento.setUsuario(usuario);
	        evento.setEmbarqueHora(rs.getTimestamp("HORA_EMBARQUE"));
	        evento.setDesembarqueHora( rs.getTimestamp("hora_desembarque"));
	        evento.setId(rs.getInt("id"));
	        evento.setTAG(rs.getString("tag"));
	        evento.setNota(rs.getInt("nota"));
	        evento.setEmbarqueLatitude(rs.getDouble("emb_lat"));
	        evento.setEmbarqueLongitude(rs.getDouble("emb_long"));
	        evento.setDesembarqueLatitude(rs.getDouble("des_lat"));
	        evento.setDesembarqueLongitude(rs.getDouble("des_long"));	        
	        return evento;
	        
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * Atualiza Evento cadastrado no banco de dados
     * 
     * @param evento  Objeto do tipo Evento com o evento que será atualizado
     */
    public void atualizarEvento(Evento evento){
    	Connection con;
        Statement stmt = null;
    	try {
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            
            String sql = "UPDATE EVENTO set HORA_DESEMBARQUE = '"+evento.getDesembarqueHora()
						+"', HORA_EMBARQUE = '"+evento.getEmbarqueHora()
						+"', EMB_LAT = '"+evento.getEmbarqueLatitude()
						+"', EMB_LONG = '"+evento.getEmbarqueLongitude()
						+"', DES_LAT = '"+evento.getDesembarqueLatitude()
						+"', DES_LONG = '"+evento.getDesembarqueLongitude()
						+"', TAG = '"+evento.getTAG()
						+"', NOTA = '"+evento.getNota()+"' where ID= '"+evento.getId()+"';";

//            String sql = "UPDATE EVENTO set HORA_DESEMBARQUE = '"+evento.getDesembarqueHora()+"' where ID="+evento.getId()+";"
//            			+"UPDATE EVENTO set HORA_EMBARQUE = '"+evento.getEmbarqueHora()+"' where ID="+evento.getId()+";"
//            			+"UPDATE EVENTO set EMB_LAT = '"+evento.getEmbarqueLatitude()+"' where ID="+evento.getId()+";"
//            			+"UPDATE EVENTO set EMB_LONG = '"+evento.getEmbarqueLongitude()+"' where ID="+evento.getId()+";"
//						+"UPDATE EVENTO set DES_LAT = '"+evento.getDesembarqueLatitude()+"' where ID="+evento.getId()+";"
//						+"UPDATE EVENTO set DES_LONG = '"+evento.getDesembarqueLongitude()+"' where ID="+evento.getId()+";"
//						+"UPDATE EVENTO set TAG = '"+evento.getTAG()+"' where ID="+evento.getId()+";"
//						+"UPDATE EVENTO set NOTA = '"+evento.getNota()+"' where ID="+evento.getId()+";";
            
            stmt.executeUpdate(sql);
            con.commit();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    /**
     * Serializa um objeto do tipo Evento em uma JSONstring
     * 
     * @param evento  Objeto do tipo Evento com o evento que será transformado em String JSON
     * @return        StringJSON do objeto
     */
    public String toJson (Evento evento){
    	JSONObject my_obj = new JSONObject();

    	my_obj.put("idusuario",evento.getUsuario().getId());
    	my_obj.put("horaembarque",evento.getEmbarqueHora());
    	my_obj.put("horadesembarque",evento.getDesembarqueHora());
    	my_obj.put("id",evento.getId());
    	my_obj.put("tag",evento.getTAG());
    	my_obj.put("nota",evento.getNota());
    	my_obj.put("embarquelatitude",evento.getEmbarqueLatitude());
    	my_obj.put("embarquelongitude",evento.getEmbarqueLongitude());
    	my_obj.put("desembarquelatitude",evento.getDesembarqueLatitude());
    	my_obj.put("desembarquelongitude",evento.getDesembarqueLongitude());
    	
    	String json_evt = my_obj.toString();
		return json_evt;
    }
    
    /**
     * Recebe uma String JSON e transforma em um objeto do tipo Evento
     * 
     * @param jsonEvento	String JSON que será transformada em um ojeto do tipo Evento
     * @return        		Retorna um Objeto do tipo Evento da StringJSON
     */
    public Evento fromJson(String jsonEvento){
    	JSONObject obj = new JSONObject(jsonEvento);
    	Evento evento = new Evento();

    	UsuarioDao usuarioDao = new UsuarioDao();
    	Usuario usuario = usuarioDao.buscaUsuarioPorId(obj.getInt("idusuario"));
    	evento.setUsuario(usuario);
    	
    	if (obj.has("id"))evento.setId(obj.getInt("id"));
    	
    	//converter Timestamp em String
    	//evento.setDesembarqueHora(obj.getString("horadesembarque"));
    	//evento.setEmbarqueHora(obj.getString("horaembarque"));
    	evento.setTAG(obj.getString("tag"));
    	evento.setNota(obj.getInt("nota"));
    	evento.setEmbarqueLatitude(obj.getDouble("embarquelatitude"));
    	evento.setEmbarqueLongitude(obj.getDouble("embarquelongitude"));
    	evento.setDesembarqueLatitude(obj.getDouble("desembarquelatitude"));
    	evento.setDesembarqueLongitude(obj.getDouble("desembarquelongitude"));

		return evento;
    }
}
