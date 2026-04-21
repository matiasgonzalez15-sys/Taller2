package taller2;

public class Pokemon {
	private String nombre;
	private String habitat;
	private double porcentajeAparicion;
	private int vida;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private String tipo;

	public Pokemon(String nombre, String habitat, double porcentajeAparicion, int vida, int ataque, int defensa,
			int ataqueEspecial, int defensaEspecial, int velocidad, String tipo) {

		this.nombre = nombre;
		this.habitat = habitat;
		this.porcentajeAparicion = porcentajeAparicion;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", habitat=" + habitat + ", porcentajeAparicion=" + porcentajeAparicion
				+ ", vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + ", ataqueEspecial="
				+ ataqueEspecial + ", defensaEspecial=" + defensaEspecial + ", velocidad=" + velocidad + ", tipo="
				+ tipo + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public String getHabitat() {
		return habitat;
	}

	public Double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String getTipo() {
		return tipo;
	}

}
