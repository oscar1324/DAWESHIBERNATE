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

<h1>Listado notas</h1>
<%@include file="/menu.html" %>


<div class="container">
	<div class="form"> 
		<form action="http://localhost:8080/colegio/listadonotas" method="post">
		  
		  
		  <label for="id_alumnos">Id alumno</label>
		  <input type="text" id="id_alumnos" name="id_alumnos">
		  
		  <label for="alumnos">Nombre alumno</label>
		  <input type="text" id="alumnos" name="alumnos">
		  
		  <label for="idas">Nombre Asignatura</label>
		  <input type="text" id="idas" name="idas"><br>
		  
		  <label for="notas">notas</label>
		  <input type="text" id="notas" name="notas"><br>
		  
		  <label for="fecha">fecha</label>
		  <input type="date" id="fecha" name="fecha"><br>
		  
		  <input type="submit" value="Enviar">
		</form> 
	</div>
	
<c:if test="${empty lista}">
	<h2> No hay resultados que mostrar con esos filtros</h2>
</c:if>
<c:if test="${not empty lista}">
	<table>
		<tr> 
			<th> ID ALUMNO </th>
			<th> NOMBRE ALUMNO </th>
			<th> ID ASIGNATURA </th>
			<th> NOTA </th>
			<th> FECHA </th>
		</tr>
		
		<c:forEach items="${lista}" var="nota">
			<tr> 
				
				<td>${nota.id_alumnos} </td>
				<td>${nota.alumnos} </td>
				<td>${nota.idas} </td>
				<td>${nota.notas} </td>
				<td>${nota.fecha} </td>
			</tr>
		
		</c:forEach>
		
	</table>
</c:if>
</div>

</body>
</html>