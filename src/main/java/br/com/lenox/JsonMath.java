package br.com.lenox;

public class JsonMath {

	
	private final String[] operadores;
	private final String tipoOperacao;
	private final Double resultado;
	
	
	
	public JsonMath(String[] operadores, String tipoOperacao,Double resultado) {
		super();
		this.operadores = operadores;
		this.tipoOperacao = tipoOperacao;
		this.resultado = resultado;
	}


	public String[] getOperadores() {
		return operadores;
	}


	public Double getResultado() {
		return resultado;
	}


	public String getTipoOperacao() {
		return tipoOperacao;
	}
	
	
	
	
}
