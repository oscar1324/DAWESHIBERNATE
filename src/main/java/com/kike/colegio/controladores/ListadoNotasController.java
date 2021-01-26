package com.kike.colegio.controladores;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.kike.colegio.dao.NotasDAO;
import com.kike.colegio.dao.impl.NotasDAOImpl;
import com.kike.colegio.dtos.Notas;

/**
 * Servlet implementation class ListadoNotasController
 */

@WebServlet("/listadonotas")
public class ListadoNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(ListadoNotasController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Direccionar hacia listadoNotas.jsp
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. recogida de valores del formulario
		String id_alumno = request.getParameter("id_alumnos");
		String alumnos = request.getParameter("alumnos");
		String id_asignatura = request.getParameter("idas");
		String notas = request.getParameter("notas");
		String fecha = request.getParameter("fecha");
		
		// 2. Instanciar objetos
		NotasDAO a = new NotasDAOImpl();
		List<Notas> listaNotas = new ArrayList<>();
		
		listaNotas = a.obtenerNotasTodo(id_alumno, alumnos,id_asignatura, notas, fecha);
		
		// 3. dar valor +  direccionar fichero
		request.setAttribute("lista", listaNotas);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/listadoNotas.jsp");
		d.forward(request, response);
	}

}
