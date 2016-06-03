<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eventos no Mapa</title>
</head>
<body>

 <div id="mapa" style="height: 500px; width: 700px">
 </div>
 		<!--  biblioteca jQuery  -->
 		<script src="js\jquery.min.js"></script>
 		
        <!-- Maps API Javascript -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyClAhsFVXpLuLSqQ2eOxeH7YWVfvdLt5JA&callback"></script>
        
        <!--  Pontos dos Eventos em Json  -->
        <script src="js\pontos.js"></script>
        
        <!-- Arquivo de inicialização do mapa -->
        <script src="js\map.js"></script>
        
</body>

</body>
</html>