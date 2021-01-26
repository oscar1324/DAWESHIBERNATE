package com.kike.colegio.dtos;

/**
 * @author 201907
 *
 */
public class MatriculaDTO {
	private Integer id;
	private Integer idAsignatura;
	private String nombreAsignatura;
	private Integer idAlumno;
	private String nombreAlumno;
	private String fecha;
	private Integer activo;
	
	public MatriculaDTO(Integer id, Integer idAsignatura, String nombreAsignatura, Integer idAlumno,
			String nombreAlumno, String fecha, Integer activo) {
		super();
		this.id = id;
		this.idAsignatura = idAsignatura;
		this.nombreAsignatura = nombreAsignatura;
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.fecha = fecha;
		this.activo = activo;
	}

	public MatriculaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
	
	
}