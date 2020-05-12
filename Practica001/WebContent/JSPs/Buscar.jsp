<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar</title>
<link rel="stylesheet"  href="/Practica001/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/Practica001/css/estilo.css" type="text/css">
</head>
<body>
	<div class="login">
	<ul>			
		<li><a href="/Practica001/JSPs/Agregar.jsp">Agregar Datos</a>			
		<li><a href="/Practica001/JSPs/login.jsp">Cerrar Sesión</a></li>
		<li><a href="/Practica001/ControladorSesion?id=2&ced=${p1.usu_id}">Mi Cuenta</a></li>		
	</ul>
	</div>
	<div>
		<h1>Busquedas</h1>
	</div>
	<br>
<form action="/Practica001/Buscar?id=1" method="POST">
	  		<h1>Busca por el número de Cedula</h1>
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-primary" name="buscarCorreo" value="correoB" type="submit">Buscar</button>
      </span>
    </div>
  </div>
</form>
<br>
<form action="/Practica001/Buscar?id=2" method="POST">
  		<h1>Busca por el número de Correo</h1>
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-primary" name="buscarCed" value="cedulaB" type="submit">Buscar</button>
      </span>
    </div>
  </div>
</form>
<table class="container">
	<thead>
			<tr>
				<th>Nombre</th>
				<th>Correo</th>
				<th>Tipo</th>
				<th>Operadora</th>
				<th>Número</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="telf" items="${p1}">
				<tr>

					<td>${telf.correo}
					<td>${telf.tipo}</td>
					<td>${telf.operadora}</td>
					<td>${telf.numero}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
<footer>
  <p>Posted by: Daniel Peralta</p>
  <p>Contact information: <a href="dperaltat1@est.ups.edu.ec">dperaltat1@est.ups.edu.ec</a></p>
</footer>
</html>