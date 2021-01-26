package com.kike.colegio.entitys;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="asignaturas")
public class AsignaturaEntity {
	

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombreAsignatura;

	@Column(name = "curso")
	private int curso;

	/*
	 * @Column(name = "tasa")
	private Double tasa;*/
	

	@OneToMany(mappedBy = "alumnos")
	List<MatriculacionesEntity> matriculaciones;



	//Constructores, Getters y setters
	
	public AsignaturaEntity(int id, String nombreAsignatura, int curso) {
		super();
		this.id = id;
		this.nombreAsignatura = nombreAsignatura;
		this.curso = curso;
		
	}

	public AsignaturaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}


	
	
	
	
	
	
	
}
