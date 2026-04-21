//Maximiliano Edhin Abd-El-Kader Gongora 22.128.215-9
//Matías Ignacio González Gómez 22.350.340-3
package taller2;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Pokemon> listaPokemonsJugador = new LinkedList<Pokemon>();
	static LinkedList<Habitat> listaHabitats = new LinkedList<Habitat>();
	static LinkedList<Pokemon> listaPokemones = new LinkedList<Pokemon>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		cargarHabitats("Habitats.txt", listaHabitats);
		cargarPokemons("Pokedex.txt", listaPokemones);

		System.out.println("Bienvenido!\n");
		String opcion;
		do {
			System.out.println("1) Continuar.");
			System.out.println("2) Nueva Partida.");
			System.out.println("3) Salir. ");
			System.out.print("> ");
			opcion = sc.nextLine();
			switch (opcion) {
			case "1":

				break;

			case "2":
				menuNuevaPartida();
				break;

			default:
				break;
			}

		} while (!opcion.equals("3"));

		sc.close();
	}

	public static void cargarHabitats(String ruta, LinkedList<Habitat> lista) {

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.strip().isEmpty()) {
					Habitat nuevoHabitat = new Habitat(line);

					lista.add(nuevoHabitat);
				}

			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void cargarPokemons(String ruta, LinkedList<Pokemon> lista) {
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.strip().isEmpty()) {
					String[] parts = line.split(";");
					String nombre = parts[0];
					String habitat = parts[1];
					double porcentaje = Double.parseDouble(parts[2]);
					int vida = Integer.parseInt(parts[3]);
					int ataque = Integer.parseInt(parts[4]);
					int defensa = Integer.parseInt(parts[5]);
					int atqEsp = Integer.parseInt(parts[6]);
					int defEsp = Integer.parseInt(parts[7]);
					int velocidad = Integer.parseInt(parts[8]);
					String tipo = parts[9];

					if (parts.length == 10) {
						Pokemon nuevoPokemon = new Pokemon(nombre, habitat, porcentaje, vida, ataque, defensa, atqEsp,
								defEsp, velocidad, tipo);
						lista.add(nuevoPokemon);
					}

				}

			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void menuNuevaPartida() {

		System.out.print("\nIngrese su apodo de jugador: ");
		String nombreCuenta = sc.nextLine();
		Persona jugador = new Persona(nombreCuenta, listaPokemonsJugador);

		String opcion;
		do {
			System.out.println("\n" + jugador.getNombre() + ", que deseas hacer?");
			System.out.println("\n1) Revisar equipo.");
			System.out.println("2) Salir a capturar.");
			System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafío al Alto Mando.");
			System.out.println("6) Curar Pokémon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			System.out.print("> ");
			opcion = sc.nextLine();
			switch (opcion) {
			case "1":
				System.out.println(listaPokemonsJugador.toString());
				break;
			case "2":
				System.out.println("\nDonde deseas ir a explorar?\n");
				System.out.println("Zonas disponibles:\n");
				int i = 1;
				for (Habitat habitat : listaHabitats) {
					System.out.println(i + ") " + habitat);
					i++;
					if (i == 7) {
						System.out.println(i + ") Volver al menu.");
					}
				}

				System.out.print("\nIngrese una zona: ");
				int opcionZona = sc.nextInt();
				if (opcionZona > listaHabitats.size()) {
					break;
				}
				Habitat habitatSeleccionado = listaHabitats.get(opcionZona - 1);

				ArrayList<Pokemon> listaTempo = new ArrayList<Pokemon>();
				for (Pokemon p : listaPokemones) {

					if (habitatSeleccionado.toString().equals(p.getHabitat())) {

						listaTempo.add(p);

					}

				}
				sc.nextLine();

				Random random = new Random();
				int indiceRandom = random.nextInt(listaTempo.size());
				Pokemon pokemonElegido = listaTempo.get(indiceRandom);
				System.out.println("\nOHH! ha aparecido un " + pokemonElegido.getNombre() + "!!");
				System.out.println("\nQue desea hacer?\n");
				System.out.println("1) Capturar.");
				System.out.println("2) Huir.\n");
				System.out.print("Ingrese Opcion: ");
				int op = sc.nextInt();
				switch (op) {
				case 1:
					System.out.println("\n" + pokemonElegido.getNombre() + " capturado con exito!!");
					listaPokemonsJugador.add(pokemonElegido);
					System.out.println("\n" + pokemonElegido.getNombre() + " ha sido agregado a tu equipo!!");
					break;
				case 2:

					System.out.println("\n huyendo.....");

					break;
				default:
					break;
				}

				break;
			case "3":

				break;
			case "4":

				break;
			case "5":

				break;
			case "6":

				break;
			case "7":

				break;
			default:

				break;
			}
		} while (!opcion.equals("8"));

	}
}
