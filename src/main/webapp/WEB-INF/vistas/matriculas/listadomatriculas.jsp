  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
	<h1>Listado matriculas</h1>
	<%@include file="/menu.html"%>




	<div class="container">
		<div class="form">

			<form action="http://localhost:8080/colegio/listadoMatriculas" method="post">
			
				<label for="idAsig">Id asignatura</label>
				<input type="text" id="idAsig" name="idAsig">

				<label for="nombreAsig">Nombre asigntatura</label> 
				<input type="text" id="nombreAsig" name="nombreAsig">
				
				<label for="idAlum">Id Alumno</label> 
				<input type="text" id="idAlum" name="idAlum">
				
				<label for="nombreAlum">nombre</label> 
				<input type="text" id="nombreAlum" name="nombreAlum">
				
				<br>
				
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha">
				
				<label for="activo">Activo</label> 
				<input type="text" id="activo" name="activo">
				
				<br> 
				<input type="submit" value="Enviar">

			</form>

		</div>
		<table>
		
		<tr>
		<th>Id asignatura</th>
		<th>Nombre asignatura</th>
		<th>Id alumno</th>
		<th>Nombre alumno</th>
		<th>Fecha</th>
		<th>Activo</th>
		</tr>
			<c:forEach items="${lista }" var="alumno">
				<tr><!-- Publica los datos en una lista, con la varibale alumno recupera
				el seggundo por parametro que se le indique -->
					<td>${alumno.idAsig }</td>
					<td>${alumno.nombreAsig}</td>
					<td>${alumno.idAlum}</td>
					<td>${alumno.nombreAlum }</td>
					<td>${alumno.fecha}</td>
					<td>${alumno.activo}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>