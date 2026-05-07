package taller2;

public class TablaTipos {

	public TablaTipos() {
		// TODO Auto-generated constructor stub
	}

	public static double getEfectividad(String tipoAtacante, String tipoDefensor) {
		switch (tipoAtacante) {
		case "Fuego":
			if (tipoDefensor.equals("Planta") || tipoDefensor.equals("Hielo") || tipoDefensor.equals("Bicho")) return 2.0;
			if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Agua") || tipoDefensor.equals("Roca") || tipoDefensor.equals("Dragon")) return 0.5;
			break;
		case "Agua":
			if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Roca") || tipoDefensor.equals("Tierra")) return 2.0;
			if (tipoDefensor.equals("Agua") || tipoDefensor.equals("Planta") || tipoDefensor.equals("Dragon")) return 0.5;
			break;
		case "Planta":
			if (tipoDefensor.equals("Agua") || tipoDefensor.equals("Roca") || tipoDefensor.equals("Tierra")) return 2.0;
			if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Planta") || tipoDefensor.equals("Veneno") || tipoDefensor.equals("Dragon") || tipoDefensor.equals("Bicho") || tipoDefensor.equals("Volador")) return 0.5;
			break;
		case "Electrico":
			if (tipoDefensor.equals("Agua") || tipoDefensor.equals("Volador")) return 2.0;
			if (tipoDefensor.equals("Electrico") || tipoDefensor.equals("Dragon") || tipoDefensor.equals("Planta")) return 0.5;
			break;
		case "Hielo":
			if (tipoDefensor.equals("Planta") || tipoDefensor.equals("Tierra") || tipoDefensor.equals("Volador") || tipoDefensor.equals("Dragon")) return 2.0;
			if (tipoDefensor.equals("Agua") || tipoDefensor.equals("Hielo")) return 0.5;
			break;
		case "Lucha":
			if (tipoDefensor.equals("Normal") || tipoDefensor.equals("Hielo") || tipoDefensor.equals("Roca")) return 2.0;
			if (tipoDefensor.equals("Veneno") || tipoDefensor.equals("Bicho") || tipoDefensor.equals("Volador") || tipoDefensor.equals("Psiquico")) return 0.5;
			break;
		case "Veneno":
			if (tipoDefensor.equals("Planta") || tipoDefensor.equals("Bicho")) return 2.0;
			if (tipoDefensor.equals("Veneno") || tipoDefensor.equals("Tierra") || tipoDefensor.equals("Roca") || tipoDefensor.equals("Fantasma")) return 0.5;
			break;
		case "Tierra":
			if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Electrico") || tipoDefensor.equals("Veneno") || tipoDefensor.equals("Roca")) return 2.0;
			if (tipoDefensor.equals("Planta") || tipoDefensor.equals("Bicho")) return 0.5;
			break;
		case "Volador":
			if (tipoDefensor.equals("Planta") || tipoDefensor.equals("Lucha") || tipoDefensor.equals("Bicho")) return 2.0;
			if (tipoDefensor.equals("Electrico") || tipoDefensor.equals("Roca")) return 0.5;
			break;
		case "Psiquico":
			if (tipoDefensor.equals("Lucha") || tipoDefensor.equals("Veneno")) return 2.0;
			if (tipoDefensor.equals("Psiquico")) return 0.5;
			break;
		case "Bicho":
			if (tipoDefensor.equals("Planta") || tipoDefensor.equals("Veneno") || tipoDefensor.equals("Psiquico")) return 2.0;
			if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Lucha") || tipoDefensor.equals("Volador")) return 0.5;
			break;
		case "Roca":
			if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Hielo") || tipoDefensor.equals("Volador") || tipoDefensor.equals("Bicho")) return 2.0;
			if (tipoDefensor.equals("Lucha") || tipoDefensor.equals("Tierra")) return 0.5;
			break;
		case "Fantasma":
			if (tipoDefensor.equals("Psiquico") || tipoDefensor.equals("Fantasma")) return 2.0;
			if (tipoDefensor.equals("Normal")) return 0.5;
			break;
		case "Dragon":
			if (tipoDefensor.equals("Dragon")) return 2.0;
			break;
		}
		return 1.0;
	}
}
