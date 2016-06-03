<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="org.json.JSONObject"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Atualiza o Evento</title>



<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#cadastrar").click(function() {
			$.ajax({
				url : "http://localhost:8080/HurryBus/rest/eventos",
				contentType : "application/json; charset=utf-8",
				type : "put",
				dataType : "json",
				data : JSON.stringify({
					idusuario : $('#idusuario').val(),
					embarqueHora : $('#horaembaque').val(),
					desembarqueHora : $('#horadesembarque').val(),
					embarquelatitude : $('#embarquelatitude').val(),
					embarquelongitude : $('#embarquelongitude').val(),
					desembarquelatitude : $('#desembarquelatitude').val(),
					desembarquelongitude : $('#desembarquelongitude').val(),
					nota : $('#nota').val(),
					tag : $('#tag').val()
				}),
				success : function(data) {
					console.log(data);
				}
			});
		});
	});
</script>




<script type="text/javascript">
	function preencher() {
		if ("geolocation" in navigator) {
			navigator.geolocation.getCurrentPosition(function(posicao) {
				var url = "http://nominatim.openstreetmap.org/reverse?lat="
						+ posicao.coords.latitude + "&lon="
						+ posicao.coords.longitude
						+ "&format=json&json_callback=preencherDados1";
				var script = document.createElement('script');
				script.src = url;
				document.body.appendChild(script);

			});
		} else {
			alert('seu navegador não suporta geolocation');
		}
	}
	function preencher2() {
		if ("geolocation" in navigator) {
			navigator.geolocation.getCurrentPosition(function(posicao) {
				var url = "http://nominatim.openstreetmap.org/reverse?lat="
						+ posicao.coords.latitude + "&lon="
						+ posicao.coords.longitude
						+ "&format=json&json_callback=preencherDados2";
				var script = document.createElement('script');
				script.src = url;
				document.body.appendChild(script);

			});
		} else {
			alert('seu navegador não suporta geolocation');
		}
	}
	function preencher3() {
		if ("geolocation" in navigator) {
			navigator.geolocation.getCurrentPosition(function(posicao) {
				var url = "http://nominatim.openstreetmap.org/reverse?lat="
						+ posicao.coords.latitude + "&lon="
						+ posicao.coords.longitude
						+ "&format=json&json_callback=preencherDados3";
				var script = document.createElement('script');
				script.src = url;
				document.body.appendChild(script);

			});
		} else {
			alert('seu navegador não suporta geolocation');
		}
	}
	function preencher4() {
		if ("geolocation" in navigator) {
			navigator.geolocation.getCurrentPosition(function(posicao) {
				var url = "http://nominatim.openstreetmap.org/reverse?lat="
						+ posicao.coords.latitude + "&lon="
						+ posicao.coords.longitude
						+ "&format=json&json_callback=preencherDados4";
				var script = document.createElement('script');
				script.src = url;
				document.body.appendChild(script);

			});
		} else {
			alert('seu navegador não suporta geolocation');
		}
	}
	function preencherDados1(dados) {
		document.querySelector('[name=embarquelatitude]').value = dados.lat;

	}
	function preencherDados2(dados) {
		document.querySelector('[name=embarquelongitude]').value = dados.lon;

	}
	function preencherDados3(dados) {
		document.querySelector('[name=desembarquelatitude]').value = dados.lat;

	}
	function preencherDados4(dados) {
		document.querySelector('[name=desembarquelongitude]').value = dados.lon;

	}
</script>
</head>
</head>
<body>



	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Atualiza o Evento</div>

				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form id="loginform" class="form-horizontal" role="form">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="idusuario"
								name="idusuario" type="text" class="form-control" value=""
								placeholder="ID do Usuário">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="id" name="id"
								type="text" class="form-control" placeholder="ID">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-time"></i></span> <input id="horaembaque"
								name="horaembarque" type="text" class="form-control"
								onfocus="(this.type='time')" onblur="(this.type='text')"
								placeholder="Hora de Embarque	">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-time"></i></span> <input
								id="horadesembarque" name="horadesembarque" type="text"
								class="form-control" onfocus="(this.type='time')"
								onblur="(this.type='text')" placeholder="Hora de Desembarque">



						</div>

						<div id="embarquelatitude" style="margin-bottom: 25px"
							class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-map-marker"></i></span> <input
								id="embarquelatitude" name="embarquelatitude" type="text"
								class="form-control" placeholder="Embarque Latitude">
							<button class="small" onclick="preencher()" type="button">Gerar
								Latitude</button>

						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-map-marker"></i></span> <input
								id="embarquelongitude" name="embarquelongitude" type="text"
								class="form-control" placeholder="Embarque longitude">
							<button class="small" onclick="preencher2()" type="button">Gerar
								Longitude</button>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-map-marker"></i></span> <input
								id="desembarquelatitude" name="desembarquelatitude" type="text"
								class="form-control" placeholder="Desembarque latitude">
							<button class="small" onclick="preencher3()" type="button">Gerar
								Latitude</button>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-map-marker"></i></span> <input
								id="desembarquelongitude" name="desembarquelongitude"
								type="text" class="form-control"
								placeholder="Desembarque longitude">
							<button class="small" onclick="preencher4()" type="button">Gerar
								Longitude</button>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-ok"></i></span> <input id="nota" name="nota"
								type="number" class="form-control" placeholder="Nota">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-tag"></i></span> <input id="tag" name="tag"
								type="text" class="form-control" placeholder="TAG">
						</div>







						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">

								<input type="submit" id="cadastrar" class="btn btn-success"
									value="Atualiar" />

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">

								</div>
							</div>
						</div>
					</form>

				</div>

			</div>
		</div>
	</div>


	<%
		//recebe os valores digitados
		//	String idusuario = request.getParameter("idusuario");
		//	String id = request.getParameter("id");
		//	String HoraEmbarque = request.getParameter("horaembarque");
		//	String HoraDesembarque = request.getParameter("horadesembarque");
		//	String EmbarqueLatitude = request.getParameter("embarquelatitude");
		//	String EmbarqueLongitude = request.getParameter("embarquelongitude");
		//	String DesembarqueLatitude = request.getParameter("desembarquelatitude");
		//	String DesembarqueLongitude = request.getParameter("desembarquelongitude");
		//	String Nota = request.getParameter("nota");
		//	String TAG = request.getParameter("tag");

		//JSONObject obj = new JSONObject();

		//obj.put("idusuario",idusuario);
		//obj.put("id", id);
		///obj.put("horaembarque",HoraEmbarque);
		//obj.put("horadesembarque", HoraDesembarque);
		//obj.put("embarquelatitude", EmbarqueLatitude);
		//obj.put("embarquelongitude",EmbarqueLongitude);
		//obj.put("desembarquelatitude",DesembarqueLatitude);
		//obj.put("desembarquelongitude",DesembarqueLongitude);
		//obj.put("nota",Nota);
		//obj.put("tag",TAG);

		//out.println(obj.toString());
	%>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>