<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TelaTest</title>
</head>
<body>

Usuario
<!--Clicando em Cadastro vai para a pagina de CRUD\UsuarioCadastro-->
<form action="CRUD\UsuarioCadastra.jsp" method="POST">
	<input type="submit" value="Cadastrar"/>
</form>

<form method="POST" action="CRUD\UsuarioExcluir.jsp">
	<input type="submit" value="Excluir"/>
</form>

<form action="CRUD\UsuarioAtualiza.jsp" method="POST">
	<input type="submit" value="Atualizar"/>
</form>

<form action="http://localhost:8080/HurryBus/rest/usuarios" method="GET">
	<input type="submit" value="Mostrar todos"/>
</form>

<form action="CRUD\UsuarioBuscaId.jsp" method="GET">
	<input type="submit" value="Buscar por ID"/>
</form>

</br>

<!--Clicando em um desses o usuario será direcinao para as funções CRUD do Evento-->
Eventos
<form action="CRUD\EventoCadastra.jsp" method="POST">
	<input type="submit" value="Cadastrar"/>
</form>

<form action="CRUD\EventoExclui.jsp" method="POST">
	<input type="submit" value="Excluir"/>
</form>

<form action="CRUD\EventoAtualiza.jsp" method="POST">
	<input type="submit" value="Atualiza"/>
</form>

<form action="http://localhost:8080/HurryBus/rest/eventos" method="GET">
	<input type="submit" value="Mostrar todos"/>
</form>

</body>