<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
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
	<%@include file="/menu.html"%>


	<div class="container">

		<h2>Actualizar Notas</h2>
		<div class="form">
			<form
				action="http://localhost:8080/colegio/formularioactualizarnotas"
				method="post">
				<label for="nombreAlumno"> Nombre Alumno </label> <input type="text"
					id="nombreAlumno" name="nombreAlumno"></br> 
					<label for="nombreAsignatura">Nombre asignaturas</label>
				<input type="text" id="nombreAsignatura" name="nombreAsignatura"><br>

				<label for="fecha">fecha</label> 
				<input type="date" id="fecha" name="fecha">
				
				 <input type="submit" value="Enviar">
			</form>
		</div>


		<c:forEach items="${lista}" var="nota">

			<div class="form">
				<form action="http://localhost:8080/colegio/actualizarnotas"method="post">
					
					<label for="nombreAlumno"> Nombre alumno </label> 
					<select name="nombreAlumno" id="nombreAlumno">
						<c:forEach items="${comboAlumnos}" var="nombreAlumno">

							<option value="${nombreAlumno.id}">${nombreAlumno.nombre}</option>

						</c:forEach>
						<option value="${nota.nombreAlumno }" selected> ${nota.nombreAlumno }</option>
					</select><br><br>
					
					 <label for="asignatura">Nombre asignatura</label> 
					 <select name="asignatura" id="asignatura">
						<c:forEach items="${comboAsignaturas}" var="nombreAsignatura">

							<option value="${nombreAsignatura.id}">${nombreAsignatura.nombre}</option>

						</c:forEach>
						<option value="${nota.nombreAsignatura }" selected> ${nota.nombreAsignatura }</option>
					</select><br>
					
					<label for="fecha">fecha</label> 
					<input type="date"id="fecha" name="fecha"><br> 
					
					<label for="nota">Nota</label> 
					<input type="text" id="fecha" name="fecha"><br> 
					
					<input type="submit"value="Modificar">
				</form>

			</div>


		</c:forEach>
	</div>

</body>
</html>