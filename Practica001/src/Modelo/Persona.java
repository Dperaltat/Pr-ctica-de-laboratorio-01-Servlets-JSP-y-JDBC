package Modelo;

public class Persona {
	
	private int usu_id;
	private String usu_cedula;
	private String usu_nombre;
	private String usu_apellido;
	private String usu_correo;
	private String usu_contrasenia;
	private Telefono Telefono;
	
	public Persona(int usu_id, String usu_cedula, String usu_nombre, String usu_apellido, String usu_correo,
			String usu_contrasenia) {
		super();
		this.usu_id = usu_id;
		this.usu_cedula = usu_cedula;
		this.usu_nombre = usu_nombre;
		this.usu_apellido = usu_apellido;
		this.usu_correo = usu_correo;
		this.usu_contrasenia = usu_contrasenia;
	}

	public Persona(){
		
	}

	public int getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(int usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_cedula() {
		return usu_cedula;
	}

	public void setUsu_cedula(String usu_cedula) {
		this.usu_cedula = usu_cedula;
	}

	public String getUsu_nombre() {
		return usu_nombre;
	}

	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}

	public String getUsu_apellido() {
		return usu_apellido;
	}

	public void setUsu_apellido(String usu_apellido) {
		this.usu_apellido = usu_apellido;
	}

	public String getUsu_correo() {
		return usu_correo;
	}

	public void setUsu_correo(String usu_correo) {
		this.usu_correo = usu_correo;
	}

	public String getUsu_contrasenia() {
		return usu_contrasenia;
	}

	public void setUsu_contrasenia(String usu_contrasenia) {
		this.usu_contrasenia = usu_contrasenia;
	}

	public Telefono getTelefono() {
		return Telefono;
	}

	public void setTelefono(Telefono telefono) {
		Telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [usu_id=" + usu_id + ", usu_cedula=" + usu_cedula + ", usu_nombre=" + usu_nombre
				+ ", usu_apellido=" + usu_apellido + ", usu_correo=" + usu_correo + ", usu_contrasenia="
				+ usu_contrasenia + ", Telefono=" + Telefono + "]";
	}
	
	
}