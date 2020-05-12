<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar</title>
<link rel="stylesheet"  href="/Practica001/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/Practica001/css/estilo.css" type="text/css">
</head>
<body id="home">
	<div class="login">
	<ul>			
		<li><a href="/Practica001/JSPs/login.jsp">Cerrar Sesión</a></li>
		<li><a href="/Practica001/ControladorSesion?id=2&ced=${p1.usu_id}">Mi Cuenta</a></li>  		
	</ul>
	</div>
	
	<div class="header">
	<h1>Modificar</h1>
	</div>

	<h1 id="title">${p1.usu_cedula}</h1>
	<h1>${p1.usu_correo}</h1>

<div  class="form-inline">
	<form action="/Practica001/AgregarNumero?ced=${p2 }" method="POST">

		<h1>Ingrese el numero para agregar:</h1>
		
		<label class="sr-only" for="exampleInputEmail3" for="numero">Numero: </label> 
		<input type="text" class="form-control" id="exampleInputName2"name="numero" placeholder="Número"> 
		
		<label class="sr-only" for="exampleInputEmail3" for="operadora">Operadora: </label> 
		<input type="text" class="form-control" id="exampleInputName2" name="operadora" placeholder="Operadora">
		
		 <label class="sr-only" for="exampleInputEmail3" for="tipo">Tipo:</label>
		 <input type="text" class="form-control" id="exampleInputName2" name="tipo" placeholder="Tipo">
		 
		<button type="submit" name="agregar" value="ingresar" class="btn btn-primary">ingresar</button>
	</form>
</div>
</body>
<footer>
  <p>Posted by: Daniel Peralta</p>
  <p>Contact information: <a href="dperaltat1@est.ups.edu.ec">dperaltat1@est.ups.edu.ec</a></p>
</footer>
</html>