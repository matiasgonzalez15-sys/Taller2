package taller2;

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
	/**
	 * Agrega un Pokemon a la lista de la persona.
	 * @param pokemonRandom El Pokemon a agregar.
	 */
	public void agregarPokemon(Pokemon pokemonRandom) {
		pokemons.add(pokemonRandom);
		
	}
	/**
	 * Muestra los primeros 6 Pokemon del equipo con nombre, tipo, stats y estado.
	 */
	public void mostrarEquipo() {
		int c = 0;
		System.out.println("Tu equipo:");
		System.out.println();
		for(Pokemon p : pokemons) {
			if(c < 6) {
				String estado = "";
				if(p.isVivo()) {
					estado = "Vivo";
				}
				else {
					estado = "Muerto";
				}
				System.out.println(p.getNombre() + " | " + p.getTipo() + " | Stats totales: "+ p.getStatsTotales() + " | Estado: " + estado );
				c++;
			}	
		}
		System.out.println();
		
		
	}
	/**
	 * Muestra el nombre y tipo de todos los Pokemon del lider (Gimnasio).
	 */
	public void mostrarPokemonsLider() {
		System.out.println();
		for(Pokemon p : pokemons) {
			p.sumarEstadisticas();
			System.out.println(p.getNombre() + " | " + p.getTipo());
		}
		System.out.println();
		
	}
	/**
	 * Muestra todos los Pokemon capturados numerados con nombre, tipo y stats.
	 * @return true si tiene al menos un Pokemon, false si la lista esta vacia.
	 */
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
	/**
	 * Intercambia de posicion dos Pokemon en la lista usando sus indices.
	 * @param opPokemon Indice del primer Pokemon (basado en 1).
	 * @param opPokemonB Indice del segundo Pokemon (basado en 1).
	 */
	public void cambiarPokemon(int opPokemon, int opPokemonB) {
		boolean error = true;
	
		try {	
			Pokemon temp = pokemons.get(opPokemon - 1);
			pokemons.set(opPokemon - 1, pokemons.get(opPokemonB - 1));
			pokemons.set(opPokemonB- 1, temp);
		}catch(Exception e) {
			System.out.println("Numeros ingresados no correctos " +e.getMessage());
			error = false;
		}
		if(error) {
			System.out.println("Cambio realizado con exito!!");
		}
	
		
	}
	/**
	 * Verifica si un Pokemon ya existe en la lista comparando por nombre.
	 * @param pokemonRandom El Pokemon a buscar.
	 * @return true si ya fue capturado, false si no.
	 */
	public boolean buscarPokemon(Pokemon pokemonRandom) {
		for(Pokemon p : pokemons) {
			if(pokemonRandom.getNombre().equals(p.getNombre())) {
				return true;
			}
		}
		return false;
	}
	
	

}
