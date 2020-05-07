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

@WebServlet("/CrearTelefonoControlador")
public class CrearTelefonoControlador extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDao;
	private Telefono telefono;
	
	public CrearTelefonoControlador() {
		telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		telefono = new Telefono();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = null;
		try {
			telefono.setTel_id(Integer.valueOf(request.getParameter("tel_id")));
			telefono.setTel_numero(request.getParameter("tel_numero"));
			telefono.setTel_tipo(request.getParameter("tel_tipo"));
			telefono.setTel_operadora(request.getParameter("tel_operadora"));			
			telefonoDao.create(telefono);			
			
			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
	
	
}
