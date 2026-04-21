package taller2;

public class Habitat {
	private String nombre;

	public Habitat(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
