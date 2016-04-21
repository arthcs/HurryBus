<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="org.json.JSONObject"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Excluir cadastro

<div class="container">
 <div class="panel-body">
	   <form action="" method="POST">
	    	  <div class="form-group">
			    <label for="inputlg">Id</label>
			    <input class="form-control" id="id" name="id" type="text" >
			  </div>
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
String id = request.getParameter("id");

JSONObject obj = new JSONObject();

obj.put("id", id);
obj.put("nome", nome);
obj.put("senha", senha);
obj.put("email", email);

out.println(obj.toString());
%>
</div>
</body>
</html>