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

	public boolean mostrarPC() {
		if(pokemons.isEmpty()) {
			System.out.println("No tienes pokemons en tu PC!!");
			return false;
		}
		else {	
			System.out.println("=== PC ===");
			System.out.println("CONSIDERA QUE HASTA LOS 6 PRIMEROS SON PARTE DE TU EQUIPO!!!");
			System.out.println();
			
			for(int i = 0; i < pokemons.size(); i++) {
				System.out.println(i+1 + ") " + pokemons.get(i).getNombre() + " | " + pokemons.get(i).getTipo() + " | Stats totales: " + pokemons.get(i).getStatsTotales());
							
			}
			
		}
		return true;	
		
	}

	public void cambiarPokemon(int opPokemon, int opPokemonB) {
		Pokemon temp = pokemons.get(opPokemon - 1);
		pokemons.set(opPokemon - 1, pokemons.get(opPokemonB - 1));
		pokemons.set(opPokemonB- 1, temp);
		
	}
	
	

}
