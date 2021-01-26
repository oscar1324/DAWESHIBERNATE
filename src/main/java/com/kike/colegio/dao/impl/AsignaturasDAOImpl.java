
/**
 * 
 */
package com.kike.colegio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kike.colegio.dao.AsignaturasDAO;
import com.kike.colegio.dtos.Alumno;
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.utils.DBUtils;

/**
 * @author Usuario
 *
 */
public class AsignaturasDAOImpl implements AsignaturasDAO{

	@Override
	public List<Asignaturas> obtenerAsignaturas() {
		List<Asignaturas> listaAsignaturas = new ArrayList<>();
		
		try {
			Connection connection = DBUtils.DBConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ASIGNATURAS");
			
			while(rs.next()) {
				Asignaturas a = new Asignaturas(rs.getInt(1), rs.getString(2), rs.getInt(3));
				listaAsignaturas.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaAsignaturas;
	}

	@Override
	public List<Asignaturas> obtenerAsignaturasIdNombreCurso(String id, String nombre, String curso) {
		// String sql = "SELECT * FROM alumnos WHERE id LIKE ? AND nombre LIKE ?";
		String sql = "select * from asignaturas where id like ? and nombre like ? and curso like ? ";

		ResultSet asignaturasResultSet = null;
		Connection connection = DBUtils.DBConnection();
		List<Asignaturas> listaAsignaturas = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, "%" + id + "%");
			ps.setString(2, "%" + nombre + "%");
			ps.setString(3,"%" + curso + "%");

			asignaturasResultSet = ps.executeQuery();

			while (asignaturasResultSet.next()) {
				Asignaturas a = new Asignaturas(asignaturasResultSet.getInt(1), asignaturasResultSet.getString(2),
						asignaturasResultSet.getInt(3));
				listaAsignaturas.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAsignaturas;
	}

	@Override
	public Integer insertarAsignaturas(String id, String nombre, String curso) {
		String sql = "INSERT INTO asignaturas (id, nombre, curso) VALUES (?,?,?)";
		Connection connection = DBUtils.DBConnection();
		Integer resultado = null;
		PreparedStatement ps = null;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, nombre);
			ps.setString(3, curso);
			
			resultado = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return resultado;
	}

	@Override
	public Integer actualizarAsignaturas(String idOld, String idNew, String nombre, String curso) {

		String sql = "UPDATE asignaturas SET id= ?, nombre = ? , curso = ? WHERE id = ?";
		
		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		try {
			
			// preparar conexion para consulta sql
			ps = connection.prepareStatement(sql); 
			
			ps.setString(1, idNew);
			ps.setString(2, nombre);
			ps.setString(3, curso);
			ps.setString(4, idOld);
			
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
	public Integer borrarAsingatura(String id) {
		String sql = "DELETE FROM asignaturas WHERE id = ?";

		Connection connection = DBUtils.DBConnection();
		PreparedStatement ps = null;
		Integer resultado = null;

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, id);

			resultado = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return resultado;
	}
	// no realizar ahora, no esta en uso
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
