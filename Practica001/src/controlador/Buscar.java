package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexion.DAOFactory;
import Conexion.TelefonoDAO;
import Modelo.Telefono;

@WebServlet("/BuscarTelefonoControlador")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDao;
	private Telefono telefono;

	public Buscar() {
		telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		telefono = new Telefono();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;
		try {
			String id = request.getParameter("tel_id");
			telefono = telefonoDao.read(id);
			request.setAttribute("persona", telefono);
			url = "/JSPs/buscar_telefono.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
