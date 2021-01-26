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
@Table(name = "asignaturas")
public class AsignaturaEntity {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "curso")
	private int curso;

	

	@OneToMany(mappedBy = "alumnos")
	List<MatriculacionesEntity> matriculaciones;



	public AsignaturaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AsignaturaEntity(int id, String nombre, int curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
	
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




	//Constructores, Getters y setters
	
	
	
	
	
	

	
}
