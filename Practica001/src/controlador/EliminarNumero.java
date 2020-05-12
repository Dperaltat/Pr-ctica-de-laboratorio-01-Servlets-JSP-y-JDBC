package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexion.DAOFactory;
import Conexion.PersonaDAO;
import Conexion.TelefonoDAO;
import Modelo.Persona;
import Modelo.Telefono;

@WebServlet("/EliminarNumero")
public class EliminarNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EliminarNumero() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PersonaDAO personaDAO = DAOFactory.getFactory().getPersonaDAO();
		TelefonoDAO telDAO = DAOFactory.getFactory().getTelefonoDAO();
		Telefono telefono = new Telefono();
		Persona persona = new Persona();
		String tel_id="";
		
		String id= request.getParameter("usu_id");
		tel_id = request.getParameter("tel_id");
		System.out.println("El ID del teléfono: "+request.getParameter("tel_id"));
		
		
		telefono = telDAO.read(tel_id);
		System.out.println("telefono para eliminar "+telefono);
		System.out.println("cedula del usuario en delete:" +id);
		
		telDAO.eliminar2(tel_id);
		System.out.println("paso del eliminar");
		
		try {
			
			persona = personaDAO.read(id);
			
			request.setAttribute("usuario", persona);
			request.setAttribute("telefono", telDAO.find());
			getServletContext().getRequestDispatcher("/JSPs/Usuario.jsp").forward(request, response);
			
		}catch(Exception e) {
			System.out.println("Error al eliminar " + e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
