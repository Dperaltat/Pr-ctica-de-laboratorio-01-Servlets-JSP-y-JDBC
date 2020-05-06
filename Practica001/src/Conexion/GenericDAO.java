package Conexion;

import java.util.List;

import Modelo.Persona;
import Modelo.Telefono;

public interface GenericDAO<T, ID> {

	public void createTable();

	public void create(Telefono telefono);

	public T read(ID id);

	public void update(Telefono telefono);

	public void delete(Telefono telefono);

	public List<T> find();

	void update(Persona persona);

}
