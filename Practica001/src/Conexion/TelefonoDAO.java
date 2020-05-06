package Conexion;

import Modelo.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{

	Telefono findByUserId(int usu_id);
	
}
