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
 * Servlet implementation class ListadoMatriculasController
 */
@WebServlet("/listadoMatriculas")
public class ListadoMatriculasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoMatriculasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculas/listadomatriculas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAsig = request.getParameter("idAsig");
		String nombreAsig = request.getParameter("nombreAsig");
		String idAlum = request.getParameter("idAlum");
		String nombreAlum = request.getParameter("nombreAlum");
		String fecha = request.getParameter("fecha");
		String activo = request.getParameter("activo");
		
		MatriculacionesDAO mdao = new MatriculaDAOImpl();
		
		List<MatriculaDTO> listaMatriculaciones = mdao.obetenerMatricula(idAsig, nombreAsig, idAlum, nombreAlum, fecha, activo);
		
		request.setAttribute("lista", listaMatriculaciones);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/matriculas/listadomatriculas.jsp");
		d.forward(request, response);
	}

}
