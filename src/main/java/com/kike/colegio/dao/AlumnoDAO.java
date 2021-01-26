package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.Alumno;

public interface AlumnoDAO {
	
	//hibernate
	Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa);
	
	
	List<Alumno> obtenerTodosAlumnos();
	List<Alumno> obtenerAlumnosporIdyNombre(String id, String nombre);
	Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio, String famNumerosa);
	Integer borrarAlumno (String id);
	public boolean esFamiliaNumerosa(String idAlumno);
	
	
	
	//jdbc
	/*
	 * 	Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa);
	
	List<Alumno> obtenerTodosAlumnos();
	List<Alumno> obtenerAlumnosporIdyNombre(String id, String nombre);
	Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio,String famNumerosa);
	Integer borrarAlumno (String id);
*/

}
