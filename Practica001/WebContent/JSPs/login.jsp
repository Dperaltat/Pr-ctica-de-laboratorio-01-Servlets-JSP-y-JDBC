<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
		<title>Login</title>
		<link href="/Practica001/css/bootstap.min.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<form class="form-inline">
  			<div class="form-group">
    			<label class="sr-only" for="exampleInputEmail3">Correo</label>
    			<input type="email" class="form-control" id="exampleInputEmail3" placeholder="Email">
  			</div>
  			<div class="form-group">
    			<label class="sr-only" for="exampleInputPassword3">Contraseņa</label>
    			<input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
  			</div>
  				<button type="submit" class="btn btn-default">Entrar</button>
		</form>
	</body>
</html>