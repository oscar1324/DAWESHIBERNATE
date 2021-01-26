package com.kike.colegio.controladores.asignaturas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.AsignaturasDAO;
import com.kike.colegio.dao.impl.AlumnoDAOImpl;
import com.kike.colegio.dao.impl.AsignaturasDAOImpl;
import com.kike.colegio.implhibernate.AsignaturasDAOImplHib;

/**
 * Servlet implementation class borrarAsignatura
 */

@WebServlet("/borrarasignaturas")
public class borrarAsignaturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrarAsignaturaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		// fuera:AsignaturasDAO a = new AsignaturasDAOImpl();
		AsignaturasDAO aa = new AsignaturasDAOImplHib();
		
		aa.borrarAsingatura(id);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos/borrarAlumnos.jsp");
		d.forward(request, response);
	}

}
