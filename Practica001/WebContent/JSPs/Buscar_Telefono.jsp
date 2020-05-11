<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teléfono Encontrada</title>
<link rel="stylesheet"  href="/Practica001/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/Practica001/css/estilo.css" type="text/css">
</head>
<body>
	<ul>
		<li><a href="/Practica001/index.html">Home</a></li>
		<li><a href="/Practica001/JSPs/CrearUsuario.jsp">Regístrate</a></li>
		<li><a href="/Practica001/JSPs/login.jsp">Inicia Sesión</a></li>
		<li><a href="/Practica001/JSPs/Invitado.jsp">Buscar en Modo Invitado</a></li>
	</ul>
	<c:set var="t" scope="request" value="${telefono}" />
	<h1>Teléfono encontrado</h1>		
		
	<p>Id: ${t.tel_id}</p>
	<p>Número: ${t.tel_numero}</p>
	<p>Tipo: ${t.tel_tipo}</p>
	<p>Operadora: ${t.tel_operadora}</p>
	
	<a href="/Practica001/index.html">Regresar</a>
	
</body>
</html>