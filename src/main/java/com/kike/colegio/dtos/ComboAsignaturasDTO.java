package com.kike.colegio.dtos;

public class ComboAsignaturasDTO {
	
	private Integer id;
	private String nombre;
	
	public ComboAsignaturasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComboAsignaturasDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
