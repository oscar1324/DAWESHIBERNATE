package com.kike.colegio.implhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.entitys.AlumnoEntity;
import com.kike.colegio.utils.DBUtils;

public class AlumnoDAOImplHib  implements AlumnoDAO{

	@Override
	public Integer insertarAlumno(String id, String nombre, String idMunicipio, String famNumerosa) {
		AlumnoEntity a = new AlumnoEntity(Integer.parseInt(id),nombre, Integer.parseInt(idMunicipio),
				Integer.parseInt(famNumerosa));
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		
		Integer idPk = (Integer) s.save(a);// el id guarda la session en el alumnoEntityi
		s.getTransaction().commit();
		return idPk;
	}

	@Override
	public List<Alumno> obtenerTodosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> obtenerAlumnosporIdyNombre(String id, String nombre) {

		String jpql = " select new com.kike.colegio.dtos.Alumno (a.id, a.nombre, m.nombre, m.idMunicipio, a.famNumerosa)"
				+ "FROM AlumnoEntity a, MunicipiosEntity m WHERE a.idMunicipio = m.idMunicipio AND  CAST( a.id AS string )  LIKE :id AND a.nombre LIKE :nombre";

		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();

		Query query = s.createQuery(jpql).setParameter("id", "%" + id + "%").setParameter("nombre", "%" + nombre + "%");
		List<Alumno> lista = query.getResultList();

		s.close(); // Cerramos la sesión

		return lista;
	}

	@Override
	public Integer actualizarAlumno(String idOld, String idNew, String nombre, String idMunicipio, String famNumerosa) {
		//Conversión famNumerosa a Integer (0 o 1), ya que viene a "on" o null
		Integer familiaNumerosa = 	(famNumerosa == null) ? 0 : 1;
		
		AlumnoEntity a = new AlumnoEntity(Integer.parseInt(idNew), nombre, Integer.parseInt(idMunicipio),
				familiaNumerosa);
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		s.update(a);
		s.getTransaction().commit();

		return a.getId();
	}

	@Override
	public Integer borrarAlumno(String id) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		//Hibernate recupera la Entidad a borrar
		AlumnoEntity a = s.get(AlumnoEntity.class, Integer.parseInt(id));
		//Borra la entidad
	    if (a != null) {
	        s.delete(a);
	        s.getTransaction().commit(); 
	    	s.close();
	    	
	        return 1;
	    }
		s.close();
	    return 0;
	}

	@Override
	public boolean esFamiliaNumerosa(String idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}







}
