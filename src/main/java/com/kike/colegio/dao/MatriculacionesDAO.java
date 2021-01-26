package com.kike.colegio.dao;
import java.util.List;

import com.kike.colegio.dtos.*;
public interface MatriculacionesDAO {
	List<MatriculaDTO>obetenerMatricula(String idAsig, String nombreAsig, String idAlum, String nombreAlum, String fecha, String activo);
	Integer insertarMatriculacion(String idAsignatura, String idAlumno, String tasa, String fecha);
	Integer borrarMatriculas(String idMatricula);
}
