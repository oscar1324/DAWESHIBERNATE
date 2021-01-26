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

<h1>Borrar notas</h1>
<%@include file="/menu.html" %>


<div class="container">

	<div class="form"> 
		<form action="http://localhost:8080/colegio/borrarformularionotas" method="post">
		  <label for="id_alumnos">Id alumno</label>
		  <input type="text" id="id_alumnos" name="id_alumnos" ><br>
		  
		  <label for="alumnos">Nombre alumno</label>
		  <input type="text" id="alumnos" name="alumnos"><br>
		  
		  <label for="idas">Nombre Asignatura</label>
		  <input type="text" id="idas" name="idas"><br>
		  
		  <label for="notas">notas</label>
		  <input type="text" id="notas" name="notas"><br>
		 
		  <input type="submit" value="Enviar">
		</form> 
	</div>
	
	<c:forEach items="${lista}" var="notas">
	
		<div class="form">
		<form action="http://localhost:8080/colegio/borrarasignaturas" method="post">
		  <label for="id_alumnos">Id alumno</label>
		  <input type="text" id="id_alumnos" name="id_alumnos" value="${notas.id_alumnos }"><br>
		  
		  <label for="alumnos">Nombre alumno</label>
		  <input type="text" id="alumnos" name="alumnos" value="${notas.alumnos }"><br>
		   
		  <label for="idas">Nombre Asignatura</label>
		  <input type="text" id="idas" name="idas" value="${notas.idas }"><br>
		  
		  <label for="notas">notas</label>
		  <input type="text" id="notas" name="notas" value="${notas.notas }"><br>
		  
			<input type="submit" value="borrar"/>
		</form>
		</div>
		
	</c:forEach>
	</div>

</body>
</html>