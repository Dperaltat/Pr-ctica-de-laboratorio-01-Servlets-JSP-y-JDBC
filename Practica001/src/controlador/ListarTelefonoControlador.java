package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexion.DAOFactory;
import Conexion.TelefonoDAO;
import Modelo.Telefono;

@WebServlet("/ListarTelefonoControlador")
public class ListarTelefonoControlador extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDao;
	private List<Telefono> listaTelefono;

	public ListarTelefonoControlador() {
		telefonoDao = DAOFactory.getFactory().getTelefonoDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		try {
			listaTelefono = telefonoDao.find();
			System.out.println("Tamaño de la lista recuperada: " + listaTelefono.size());
			request.setAttribute("telefonos", listaTelefono);
			url = "/JSPs/listar_telefono.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
