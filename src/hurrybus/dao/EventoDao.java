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
    Connection con;
    Statement stmt = null;


    /**
     * Mostra todos os eventos cadastrados
     * 
     * @return	Retorna um ArryList com todos os eventos
     */
    public List<Evento> mostrarEvento() {
    	
    	ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM evento;");
            UsuarioDao dao = new UsuarioDao();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("id_usuario");
                String horaEmbarque = rs.getString("hora_embarque");
                String horaDesembarque = rs.getString("hora_desembarque");
                String tag = rs.getString("tag");
                int nota = rs.getInt("nota");
                int embarqueLatitude = rs.getInt("emb_lat");
                int embarqueLongitude = rs.getInt("emb_long");
                int destinoLatitude = rs.getInt("des_lat");
                int destinoLongitude = rs.getInt("des_long");
                Usuario usuario = dao.buscaUsuarioPorId(userId);
                                
                Evento evento = new Evento();
                evento.setDesemb_lat(destinoLatitude);
                evento.setDesemb_lon(destinoLongitude);
                evento.setHora_desembarque(horaDesembarque);
                evento.setHora_embarque(horaEmbarque);
                evento.setNota(nota);
                evento.setEmb_lat(embarqueLatitude);
                evento.setEmb_lon(embarqueLongitude);
                evento.setTAG(tag);
                evento.setId(id);
                evento.setUsuario(usuario);                
                
                eventos.add(evento);
                System.out.println("Efetuado com sucesso");
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
 	* @param evento  Objeto do tipo Evento com o evento que será removido
 	*/
    public void excluiEvento(Evento evento) {
        try {
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String sql = "DELETE FROM evento WHERE id = '" + evento.getId() + "';";
            stmt.executeUpdate(sql);
            con.commit();
            con.close();
            stmt.close();
            System.out.println("Excluido com sucesso");
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
        try {
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            Timestamp hora = new Timestamp(System.currentTimeMillis());
            stmt = con.createStatement();
            String sql = "INSERT INTO EVENTO (ID_USUARIO,HORA_EMBARQUE,HORA_DESEMBARQUE,TAG,NOTA,EMB_LAT,EMB_LONG,DES_LAT,DES_LONG) "
					+ "VALUES ('"+evento.getUsuario().getId()
					+"','"
					+ hora
					+"', '"
					+hora+"', '"
					+evento.getTAG()+"', '"+evento.getNota()+"', '"+evento.getEmb_lat()
					+"', '"+evento.getEmb_lon()+"', '0', '0');";

            stmt.executeUpdate(sql);
            con.commit();
            stmt.close();
            con.close();

            System.out.println("Criado com sucesso");
            
        } catch (Exception e) {
        	System.out.println("Erro: Evento não criado!");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
    }
    
    /**
     * Busca Evento cadastrado na tabela Eventos por Id
     * 
     * @param id  Um inteiro com o id do Evento a ser buscado
     * @return    Retorna um Objeto do tipo Evento com o evento buscado
     */
    public Evento buscaEvento(int id){
    	
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
	        evento.setHora_embarque(rs.getString("HORA_EMBARQUE"));
	        evento.setHora_desembarque( rs.getString("hora_desembarque"));
	        evento.setId(rs.getInt("id"));
	        evento.setTAG(rs.getString("tag"));
	        evento.setNota(rs.getInt("nota"));
	        evento.setEmb_lat(rs.getInt("emb_lat"));
	        evento.setEmb_lon(rs.getInt("emb_long"));
	        evento.setDesemb_lat(rs.getInt("des_lat"));
	        evento.setDesemb_lon(rs.getInt("des_long"));	        
	        return evento;
	        
		} catch (SQLException e) {
			System.out.println("Erro na busca!");
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * Atualiza Evento cadastrado no banco de dados
     * 
     * @param evento  Objeto do tipo Evento com o evento que será atualizado
     */
    public void updateEvento(Evento evento){
    	try {
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String sql = "UPDATE EVENTO set HORA_DESEMBARQUE = '"+evento.getHora_desembarque()+"' where ID="+evento.getId()+";"
            			+"UPDATE EVENTO set HORA_EMBARQUE = '"+evento.getHora_embarque()+"' where ID="+evento.getId()+";"
            			+"UPDATE EVENTO set EMB_LAT = '"+evento.getEmb_lat()+"' where ID="+evento.getId()+";"
            			+"UPDATE EVENTO set EMB_LONG = '"+evento.getEmb_lon()+"' where ID="+evento.getId()+";"
						+"UPDATE EVENTO set DES_LAT = '"+evento.getDesemb_lat()+"' where ID="+evento.getId()+";"
						+"UPDATE EVENTO set DES_LONG = '"+evento.getDesemb_lon()+"' where ID="+evento.getId()+";"
						+"UPDATE EVENTO set TAG = '"+evento.getTAG()+"' where ID="+evento.getId()+";"
						+"UPDATE EVENTO set NOTA = '"+evento.getNota()+"' where ID="+evento.getId()+";";
            stmt.executeUpdate(sql);
            con.commit();
            stmt.close();
            con.close();
            System.out.println("Evento atualizado!");
        } catch (Exception e) {
        	System.out.println("Erro: Evento não atualizado!");
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
    	my_obj.put("horaembarque",evento.getHora_embarque());
    	my_obj.put("horadesembarque",evento.getHora_desembarque());
    	my_obj.put("id",evento.getId());
    	my_obj.put("tag",evento.getTAG());
    	my_obj.put("nota",evento.getNota());
    	my_obj.put("embarquelatitude",evento.getEmb_lat());
    	my_obj.put("embarquelongitude",evento.getEmb_lon());
    	my_obj.put("desembarquelatitude",evento.getDesemb_lat());
    	my_obj.put("desembarquelongitude",evento.getDesemb_lon());
    	
    	String json_evt = my_obj.toString();
		return json_evt;
    }
    
    /**
     * Recebe uma String JSON e transforma em um objeto do tipo Evento
     * 
     * @param jsonEvento	String JSON que será transformada em um ojeto do tipo Evento
     * @return        		Retorna um Objeto do tipo Evento da StringJSON
     */
    //recebe a String Jsom e retorna um Obj Evento
    public Evento fromJson(String jsonEvento){
    	JSONObject obj = new JSONObject(jsonEvento);
    	Evento evento = new Evento();

    	UsuarioDao usuarioDao = new UsuarioDao();
    	Usuario usuario = usuarioDao.buscaUsuarioPorId(obj.getInt("idusuario"));
    	evento.setUsuario(usuario);
    	
    	if (obj.has("id"))evento.setId(obj.getInt("id"));
    	
    	evento.setHora_desembarque(obj.getString("horadesembarque"));
    	evento.setHora_embarque(obj.getString("horaembarque"));
    	evento.setTAG(obj.getString("tag"));
    	evento.setNota(obj.getInt("nota"));
    	evento.setEmb_lat(obj.getInt("embarquelatitude"));
    	evento.setEmb_lon(obj.getInt("embarquelongitude"));
    	evento.setDesemb_lat(obj.getInt("desembarquelatitude"));
    	evento.setDesemb_lon(obj.getInt("desembarquelongitude"));

		return evento;
    }
}
