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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		
		PersonaDAO personaDAO = DAOFactory.getFactory().getPersonaDAO();
		String email ="";
		String pwd = "";
		//String url=null;
		int i=0;
		
		String resp = request.getParameter("resp");
		
		if(resp.equals("Login")) {
			email = request.getParameter("user");
			pwd = request.getParameter("password");
			
			i = personaDAO.buscar(email, pwd);
			System.out.println(i);
		}
		try {
			if(i>0) {
				TelefonoDAO telDAO = DAOFactory.getFactory().getTelefonoDAO();
				
				request.setAttribute("telefono", telDAO.find());
				getServletContext().getRequestDispatcher("ListarTelefonoControlador.java").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/Practica001/login.jsp").forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(">>>WARNING (LOGINSERVEL):DOPOS: T"+e.getMessage());
		}
		
		
				
		
	
	}

}
