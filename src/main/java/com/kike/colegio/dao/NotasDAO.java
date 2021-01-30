package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.dtos.Notas;
import com.kike.colegio.dtos.NotasDTO;

public interface NotasDAO {
	List<NotasDTO> obtenerAsignaturas();
	//List<NotasDTO> obtenerNotasTodo( String id_alumno,String alumnos, String id_asignatura, String notas, String fecha);
	List<NotasDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(String idAlumno, String nombre, String asignatura, String nota, String fecha); 
	
	List<NotasDTO> obtenerNombreAsignaturaNota(String nombreAlumno, String nombreAsignatura, String fecha);
	//Integer insertarNotas(String alumnos, String idas, String notas, String fecha);
	Integer insertarNota(String idAlumno, String idAsignatura,String nota, String fecha);
	Integer actualizarNotas(String idAlumno,String idasignatura, String fecha );
	//hibernate Integer actualizarNota(String idNota, String idAlumno, String idAsignatura, String nota, String fecha);
	Integer borrarNotas (String id);


	
}
