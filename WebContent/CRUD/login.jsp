<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/stilo.css"/>
	
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#cadastrar").click(function() {
				$.ajax({
					url : "http://localhost:8080/HurryBus/rest/usuarios/autentica",
					contentType : "application/json; charset=utf-8",
					type : "post",
					dataType : "json",
					data : JSON.stringify({
						nome : $('#nome').val(),
						senha : $('#senha').val()
						}),
					sucess : function(data) {
						console.log(data);
						//alert(data);
						alert("Usuario cadastrado");
						},
					
					error : function (data){
						alert("Não exite");
						}
				});
			});
		});
</script>

</head>
<body>
		<div class="container">
			<div class="row vertical-offset-100">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Acesso ao sistema</h3>
						</div>
						<div class="panel-body">
							<form accept-charset="UTF-8" role="form" method="POST">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="Nome" name="nome" type="text">
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Senha" name="senha" type="password" value="">
									</div>
									<input class="btn btn-lg btn-success btn-block" id="cadastrar" value="Esse" type="submit" value="Login">	
									<input class="btn btn-lg btn-success btn-block" type="reset" value="Limpar">	
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</body>
</html>