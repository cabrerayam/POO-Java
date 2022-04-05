package examen.amigosclub;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {

		Club club = new Club("Sportivo Vecinal");

		System.out.println();
		agregarSocio(club, "Juan", 23);
		agregarSocio(club, "Laura", 18);
		agregarSocio(club, "Maria", 26);
		agregarSocio(club, "Joaquin", 20);
		agregarSocio(club, "Belen", 20);
		agregarSocio(club, "Daniel", 21);
		agregarSocio(club, "Valeria", 20);
		agregarSocio(club, "Ana", 19);
		agregarSocio(club, "Javier", 22);
		agregarSocio(club, "Javier", 22);

		System.out.println();
		establecerAmistad(club, "Juan", "Ana");
		establecerAmistad(club, "Laura", "Ana");
		establecerAmistad(club, "Laura", "Juan");
		establecerAmistad(club, "Maria", "Ana");
		establecerAmistad(club, "Belen", "Joaquin");
		establecerAmistad(club, "Belen", "Daniel");
		establecerAmistad(club, "Valeria", "Ana");
		establecerAmistad(club, "Ana", "Daniel");
		establecerAmistad(club, "Javier", "Juan");
		establecerAmistad(club, "Javier", "Ana");
		establecerAmistad(club, "Ana", "Javier");
		establecerAmistad(club, "Ana", "Ana");
		establecerAmistad(club, "Laura", "Marcelo");
		establecerAmistad(club, "Toribio", "Ana");

		System.out.println();
		deshacerAmistad(club, "Ana", "Javier");
		deshacerAmistad(club, "Ana", "Valeria");
		deshacerAmistad(club, "Ana", "Ana");
		deshacerAmistad(club, "Laura", "Marcelo");
		deshacerAmistad(club, "Toribio", "Ana");

		System.out.println();
		club.listarSociosConPromedioEdadAmigos();
		
		mostrarAmigosDe(club, "Laura");
		mostrarAmigosDe(club, "Walter");
	}

	public static void agregarSocio(Club club, String nombre, int edad) {
		String metodo = "agregarSocio (" + nombre + ", " + edad + "): ";
		mostrarResultado(metodo, club.agregarSocio(nombre, edad));
	}

	public static void deshacerAmistad(Club club, String nombre1, String nombre2) {
		String metodo = "deshacerAmistad (" + nombre1 + "/" + nombre2 + "): ";
		mostrarResultado(metodo, club.deshacerAmistad(nombre1, nombre2));
	}

	public static void establecerAmistad(Club club, String nombre1, String nombre2) {
		String metodo = "establecerAmistad (" + nombre1 + "/" + nombre2 + "): ";
		mostrarResultado(metodo, club.establecerAmistad(nombre1, nombre2));
	}

	private static void mostrarAmigosDe(Club club, String nombrePersona) {
		System.out.println("\nAmigos de " + nombrePersona);
		ArrayList<NombreYEdad> amigosDe = club.obtenerAmigosDe(nombrePersona);
		if (amigosDe != null) {
			for (NombreYEdad amigo : amigosDe) {
				System.out.println(amigo);
			}
		} else {
			System.out.println("No hay nadie que se llame " + nombrePersona);
		}
	}

	public static void mostrarResultado(String metodo, Resultado res) {
		System.out.println(metodo + res);
	}

}
