<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persona Encontrada</title>
</head>
<body>
	<c:set var="t" scope="request" value="${telefono}" />
	<h1>Teléfono encontrado</h1>		
		
	<p>Id: ${t.tel_id}</p>
	<p>Número: ${t.tel_numero}</p>
	<p>Tipo: ${t.tel_tipo}</p>
	<p>Operadora: ${t.tel_operadora}</p>
	
	<a href="/Practica001/index.html">Regresar</a>
	
</body>
</html>