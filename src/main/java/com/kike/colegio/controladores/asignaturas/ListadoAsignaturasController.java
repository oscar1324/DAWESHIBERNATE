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

import com.kike.colegio.dao.AsignaturasDAO;
import com.kike.colegio.dao.impl.AsignaturasDAOImpl;
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.implhibernate.AlumnoDAOImplHib;
import com.kike.colegio.implhibernate.AsignaturasDAOImplHib;

/**
 * Servlet implementation class ListadoAsignaturasController
 */

@WebServlet("/listadoasignaturas")
public class ListadoAsignaturasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(ListadoAsignaturasController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoAsignaturasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// En este apartado simplemente direccionamos hacía el fichero jsp
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/listadoAsignaturas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recogida de valores
		String id = request.getParameter("id");
		String nombre =  request.getParameter("nombre");
		String curso = request.getParameter("curso");
		
		// 2. Instanciar objetos 
		// Se retira jdbc: AsignaturasDAO a = new AsignaturasDAOImpl();
		AsignaturasDAO aHib = new AsignaturasDAOImplHib();
		
		List<Asignaturas>  listaAsignaturas = new ArrayList<>();
		listaAsignaturas = aHib.obtenerAsignaturasIdNombreCurso(id,nombre,curso); 
		
		// 3. Dar valor + Direccionar fichero 
		
		request.setAttribute("lista", listaAsignaturas);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/asignaturas/listadoAsignaturas.jsp");
		d.forward(request, response);
	}

}
