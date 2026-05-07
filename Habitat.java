package taller2;

import java.util.LinkedList;

public class Habitat {
	private String nombre;
	private LinkedList<Pokemon> pokemones;

	public Habitat(String nombre) {
		this.nombre = nombre;
		this.pokemones = new LinkedList<Pokemon>();
	}

	public void agregarPokemon(int aparicion, Pokemon p) {
		pokemones.add(p);
	}

	public LinkedList<Pokemon> getPokemones() {
		return pokemones;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
