<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="org.json.JSONObject"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluir evento</title>
</head>
<body>
Excluir Evento
<div class="container">
 <div class="panel-body">
	   <form action="" method="POST">
	   
	    	  <div class="form-group">
			    <label for="inputlg">Id do Usuário</label>
			    <input class="form-control" id="idusuario" name="idusuario" type="text">
			  </div>
	   
	   		  <div class="form-group">
			    <label for="inputlg">Id</label>
			    <input class="form-control" id="id" name="id" type="text">
			  </div>
	    	  <div class="form-group">
			    <label for="inputlg">Hora de Embarque</label>
			    <input class="form-control" id="horaembaque" name="horaembarque" type="text" >
			  </div>
	   		 <div class="form-group">
			    <label for="inputlg">Hora de Desembarque</label>
			    <input class="form-control" id="horadesembarque" name="horadesembarque" type="text" >
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
//recebe os valores digitados
	String idusuario = request.getParameter("idusuario");
	String id = request.getParameter("id");
	String HoraEmbarque = request.getParameter("horaembarque");
	String HoraDesembarque = request.getParameter("horadesembarque");
	String EmbarqueLatitude = request.getParameter("embarquelatitude");
	String EmbarqueLongitude = request.getParameter("embarquelongitude");
	String DesembarqueLatitude = request.getParameter("desembarquelatitude");
	String DesembarqueLongitude = request.getParameter("desembarquelongitude");
	String Nota = request.getParameter("nota");
	String TAG = request.getParameter("tag");

JSONObject obj = new JSONObject();

obj.put("idusuario",idusuario);
obj.put("id",id);
obj.put("horaembarque",HoraEmbarque);
obj.put("horadesembarque",HoraDesembarque);
obj.put("embarquelatitude",EmbarqueLatitude);
obj.put("embarquelongitude",EmbarqueLongitude);
obj.put("desembarquelatitude",DesembarqueLatitude);
obj.put("desembarquelongitude",DesembarqueLongitude);
obj.put("nota",Nota);
obj.put("tag",TAG);

out.println(obj.toString());
%>
</div>

</body>
</html>