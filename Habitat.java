package asd;

import java.util.LinkedList;
import java.util.List;

public class Habitat {
	private String nombre;
	private List<Pokemon> pokemones;
	
	public Habitat(String nombre) {
		this.nombre = nombre;
		this.pokemones = new LinkedList<Pokemon>();
	}

	public String getNombre() {
		return nombre;
	}

	public List<Pokemon> getPokemones() {
		return pokemones;
	}

	public void agregarPokemon(int aparicion, Pokemon p) {
		for(int i = 0; i < aparicion; i++) {
			pokemones.add(p);
		}
		
	}
	
	

}
