<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>
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
		<center>
		<div class="form-horizontal" >
			<form class="form-inline" action="/Practica001/CrearUsuario" method="POST">
				<h1>Registrarse</h1><br>
				<div class="form-horizontal">
					<label class="sr-only" for="exampleInputEmail3">Nombre:</label>
    				<input type="text" class="form-control" id="exampleInputName2" placeholder="Nombre" name="usu_nombre" required>
				</div>
				<div class="form-horizontal">
					<label class="sr-only" for="exampleInputEmail3">Apellido:</label>
    				<input type="text" class="form-control" id="exampleInputName2" placeholder="Apellido" name="usu_apellido" required>
				</div>
				<div class="form-horizontal">
					<label class="sr-only" for="exampleInputEmail3">Cedula:</label>
					<input type="text" class="form-control" id="exampleInputName2" placeholder="Cedula" name="usu_cedula" required>
				</div>
				<div class="form-horizontal">
					<label class="sr-only" for="exampleInputEmail3">Correo:</label>
					<input type="email" class="form-control" id="exampleInputEmail3" placeholder="Correo" name="usu_correo" required>
				</div>
				<div class="form-horizontal">
					<label class="sr-only" for="exampleInputEmail3">Contraseña:</label>
					<input type="password" class="form-control" id="exampleInputPassword3" placeholder="Contraseña" name="usu_contrasenia" required>
				</div>
				<br>
				<button class="btn btn-primary" type="submit" name="resp" value="Registrarse">Registrarse</button>
			</form>
		</div>
		</center>
</form>
</body>
<footer>
  <p>Posted by: Daniel Peralta</p>
  <p>Contact information: <a href="dperaltat1@est.ups.edu.ec">dperaltat1@est.ups.edu.ec</a></p>
</footer>
</html>