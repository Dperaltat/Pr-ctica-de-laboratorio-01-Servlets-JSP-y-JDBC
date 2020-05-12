package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.PersonaDAO;
import Conexion.TelefonoDAO;
import Modelo.Contacto;
import Modelo.Persona;
import Modelo.Telefono;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, String> implements TelefonoDAO{
 
	
	@Override
	public void create(Telefono entity) {
		// TODO Auto-generated method stub
		conexionDos.update("INSERT into telefono (tel_id, tel_numero, tel_tipo, tel_operadora) values"
				+ " ( '" + entity.getTel_id() + "', '"
		+ entity.getTel_numero() + "','"+entity.getTel_tipo()+"','"+entity.getTel_operadora()+"' )");
	}

	@Override
	public Telefono read(String id) {
		// TODO Auto-generated method stub
		
		Telefono t = null;
		ResultSet rs = conexionDos.query("SELECT * FROM telefono where tel_id='" + id+"'");
		
		try {
			if(rs.next()) {
				t = new Telefono(rs.getInt("tel_id"), rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora"));
			}
		}catch(SQLException e) {
			System.out.println(">>> Warning (TelefonoDAO:read): "+ e.getMessage());
		}
		
		
		return t;
	}

	@Override
	public void update(Telefono entity) {
		// TODO Auto-generated method stub
		conexionDos.update("UPDATE telefono SET tel_numero = '" + entity.getTel_numero() + "', tel_tipo = '" +  entity.getTel_tipo() + 
				"', tel_operadora = '" + entity.getTel_operadora() + "'WHERE tel_id = " + entity.getTel_id());
	}

	@Override
	public void delete(Telefono entity) {
		// TODO Auto-generated method stub
		conexionDos.update("DELETE FROM telefono WHERE tel_id="+entity.getTel_id());
	}

	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		List<Telefono> listTelefono = new ArrayList<Telefono>();
		ResultSet rs = conexionDos.query("SELECT * FROM telefono");
		try {
			while(rs.next()) {
				listTelefono.add(new Telefono(rs.getInt("tel_id"), rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				//System.out.println("desde el jdbcTelefono"+listTelefono);
			}
		}catch(SQLException e) {
			System.out.println(">>> WARNING (JDBCTelefonoDAO: find) : " + e.getMessage());
		}
		
		
		return listTelefono;
	}
	

	@Override
	public Persona buscar(String email, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("Email: ------------- "+email.toString());
		int i=0;
		Persona persona = null;
		ResultSet rs = conexionDos.query("SELECT * FROM usuario WHERE  usu_correo=" +  "'" + email + "'" + "AND usu_contrasenia=" +  "'" + pwd + "'" );
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
		String ced = null;
		Persona us = null;
		ced = us.getUsu_cedula();
		ResultSet rs = conexionDos.query("SELECT * FROM usuario WHERE usu_cedula='"+cdi+"'");
		try {
			if( rs != null && rs.next()) {
				ced = rs.getString("usu_cedula");
			}
		}catch(SQLException e) {
			
		}
		return ced;
		

	}

	@Override
	public List<Contacto> buscarCorreo(String correo) {
		// TODO Auto-generated method stub
		List<Contacto> listCont = new ArrayList<Contacto>();
		System.out.print("Consultando.....");
		
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexionDos.query("SELECT * FROM telefono, usuario where usuario.usu_id=telefono.tel_id and usuario.usu_correo="+"'"+ correo+"'");
		//ResultSet t = null;
		try {
			while (rs.next()) {
				Contacto cont=new Contacto();
				//list.add(new telefono(rs.getInt("tel_codigo"), rs.getString("tel_cedula"), rs.getString("tel_numero"),rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				cont.setNumero(rs.getString("tel_numero"));
				
				cont.setOperadora(rs.getString("tel_operadora"));
				
				cont.setTipo(rs.getString("tel_tipo"));
				
				cont.setNombres(rs.getString("usu_nombre"));
				
				cont.setApellidos(rs.getString("usu_apellido"));
				
				cont.setCorreo(rs.getString("usu_correo"));

				listCont.add(cont);
				
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:obtenerContacto): " + e.getMessage());
		}
		
		return listCont;
	}

	@Override
	public List<Telefono> buscarCedula(String cedula) {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexionDos.query("SELECT * FROM usuario, telefono WHERE telefono.tel_id=usuario.usu_id and usuario.usu_cedula="+ cedula);
		try {
			while (rs.next()) {
				list.add(new Telefono(rs.getInt("tel_id"), rs.getString("tel_numero"), rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				//System.out.println("desde el jdbcTelefono"+listTelefono);
			
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public List<Contacto> obtenerContacto() {
		// TODO Auto-generated method stub
		List<Contacto> listCont = new ArrayList<Contacto>();
		System.out.print("Consultando.....");
		
		//Usuario user = new Usuario();
		
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexionDos.query("SELECT * FROM telefono, usuario where usuario.usu_id=telefono.tel_id");
		//ResultSet t = null;
		try {
			while (rs.next()) {
				Contacto cont = new Contacto();
				//list.add(new telefono(rs.getInt("tel_codigo"), rs.getString("tel_cedula"), rs.getString("tel_numero"),rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				cont.setNumero(rs.getString("tel_numero"));
				
				cont.setOperadora(rs.getString("tel_operadora"));
				
				cont.setTipo(rs.getString("tel_tipo"));
				
				cont.setNombres(rs.getString("usu_nombre"));
				
				cont.setApellidos(rs.getString("usu_apellido"));
				
				cont.setCorreo(rs.getString("usu_correo"));
				
				listCont.add(cont);
				
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:obtenerContacto): " + e.getMessage());
		}
		
		

		return listCont;
}

	@Override
	public List<Contacto> buscarCedInv(String cedula) {
		// TODO Auto-generated method stub
		List<Contacto> listCont = new ArrayList<Contacto>();
		System.out.print("Consultando.....");
		
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexionDos.query("SELECT * FROM telefono, usuario where usuario.usu_id=telefono.tel_id and usuario.usu_cedula="+"'"+cedula+"'");
		//ResultSet t = null;
		try {
			while (rs.next()) {
				Contacto cont=new Contacto();
				//list.add(new telefono(rs.getInt("tel_codigo"), rs.getString("tel_cedula"), rs.getString("tel_numero"),rs.getString("tel_tipo"), rs.getString("tel_operadora")));
				cont.setNumero(rs.getString("tel_numero"));
				
				cont.setOperadora(rs.getString("tel_operadora"));
				
				cont.setTipo(rs.getString("tel_tipo"));
				
				cont.setNombres(rs.getString("usu_nombre"));
				
				cont.setApellidos(rs.getString("usu_apellido"));
				
				cont.setCorreo(rs.getString("usu_correo"));

				listCont.add(cont);
				
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:obtenerContacto): " + e.getMessage());
		}
		return listCont;
	}

	@Override
	public void eliminar2(String tel_id) {
		// TODO Auto-generated method stub
		conexionDos.update("DELETE FROM telefono WHERE tel_id="+Integer.parseInt(tel_id));
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Telefono findByUserId(Integer usu_id) {
		// TODO Auto-generated method stub
		return null;
	}

}