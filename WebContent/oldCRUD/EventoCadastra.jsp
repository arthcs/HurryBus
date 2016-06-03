<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.json.JSONObject"%>   

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
            	  url: "http://localhost:8080/HurryBus/rest/eventos",
               contentType: "application/json; charset=utf-8",
               type: "post",
               dataType:"json",
               data : JSON.stringify( {
            	   idusuario : $('#idusuario').val(),
            	   embarquelatitude : $('#embarquelatitude').val(),
            	   embarquelongitude : $('#embarquelongitude').val(),
            	   desembarquelatitude : $('#desembarquelatitude').val(),
            	   desembarquelongitude : $('#desembarquelongitude').val(),
            	   nota : $('#nota').val(),
            	   tag : $('#tag').val()
            	   }),
               success: function(data) {
                   console.log(data);
               }
           });
       });       
   });
</script>

<title>Cadastra Evento</title>
</head>
<body>
Cadastrar novo evento
<div class="container">
 <div class="panel-body">
	   <form method="POST">
	    	  <div class="form-group">
			    <label for="inputlg">Id do Usuario</label>
			    <input class="form-control" id="idusuario" name="idusuario" type="text">
			  </div>
			  <div class="form-group">
			    <label for="inputlg">Embarque latitude</label>
			    <input class="form-control" id="embarquelatitude" name="embarquelatitude" type="text">
			  </div>
			  <div class="form-group">
			    <label for="inputsm">Embarque longitude</label>
			    <input class="form-control" id="embarquelongitude" name="embarquelongitude" type="text">
			  </div>
			  <div class="form-group">
			    <label for="inputlg">Desembarque latitude</label>
			    <input class="form-control" id="desembarquelatitude" name="desembarquelatitude" type="text">
			  </div>
			  <div class="form-group">
			    <label for="inputsm">Desembarque longitude</label>
			    <input class="form-control" id="desembarquelongitude" name="desembarquelongitude" type="text">
			  </div>
			  <div class="form-group">
			    <label for="inputlg">Nota</label>
			    <input class="form-control" id="nota" name="nota" type="text">
			  </div>
			  <div class="form-group">
			    <label for="inputsm">tag</label>
			    <input class="form-control" id="tag" name="tag" type="text">
			  </div>
			  <input type="submit" id="cadastrar" class="btn btn-default" value="Enviar"/>
	   </form>
	  </div>
	  
<% 

%>
</div>

</body>
</html>