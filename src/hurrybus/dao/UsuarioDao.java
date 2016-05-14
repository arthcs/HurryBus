package hurrybus.dao;
import hurrybus.dao.banco.ConectionFactory;
import hurrybus.model.Usuario;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 *	Esta classe é responsavel por todas as requisições e persistencias
 * nescessárias na tabela Usuário do banco de dados.
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class UsuarioDao {
   /**
    * Mostra todos os Usuarios cadastrados
    * 
    * @return	Retorna um List com todos os Usuários
    */
    public List<Usuario> buscarTodosUsuarios() {
        Connection con;
        Statement stmt;
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        con = new ConectionFactory().getConnetion();
        try {
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
    * Busca Usuário cadastrado na tabela Usuarios por Id
    * 
    * @param id  Um inteiro com o id do usuário a ser buscado
    * @return    Retorna um Objeto do Usuário buscado
    */
    public Usuario buscaUsuarioPorId(int id) {
        Connection con;
        Statement stmt;
        try {
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
            System.out.println("ID não encontrado\n");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }        
    }

   /**
 	* Exclui Usuário cadastrado no banco de dados
 	* 
 	* @param usuario  Objeto do usuário que será removido
 	*/
    public void excluiUsuario(Usuario usuario) {
        Connection con;
        Statement stmt;
        try {
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
    * @param usuario  Objeto do usuário que será atualizado
    */
    public void atualizaUsuario(Usuario usuario) {
        Connection con;
        Statement stmt;
        try {
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
    * Cadastra novo Usuário na Tabela Usuarios
    * 
    * @param usuario  Objeto do usuário que será cadastrado
    */
    public void insereUsuario(Usuario usuario) {
        Connection con;
        Statement stmt;
        try {
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
    * Serializa um objeto do tipo Usuários em uma JSONstring
    * 
    * @param u  Objeto Usuário que será transformado em String JSON
    * @return   StringJSON do objeto
    */
    public String toJson (Usuario u){
    	JSONObject my_obj = new JSONObject();
    	
    	my_obj.put("id", u.getId());
    	my_obj.put("nome",u.getName());
        my_obj.put("email",u.getEmail());
        my_obj.put("senha",u.getSenha());
    	
    	String json_user = my_obj.toString();
		return json_user;
    }
    
   /**
    * Recebe uma String JSON e transforma em um objeto do tipo Usuario
    * 
    * @param json	String JSON que será transformada em um ojeto do tipo Usuario
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
}
