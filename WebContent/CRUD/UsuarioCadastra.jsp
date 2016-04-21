<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario Cadastra</title>
</head>
<body>
Cadastrando Usuario
<div class="container">
 <div class="panel-body">
	   <form action="" method="POST">
	   		 <div class="form-group">
			    <label for="inputlg">Nome</label>
			    <input class="form-control" id="nome" name="nome" type="text" >
			  </div>
			  <div class="form-group">
			    <label for="inputlg">Senha</label>
			    <input class="form-control" id="senha" name="senha" type="text">
			  </div>
			  <div class="form-group">
			    <label for="inputsm">Email</label>
			    <input class="form-control" id="email" name="email" type="text">
			  </div>
			  <input type="submit" id="cadastrar" class="btn btn-default" value="Enviar"/>
	   </form>
	  </div>
	  
<% 
//recebe os valores digitados
String nome = request.getParameter("nome");
String senha = request.getParameter("senha");
String email = request.getParameter("email");

JSONObject obj = new JSONObject();
obj.put("nome", nome);
obj.put("senha", senha);
obj.put("email", email);

out.println(obj.toString());
%>
</div>
</body>
</html>