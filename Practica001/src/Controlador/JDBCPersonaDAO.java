package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Conexion.DAOFactory;
import Conexion.PersonaDAO;
import Conexion.TelefonoDAO;
import Modelo.Persona;
import Modelo.Telefono;

public class JDBCPersonaDAO extends JDBCGenericDAO<Persona, Integer> implements PersonaDAO{
	
	@Override
	public void createTable() {

		conexionUno.update("DROP TABLE IF EXISTS Telefono");
		conexionUno.update("DROP TABLE IF EXISTS Persona");
		conexionUno.update("CREATE TABLE Persona (" + "USU_ID INT NOT NULL, USU_CEDULA VARCHAR(12), "
				+ "USU_NOMBRE VARCHAR(255), USU_APELLIDO VARVHAR(255), USU_CORREO VARCHAR(255), +"
				+ "USU_CONTRASENIA VARCHAR(255), PRIMARY KEY (USU_ID))");
		DAOFactory.getFactory().getTelefonoDAO().createTable();
	}
	
	@Override
	public void create(Persona persona) {

		conexionUno.update("INSERT Persona VALUES (" + persona.getUsu_id() + ", " + persona.getUsu_cedula() + ", '" + persona.getUsu_nombre()
				+ "', '" + persona.getUsu_apellido() + "', '" + persona.getUsu_correo() + "', '" + persona.getUsu_contrasenia() + "')");
		Telefono telefono = persona.getTelefono();
		
		if (telefono != null) {
			DAOFactory.getFactory().getPersonaDAO().create(persona);
		}

	}
	
	@Override
	public Persona read(Integer id) {

		Persona persona = null;
		ResultSet rs = conexionUno.query("SELECT * FROM Persona WHERE usu_id=" + id);
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getInt("usu_id"), rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),rs.getString("usu_correo"),rs.getString("usu_contrasenia"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUserDAO:read): " + e.getMessage());
		}
		if (persona == null) {
			return null;
		} else {
			Telefono telefono = DAOFactory.getFactory().getTelefonoDAO().findByUserId(persona.getUsu_id());
			if (telefono != null) {
				persona.setTelefono(telefono);
				// detail.setUser(user);
			}
		}
		return persona;
	}
	
	@Override
	public void update(Persona persona) {

		PersonaDAO personaDAO = DAOFactory.getFactory().getPersonaDAO();
		Telefono telefono = personaDAO.findByUserId(persona.getUsu_id());
		System.out.println("Act:..." + persona);
		conexionUno.update("UPDATE Persona SET usu_nombre = '" + persona.getUsu_nombre() + "', contrasenia = '" + persona.getUsu_contrasenia()
				+ "', usu_correo= " + persona.getUsu_correo() + " WHERE usu_id = " + persona.getUsu_id());

		if (persona.getTelefono() == null && telefono != null) {
			personaDAO.delete(telefono);
		} else if (persona.getTelefono()!= null && telefono == null) {
			personaDAO.create(persona.getTelefono());
		} else if (persona.getTelefono() != null && telefono != null) {
			personaDAO.update(persona.getTelefono());
		}

	}

	@Override
	public void create(Telefono telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Persona> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Telefono findByUserId(int usu_id) {
		// TODO Auto-generated method stub
		return null;
	}
}
