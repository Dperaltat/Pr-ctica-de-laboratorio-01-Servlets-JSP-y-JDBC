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

@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Buscar() {
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
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();

		// out.println("<h1>Gracias por acceder al servidor</h1>");
		// sesion.setAttribute("accesos", 1);
		System.out.println("Buscando");
		if (Integer.parseInt(request.getParameter("id")) == 1) {
			// Correo
			if (request.getParameter("correo") != null) {
				System.out.print("Correo: " + request.getParameter("correo"));

				request.setAttribute("telefono", telefonoDao.buscarCorreo(request.getParameter("correo")));
				getServletContext().getRequestDispatcher("/JSPs/Buscar.jsp").forward(request, response);

			}

		} else {

		}

		if (Integer.parseInt(request.getParameter("id")) == 2) {
			// Cedula
			if (request.getParameter("cedula") != null) {
				System.out.print("Cedula: " + request.getParameter("cedula"));
				request.setAttribute("telefono", telefonoDao.buscarCedInv(request.getParameter("cedula")));
				getServletContext().getRequestDispatcher("/JSPs/Busquedas.jsp").forward(request, response);
			}
		} else {

		}
		
	}

}