<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teléfono encontrado</title>
</head>
<body>
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
	<a href="/Practica001/index.html">Regresar</a>

</body>
</html>