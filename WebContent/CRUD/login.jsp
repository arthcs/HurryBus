<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.json.JSONObject"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/stilo.css" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script>

<script src="//code.jquery.com/jquery-3.0.0-rc1.min.js"></script> -->


<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<!-- 
<script type="text/javascript">
	$(document).ready(function() {
		$("#cadastrar").click(function() {
			$.ajax({
				url : "http://localhost:8080/HurryBus/rest/usuarios' + '/login'",
				contentType : "application/json; charset=utf-8",
				type : "post",
				dataType : "json",
				data : JSON.stringify({
					nome : $('#nome').val(),
					senha : $('#senha').val()
				}),
				
				
				success: function(retorno){
			        alert(retorno);
			    },
			    error: function(XMLHttpRequest, textStatus, errorThrown){
			        alert("Erro!");
			       
			        }
			  //  }

				
				
				/* success : function(data) {
					console.log(data);
					c
				},
				
				error : function (data)
				{
					/* alert("ERRO"); */
					
				//} 
			//});
		});
	});
</script>
 -->


<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#cadastrar")
								.click(
										function(event) {
											event.preventDefault();
											$
													.ajax({
														type : 'POST',
														url : 'http://localhost:8080/HurryBus/rest/usuarios'
																+ '/login',
														contentType : 'application/json; charset=utf-8',
														data : JSON.stringify({
															nome : $('#nome')
																	.val(),
															senha : $('#senha')
																	.val()
														}),
														dataType : 'json',
														cache : false,
														async : false,
														crossDomain : true,
														jsonp : true,
														jsonpCallback : "callback",
														/* dataType : 'json',
														contentType : "application/json; charset=utf-8", */

														//dataType: "jsonp", 
														success : AjaxSucceeded,

														/*  success : function(result) {
														      window.location = 'http://localhost:8080/HurryBus/CRUD/index.jsp';
														}, */

														error : AjaxFailed

													/* error: function (data, textStatus, xhr) {
														console.log(data)
														if(data.status == '404'){
															var url = "http://localhost:2020/snapcity/index.jsp";  
															  $(location).attr('href', url);
															}
													}, */

													/* complete: function (data, XMLHttpRequest, textStatus) {

													        if (XMLHttpRequest.status != null)
													           window.location.reload(); // Atualizo a pagina para redirecionar para o login

													//Seu código 
													
															if ( data.status){
																window.location.href = "error.html";
															} */

													//}

													});

										});
					});

	function AjaxSucceeded(result) {
		
		alert("Usuario Cadastrado");
		
		window.location.href = "http://localhost:8080/HurryBus/CRUD/index.jsp";
	
		//alert(result.status + ' ' + result.statusText);

		
		/* 
		window.location.href = "error.html";
			  if (result.getResponseHeader('REQUIRES_AUTH') === '1'){ 
		        window.location.href = 'http://localhost:8080/HurryBus/CRUD/index.jsp';
		    }  
		    var redirect_url = 'http://localhost:8080/HurryBus/CRUD/index.jsp';
		    if (result.redirect !== undefined && result.redirect) {
		        window.location.href = result.redirect_url;
		    } 
		  //  window.location = 'http://localhost:8080/HurryBus/CRUD/index.jsp';
		 */
	}
	function AjaxFailed(result) {
		alert("Erro de Acesso");
		if (result) {
			var successUrl = "http://localhost:8080/HurryBus/CRUD/login.jsp"; // might be a good idea to return this URL in the successful AJAX call
			window.location.href = successUrl;
		}

		
		//alert(result.status + ' ' + result.statusText);
		

	}


</script>


</head>
<body>
	<!--  <form action="ServletLogar" method="get"> 
	 <form action="rest/usuarios/login" method="get"> -->
	<div class="container">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Acesso ao sistema</h3>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8" role="form">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Nome" name="nome"
										id="nome" type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Senha" name="senha"
										id="senha" type="password" value="">
								</div>

								<input class="btn btn-lg btn-success btn-block" name="cadastrar"
									id="cadastrar" value="Acessar" type="submit" value="Login">

								<input
									class="btn btn-lg btn-success btn-block" type="reset"
									value="Limpar">

								<%-- <c:choose>
										<c:when test = "${mensagem!= null}">
											${mensagem}
										</c:when>
										<c:otherwise>
										<br>
											Entre com usuario/senha
										</c:otherwise>
									</c:choose>	 --%>

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
</body>
</body>
</html>