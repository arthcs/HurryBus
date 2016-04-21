package hurrybus.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import hurrybus.dao.banco.ConectionFactory;
import hurrybus.model.Usuario;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 *
 * @author Dener
 * @update Arthur Silveira
 * 
 */
public class UsuarioDao {

    private Connection connection;

    Connection con;
    Statement stmt;


    public List<Usuario> buscarTodosUsuarios() {
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        this.connection = new ConectionFactory().getConnetion();
        try {
            con = connection;
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
            System.out.println("Usuarios mostrados com sucesso");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }        
        return usuarios;
    }
 
  //ok
    public Usuario buscaUsuarioPorId(int id) {    	
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
         
            System.out.println("Busca com sucesso");
            return usuario;
        } catch (Exception e) {
            System.out.println("ID não encontrado\n");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }        
    }

    //ok
    public void excluiUsuario(Usuario usuario) {
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

   //ok
    public void atualizaUsuario(Usuario usuario) {
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
    
    //ok
    public void insereUsuario(Usuario usuario) {
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
    
    
    public String toJson (Usuario u){
    	JSONObject my_obj = new JSONObject();
    	
    	my_obj.put("nome",u.getName());
    	my_obj.put("email",u.getEmail());
    	my_obj.put("id", u.getId());
    	my_obj.put("senha",u.getSenha());
    	
    	String json_user = my_obj.toString();
		return json_user;
    }
    
    //recebe a String Jsom e retorna um Obj usuario
    public Usuario fromJson(String json){
    	
    	JSONObject my_obj = new JSONObject(json);
    	Usuario user = new Usuario();
    	
    	user.setId(my_obj.getInt("id"));
    	user.setName(my_obj.getString("nome"));
    	user.setEmail(my_obj.getString("email"));
    	user.setSenha(my_obj.getString("senha"));
    	
		return user;
    }
    
}
