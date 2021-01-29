package com.kike.colegio.implhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kike.colegio.dao.NotasDAO;
import com.kike.colegio.dtos.Notas;
import com.kike.colegio.dtos.NotasDTO;
import com.kike.colegio.entitys.AlumnoEntity;
import com.kike.colegio.entitys.AsignaturaEntity;
import com.kike.colegio.entitys.NotasEntity;
import com.kike.colegio.utils.DBUtils;

public class NotasDAOImplHib implements NotasDAO{

	@Override
	public List<Notas> obtenerAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notas> obtenerNotasTodo(String id_alumno, String alumnos, String id_asignatura, String notas,
			String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotasDTO> obtenerNombreAsignaturaNota(String nombreAlumno, String nombreAsignatura, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarNota(String idAlumno, String idAsignatura, String nota, String fecha) {
		SessionFactory factory = DBUtils.creadorSessionFactory();
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		
		//AlumnoEntityy encontrar mediante .find
		AlumnoEntity a = s.find(AlumnoEntity.class, Integer.parseInt(idAlumno));
		//Asignatura Entity encontrar mediante .find
		AsignaturaEntity asig = s.find(AsignaturaEntity.class, Integer.parseInt(idAsignatura));
		
		 Integer idA = a.getId();
		 
		 // NotasEntity n = new NotasEntity(a, asig, Double.parseDouble(nota), fecha);
		 NotasEntity n = new NotasEntity(idA, a, asig, Double.parseDouble(nota), fecha);
		 Integer idPk = (Integer) s.save(n);
		 
		 s.getTransaction().commit();
		return idPk;
	}

	@Override
	public Integer actualizarNotas(String idAlumno, String idasignatura, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarNotas(String id) {
		// TODO Auto-generated method stub
		return null;
	}




}
