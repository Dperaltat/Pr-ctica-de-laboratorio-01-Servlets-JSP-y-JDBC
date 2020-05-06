package Conexion;

import java.util.Set;

import Modelo.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{

	public abstract Telefono findByUserId(Integer usu_id);
	
}
