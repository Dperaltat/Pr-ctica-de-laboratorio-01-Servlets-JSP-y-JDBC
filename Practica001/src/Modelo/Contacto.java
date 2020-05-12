package Modelo;

import java.io.Serializable;

public class Contacto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String nombres ="";
	String apellidos="";
	String correo ="";
	String numero="";
	String operadora="";
	String tipo ="";
	
	public Contacto() {
		
	}
	
	public Contacto(String nombres, String apellidos, String correo, String numero, String operadora, String tipo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.numero = numero;
		this.operadora = operadora;
		this.tipo = tipo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Contacto [nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", numero=" + numero
				+ ", operadora=" + operadora + ", tipo=" + tipo + "]";
	}
	
	
	
}
