package com.kike.colegio.controladores.asignaturas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kike.colegio.controladores.InsertarAlumnosController;
import com.kike.colegio.dao.AsignaturasDAO;
import com.kike.colegio.dao.impl.AsignaturasDAOImpl;
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.implhibernate.AsignaturasDAOImplHib;

/**
 * Servlet implementation class InsertarAsignaturaController
 */
@WebServlet("/insertasignaturas")
public class InsertarAsignaturaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = LoggerFactory.getLogger(InsertarAlumnosController.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarAsignaturaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dirigir jsp
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignaturas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String curso = request.getParameter("curso");
		
		// 2. Instanciar objetos 
		// dejamos implementación jdbc AsignaturasDAO a = new AsignaturasDAOImpl();
		
		AsignaturasDAO aa = new AsignaturasDAOImplHib();
		Integer resultado = aa.insertarAsignaturas(id, nombre, curso);
		request.setAttribute("resultado", resultado);
		// 3. Direccionar fichero 
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/insertarAsignaturas.jsp");
		d.forward(request, response);
	}

}
