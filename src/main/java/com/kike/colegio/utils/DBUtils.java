package com.kike.colegio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {
	
	// Creación de sessionFactory
	private static  SessionFactory sessionFactory; 
	public static SessionFactory creadorSessionFactory() {

		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Error al crear el objeto SessionFactory" + ex);
				throw new ExceptionInInitializerError(ex);
			}

		}

		return sessionFactory;
	}
	
	
	
	
	public static Connection DBConnection() {
		
		
		Context ctx = null;
		Connection connection = null;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ColegioDB");
			connection = ds.getConnection();
			

		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		return connection;
		
		
		
	}

}
