<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="org.json.JSONObject"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script  type="text/javascript" >
function teste(){			
	$.ajax({
				type : 'POST',
				url : 'http://localhost:8080/HurryBus/rest/usuarios'+'/login',
				contentType : 'application/json; charset=utf-8',
				data : JSON.stringify({
					nome : localStorage.nome
							,
					senha : localStorage.id
				}),
				dataType : 'json',
				cache : false,
				async : false,
				crossDomain : true,
				jsonp : true,
				jsonpCallback : "callback",
			
				success : AjaxSucceeded,
				error : AjaxFailed
			});
	
}
    function AjaxSucceeded(result) {
		
		alert("Usuario Cadastrado");
		
		window.location.href = "http://localhost:8080/HurryBus/CRUD/index.jsp";
	
	}
	function AjaxFailed(result) {
		alert("Erro de Acesso");
		if (result) {
			var successUrl = "http://localhost:8080/HurryBus/CRUD/login.jsp"; // might be a good idea to return this URL in the successful AJAX call
			window.location.href = successUrl;
		}
	
	
	}
</script >
<script>
  
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    
    if (response.status === 'connected') {
      
      testAPI();
    } else if (response.status === 'not_authorized') {
     
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
     
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

 
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '626698044148646',
    cookie     : true,  
                        
    xfbml      : true,  
    version    : 'v2.6' 
  });

 

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>



<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

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

														success : AjaxSucceeded,
														error : AjaxFailed

													});

										});
					});
		
		 function AjaxSucceeded(result) {
			
			alert("Usuario Cadastrado");
			
			window.location.href = "http://localhost:8080/HurryBus/CRUD/index.jsp";
	}
	function AjaxFailed(result) {
		alert("Erro de Acesso");
		if (result) {
			var successUrl = "http://localhost:8080/HurryBus/CRUD/login.jsp"; // might be a good idea to return this URL in the successful AJAX call
			window.location.href = successUrl;
		}
	}

</script>
</head>
  <div class="panel panel-default">
            <div class="panel-heading" style="display: flex; justify-content: center; align-items: center; overflow: auto;">
              <h3 class="panel-title">Atualiza��es</h3>
            </div>
            <div id="mapa" style="height: 100%; width: 100%; margin: 0 auto; padding: 20px;position:absolute; justify-content: center; align-items: center; resize: both; overflow: auto;">
    			<!--  biblioteca jQuery  -->
 				<script src="js\jquery.min.js"></script>
   				<!-- Maps API Javascript -->
    			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyClAhsFVXpLuLSqQ2eOxeH7YWVfvdLt5JA&callback"></script>
    			<!--  Pontos dos Eventos em Json  -->
    			<script src="js\pontos.js"></script>
    			<!-- Arquivo de inicializa��o do mapa -->
    			<script src="js\map.js"></script>
            </div>
          </div>

<body>
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
								
								<input class="btn btn-lg btn-success btn-block" type="button" value="Cadastrar" onclick="document.location.href='UsuarioCadastra.jsp'"/>
								<input class="btn btn-lg btn-success btn-block" type="reset" value="Limpar">
								
								<div class="fb-login-button" data-max-rows="1" onlogin="teste()" data-size="xlarge" data-show-faces="false" data-auto-logout-link="false"></div>
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