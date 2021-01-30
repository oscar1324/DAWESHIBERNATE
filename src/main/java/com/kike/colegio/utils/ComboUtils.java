package com.kike.colegio.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kike.colegio.dao.CombosDAO;
import com.kike.colegio.dao.impl.CombosDAOImpl;
import com.kike.colegio.dtos.ComboAlumnosDTO;
import com.kike.colegio.dtos.ComboAsignaturasDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.implhibernate.CombosDAOImplHib;

public class ComboUtils {

	
	public static void recuperacionComboMunicipios(HttpServletRequest request) {
		CombosDAO comboMunicipio = new CombosDAOImpl();
		List<ComboDTO> listaMunicipios = comboMunicipio.comboMunicipios();
		request.setAttribute("comboMunicipios", listaMunicipios);
	}
	
	//combo con hibernate
	 public static void recuperacionComboMunicipiosHib(HttpServletRequest request) {
		CombosDAO comboMunicipio = new CombosDAOImplHib();
		List<ComboDTO> listaMunicipios = comboMunicipio.comboMunicipios();
		request.setAttribute("comboMunicipios", listaMunicipios);
	}
	
	/*
	 * 	public static void recuperacionComboAlumnos(HttpServletRequest request) {
		CombosDAO comboAlumnos = new CombosDAOImpl();
		List<ComboAlumnosDTO> listaAlumnos = comboAlumnos.comboAlumnos();
		request.setAttribute("comboAlumnos", listaAlumnos);
	}
	public static void recuperacionComboAsignaturas(HttpServletRequest request) {
		CombosDAO comboAsignaturas = new CombosDAOImpl();
		List<ComboAsignaturasDTO> listaAsignaturas = comboAsignaturas.comboAsignaturas();
		request.setAttribute("comboAsignaturas", listaAsignaturas);
	}*/
	public static void recuperarComboAlumnosHib(HttpServletRequest request) {	
		CombosDAO comboAlumnos = new CombosDAOImplHib();	// puede ser error	
		List<ComboDTO> listaAlumnos = comboAlumnos.comboAlumnos();
		request.setAttribute("listaAlumnos",listaAlumnos);

	}
	
	public static void recuperarComboAsignaturasHib(HttpServletRequest request) {		
		CombosDAO comboAsignaturas = new CombosDAOImplHib();		
		List<ComboDTO> listaAsignaturas = comboAsignaturas.comboAsignaturas();
		request.setAttribute("listaAsignaturas",listaAsignaturas);
	}

}
