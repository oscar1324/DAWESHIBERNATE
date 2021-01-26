package com.kike.colegio.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kike.colegio.dao.NotasDAO;
import com.kike.colegio.dao.impl.NotasDAOImpl;
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.dtos.Notas;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class FormularioBorrarNotasController
 */
@WebServlet("/borrarformularionotas")
public class FormularioBorrarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarNotasController() {
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
		String id_alumno = request.getParameter("id_alumnos");
		String alumnos = request.getParameter("alumnos");
		String id_asignatura = request.getParameter("idas");
		String notas = request.getParameter("notas");
		String fecha = request.getParameter("fecha");
		
		// instanciar objetos
		// (id_alumno, alumnos,id_asignatura, notas, fecha)
		NotasDAO a = new NotasDAOImpl();
		List<Notas> listaNotas = new ArrayList<>();
		
		listaNotas = a.obtenerNotasTodo(id_alumno, alumnos, id_asignatura, notas, fecha);
		
		request.setAttribute("listaNotas", listaNotas);

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/BorrarNotas.jsp");
		d.forward(request, response);
	}

}
