<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"  href="/Practica001/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/Practica001/css/estilo.css" type="text/css">
</head>
<body id="home">
	<div>
	<ul>			
		<li><a href="/Practica001/JSPs/login.jsp">Cerrar Sesión</a></li>		
	</ul>
	</div>
	
	<c:set var="t1" value="${requestScope['telefono']}"/>
	<c:set var="p2" value="${requestScope['usuario'] }"/>

<%/* <h1>Login con exito</h1> */%>
	
	<div class="header">
		<div>
  		<h1>Bienvenido ${p2.nombre }</h1>
  		Busca por el número de Cedula.
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-primary" name="usu_cedula" type="button">Buscar</button>
      </span>
    </div>
  </div>
</div>
  		Busca por el número de Correo.
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control">
      <span class="input-group-btn">
        <button class="btn btn-primary" name="usu_correo" type="button">Buscar</button>
      </span>
    </div>
  </div>
</div>
  		<h1> ${p2.usu_nombre} ${p2.usu_apellido }</h1>
  			<ul>
  				<li><a href="/Practica001/ControladorSesion?id=2&idU=${p2.usu_id}"></a>
  			</ul>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</div>
		
	<table class="table">
	<thead>
		<tr>
			<th><h1>Codigo</h1></th>
			<th><h1>Numero</h1></th>
			<th><h1>Tipo</h1></th>
			<th><h1>Operadora</h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="telf" items="${t1}">
			<tr>	
				<td>${telf.tel_id}</td>
				<td>${telf.tel_numero}</td>
				<td>${telf.tel_tipo}</td>
				<td>${telf.tel_operadora}</td>
				<td><a href="/Practica-1/EliminarNumero?id=${telf.tel_id}&idUser=${p2.usu_id}">Eliminar</a></td>
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