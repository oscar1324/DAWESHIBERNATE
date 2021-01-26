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

<h2> Borrar asignaturas</h2>
	<div class="form"> 
		<form action="http://localhost:8080/colegio/formularioborrarasignaturas" method="post">
		  <label for="id">ID</label>
		  <input type="text" id="id" name="id">
		  <label for="nombre">Nombre Asignatura</label>
		  <input type="text" id="nombre" name="nombre"><br>
		  <label for="curso">curso</label>
		  <input type="text" id="curso" name="curso"><br>
		  <input type="submit" value="Enviar">
		</form> 
	</div>
	
	<c:forEach items="${lista}" var="asignaturas">
	
		<div class="form">
		<form action="http://localhost:8080/colegio/borrarasignaturas" method="post">
			<input class="hidden" type="text" id="idOld" name="idOld" value="${asignaturas.id}">
			<label for="id"> Id </label>
			<input type="text" id="id" name="id" value="${asignaturas.id}">
			<label for="nombre"> Nombre asignatura </label>
			<input type="text" id="nombre" name="nombre" value="${asignaturas.nombre}"> </br>
			<label for="curso">curso</label>
		    <input type="text" id="curso" name="curso" value="${asignaturas.curso}"><br>
			<input type="submit" value="borrar"/>
		</form>
		</div>
		
	</c:forEach>


</div> <!--  Fin container -->

</body>
</html>