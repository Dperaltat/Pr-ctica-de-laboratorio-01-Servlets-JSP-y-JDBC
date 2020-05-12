package Conexion;

import java.util.List;
import java.util.Set;

import Modelo.Contacto;
import Modelo.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, String>{

	public abstract Telefono findByUserId(Integer usu_id);
	
	List<Contacto> buscarCorreo(String correo);
	List<Telefono> buscarCedula(String cedula);
	List<Contacto> obtenerContacto();

	List<Contacto> buscarCedInv(String cedula);
	void eliminar2(String tel_id);
}
