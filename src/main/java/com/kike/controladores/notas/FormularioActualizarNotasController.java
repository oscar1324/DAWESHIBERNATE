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
import com.kike.colegio.dtos.Asignaturas;
import com.kike.colegio.dtos.Notas;
import com.kike.colegio.dtos.NotasDTO;
import com.kike.colegio.utils.ComboUtils;

/**
 * Servlet implementation class FormularioActualizarNotasController
 */
@WebServlet("/formularioactualizarnotas")
public class FormularioActualizarNotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarNotasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/ActualizarNotas.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. recuperar parametros    SIMPLEMENTE TE PIDEN 3
		String nombreAlumno = request.getParameter("nombreAlumno");
		String nombreAsignatura = request.getParameter("nombreAsignatura");// para luego modificar en insertar o acutalizar en jsp
		String fecha = request.getParameter("fecha");
	
		ComboUtils.recuperarComboAsignaturasHib(request);
		ComboUtils.recuperarComboAsignaturasHib(request);
		// 2. instanciar objetos
		NotasDAO a = new NotasDAOImpl();
		List<NotasDTO> listaNotas = new ArrayList<>();
		listaNotas = a.obtenerNombreAsignaturaNota(nombreAlumno, nombreAsignatura, fecha);
		
		request.setAttribute("lista", listaNotas);
		// 3. Direccionar
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/notas/ActualizarNotas.jsp");
		d.forward(request, response);
	}

}