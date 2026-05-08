package asd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static List<Habitat> habitats = new LinkedList<Habitat>();
	public static List<Gimnasio> gimnasios = new LinkedList<Gimnasio>();
	public static List<Pokemon> pokemones = new LinkedList<Pokemon>();
	public static List<Persona> altosMandos = new LinkedList<Persona>();

	public static int gimnasiosDerrotados = 0;

	public static void main(String[] args) throws IOException {
		// Maximiliano Edhin Abd-El-Kader Gongora 22.128.215-9 - ICCI
		// Matías Ignacio González Gómez 22.350.340-3 - ICCI
		leerHabitats();
		leerPokemons();
		leerGimnasios();
		leerAltoMando();
		menuPrincipal();

	}
	/*
	 * Lee el archivo AltoMando.txt y crea una Persona por cada miembro,
	 * asignandole sus pokemones correspondientes.
	 */
	private static void leerAltoMando() throws FileNotFoundException {
		File arch = new File("AltoMando.txt");
		Scanner lector = new Scanner(arch);

		while (lector.hasNext()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[1];
			Persona p = new Persona(nombre);
			for (int i = 2; i < partes.length; i++) {
				Pokemon pok = buscarPokemon(partes[i]);
				if (pok != null) {
					p.agregarPokemon(pok);
				}

			}
			altosMandos.add(p);
		}

	}
	/**
	 * Lee el archivo Gimnasios.txt y crea un Gimnasio por cada linea,
	 * asignandole su lider y sus pokemones correspondientes.
	 */
	private static void leerGimnasios() throws FileNotFoundException {
		File arch = new File("Gimnasios.txt");
		Scanner lector = new Scanner(arch);
		while (lector.hasNext()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			int numeroGim = Integer.valueOf(partes[0]);
			String nombreGim = partes[1];
			String estado = partes[2];
			int cantPokemones = Integer.valueOf(partes[3]);
			Persona p = new Persona(nombreGim);
			for (int i = 4; i < cantPokemones + 4; i++) {
				String nombre = partes[i];
				Pokemon pok = buscarPokemon(nombre);
				if (pok != null) {
					p.agregarPokemon(pok);
				}
			}
			Gimnasio g = new Gimnasio(numeroGim, p, estado);
			gimnasios.add(g);

		}

	}
	/**
	 * Busca un Pokemon en la lista global de pokemones por su nombre.
	 * @param nombre El nombre del Pokemon a buscar.
	 * @return El Pokemon encontrado, o null si no existe.
	 */
	private static Pokemon buscarPokemon(String nombre) {
		for (Pokemon p : pokemones) {
			if (p.getNombre().equals(nombre)) {
				return p;
			}

		}
		return null;
	}
	/**
	 * Muestra el menu principal del juego con las opciones de
	 * continuar, nueva partida o salir.
	 */
	private static void menuPrincipal() throws IOException {
		int opcion = -1;
		while (opcion != 3) {
			try {
				System.out.println("1) Continuar.");
				System.out.println("2) Nueva Partida.");
				System.out.println("3) Salir");
				System.out.print("Ingrese opcion: ");
				opcion = Integer.valueOf(sc.nextLine());
			} catch (Exception InputMismatchException) {
				System.out.println("Ingrese una opcion valida");
			}

			switch (opcion) {
			case 1:
				continuarPartida();
				break;
			case 2:
				crearPartidas();
				break;
			case 3:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Ingrese opcion correcta");
			}
		}

	}
	/**
	 * Carga la partida guardada en Registros.txt, restaurando el estado
	 * del jugador, sus pokemones y los gimnasios derrotados.
	 */
	private static void continuarPartida() throws IOException {

		System.out.println();
		File arch = new File("Registros.txt");
		if (arch.length() == 0) {
			System.out.println("No hay partida guardada...");
		} else { // Creando usuario
			gimnasiosDerrotados = 0;
			Scanner lector = new Scanner(arch);
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			String nombre = partes[0];
			Persona p = new Persona(nombre);
			if (!partes[1].equals("none")) {
				for (int i = 1; i < partes.length; i++) {
					String nombreGim = partes[i];
					cambiarEstadoGimnasio(nombreGim);
					gimnasiosDerrotados += 1;
				}

			}
			while (lector.hasNext()) { // Guardando pokemones
				linea = lector.nextLine();
				if (!linea.equals("")) {
					String[] partes2 = linea.split(";");
					String nombrePokemon = partes2[0];
					String estado = partes2[1];
					Pokemon pok = buscarPokemon(nombrePokemon);
					if (pok != null) {
						if (estado.equals("Debilitado")) {
							pok.setVivo(false);
						}
						p.agregarPokemon(pok);
					}

				}

			}
			System.out.println("Bienvenido " + p.getNombre() + "!!!");
			System.out.println();
			int opcion = -1;
			while (opcion != 8) {
				try {
					System.out.println(p.getNombre() + " , que deseas hacer?");
					System.out.println();
					System.out.println("1) Revisar equipo.");
					System.out.println("2) Salir a capturar.");
					System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
					System.out.println("4) Retar un gimnasio.");
					System.out.println("5) Desafío al Alto Mando.");
					System.out.println("6) Curar Pokémon.");
					System.out.println("7) Guardar.");
					System.out.println("8) Guardar y Salir.");
					System.out.print("Ingrese opcion: ");
					opcion = Integer.valueOf(sc.nextLine());

				} catch (Exception e) {
					System.out.println("Ingrese una opcion valida");
					System.out.println();
				}
				switch (opcion) {
				case 1:
					verEquipo(p);
					break;
				case 2:
					capturarPokemons(p);
					break;
				case 3:
					accesoPC(p);
					break;
				case 4:
					retarGimnasio(p);
					break;
				case 5:
					altoMando(p);
					break;
				case 6:
					curarPokemon(p);
					break;
				case 7:
					guardarPartida(p);
					break;
				case 8:
					guardarPartida(p);
					System.out.println("Hasta luego entrenador!!");
					System.out.println();
					break;

				}
			

			}

		}
		System.out.println();

	}
	/**
	 * Marca un gimnasio como Derrotado buscandolo por el nombre de su lider.
	 * @param nombreGim El nombre del lider del gimnasio a marcar.
	 */
	private static void cambiarEstadoGimnasio(String nombreGim) {
		Gimnasio gym = null;
		for (Gimnasio g : gimnasios) {
			if (g.getLider().getNombre().equals(nombreGim)) {
				gym = g;
				gym.setDerrotado("Derrotado");
				break;
			}

		}

	}
	/**
	 * Crea una nueva partida solicitando un apodo al jugador,
	 * limpiando el estado de los gimnasios previos.
	 */
	private static void crearPartidas() throws IOException {
		limpiarGimnasios();
		System.out.println();
		System.out.print("Ingrese apodo: ");
		String apodo = sc.nextLine();
		Persona p = new Persona(apodo);
		System.out.println();
		System.out.println("Bienvenido " + p.getNombre() + "!!!");
		System.out.println();
		int opcion = -1;
		while (opcion != 8) {
			try {
				System.out.println(p.getNombre() + " , que deseas hacer?");
				System.out.println();
				System.out.println("1) Revisar equipo.");
				System.out.println("2) Salir a capturar.");
				System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
				System.out.println("4) Retar un gimnasio.");
				System.out.println("5) Desafío al Alto Mando.");
				System.out.println("6) Curar Pokémon.");
				System.out.println("7) Guardar.");
				System.out.println("8) Guardar y Salir.");
				System.out.print("Ingrese opcion: ");
				opcion = Integer.valueOf(sc.nextLine());

			} catch (Exception e) {
				System.out.println("Ingrese una opcion valida");
				System.out.println();
			}
			switch (opcion) {
			case 1:
				verEquipo(p);
				break;
			case 2:
				capturarPokemons(p);
				break;
			case 3:
				accesoPC(p);
				break;
			case 4:
				retarGimnasio(p);
				break;
			case 5:
				altoMando(p);
				break;
			case 6:
				curarPokemon(p);
				break;
			case 7:
				guardarPartida(p);
				break;
			case 8:
				guardarPartida(p);
				System.out.println("Hasta luego entrenador!!");
				System.out.println();
				break;

			}

		}

	}
	/**
	 * Resetea todos los gimnasios a estado Sin derrotar y reinicia
	 * el contador de gimnasios derrotados.
	 */
	private static void limpiarGimnasios() {
		for (Gimnasio g : gimnasios) {
			String estado = g.getDerrotado();
			if (estado.equals("Derrotado")) {
				g.setDerrotado("Sin derrotar");
			}
		}
		gimnasiosDerrotados = 0;

	}
	/**
	 * Guarda el estado actual de la partida en Registros.txt,
	 * incluyendo el nombre del jugador, gimnasios derrotados y pokemones con su estado.
	 * @param p La persona (jugador) cuya partida se guarda.
	 */
	private static void guardarPartida(Persona p) throws IOException {
		System.out.println();
		BufferedWriter bw = new BufferedWriter(new FileWriter("Registros.txt"));
		String linea = p.getNombre();
		if (gimnasiosDerrotados == 0) {
			bw.write(linea + ";" + "none");
			bw.newLine();
		} else {
			for (Gimnasio g : gimnasios) {
				if (g.getDerrotado().equals("Derrotado")) {
					linea += ";" + g.getLider().getNombre();
				}
			}
			bw.write(linea);
			bw.newLine();
		}

		for (Pokemon pok : p.getPokemons()) {
			String lineaP = null;
			if (pok.isVivo()) {
				lineaP = pok.getNombre() + ";" + "Vivo";
				bw.write(lineaP);
			} else {
				lineaP = pok.getNombre() + ";" + "Debilitado";
				bw.write(lineaP);
			}
			bw.newLine();

		}
		bw.close();
		System.out.println("Partida guardada con exito!!!");
		System.out.println();

	}
	/**
	 * Permite al jugador desafiar al Alto Mando de forma consecutiva,
	 * requiriendo haber derrotado los 8 gimnasios previamente.
	 * @param p La persona (jugador) que desafia al Alto Mando.
	 */
	private static void altoMando(Persona p) {
		System.out.println();
		if (gimnasiosDerrotados < gimnasios.size()) {
			System.out.println("No puedes batallar contra los Altos Mandos!!!, no has derrotado a todos los gimnasios");
		} else {
			boolean ganador = true;
			for (Persona campeon : altosMandos) {
				System.out.println("Enfrentandose a " + campeon.getNombre());
				System.out.println();
				boolean vencido = peleaPokemones(campeon, p);
				if (vencido) {
					System.out.println("Has derrotado a " + campeon.getNombre());
				} else {
					System.out.println("Has perdido...");
					ganador = false;
					break;
				}
			}
			if(ganador) {
				System.out.println("Felicidades, eres todo un campeon");
			}	
		}
		System.out.println();

	}
	/**
	 * Permite al jugador acceder al PC para intercambiar pokemones de posicion en su lista.
	 * @param p La persona (jugador) que accede al PC.
	 */
	private static void accesoPC(Persona p) {
		int opcion = -1;

		System.out.println();
		boolean vacio = p.mostrarPC();
		System.out.println();
		if (vacio) {
			try {

				System.out.println("Que deseas hacer?");
				System.out.println("1) Cambiar Pokemon");
				System.out.println("2) Salir");
				System.out.print("Ingrese una opcion: ");
				opcion = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Ingrese una opcion valida");
			}
			if (opcion == 1) {
				System.out.println("OBSERVA LA LISTA ANTERIOR DE POKEMONES");
				System.out.print("Numero del pokemon que deseas cambiar: ");
				int opPokemon = Integer.valueOf(sc.nextLine());
				System.out.print("Numero del pokemon que quieres agregar: ");
				int opPokemonB = Integer.valueOf(sc.nextLine());
				p.cambiarPokemon(opPokemon, opPokemonB);

				

			}
			else if(opcion == 2) {
				System.out.println("Saliendo...");
			}
			else {
				System.out.println("Opcion invalida");
			}
			System.out.println();
		}

	}
	/**
	 * Cura todos los pokemones debilitados del jugador, pasando su estado a Vivo.
	 * @param p La persona (jugador) cuyos pokemones se curan.
	 */
	private static void curarPokemon(Persona p) {
		System.out.println();
		int muertos = 0;
		for (Pokemon pok : p.getPokemons()) {
			if (!pok.isVivo()) {
				pok.setVivo(true);
				muertos++;

				System.out.println(pok.getNombre() + " ha sido curado!!");

			}
		}
		if (muertos == 0) {
			System.out.println("No tienes pokemons muertos!!");
		}
		System.out.println();

	}
	/**
	 * Muestra los gimnasios disponibles y permite al jugador retar a uno,
	 * respetando el orden consecutivo de desafios.
	 * @param p La persona (jugador) que reta el gimnasio.
	 */
	private static void retarGimnasio(Persona p) {
		int opcion = -1;
		try {
			System.out.println();
			System.out.println("A cual lider deseas retar?");
			System.out.println();
			int c = 1;
			for (Gimnasio g : gimnasios) {
				System.out.println(c + ") " + g.getLider().getNombre() + " - Estado: " + g.getDerrotado());
				c++;
			}
			System.out.println("9) Volver al Menu");
			System.out.println("Ingrese opcion: ");
			opcion = Integer.valueOf(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Ingrese una opcion valida");
		}
		if (opcion >= 1 && opcion <= 8) {
			Gimnasio gim = gimnasios.get(opcion - 1);
			if (opcion - 1 > gimnasiosDerrotados) {
				System.out.println("Calmado entrenador!!! No puedes retar a " + gim.getLider().getNombre()
						+ " sin haber derrotado a los lideres anteriores!!!");

			} else {
				if (p.getPokemons().size() == 0) {
					System.out.println("Captura pokemones antes de batallar en un gimnasio!!!");
				} else if (gim.getDerrotado().equals("Derrotado")) {
					System.out.println("Este gimnasio ya lo has derrotado!");
				} else {
					System.out.println();
					System.out.println("Desafiando a " + gim.getLider().getNombre() + "!!");
					System.out.println();

					boolean gane = peleaPokemones(gim.getLider(), p);
					if (gane) {
						System.out.println("Gimnasio derrotado!!");
						gimnasiosDerrotados += 1;
						gim.setDerrotado("Derrotado");
					} else {
						System.out.println("Volviendo al menu...");
						System.out.println();
					}
				}

			}
		} else if (opcion == 9) {
			System.out.println();
			System.out.println("Volviendo al menu...");
		}
		else {
			System.out.println();
			System.out.println("Opcion invalida");
		}

		System.out.println();
	}
	/**
	 * Simula un combate entre el lider y el jugador. El jugador puede atacar,
	 * cambiar de pokemon o rendirse. Aplica la tabla de tipos para calcular
	 * el multiplicador de stats.
	 * @param lider La persona que actua como rival (lider de gimnasio o Alto Mando).
	 * @param p La persona (jugador).
	 * @return true si el jugador gana, false si pierde o se rinde.
	 */
	private static boolean peleaPokemones(Persona lider, Persona p) {

		int disponiblesA = lider.getPokemons().size();
		int disponiblesB = p.getPokemons().size();
		boolean seguimos = true;

		int a = 0;
		int b = 0;
		while (seguimos) {
			Pokemon pokemonA = lider.getPokemons().get(a); // gimnasio
			Pokemon pokemonB = p.getPokemons().get(b); // usuario
			int opcion = -1;
			int statsA = pokemonA.getStatsTotales();
			int statsB = pokemonB.getStatsTotales();
			try {
				System.out.println();
				System.out.println(lider.getNombre() + " ha sacado a " + pokemonA.getNombre() + "!");
				System.out.println(p.getNombre() + " ha sacado a " + pokemonB.getNombre() + "!");
				System.out.println();
				System.out.println("Que deseas hacer?");
				System.out.println("1) Atacar");
				System.out.println("2) Cambiar de pokemon");
				System.out.println("3) Rendirse");
				System.out.print("Ingrese una opcion: ");
				opcion = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Ingrese una opcion valida");
			}
			switch (opcion) {
			case 1:
				System.out.println();
				System.out.println(pokemonB.getNombre() + " -> " + statsB);
				System.out.println(pokemonA.getNombre() + " -> " + statsA);

				double multiplicador = TablaTipos.getEfectividad(pokemonB.getTipo(), pokemonA.getTipo());
				if (multiplicador > 1.0) {
					statsB = statsB * 2;
					System.out.println();
					System.out.println(pokemonB.getNombre() + " si es efectivo contra " + pokemonA.getNombre() + "!");
					System.out.println("Nuevo puntaje:");
					System.out.println(pokemonB.getNombre() + " -> " + statsB);
					System.out.println(pokemonA.getNombre() + " -> " + statsA);
				} else if (multiplicador < 1.0) {
					statsB = statsB / 2;
					System.out.println();
					System.out.println(pokemonB.getNombre() + " no es efectivo contra " + pokemonA.getNombre() + "!");
					System.out.println("Nuevo puntaje:");
					System.out.println(pokemonB.getNombre() + " -> " + statsB);
					System.out.println(pokemonA.getNombre() + " -> " + statsA);
				}
				if (statsB > statsA) {
					System.out.println();
					System.out.println("Ha ganado " + pokemonB.getNombre() + "! " + pokemonA.getNombre()
							+ " ha sido derrotado...");
					disponiblesA -= 1;
					a++;

				} else if (statsA > statsB) {
					System.out.println();
					System.out.println("Ha ganado " + pokemonA.getNombre() + "! " + pokemonB.getNombre()
							+ " ha sido derrotado...");
					pokemonB.setVivo(false);
					disponiblesB -= 1;
					for (int i = 0; i < p.getPokemons().size(); i++) {
						if (p.getPokemons().get(i).isVivo()) {
							b = i;
							break;
						}
					}

				} else {
					System.out.println("Empate");
				}
				System.out.println();
				if (disponiblesA == 0) {
					seguimos = false;
					return true;
				}
				if (disponiblesB == 0) {
					System.out.println("Te has quedado sin pokemones en tu equipo...");
					seguimos = false;
				}

				break;
			case 2:
				int c = 0; // contador para mostrar el equipo
				int v = 0; // contador de los vivos
				System.out.println();
				if (p.getPokemons().size() == 1) {
					System.out.println("No puedes cambiar. Solo tienes 1 pokemon en tu equpo !");
				} else {
					int opPokemon = -1;
					try {
						System.out.println("Que pokemon deseas usar?:");
						System.out.println();
						for (int i = 0; i < p.getPokemons().size(); i++) {
							if (p.getPokemons().get(i).isVivo() && v < 6) {
								System.out.println("Pokemon N." + (i + 1) + ") " + p.getPokemons().get(i).getNombre());
								c++;

							}
							v++;
						}
						System.out.print("Ingrese una opcion: ");
						opPokemon = Integer.valueOf(sc.nextLine());
					} catch (Exception e) {
						System.out.println("Ingrese una opcion valida");
					}
					b = opPokemon - 1;

				}
				System.out.println();
				break;
			case 3:
				System.out.println("Huyendo...");
				seguimos = false;
				break;
			}

		}

		return false;

	}
	/**
	 * Permite al jugador explorar una zona y capturar un Pokemon aleatorio.
	 * Verifica que el Pokemon no haya sido capturado previamente.
	 * @param p La persona (jugador) que sale a capturar.
	 */
	private static void capturarPokemons(Persona p) {
		int opcion = -1;
		try {
			System.out.println();
			System.out.println("Donde deseas ir a explorar?");
			System.out.println();
			System.out.println("Zonas disponibles:");
			System.out.println();
			for (int i = 0; i < habitats.size(); i++) {
				System.out.println(i + 1 + ") " + habitats.get(i).getNombre());
			}
			System.out.println("7) Volver al menu.");
			System.out.println();
			System.out.print("Ingrese zona: ");
			opcion = Integer.valueOf(sc.nextLine());

		} catch (Exception e) {
			System.out.println("Ingrese una opcion valida");
		}
		System.out.println();
		if (opcion == 7) {
			System.out.println("Volviendo al menú...");
		}
		else if(opcion >= 1 && opcion < 7) {
			Habitat habitatElegido = habitats.get(opcion - 1);
			Random random = new Random();
			int indiceRandom = random.nextInt(habitatElegido.getPokemones().size());
			Pokemon pokemonRandom = habitatElegido.getPokemones().get(indiceRandom);
			System.out.println("Oh!! Ha aparecido un increible " + pokemonRandom.getNombre());
			System.out.println();
			System.out.println("Que deseas hacer?");
			System.out.println();
			System.out.println("1) Capturar");
			System.out.println("2) Huir");
			System.out.print("Ingrese opcion: ");
			int opcionPokemon = Integer.valueOf(sc.nextLine());
			switch (opcionPokemon) {
			case 1:
				boolean encontrado = p.buscarPokemon(pokemonRandom);
				if (!encontrado) {
					p.agregarPokemon(pokemonRandom);
					System.out.println();
					System.out.println(pokemonRandom.getNombre() + " capturado con exito!!");
					System.out.println(pokemonRandom.getNombre() + " ha sido agregado a tu equipo.");
					System.out.println();
				} else {
					System.out.println("Este pokemon ya lo has capturado!!");
				}
				break;
			case 2:
				System.out.println("Huyendo...");
				break;
			default:
				System.out.println("Opcion invalida");	
			}
			
			System.out.println();
		}
		else {
			System.out.println("Ingrese una opcion correcta");
		}

	}
	/**
	 * Muestra el equipo actual del jugador con nombre, tipo y stats de cada Pokemon.
	 * @param p La persona (jugador) cuyo equipo se muestra.
	 */
	private static void verEquipo(Persona p) {
		List<Pokemon> equipo = p.getPokemons();
		if (equipo.isEmpty()) {
			System.out.println("No tienes pokemons en tu equipo");
		} else {

			p.mostrarEquipo();

		}

	}
	/**
	 * Lee el archivo Pokedex.txt y crea un Pokemon por cada linea,
	 * asignandolo a su habitat correspondiente segun su porcentaje de aparicion.
	 */
	private static void leerPokemons() throws FileNotFoundException {
		File arch = new File("Pokedex.txt");
		Scanner lector = new Scanner(arch);
		while (lector.hasNext()) {
			Pokemon p = null;
			String linea = lector.nextLine();
			String[] partes = linea.split(";");
			String pokemon = partes[0];
			String habitat = partes[1];

			Habitat h = buscarHabitat(habitat);

			double porcAparicion = Double.valueOf(partes[2]);
			int aparicion = (int) (porcAparicion * 100);
			int vida = Integer.valueOf(partes[3]);
			int ataque = Integer.valueOf(partes[4]);
			int defensa = Integer.valueOf(partes[5]);
			int ataqueEspecial = Integer.valueOf(partes[6]);
			int defensaEspecial = Integer.valueOf(partes[7]);
			int velocidad = Integer.valueOf(partes[8]);
			String tipo = partes[9];

			if (h != null) {
				p = new Pokemon(pokemon, h, aparicion, vida, ataque, defensa, ataqueEspecial, defensaEspecial,
						velocidad, tipo);

				h.agregarPokemon(aparicion, p);
			} else {
				p = new Pokemon(pokemon, h, aparicion, vida, ataque, defensa, ataqueEspecial, defensaEspecial,
						velocidad, tipo);

			}
			p.sumarEstadisticas();
			pokemones.add(p);

		}

	}
	/**
	 * Busca un Habitat en la lista global de habitats por su nombre.
	 * @param habitat El nombre del habitat a buscar.
	 * @return El Habitat encontrado, o null si no existe.
	 */
	private static Habitat buscarHabitat(String habitat) {
		for (Habitat h : habitats) {
			if (h.getNombre().equals(habitat)) {
				return h;
			}
		}
		return null;

	}
	/**
	 * Lee el archivo Habitats.txt y crea un Habitat por cada linea.
	 */
	private static void leerHabitats() throws FileNotFoundException {
		File arch = new File("Habitats.txt");
		Scanner lector = new Scanner(arch);

		while (lector.hasNext()) {
			String linea = lector.nextLine();
			String habitat = linea;
			Habitat h = new Habitat(habitat);
			habitats.add(h);
		}

	}

}
