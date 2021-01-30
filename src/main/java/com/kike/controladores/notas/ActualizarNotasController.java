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
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class ActualizarNotasController
 */
@WebServlet("/actualizarnotas")
public class ActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarNotasController() {
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
		// 1. recogida de valores del formulario

		String nombreAlumno = request.getParameter("nombreAlumno");
		String asignatura = request.getParameter("asignatura");
		String fecha = request.getParameter("fecha");
		

		// 2. Instanciar objetos
		NotasDAO a = new NotasDAOImpl();
//		a.actualizarNotas(idAlumno, idasignatura, fecha);
		
		// 3.direccionar fichero

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/ActualizarNotas.jsp");
		d.forward(request, response);
	}

}
