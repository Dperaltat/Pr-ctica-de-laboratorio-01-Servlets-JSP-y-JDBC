package Conexion;

import Modelo.Persona;
import Modelo.Telefono;

public interface PersonaDAO extends GenericDAO<Persona, Integer>{

	Telefono findByUserId(int usu_id);

	void create(Persona persona);

} 


