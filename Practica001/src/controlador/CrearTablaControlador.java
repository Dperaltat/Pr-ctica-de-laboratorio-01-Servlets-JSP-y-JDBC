package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexion.DAOFactory;
import Conexion.PersonaDAO;


@WebServlet("/CrearTablaController")
public class CrearTablaControlador extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;

	public CrearTablaControlador() {
		personaDao = DAOFactory.getFactory().getPersonaDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		try {
			personaDao.createTable();
			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}
	
	
}
