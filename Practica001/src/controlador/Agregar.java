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
import Modelo.Telefono;

@WebServlet("/Agregar")
public class Agregar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Agregar() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String numero="";
		String operadora="";
		String tipo="";
		String id="";

		HttpSession sesion = request.getSession();
		
		System.out.print("ID sesion: "+ String.valueOf(sesion.getId()));
		System.out.print("ID sesionRetornada: "+String.valueOf(sesion.getAttribute("accesos")));
		
		//System.out.println("ingresados" +request.getParameter("numero"));
		
		Telefono telefono = new Telefono();
		Persona persona = new Persona();
		String resp = request.getParameter("agregar");
		
		TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();
		PersonaDAO personaDAO = DAOFactory.getFactory().getPersonaDAO();
		
		if(resp.equals("ingresar")) {
			numero = request.getParameter("numero");
			//System.out.println("numero "+numero);
			
			operadora = request.getParameter("tel_operadora");
			tipo = request.getParameter("tipo");
			id = request.getParameter("ced");
			System.out.println("datos recolectados "+numero +", "+operadora+", "+tipo+","+ id);
			
			persona=personaDAO.read(id);
			System.out.print(persona +" "+tipo);
			System.out.println("ID: " + request.getParameter("ced"));
			telefono = new Telefono(id,numero,tipo,operadora);
			
			telfDAO.create(telefono);
			
			System.out.println("Agregando");
			
		}
		try {
			
			request.setAttribute("usuario", persona);
			request.setAttribute("telefono", telfDAO.buscarCedula(request.getParameter("ced")));
			
			System.out.println("ingresando telefono");
			
			getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println("Error en agregar "+e.getMessage());
		}
		
	}

}
