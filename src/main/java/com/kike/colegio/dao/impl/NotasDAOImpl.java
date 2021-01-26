package com.kike.colegio.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kike.colegio.dao.NotasDAO;
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.dtos.Notas;
import com.kike.colegio.dtos.NotasDTO;

import com.kike.colegio.utils.DBUtils;

public class NotasDAOImpl implements NotasDAO{

	@Override
	public List<Notas> obtenerAsignaturas() {
		
		List<Notas> listaNotas = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();
			Statement st = connection.createStatement();
			ResultSet re = st.executeQuery("select n.id_alumnos, a.nombre, asi.nombre, n.nota, n.fecha from notas n, asignaturas asi, alumnos a where n.id_asignaturas= asi.id and n.id_alumnos=a.id");
			
			while(re.next()) {
				Notas a = new Notas(re.getInt(1), re.getString(2), re.getString(3), re.getInt(4),  re.getString(5));
				listaNotas.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listaNotas;
	}

	@Override
	public List<Notas> obtenerNotasTodo(String id_alumno,String alumnos, String id_asignatura, String notas,String fecha) {
		
		String sql = "select n.id_alumnos, a.nombre, asi.nombre, n.nota, n.fecha from notas n, asignaturas asi, alumnos a "
				+ "where n.id_asignaturas= asi.id and n.id_alumnos=a.id and "
				+ "n.id_alumnos like ? and a.nombre like ? and asi.nombre like ? and n.nota like ? and n.fecha between ? and curdate() ";
		
		ResultSet notasResult = null;
		Connection connection = DBUtils.DBConnection();
		List<Notas> listaNotas = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, "%" + id_alumno + "%");
			ps.setString(2, "%" + alumnos + "%");
			ps.setString(3, "%" + id_asignatura + "%");
			ps.setString(4, "%" + notas + "%");
			ps.setString(5, fecha);
			
			notasResult = ps.executeQuery();
			
			while(notasResult.next()) {
				Notas a = new Notas(notasResult.getInt(1),notasResult.getString(2),notasResult.getString(3), notasResult.getInt(4), notasResult.getString(5));
				listaNotas.add(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		return listaNotas;
	}
	
	@Override
	public Integer insertarNotas( String alumnos, String idas, String notas, String fecha) {
		String sql = "INSERT INTO notas (id_alumnos ,id_asignaturas ,nota ,fecha ) VALUES (?, ?, ? , ?)";
		
		Connection connection = DBUtils.DBConnection();
		Integer resultado = null;
		PreparedStatement ps = null;
		
		
		try {
			ps = connection.prepareStatement(sql);
			// meter
			 if (fecha=="") {
				 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				 Date now = new Date();
				       String strDate = sdfDate.format(now);
				      fecha=strDate;
				 }
		
			ps.setString(1, alumnos);
			ps.setString(2, idas );
			ps.setString(3, notas);
			ps.setString(4, fecha);
			
			resultado = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		return resultado;
	}

/*
 * 	@Override
	public Integer actualizarNotas(String idAlumno,String idasignatura, String fecha , String idAlumnoAntiguo) {
		String sql = "UPDATE asignaturas SET id_alumnos= ?, nombre = ? , curso = ? WHERE id = ?";
		// revisar sentencia
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			
			// preparar conexion para consulta sql
			ps = connection.prepareStatement(sql); 
			
			ps.setString(1, idAlumno);
			ps.setString(2, idasignatura);
			ps.setString(3, fecha);
			ps.setString(4, idAlumnoAntiguo);
			
			// resultado 
			resultado = ps.executeUpdate();  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		return resultado;
	}
 * */



	@Override
	public Integer borrarNotas(String id) {
		String sql = "DELETE FROM notas WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}

		return resultado;
	}

	@Override
	public Integer actualizarNotas(String idAlumno, String idasignatura, String fecha) {
		String sql = "UPDATE asignaturas SET id_alumnos= ?, nombre = ? , curso = ? WHERE id = ?";
		// revisar sentencia
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			
			// preparar conexion para consulta sql
			ps = connection.prepareStatement(sql); 
			
			ps.setString(1, idAlumno);
			ps.setString(2, idasignatura);
			ps.setString(3, fecha);
			
			// resultado 
			resultado = ps.executeUpdate();  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		return resultado;
	}

	@Override
	public List<NotasDTO> obtenerNombreAsignaturaNota(String nombreAlumno, String nombreAsignatura, String fecha) {
		String sql = "select n.id_alumnos, a.nombre,asig.id ,asig.nombre, n.nota,n.fecha  " 
				+ "from notas n, asignaturas asig, alumnos a " 
				+ "where  n.id_asignaturas = asig.id " 
				+ "and n.id_alumnos = a.id " 
				+ "and a.nombre like ? "
				+ "and asig.nombre like ? "
				+ "and n.fecha >= ?";
		
		
		ResultSet notasResult = null;
		Connection connection = DBUtils.DBConnection();
		List<NotasDTO> listaNotas = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, "%" + nombreAlumno + "%");
			ps.setString(2, "%" + nombreAsignatura + "%");
			ps.setString(3, fecha);
	
			
			notasResult = ps.executeQuery();
			
			while(notasResult.next()) {
				
				// recoge los parametros de la sql
				NotasDTO b = new NotasDTO(notasResult.getString(1),notasResult.getString(2),notasResult.getString(3),notasResult.getString(4),notasResult.getString(5),notasResult.getString(6));
				listaNotas.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		return listaNotas;
	}




}


