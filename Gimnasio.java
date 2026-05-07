package taller2;

public class Gimnasio {
	private int numero;
	private Persona lider;
	private String estado;

	public Gimnasio(int numero, Persona lider, String estado) {
		this.numero = numero;
		this.lider = lider;
		this.estado = estado;
	}

	public int getNumero() { return numero; }
	public Persona getLider() { return lider; }
	public String getDerrotado() { return estado; }
	public void setDerrotado(String estado) { this.estado = estado; }
}
