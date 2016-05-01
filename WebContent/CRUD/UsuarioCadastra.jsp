<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
        $("#cadastrar").click(function() {
               $.ajax({
            	  url: "http://localhost:8080/HurryBus/rest/usuarios",
               contentType: "application/json; charset=utf-8",
               type: "post",
               dataType:"json",
               data : JSON.stringify( {nome : $('#nome').val(), senha : $('#senha').val(), email : $('#email').val()} ),
               success: function(data) {
                   console.log(data);
               }
           });
       });       
   });
</script>

<title>Usuario Cadastra</title>
</head>
<body>
Cadastrando Usuario
<div class="container">
 <div class="panel-body">
     <form method="POST">
	   		 <div class="form-group">
			    <label for="inputlg">Nome</label>
			    <input class="form-control" id="nome" name="nome" type="text" >
			  </div>
			  <div class="form-group">
			    <label for="inputlg">Senha</label>
			    <input class="form-control" id="senha" name="senha" type="password">
			  </div>
			  <div class="form-group">
			    <label for="inputsm">Email</label>
			    <input class="form-control" id="email" name="email" type="text">
			  </div>
			  <input type="submit" id="cadastrar" class="btn btn-default" value="Cadastrar"/>	  			
	  </form>
	  </div>
</div>
</body>
</html>