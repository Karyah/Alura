package br.com.alura;

public class Endereco {
	private String rua;
	private Integer numero;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(String rua, Integer numero) {
		super();
		this.rua = rua;
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
}
