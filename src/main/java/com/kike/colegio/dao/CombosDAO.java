package com.kike.colegio.dao;


import java.util.List;

import com.kike.colegio.dtos.ComboAlumnosDTO;
import com.kike.colegio.dtos.ComboAsignaturasDTO;
import com.kike.colegio.dtos.ComboDTO;


public interface CombosDAO {
	
	List<ComboDTO> comboMunicipios();
	
	List<ComboAlumnosDTO> comboAlumnos();
	
	List<ComboAsignaturasDTO> comboAsignaturas();
	

}
