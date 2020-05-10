<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>
<link rel="stylesheet"  href="/Practica001/css/bootstap.min.css" type="text/css">
</head>
<body>
	<form action="/Practica001/CrearUsuario" method="POST">
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><a href="/Practica001/JSPs/index.jsp" style="font-size:x-large">Agenda</a><span></span></div>
		</div>
		<br>
		<div class="login">
				<h1>Registrar Usuario</h1><br>
				<input type="text" placeholder="Nombre" name="usu_nombre" required><br>
				<input type="text" placeholder="Apellido" name="usu_apellido" required><br>
				<input type="text" placeholder="Cedula" name="usu_cedula" required><br>
				<input type="text" placeholder="E-mail" name="usu_correo" required><br>
				<input type="password" placeholder="Password" name="usu_contrasenia" required><br>
				<button type="submit" name="resp" value="Registrarse">Registrarse</button>
		</div>
</form>
</body>
</html>