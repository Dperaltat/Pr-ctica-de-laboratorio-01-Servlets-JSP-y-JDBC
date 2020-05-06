package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.DAOFactory;
import Conexion.PersonaDAO;
import Conexion.TelefonoDAO;
import Modelo.Persona;
import Modelo.Telefono;

public class JDBCPersonaDAO extends JDBCGenericDAO<Persona, Integer> implements PersonaDAO{
	
	@Override
	public void createTable() {

		conexionUno.update("DROP TABLE IF EXISTS telefono");
		conexionUno.update("DROP TABLE IF EXISTS usuario");
		conexionUno.update("CREATE TABLE usuario (" + "usu_id INT NOT NULL, usu_cedula VARCHAR(12), "
				+ "usu_nombre VARCHAR(255), usu_apellido VARVHAR(255), usu_correo VARCHAR(255), +"
				+ "usu_contrasenia VARCHAR(255), PRIMARY KEY (USU_ID))");
		DAOFactory.getFactory().getTelefonoDAO().createTable();
	}
	
	@Override
	public void create(Persona persona) {

		conexionUno.update("INSERT usuario VALUES (" + persona.getUsu_id() + ", " + persona.getUsu_cedula() + ", '" + persona.getUsu_nombre()
				+ "', '" + persona.getUsu_apellido() + "', '" + persona.getUsu_correo() + "', '" + persona.getUsu_contrasenia() + "')");
		Telefono telefono = persona.getTelefono();
		
		if (telefono != null) {
			DAOFactory.getFactory().getTelefonoDAO().create(telefono);
		}

	}
	
	@Override
	public Persona read(Integer id) {

		Persona persona = null;
		ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_id=" + id);
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getInt("usu_id"), rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),rs.getString("usu_correo"),rs.getString("usu_contrasenia"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		if (persona == null) {
			return null;
		} else {
			Telefono telefono = DAOFactory.getFactory().getTelefonoDAO().findByUserId(persona.getUsu_id());
			if (telefono != null) {
				persona.setTelefono(telefono);
			}
		}
		return persona;
	}
	
	@Override
	public void update(Persona persona) {

		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		Telefono telefono = telefonoDAO.findByUserId(persona.getUsu_id());
		System.out.println("Act:..." + persona);
		conexionUno.update("UPDATE usuario SET usu_nombre = '" + persona.getUsu_nombre() + "', contrasenia = '" + persona.getUsu_contrasenia()
				+ "', usu_correo= " + persona.getUsu_correo() + " WHERE usu_id = " + persona.getUsu_id());

		if (persona.getTelefono() == null && telefono != null) {
			telefonoDAO.delete(telefono);
		} else if (persona.getTelefono()!= null && telefono == null) {
			telefonoDAO.create(persona.getTelefono());
		} else if (persona.getTelefono() != null && telefono != null) {
			telefonoDAO.update(persona.getTelefono());
		}

	}
	
	@Override
	public void delete(Persona persona) {

		if (persona.getTelefono() != null) {
			DAOFactory.getFactory().getTelefonoDAO().delete(persona.getTelefono());
		}
		conexionUno.update("DELETE FROM User WHERE id = " + persona.getUsu_id());

	}
	
	@Override
	public List<Persona> find() {
		List<Persona> list = new ArrayList<Persona>();
		ResultSet rs = conexionUno.query("SELECT * FROM usuario");
		try {
			while (rs.next()) {
				Persona persona = new Persona(rs.getInt("usu_id"), rs.getString("usu_cedula"), rs.getString("usu_nombre"),
						rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_contrasenia"));
				list.add(persona);

			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		for (int i = 0; i < list.size(); i++) {
			Persona persona = list.get(i);
			Telefono telefono = DAOFactory.getFactory().getTelefonoDAO().findByUserId(persona.getUsu_id());
			if (telefono != null) {
				// detail.setUser(user);
				persona.setTelefono(telefono);
				list.set(i, persona);
			}
		}
		return list;
	}

}
