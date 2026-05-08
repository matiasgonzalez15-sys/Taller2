package taller2;

public class Gimnasio {
	private int numero;
	private Persona lider;
	private String derrotado;
	
	public Gimnasio(int numero, Persona lider, String derrotado) {
		this.numero = numero;
		this.lider = lider;
		this.derrotado = derrotado;
	}

	public int getNumero() {
		return numero;
	}

	public Persona getLider() {
		return lider;
	}

	public String getDerrotado() {
		return derrotado;
	}

	public void setDerrotado(String derrotado) {
		this.derrotado = derrotado;
	}
	
	

}
