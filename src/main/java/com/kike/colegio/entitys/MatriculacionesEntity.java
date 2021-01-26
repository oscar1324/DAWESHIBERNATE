package com.kike.colegio.entitys;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;




@Entity
@Table(name="matriculaciones")
public class MatriculacionesEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="name")
	private int id;
	
	@Column(name="fecha")
	private int fecha;
	
	@Column(name="activo")
	private int activo;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name="id_alumno")
	private AlumnoEntity alumnos;
	// mapeamos con la fk hacía las otras tablas de la bbdd
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name="id_Asignatura")
	private AsignaturaEntity asignaturas;
}
