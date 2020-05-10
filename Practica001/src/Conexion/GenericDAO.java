package Conexion;

import java.util.List;

import Modelo.Persona;
import Modelo.Telefono;

public interface GenericDAO<T, ID> {

	public void createTable();

	public void create(T entity);

	public T read(ID id);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();
	
	int buscar(String email, String pwd);
	
	String cedula(String cdi);

}
