/**
 * 
 */
package com.kike.colegio.dtos;

/**
 * @author Usuario
 *
 */
public class Asignaturas {
	
	private Integer id;
	private String nombre;
	private Integer curso;
	
	public Asignaturas(int id, String nombre, int curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	public Asignaturas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	
}
