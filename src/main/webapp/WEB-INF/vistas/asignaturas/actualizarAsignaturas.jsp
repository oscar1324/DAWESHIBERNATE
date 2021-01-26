<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/formularios.css">
  <link rel="stylesheet" href="css/tablas.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Listado asignaturas</h1>
<%@include file="/menu.html" %>


<div class="container">

<h2> Actualizar Asignaturas</h2>
	<div class="form"> 
		<form action="http://localhost:8080/colegio/formularioactualizarasignaturas" method="post">
		  
		  <label for="id">Id Asignatura</label>
		  <input type="text" id="id" name="id">
		  <label for="nombre">Nombre Asignatura</label>
		  <input type="text" id="nombre" name="nombre"><br>
		  <label for="curso"> curso</label>
		  <input type="curso" id="curso" name="curso">
		  <input type="submit" value="Enviar">
		</form> 
	</div>
	

<c:forEach items="${lista}" var="asignatura">

	<div class="form">
		<form action="http://localhost:8080/colegio/actualizarasignatura" method="post">
			<input class="hidden" type="text" id="idOld" name="idOld" value="${asignatura.id}">
			<label for="id"> Id Asignatura </label>
			<input type="text" id="id" name="id" value="${asignatura.id}">
			<label for="nombre"> Nombre Asignatura </label>
			<input type="text" id="nombre" name="nombre" value="${asignatura.nombre}"> </br>
			<label for="curso"> Curso</label>
			<input type="text" id="curso" name="curso" value="${asignatura.curso}">
			
		<input type="submit" value="Modificar">
		</form>
	
	</div>


</c:forEach>
</div>

</body>
</html>