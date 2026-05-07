package taller2;

public class Pokemon {
	private String nombre;
	private Habitat habitat;
	private int porcentajeAparicion;
	private int vida;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private String tipo;
	private boolean vivo;
	private int statsTotales;

	public Pokemon(String nombre, Habitat habitat, int porcentajeAparicion, int vida, int ataque, int defensa,
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
		this.vivo = true;
		this.statsTotales = 0;
	}

	public void sumarEstadisticas() {
		this.statsTotales = vida + ataque + defensa + ataqueEspecial + defensaEspecial + velocidad;
	}

	public int getStatsTotales() { return statsTotales; }
	public boolean isVivo() { return vivo; }
	public void setVivo(boolean vivo) { this.vivo = vivo; }
	
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

	public Habitat getHabitat() {
		return habitat;
	}

	public int getPorcentajeAparicion() {
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
