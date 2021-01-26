package com.kike.colegio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.utils.DBUtils;

public interface AsignaturasDAO {
	
	//hibernate
	Integer insertarAsignaturas(String id, String nombre, String curso);
	
	
	// Aquí se insertan los métodos que tengamos que realizar
	List<Asignaturas> obtenerAsignaturas();
	List<Asignaturas> obtenerAsignaturasIdNombreCurso(String id, String nombre, String curso);
	Integer actualizarAsignaturas(String idOld,String idNew, String nombre, String curso);
	Integer borrarAsingatura (String id);
	
	int obtenerNumeroAsignaturasMatriculaciones(String idAlumno);
	double obtenerTasaAsignatura(String idAsignatura);
	// fijarme en como lo hace en jdbc y ya esta
}


