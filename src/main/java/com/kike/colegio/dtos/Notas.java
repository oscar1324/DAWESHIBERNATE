package com.kike.colegio.dtos;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Notas {
	
	
	private Integer id_alumnos;
	private String alumnos;
	private String idas;
	private Integer notas;
	private String fecha;
	
	

	public Notas() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Notas(Integer id_alumnos, String alumnos, String idas, Integer notas, String fecha) {
		super();
		this.id_alumnos = id_alumnos;
		this.alumnos = alumnos;
		this.idas = idas;
		this.notas = notas;
		this.fecha = fecha;
	}



	public Integer getId_alumnos() {
		return id_alumnos;
	}



	public void setId_alumnos(Integer id_alumnos) {
		this.id_alumnos = id_alumnos;
	}



	public String getAlumnos() {
		return alumnos;
	}



	public void setAlumnos(String alumnos) {
		this.alumnos = alumnos;
	}



	public String getIdas() {
		return idas;
	}



	public void setIdas(String idas) {
		this.idas = idas;
	}



	public Integer getNotas() {
		return notas;
	}



	public void setNotas(Integer notas) {
		this.notas = notas;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}





	
	
}
