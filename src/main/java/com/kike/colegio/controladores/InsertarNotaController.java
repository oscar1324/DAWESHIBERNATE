package com.kike.colegio.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kike.colegio.dao.NotasDAO;
import com.kike.colegio.dao.impl.NotasDAOImpl;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class InsertarNotaController
 */
@WebServlet("/insertarnota")
public class InsertarNotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LoggerFactory.getLogger(InsertarNotaController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarNotaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1- Recuperar de la BBDD todos los alumnos id-nombre + asignaturas
		ComboUtils.recuperarComboAsignaturasHib(request);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/InsertarNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperar datos del formulario
		//String id_alumno = request.getParameter("id_alumnos");
		String alumnos = request.getParameter("alumnos");
		String id_asignatura = request.getParameter("idas");
		String notas = request.getParameter("notas");
		String fecha = request.getParameter("fecha");
		
		// instanciar objetos
		// (id_alumno, alumnos,id_asignatura, notas, fecha)
		NotasDAO a = new NotasDAOImpl();
		Integer resultado = a.insertarNota(idAlumno, idAsignatura, notas, fecha);
		// realizar cambios, fijarme en como lo he declarado las variables en DAO
		//Integer resultado = a.insertarNotas(alumnos, id_asignatura, notas, fecha);
		
		request.setAttribute("resultado", resultado);
		ComboUtils.recuperarComboAlumnosHib(request);
		ComboUtils.recuperarComboAsignaturasHib(request);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/InsertarNotas.jsp");
		d.forward(request, response);
	}

}
