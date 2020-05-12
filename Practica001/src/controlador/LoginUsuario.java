package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Conexion.DAOFactory;
import Conexion.PersonaDAO;
import Conexion.TelefonoDAO;
import Modelo.Persona;


@WebServlet(name = "LoginUsuario", urlPatterns = {"/LoginUsuario"})
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LoginUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");

		PersonaDAO personaDao = DAOFactory.getFactory().getPersonaDAO();
		String correo = "";
		String contrasena = "";
		String url = null;
		int i = 0;

		String accion = request.getParameter("resp");
		Persona persona = new Persona();
		HttpSession sesion = request.getSession(true);

		sesion.setAttribute("accesos", sesion.getId());
		System.out.println("ID sesion: " + String.valueOf(sesion.getId()));
		if (accion.equals("Login")) {
			correo = request.getParameter("usu_correo");
			contrasena = request.getParameter("usu_contrasenia");
			persona = personaDao.buscar(correo, contrasena);
			System.out.println("retorno de usuario: "+ personaDao.buscar(correo, contrasena));
			try {
				if (persona != null) {
					TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();

					request.setAttribute("telefono", telfDAO.buscarCedula(persona.getUsu_cedula()));
					request.setAttribute("usuario", persona);
					getServletContext().getRequestDispatcher("/JSPs/Usuario.jsp").forward(request, response);
				} 
			} catch (Exception e) {
				System.out.println("Error en el login: " + e.getMessage());
			}
		}else {
			getServletContext().getRequestDispatcher("/JSPs/login.jsp").forward(request, response);
		}
		

	}

}
