package taller2;

import java.util.LinkedList;

public class Persona {
	private String nombre;
	private LinkedList<Pokemon> pokemons;
	private LinkedList<Pokemon> pc;
	
	public String getNombre() {
		return nombre;
	}

	public Persona(String nombre) {
		this.nombre = nombre;
		this.pokemons = new LinkedList<Pokemon>();
		this.pc = new LinkedList<Pokemon>();
	}

	public Persona(String nombre, LinkedList<Pokemon> pokemons) {
		super();
		this.nombre = nombre;
		this.pokemons = pokemons;
		this.pc = new LinkedList<Pokemon>();
	}

	public void agregarPokemon(Pokemon p) {
		if (pokemons.size() < 6) {
			pokemons.add(p);
		} else {
			pc.add(p);
		}
	}

	public LinkedList<Pokemon> getPC() {
		return pc;
	}

	public void mostrarEquipo() {
		System.out.println("=== Equipo de " + nombre + " ===");
		for (int i = 0; i < pokemons.size(); i++) {
			Pokemon p = pokemons.get(i);
			String estado = p.isVivo() ? "Vivo" : "Muerto";
			System.out.println((i + 1) + ") " + p.getNombre() + " [" + p.getTipo() + "] - " + estado + " - Stats: " + p.getStatsTotales());
		}
		System.out.println();
	}

	public boolean mostrarPC() {
		System.out.println("=== Equipo activo ===");
		for (int i = 0; i < pokemons.size(); i++) {
			Pokemon p = pokemons.get(i);
			String estado = p.isVivo() ? "Vivo" : "Muerto";
			System.out.println((i + 1) + ") " + p.getNombre() + " - " + estado);
		}
		System.out.println();
		if (pc.isEmpty()) {
			System.out.println("No tienes pokemones guardados en el PC.");
			return false;
		}
		System.out.println("=== PC (pokemones guardados) ===");
		for (int i = 0; i < pc.size(); i++) {
			Pokemon p = pc.get(i);
			String estado = p.isVivo() ? "Vivo" : "Muerto";
			System.out.println((pokemons.size() + i + 1) + ") " + p.getNombre() + " - " + estado);
		}
		return true;
	}

	public void cambiarPokemon(int opA, int opB) {
		int idxEquipo = opA - 1;
		int idxPC = opB - pokemons.size() - 1;
		if (idxEquipo < 0 || idxEquipo >= pokemons.size() || idxPC < 0 || idxPC >= pc.size()) {
			System.out.println("Opcion invalida.");
			return;
		}
		Pokemon sale = pokemons.get(idxEquipo);
		Pokemon entra = pc.get(idxPC);
		pokemons.set(idxEquipo, entra);
		pc.set(idxPC, sale);
	}



	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", pokemons=" + pokemons + "]";
	}



	public LinkedList<Pokemon> getPokemons() {
		return pokemons;
	}



	
	
}
