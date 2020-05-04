package Modelo;

public class Telefono {
	
	private int tel_id;
	private String tel_numero;
	private String tel_tipo;
	private String tel_operadora;
		
	public Telefono(int tel_id, String tel_numero, String tel_tipo, String tel_operadora) {
		super();
		this.tel_id = tel_id;
		this.tel_numero = tel_numero;
		this.tel_tipo = tel_tipo;
		this.tel_operadora = tel_operadora;
	}
	
	public int getTel_id() {
		return tel_id;
	}
	public void setTel_id(int tel_id) {
		this.tel_id = tel_id;
	}
	public String getTel_numero() {
		return tel_numero;
	}
	public void setTel_numero(String tel_numero) {
		this.tel_numero = tel_numero;
	}
	public String getTel_tipo() {
		return tel_tipo;
	}
	public void setTel_tipo(String tel_tipo) {
		this.tel_tipo = tel_tipo;
	}
	public String getTel_operadora() {
		return tel_operadora;
	}
	public void setTel_operadora(String tel_operadora) {
		this.tel_operadora = tel_operadora;
	}
	
	
}