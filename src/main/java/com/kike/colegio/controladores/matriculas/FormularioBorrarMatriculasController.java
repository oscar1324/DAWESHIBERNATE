package com.kike.colegio.controladores.matriculas;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.MatriculacionesDAO;
import com.kike.colegio.dao.impl.MatriculaDAOImpl;
import com.kike.colegio.dtos.MatriculaDTO;

/**
 * Servlet implementation class FormularioBorrarMatriculasController
 */
@WebServlet("/borrarmatriculas")
public class FormularioBorrarMatriculasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarMatriculasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = request.getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculas/borrarmatriculas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idMatricula = request.getParameter("idMatricula");
		MatriculacionesDAO m = new MatriculaDAOImpl();
		Integer resultado = m.borrarMatriculas(idMatricula);
		request.setAttribute("resultado", resultado);
		
		RequestDispatcher d = request.getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculas/borrarmatriculas.jsp");
		d.forward(request, response);
		

	}

}
