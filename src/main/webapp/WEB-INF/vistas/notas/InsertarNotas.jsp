<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
</head>
<body>
	<header>
		<h2>Inserción de nuevo nota</h2>
	</header>


	<%@include file="/menu.html"%>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/insertarnota" method="post" id="formulario">
				<label for="alumnos">Nombre Alumno</label>
				<select name="alumnos" id="alumnos" form="formulario">
					<c:forEach items="${listaAlumnos}" var="alumnos"> <!-- puede haber un error -->
						<option value="${alumnos.id}">${alumnos.id}-${alumnos.descripcion}</option>
					</c:forEach>
				</select><br><br>
				
				
				 <label for="idas">Nombre Asignatura</label>
				 <select name="idas" id="idas" form="formulario">
					<c:forEach items="${listaAsignaturas}" var="asignaturas">

						<option value="${asignaturas.id}">${asignaturas.id}-${asignaturas.descripcion}</option><!-- Puede que haya un error -->

					</c:forEach>
					

				</select><br><br>
				
				 <label for="notas">notas</label>
				  <input type="text" id="notas"name="notas"><br> 
				  
				  <label for="fecha">fecha</label> 
				  <input type="date" id="fecha" name="fecha"><br>
				

				 <input type="submit" value="Enviar">
			</form>

		</div>
		<c:if test="${resultado == 1}">
			<b>Notas insertada correctamente</b>
		</c:if>
	</div>

</body>
</html>