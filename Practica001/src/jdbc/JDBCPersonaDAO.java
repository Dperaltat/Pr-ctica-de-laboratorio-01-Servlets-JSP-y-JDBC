package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.DAOFactory;
import Conexion.PersonaDAO;
import Conexion.TelefonoDAO;
import Modelo.Persona;
import Modelo.Telefono;

public class JDBCPersonaDAO extends JDBCGenericDAO<Persona, String> implements PersonaDAO{
	/*
	@Override
	public void createTable() {

		conexionUno.update("DROP TABLE IF EXISTS telefono");
		conexionUno.update("DROP TABLE IF EXISTS usuario");
		conexionUno.update("CREATE TABLE usuario (" + "usu_id INT NOT NULL, usu_cedula VARCHAR(12), "
				+ "usu_nombre VARCHAR(255), usu_apellido VARVHAR(255), usu_correo VARCHAR(255), +"
				+ "usu_contrasenia VARCHAR(255), PRIMARY KEY (usu_id))");
		DAOFactory.getFactory().getTelefonoDAO().createTable();
	}*/
	
	@Override
	public void create(Persona entity) {
		// TODO Auto-generated method stub
		conexionUno.update("INSERT usuario VALUES ('"+entity.getUsu_id()+"','"+entity.getUsu_cedula()+"', '" +entity.getUsu_nombre()+
				"','"+entity.getUsu_apellido()+"','"+ entity.getUsu_correo()+"','" + entity.getUsu_contrasenia()+"')");
	}

	
	@Override
	public Persona read(String id) {
		// TODO Auto-generated method stub
		Persona persona = null;
		ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_id="+id);
		try {
			if (rs != null && rs.next()) {
				persona = new Persona(rs.getInt("usu_id"),rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_contrasenia"));
			}
		}catch(SQLException e) {
			System.out.println("Error al leer usuario >>"+e.getMessage());
		}
		return persona;
	}

	@Override
	public void update(Persona entity) {
		// TODO Auto-generated method stub
		conexionUno.update("'UPDATE usuario set usu_nombre='"+ entity.getUsu_nombre() + "',apellido='"+entity.getUsu_apellido()+
				"'Where usu_cedula='"+entity.getUsu_cedula()+"");
	}

	@Override
	public void delete(Persona entity) {
		// TODO Auto-generated method stub
		conexionUno.update("DELETE FROM Usuario WHERE usu_id="+entity.getUsu_id());
	}

	@Override
	public List<Persona> find() {
		// TODO Auto-generated method stub
		List<Persona> list = new ArrayList<Persona>();
		//, usuario where usuario.cedula = telefono.tel_cedula
		ResultSet rs = conexionUno.query("SELECT * FROM usuario");
		try {
			while(rs.next()) {
				list.add(new Persona(rs.getInt("usu_id"), rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_correo"), rs.getString("usu_contrasenia")));
			}
		}catch(SQLException e) {
			System.out.println(">>>Warning (JDBCPersonaDAO:find): " + e.getMessage());
		}
		for(Persona usu: list) {
			System.out.println(usu.getUsu_cedula() +", "+ usu.getUsu_nombre()+", "+usu.getUsu_apellido());
		}
		return list;
	}


	@Override
	public Persona buscar(String email, String pwd) {
		// TODO Auto-generated method stub
		
		//System.out.println("Email: ------------- "+email.toString());
		int i=1;
		Persona persona = null;
		ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE  usu_correo=" +  "'" + email + "'" + "AND usu_contrasenia=" +  "'" + pwd + "'" );
		try {
			if (rs != null && rs.next()) {
				i=1;
				persona = new Persona (rs.getInt("usu_id"), rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),rs.getString("usu_correo"), rs.getString("usu_contrasenia"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return persona;
	}


	@Override
	public String cedula(String cdi) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

}
