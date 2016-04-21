package testes;

import org.json.JSONObject;

import hurrybus.dao.UsuarioDao;
import hurrybus.model.Usuario;

public class UsuarioJson {
    //recebe a String Jsom e retorna um Obj usuario
    public void cadastraJson(String json){
    	
    	JSONObject my_obj = new JSONObject(json);
    	Usuario user = new Usuario();
    	
    	user.setId(my_obj.getInt("ID"));
    	user.setName(my_obj.getString("Nome"));
    	user.setEmail(my_obj.getString("Email"));
    	user.setSenha(my_obj.getString("Senha"));
    	
    	UsuarioDao userdao = new UsuarioDao();
    	userdao.insereUsuario(user);
    }
    
    public void excluiJson(String json){
    	
    	JSONObject my_obj = new JSONObject(json);
    	Usuario user = new Usuario();
    	
    	user.setId(my_obj.getInt("ID"));
    	user.setName(my_obj.getString("Nome"));
    	user.setEmail(my_obj.getString("Email"));
    	user.setSenha(my_obj.getString("Senha"));
    	
    	UsuarioDao userdao = new UsuarioDao();
    	userdao.excluiUsuario(user);
    	}


    public void atualizaJson(String json){
	
    	JSONObject my_obj = new JSONObject(json);
    	Usuario user = new Usuario();
	
    	user.setId(my_obj.getInt("ID"));
    	user.setName(my_obj.getString("Nome"));
    	user.setEmail(my_obj.getString("Email"));
    	user.setSenha(my_obj.getString("Senha"));
	
    	UsuarioDao userdao = new UsuarioDao();
    	userdao.atualizaUsuario(user);
    	}
}
