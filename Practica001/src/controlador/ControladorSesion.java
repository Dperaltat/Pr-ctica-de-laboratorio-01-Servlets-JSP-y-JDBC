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


@WebServlet("/ControladorSesion")
public class ControladorSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControladorSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sesion = request.getSession();
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		
		TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();
		Persona persona = new Persona();
		PersonaDAO personaDao = DAOFactory.getFactory().getPersonaDAO();
		
		
		if(Integer.parseInt(request.getParameter("id"))==1) {
			
			PersonaDAO usuDAO = DAOFactory.getFactory().getPersonaDAO();
			request.setAttribute("idc", request.getParameter("c"));
			request.setAttribute("usuarios", usuDAO.find());
			
			getServletContext().getRequestDispatcher("/JSPs/Agregar.jsp").forward(request, response);
		}else if(Integer.parseInt(request.getParameter("id"))==2) {
			
			persona = personaDao.read(request.getParameter("usu_id"));
			request.setAttribute("telefono", telfDAO.buscarCedula(persona.getUsu_cedula()));
			request.setAttribute("usuario", persona);
			
			getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
		}
		//No tocar
		if(Integer.parseInt(request.getParameter("id"))==3) {
			System.out.println("Ingresando...");
			request.setAttribute("telefonos", telfDAO.find());
	
			getServletContext().getRequestDispatcher("/JSPs/Invitado.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
