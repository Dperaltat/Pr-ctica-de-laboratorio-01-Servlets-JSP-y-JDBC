package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.PersonaDAO;
import Conexion.TelefonoDAO;
import Modelo.Persona;
import Modelo.Telefono;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO{
	
	
	@Override
	public void createTable() {

		conexionDos.update("DROP TABLE IF EXISTS telefono");
		conexionDos.update("CREATE TABLE telefono (" + "tel_id INT NOT NULL, tel_numero VARCHAR(45), "
				+ "tel_tipo VARCHAR(45), tel_operadora VARCHAR(255), "
				+ "usu_id INT, PRIMARY KEY (tel_id), FOREIGN KEY(usu_id) REFERENCES usuario(usu_id))");
	}
	
	@Override
	public void create(Telefono telefono) {

		conexionDos.update("INSERT telefono VALUES (" + telefono.getTel_id() + ", '" + telefono.getTel_numero() + "', " + telefono.getTel_tipo()
				+ "', " + telefono.getTel_operadora() + "', "
				+ telefono.getPersona().getUsu_id()+ ")");
	}


	@Override
	public Telefono read(Integer id) {

		Telefono telefono = null;
		ResultSet rsTel = conexionUno.query("SELECT * FROM telefono WHERE tel_id=" + id);
		try {
			if (rsTel != null && rsTel.next()) {
				telefono = new Telefono(rsTel.getInt("tel_id"), rsTel.getString("tel_numero"), 
								rsTel.getString("tel_tipo"), rsTel.getString("tel_operadora"));

				ResultSet rsUser = conexionDos.query("SELECT * FROM usuario WHERE usu_id=" + rsTel.getInt("usu_id"));
				if (rsUser != null && rsUser.next()) {
					Persona persona = new Persona(rsUser.getInt("usu_id"), rsUser.getString("usu_cedula"), rsUser.getString("usu_nombre"), rsUser.getString("usu_apellido"),
							rsUser.getString("usu_correo"), rsUser.getString("usu_contrasenia"));
					telefono.setPersona(persona);
				}

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
		}
		if (telefono == null) {
			return null;
		}
		return telefono;

	}

	@Override
	public void update(Telefono telefono) {

		conexionDos.update(
				"UPDATE telefono SET tel_numero = '" + telefono.getTel_numero() + "' WHERE tel_id = " + telefono.getTel_id());
	}

	@Override
	public void delete(Telefono telefono) {

		conexionDos.update("DELETE FROM telefono WHERE tel_id = " + telefono.getTel_id());

	}

	@Override
	public List<Telefono> find() {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rsTel = conexionUno.query("SELECT * FROM telefono");
		try {
			while (rsTel.next()) {
				Telefono telefono = new Telefono(rsTel.getInt("tel_id"), rsTel.getString("tel_numero"), rsTel.getString("tel_tipo")
									, rsTel.getString("tel_operadora"));

				int userId = rsTel.getInt("usu_id");
				ResultSet rsUser = conexionDos.query("SELECT * FROM usuario WHERE usu_id=" + userId);
				if (rsUser != null && rsUser.next()) {
					Persona persona = new Persona(rsUser.getInt("usu_id"), rsUser.getString("usu_cedula"), rsUser.getString("usu_nombre"),
							rsUser.getString("usu_apellido"), rsUser.getString("usu_correo"), rsUser.getString("usu_contrasenia"));
					telefono.setPersona(persona);
				}
				list.add(telefono);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}

		return list;
	}

	@Override
	public Telefono findByUserId(Integer userId) {
		Telefono telefono = null;
		ResultSet rsTel = conexionUno.query("SELECT * FROM telefono WHERE usu_id=" + userId);
		try {
			if (rsTel != null && rsTel.next()) {
				telefono = new Telefono(rsTel.getInt("tel_id"), rsTel.getString("tel_numero"), rsTel.getString("tel_tipo"), rsTel.getString("tel_operadora"));

				ResultSet rsUser = conexionDos.query("SELECT * FROM usuario WHERE usu_id=" + rsTel.getInt("usu_id"));
				if (rsUser != null && rsUser.next()) {
					Persona persona = new Persona(rsUser.getInt("usu_id"), rsUser.getString("usu_cedula"), rsUser.getString("usu_nombre"),
							rsUser.getString("usu_apellido"), rsUser.getString("usu_correo"), rsUser.getString("usu_contrasenia"));
					telefono.setPersona(persona);
				}

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:findByUserId): " + e.getMessage());
		}
		if (telefono == null) {
			return null;
		}
		return telefono;
	}
}

