<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listas de telefonos</title>
<link rel="stylesheet"  href="/Practica001/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/Practica001/css/estilo.css" type="text/css">
</head>
<body id="home">
	<div class="login">
	<ul>			
		<li><a href="/Practica001/JSPs/CrearUsuario.jsp">Regístrate</a></li>
		<li><a href="/Practica001/JSPs/login.jsp">Inicia Sesión</a></li>
		<li><a href="/Practica001/JSPs/Invitado.jsp">Buscar en Modo Invitado</a></li>
		<li><a href="/Practica001/JSPs/index.jsp">Home</a></li>			
	</ul>
	</div>	
<form action="/Practica001/src/controlador/ListarTelefonoControlador.java" method="get">
	<c:set var="lista" scope="request" value="${listaTelefono}" />
	<h1>Lista de telefonos</h1>

	<table>
		<tr>
			<td><strong>codigo</strong></td>
			<td><strong>telefono</strong></td>
			<td><strong>tipo</strong></td>
			<td><strong>Operadora</strong></td>
		</tr>
		<c:forEach var="t" items="${lista}">
			<tr>
				<td>${t.codigo}</td>
				<td>${t.numero}</td>
				<td>${t.tipo}</td>
				<td>${t.operadora}</td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
<footer>
  <p>Posted by: Daniel Peralta</p>
  <p>Contact information: <a href="dperaltat1@est.ups.edu.ec">dperaltat1@est.ups.edu.ec</a></p>
</footer>
</html>