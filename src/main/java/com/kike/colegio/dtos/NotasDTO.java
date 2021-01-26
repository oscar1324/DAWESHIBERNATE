package com.kike.colegio.dtos;

public class NotasDTO {
	
	private String idAlumno;
	private String nombreAlumno;
	private String idAsignatura;
	private String nombreAsignatura;
	private String nota;
	private String fecha;

	
	
	
	public NotasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public NotasDTO(String idAlumno, String nombreAlumno, String idAsignatura, String nombreAsignatura, String nota,
			String fecha) {
		super();
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.nota = nota;
		this.fecha = fecha;
	}




	public String getIdAlumno() {
		return idAlumno;
	}




	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}




	public String getNombreAlumno() {
		return nombreAlumno;
	}




	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}




	public String getIdAsignatura() {
		return idAsignatura;
	}




	public void setIdAsignatura(String idAsignatura) {
		this.idAsignatura = idAsignatura;
	}




	public String getNombreAsignatura() {
		return nombreAsignatura;
	}




	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}




	public String getNota() {
		return nota;
	}




	public void setNota(String nota) {
		this.nota = nota;
	}




	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	
	

	
}
