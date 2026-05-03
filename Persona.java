package asd;

import java.util.LinkedList;
import java.util.List;

public class Persona {
	private String nombre;
	private List<Pokemon> pokemons;
	
	public Persona(String nombre) {
		this.nombre = nombre;
		this.pokemons = new LinkedList<Pokemon>();
	}

	public String getNombre() {
		return nombre;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void agregarPokemon(Pokemon pokemonRandom) {
		pokemons.add(pokemonRandom);
		
	}

	public void mostrarEquipo() {
		int c = 0;
		System.out.println("Tu equipo:");
		System.out.println();
		for(Pokemon p : pokemons) {
			if(c < 6) {
				System.out.println(p.getNombre() + " | " + p.getTipo() + " | Stats totales: "+ p.getStatsTotales());
				c++;
			}	
		}
		System.out.println();
		
		
	}

	public void mostrarPokemonsLider() {
		System.out.println();
		for(Pokemon p : pokemons) {
			p.sumarEstadisticas();
			System.out.println(p.getNombre() + " | " + p.getTipo());
		}
		System.out.println();
		
	}
	
	

}
