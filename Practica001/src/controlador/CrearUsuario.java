package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexion.DAOFactory;
import Conexion.PersonaDAO;
import Modelo.Persona;

@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String usu_nombre ="";
		String usu_apellido ="";
		String usu_cedula ="";
		String usu_correo ="";
		String usu_contrasenia="";
		
		Persona persona = new Persona();
		
		String resp = request.getParameter("resp");
		PersonaDAO personaDAO = DAOFactory.getFactory().getPersonaDAO();
		if(resp.equals("Registrarse")) {
			int id=0;
			usu_nombre = request.getParameter("usu_nombre");
			usu_apellido = request.getParameter("usu_apellido");
			usu_cedula = request.getParameter("usu_cedula");
			usu_correo = request.getParameter("usu_correo");
			usu_contrasenia = request.getParameter("usu_contrasenia");
			
			persona = new Persona(id,usu_cedula, usu_nombre, usu_apellido, usu_correo, usu_contrasenia);
			
			personaDAO.create(persona);
			getServletContext().getRequestDispatcher("/JSPs/ExitoCreacion.jsp").forward(request, response);
		}
	}

}
