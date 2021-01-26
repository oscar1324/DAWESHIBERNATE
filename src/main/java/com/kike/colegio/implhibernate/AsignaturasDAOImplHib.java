package com.kike.colegio.implhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.kike.colegio.dao.AsignaturasDAO;
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.entitys.AsignaturaEntity;
import com.kike.colegio.utils.DBUtils;

public class AsignaturasDAOImplHib implements AsignaturasDAO{

	@Override
	public Integer insertarAsignaturas(String id, String nombre, String curso) {
		AsignaturaEntity a = new AsignaturaEntity( Integer.parseInt(id), nombre, Integer.parseInt(curso));
		
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session ss = factory.getCurrentSession();
		
		ss.beginTransaction();
		
		//idPK
		Integer idPk = (Integer) ss.save(a);
		ss.getTransaction().commit();
		
		return idPk;
	
	}

	@Override
	public List<Asignaturas> obtenerAsignaturas() {
		//AsignaturaEntity a = new AsignaturaEntity(Integer.parseInt(id), nombreAsignatura, Integer.parseInt(curso));
		String hql = " FROM AlumnoEntity";
		AsignaturaEntity a = new AsignaturaEntity();
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session ss = factory.getCurrentSession();
		ss.beginTransaction();
		
		Query query = ss.createQuery(hql);
		List<Asignaturas> lista = query.getResultList();

		return lista;
	}
	

	@Override
	public List<Asignaturas> obtenerAsignaturasIdNombreCurso(String id, String nombre, String curso) {
		/*String jpql = "select new com.kike.colegio.dtos.Asignaturas(asig.id, asig.nombre, asig.curso)"
				+ "FROM AsignaturaEntity a, MatriculacionesEntity m where a.id = m.id CAST(a.id AS string)";*/
		
		String jpql = "select new com.kike.colegio.dtos.Asignaturas(asig.id, asig.nombre, asig.curso)"
				+ " FROM AsignaturaEntity  asig WHERE CAST(asig.id AS string) LIKE :id AND asig.nombre LIKE :nombre AND CAST(asig.curso AS string) LIKE :curso";
		// hacemos uso de LIKE:id para sustituir el like ? que utilizamos anteriormente
		
		//creación sessionFactory
		SessionFactory factory = DBUtils.creadorSessionFactory();
		//Creación session
		Session ss = factory.getCurrentSession();
		ss.beginTransaction();
		
		// preguntar query
		Query query = ss.createQuery(jpql).setParameter("id", "%" + id + "%").setParameter("nombre", "%" + nombre + "%").setParameter("curso", "%" + curso + "%");
		//      ------- se menciona por el alias
		List<Asignaturas> lista = query.getResultList(); 
		return lista;
	}

	@Override
	public Integer actualizarAsignaturas(String idOld, String idNew, String nombre, String curso) {

		AsignaturaEntity a = new AsignaturaEntity( Integer.parseInt(idNew), nombre, Integer.parseInt(curso));
		//Integer.parseInt(idOld), Integer.parseInt(idNew), nombre, Integer.parseInt(curso)
		//AsignaturaEntity a = new AsignaturaEntity(id, nombreAsignatura, curso);
		//sessionFactory
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session ss = factory.getCurrentSession();
		
		//cambios beginTransaction() ipdate() commit()
		ss.beginTransaction();
		ss.update(a);
		ss.getTransaction().commit();
		return a.getId();
		
	}

	@Override
	public Integer borrarAsingatura(String id) {
		
		
		//SessionFctory = DBUtils + creador del sessionFactory
		SessionFactory factory = DBUtils.creadorSessionFactory();
		//Session
		Session ss = factory.getCurrentSession();
		
		ss.beginTransaction();
		
		// recuperamos la entidad que vamos a borrar
		AsignaturaEntity as = ss.get(AsignaturaEntity.class,Integer.parseInt(id));
		
		//elminación de entidad
		if(as != null) {
			ss.delete(as);
			ss.getTransaction().commit();// escribe los cambios en la base de datos
			ss.close();
			
			return 1;
		}
		ss.close();
		return 0;
	}

	@Override
	public int obtenerNumeroAsignaturasMatriculaciones(String idAlumno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtenerTasaAsignatura(String idAsignatura) {
		// TODO Auto-generated method stub
		return 0;
	}


}
