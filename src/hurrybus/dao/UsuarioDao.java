package hurrybus.dao;
import hurrybus.dao.banco.ConectionFactory;
import hurrybus.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 *	Esta classe � responsavel por todas as requisi��es e persistencias
 * nescess�rias na tabela Usu�rio do banco de dados.
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class UsuarioDao {
	
	/**
	 * Verifica se o usuarios esta cadastrado no banco de dados
	 * 
	 * @return	Retorna um List com todos os Usu�rios
	 */
	public Usuario verificaUsuario(Usuario usuario) {
		Connection connection = new ConectionFactory().getConnetion();
		Statement stmt;
		
		try {
			stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from usuarios where nome = '"+usuario.getName()+"' and senha = '"+usuario.getSenha()+"';");
	        
	        rs.next();
	        usuario.setName(rs.getString("nome"));
	        usuario.setSenha(rs.getString("senha"));
	        usuario.setId(rs.getInt("id"));
	        usuario.setEmail(rs.getString("email"));  
	        return usuario;
		  	}
		  catch (SQLException e){  
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		  }
		  return null;
		}
	
	
   /**
    * Mostra todos os Usuarios cadastrados
    * 
    * @return	Retorna um List com todos os Usu�rios
    */
    public static List<Usuario> buscarTodosUsuarios() {
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
        	Connection con;
            Statement stmt;
            con = new ConectionFactory().getConnetion();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS");
            while (rs.next()) {                
                Usuario usuario = new Usuario();
                usuario.setName(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));   
                usuarios.add(usuario);
            }
            rs.close();
            con.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
        return usuarios;
    }
 
   /**
    * Busca Usu�rio cadastrado na tabela Usuarios por Id
    * 
    * @param id  Um inteiro com o id do usu�rio a ser buscado
    * @return    Retorna um Objeto do Usu�rio buscado
    */
    public Usuario buscaUsuarioPorId(int id) {
        try {
            Connection con;
            Statement stmt;
        	con = new ConectionFactory().getConnetion();
        	con.setAutoCommit(false);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS WHERE id = '" + id + "';");
            rs.next();
            
            Usuario usuario = new Usuario();
            usuario.setEmail(rs.getString("email"));
            usuario.setName(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setId(rs.getInt("id"));

            rs.close();
            con.close();
            stmt.close();

            return usuario;
        } catch (Exception e) {
            System.out.println("ID n�o encontrado\n");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }        
    }

   /**
 	* Exclui Usu�rio cadastrado no banco de dados
 	* 
 	* @param usuario  Objeto do usu�rio que ser� removido
 	*/
    public void excluiUsuario(Usuario usuario) {
        try {
            Connection con;
            Statement stmt;
        	con = new ConectionFactory().getConnetion();
        	con.setAutoCommit(false);
            stmt = con.createStatement();
            String sql = "DELETE FROM USUARIOS WHERE id = '" + usuario.getId()+ "';";
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
    * Atualiza Usuario cadastrado no banco de dados
    * 
    * @param usuario  Objeto do usu�rio que ser� atualizado
    */
    public void atualizaUsuario(Usuario usuario) {
        try {
            Connection con;
            Statement stmt;
            con = new ConectionFactory().getConnetion();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String sql = "UPDATE usuarios set nome = '" + 
            		usuario.getName() + "',senha ='" + 
            		usuario.getSenha() + "', email = '" + 
            		usuario.getEmail() + "' where id='" + 
            		usuario.getId() + "';";
            stmt.executeUpdate(sql);
            con.commit();
            con.close();
            stmt.close();
            System.out.println("Atualizado com sucesso");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
    }
    
   /**
    * Cadastra novo Usu�rio na Tabela Usuarios
    * 
    * @param usuario  Objeto do usu�rio que ser� cadastrado
    */
    public void insereUsuario(Usuario usuario) {
        try {
            Connection con;
            Statement stmt;
            con = new ConectionFactory().getConnetion();       
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String sql = "INSERT INTO usuarios (nome,senha,email) values ('" + 
            		usuario.getName() + "','" + 
            		usuario.getSenha() + "','" + 
            		usuario.getEmail() + "');";
            stmt.executeUpdate(sql);
            con.commit();
            stmt.close();
            con.close();
            System.out.println("Criado com sucesso");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " Erro: " + e.getMessage());
        }        
    }
    
   /**
    * Serializa um objeto do tipo Usu�rios em uma JSONstring
    * 
    * @param u  Objeto Usu�rio que ser� transformado em String JSON
    * @return   StringJSON do objeto
    */
    public static JSONObject toJson (Usuario u){
    	JSONObject my_obj = new JSONObject();
    	
    	my_obj.put("id", u.getId());
    	my_obj.put("nome",u.getName());
        my_obj.put("email",u.getEmail());
        my_obj.put("senha",u.getSenha());
    	
    	//String json_user = my_obj.toString();
		return my_obj;
    }
    
   /**
    * Recebe uma String JSON e transforma em um objeto do tipo Usuario
    * 
    * @param json	String JSON que ser� transformada em um ojeto do tipo Usuario
    * @return    	Retorna um Objeto do tipo Usuario da StringJSON
    */
    public Usuario fromJson(String json){
    	
    	JSONObject my_obj = new JSONObject(json);
    	Usuario user = new Usuario();
    	
    	if (my_obj.has("id"))user.setId(my_obj.getInt("id"));
    		
    	user.setName(my_obj.getString("nome"));
    	user.setEmail(my_obj.getString("email"));
    	user.setSenha(my_obj.getString("senha"));
    	
		return user;
    }
    
    /**
     * Recebe uma String JSON e transforma em um objeto do tipo Usuario
     * 
     * @param json	String JSON que ser� transformada em um ojeto do tipo Usuario
     * @return    	Retorna um Objeto do tipo Usuario da StringJSON
     */
     public Usuario loginJson(String json){
     	
     	JSONObject my_obj = new JSONObject(json);
     	Usuario user = new Usuario();
     	
     	if (my_obj.has("id"))user.setId(my_obj.getInt("id"));
     		
     	user.setName(my_obj.getString("nome"));
     	//user.setEmail(my_obj.getString("email"));
     	user.setSenha(my_obj.getString("senha"));
     	
 		return user;
     }
}
