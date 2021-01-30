package com.kike.controladores.notas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.AsignaturasDAO;
import com.kike.colegio.dao.NotasDAO;
import com.kike.colegio.dao.impl.AsignaturasDAOImpl;
import com.kike.colegio.dao.impl.NotasDAOImpl;
import com.kike.colegio.dtos.Notas;

/**
 * Servlet implementation class BorrarNotasController
 */
@WebServlet("/borrarnotas")
public class BorrarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/BorrarNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperar datos del formulario
		String id = request.getParameter("id_alumnos");
		//String alumnos = request.getParameter("alumnos");
		//String id_asignatura = request.getParameter("idas");
		//String notas = request.getParameter("notas");
		//String fecha = request.getParameter("fecha");
		
		// instanciar objetos
		// (id_alumno, alumnos,id_asignatura, notas, fecha)
		NotasDAO a = new NotasDAOImpl();
		
		a.borrarNotas(id);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/BorrarNotas.jsp");
		d.forward(request, response);
	}
	
}
