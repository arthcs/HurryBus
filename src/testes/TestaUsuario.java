package testes;

import java.io.IOException;

import hurrybus.UsuarioHandler;
import hurrybus.dao.UsuarioDao;
import hurrybus.model.Usuario;

public class TestaUsuario {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Usuario arthur = new Usuario();
		 arthur.setName("Scar");
		 arthur.setEmail("s@s.com");
		 arthur.setSenha("sacarface");
		 arthur.setId(20);
		 
		 //System.out.println(arthur.toString());
		 
		 UsuarioDao dao = new UsuarioDao();
		 //dao.insereUser(arthur);
		 //arthur.setId(14);
		 //arthur.setName("Trocado");
		 //dao.atualizaUser(arthur);
		 
		 //dao.excluiUser(arthur);
		 
		 String json = "";
		 
		 Usuario u1 = dao.fromJson(json);
		 
		 //----Teste de busca
		 Usuario buscado = new Usuario();
		 //buscado=dao.buscaUser(15);
		 System.out.println(buscado.toString());
		 System.out.println();
		 //dao.mostrarUsuario();
		 
		 //----teste do String json
		 arthur.setName("Sacarlet alterado");
		 String JsonUser = dao.toJson(arthur);
		 System.out.println("Obj para StringJSON="+JsonUser);
		 UsuarioJson Json = new UsuarioJson();
		 //Json.atualizaJson(JsonUser);
		 Json.excluiJson(JsonUser);
		 //Json.cadastraJson(JsonUser);
		 
		 //----String json para Obj Usuario
		 Usuario user = new Usuario();
		 //user=dao.fromJson(JsonUser);
		 //System.out.println("JSON para Obj="+user.toString());
		 
//		 UsuarioHandler handler = new UsuarioHandler();
//		 handler.novoUsuario("teste", null);
//		 
	}

}
