package taller2;

import java.util.LinkedList;

public class Persona {
	private String nombre;
	private LinkedList<Pokemon> pokemons;
	
	public String getNombre() {
		return nombre;
	}

	

	public Persona(String nombre, LinkedList<Pokemon> pokemons) {
		super();
		this.nombre = nombre;
		this.pokemons = pokemons;
	}



	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", pokemons=" + pokemons + "]";
	}



	public LinkedList<Pokemon> getPokemons() {
		return pokemons;
	}



	
	
}
