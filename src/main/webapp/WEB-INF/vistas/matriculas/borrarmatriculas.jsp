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
		<form action="http://localhost:8080/colegio/formularioborrarmatriculas" method="post">
			
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
	
	<c:forEach items="${resultado}" var="matriculas">
	
		<div class="form">
		<form action="http://localhost:8080/colegio/borrarmatriculas" method="post">
		    			
				<label for="idAsig">Id asignatura</label>
				<input type="text" id="idAsig" name="idAsig" value="${matriculas.idAsig}">

				<label for="nombreAsig">Nombre asigntatura</label> 
				<input type="text" id="nombreAsig" name="nombreAsig" value="${matriculas.nombreAsig}">
				
				<label for="idAlum">Id Alumno</label> 
				<input type="text" id="idAlum" name="idAlum" value="${matriculas.idAlum }">
				
				<label for="nombreAlum">nombre</label> 
				<input type="text" id="nombreAlum" name="nombreAlum" value="${matriculas.nombreAlum }">
				
				<br>
				
				<label for="fecha">Fecha</label> 
				<input type="date" id="fecha" name="fecha" value="${matriculas.fecha }">
				
				<label for="activo">Activo</label> 
				<input type="text" id="activo" name="activo" value="${matriculas.activo }">
				
				<br> 
			<input type="submit" value="borrar"/>
		</form>
		</div>
		
	</c:forEach>


</div> <!--  Fin container -->

</body>
</html>