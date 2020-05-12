<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teléfono encontrado</title>
<link rel="stylesheet" href="/Practica001/css/estilo.css" type="text/css">
</head>
<body>
	<ul>		
		<li><a href="/Practica001/JSPs/CrearUsuario.jsp">Regístrate</a></li>
		<li><a href="/Practica001/JSPs/login.jsp">Inicia Sesión</a></li>
		<li><a href="/Practica001/JSPs/Invitado.jsp">Buscar en Modo Invitado</a></li>
		<li><a href="/Practica001/index.html">Home</a></li>
	</ul>
	<c:set var="lista" scope="request" value="${telefono}" />
	<h1>Lista de teléfonos</h1>

	<table>
		<tr>
			<td><strong>Id</strong></td>
			<td><strong>Número</strong></td>
			<td><strong>Tipo</strong></td>
			<td><strong>Operadora</strong></td>
		</tr>
		<c:forEach var="t" items="${lista}">
			<tr>
				<td>${t.tel_id}</td>
				<td>${t.tel_numero}</td>
				<td>${t.tel_tipo}</td>
				<td>${t.tel_operadora}</td>
			</tr>
		</c:forEach>
	</table>

</body>
<footer>
  <p>Posted by: Daniel Peralta</p>
  <p>Contact information: <a href="dperaltat1@est.ups.edu.ec">dperaltat1@est.ups.edu.ec</a></p>
</footer>
</html>