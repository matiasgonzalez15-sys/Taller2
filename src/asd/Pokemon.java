package taller2;

public class Pokemon {
	private String nombre;
	private Habitat habitat;
	private double porcentaje;
	private int vida;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private String tipo;
	private int statsTotales;
	private boolean vivo;
	
	public Pokemon(String nombre, Habitat habitat, double porcentaje, int vida, int ataque, int defensa,
			int ataqueEspecial, int defensaEspecial, int velocidad, String tipo) {
		this.nombre = nombre;
		this.habitat = habitat;
		this.porcentaje = porcentaje;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.tipo = tipo;
		this.statsTotales = 0;
		this.vivo = true;
	}

	public String getNombre() {
		return nombre;
	}

	public Habitat getHabitat() {
		return habitat;
	}

	public double getPorcentaje() {
		return porcentaje;
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
	/**
	 * Calcula y almacena la suma de todas las estadisticas del Pokemon
	 * (vida + ataque + defensa + ataqueEspecial + defensaEspecial + velocidad).
	 */
	public void sumarEstadisticas() {
		this.statsTotales = this.ataque + this.defensa + this.ataqueEspecial + this.defensaEspecial + this.vida + this.velocidad;
	}

	public int getStatsTotales() {
		return statsTotales;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	
	
}
