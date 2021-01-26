
package com.kike.colegio.entitys;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Usuario
 *
 */

@Entity
@Table(name= "alumnos")
public class AlumnoEntity {

	@Id
	@Column(name= "id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="id_municipio")
	private int idMunicipio;
	
	@Column(name="familia_numerosa")
	private int famNumerosa;


	//mapeo de la relacion sobre las entidades
	@OneToMany(mappedBy = "asignaturas")
	List<MatriculacionesEntity> matriculaciones;
	 
	// realizamos todo getters y setters
	
	public AlumnoEntity() {
		super();
	}

	public AlumnoEntity(int id, String nombre, int idMunicipio, int famNumerosa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMunicipio = idMunicipio;
		this.famNumerosa = famNumerosa;
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

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	
}
