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
        $("#buscar").click(function() {
               $.ajax({
            	  url: "http://localhost:8080/HurryBus/rest/eventos/"+$('#id').val(),
               contentType: "application/json; charset=utf-8",
               type: "get",
               dataType:"json",
               success: function(data) {
                   console.log(data);
               }
           });
       });       
   });
</script>

<title>Busca por Id</title>
</head>
<body>
Buscar o evento por Id
<div class="container">
 <div class="panel-body">
	   <form>
	   		  <div class="form-group">
			    <label for="inputlg">Id</label>
			    <input class="form-control" id="id" name="id" type="text">
			  </div>
	    	  <input type="submit" id="buscar" class="btn btn-default" value="Buscar"/>
	   </form>
	  </div>
	  
<% 
%>
</div>

</body>
</html>