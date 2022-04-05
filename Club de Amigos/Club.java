package examen.amigosclub;

import java.util.ArrayList;

public class Club {
	private static final int EDADIMPOSIBLE = 200;
	private String nombre;
	private ArrayList<Persona> socios;

	public Club(String nombre) {
		this.setNombre(nombre);
		this.socios = new ArrayList<Persona>();
	}

	public Resultado agregarSocio(String nombre, int edad) {
		Resultado resultado = Resultado.ERROR;
		if (nombre != null && !nombre.isEmpty() && edad > 0  && edad < EDADIMPOSIBLE) {
			if (buscarSocio(nombre) == null) {
				socios.add(new Persona(nombre, edad));
				resultado = Resultado.OK;
			} else {
				resultado = Resultado.YA_EXISTE;
			}
		}
		return resultado;
	}

	private Persona buscarSocio(String nombre) {
		int i = 0;
		Persona socioEncontrado = null;
		while (i < this.socios.size() && socioEncontrado == null) {
			Persona socio = this.socios.get(i);
			if (socio.getNombre().equals(nombre)) {
				socioEncontrado = socio;
			}
			i++;
		}
		return socioEncontrado;
	}

	public Resultado deshacerAmistad(String nombre1, String nombre2) {
		Resultado resultado;
		if (nombre1.equals(nombre2)) {
			resultado = Resultado.NOMBRES_IGUALES;
		} else {
			Persona socio1 = buscarSocio(nombre1);
			if (socio1 == null) {
				resultado = Resultado.NO_EXISTE;
			} else {
				Persona socio2 = buscarSocio(nombre2);
				if (socio2 == null) {
					resultado = Resultado.NO_EXISTE;
				} else {
					if (socio1.quitarAmigo(socio2)) {
						socio2.quitarAmigo(socio1);
						resultado = Resultado.OK;
					} else {
						resultado = Resultado.NO_SON_AMIGOS;
					}
				}
			}
		}
		return resultado;
	}

	public Resultado establecerAmistad(String nombre1, String nombre2) {
		Resultado resultado;
		if (nombre1.equals(nombre2)) {
			resultado = Resultado.NOMBRES_IGUALES;
		} else {
			Persona socio1 = buscarSocio(nombre1);
			if (socio1 == null) {
				resultado = Resultado.NO_EXISTE;
			} else {
				Persona socio2 = buscarSocio(nombre2);
				if (socio2 == null) {
					resultado = Resultado.NO_EXISTE;
				} else {
					if (socio1.agregarAmigo(socio2)) {
						socio2.agregarAmigo(socio1);
						resultado = Resultado.OK;
					} else {
						resultado = Resultado.YA_SON_AMIGOS;
					}
				}
			}
		}
		return resultado;
	}

	public String getNombre() {
		return nombre;
	}

	public void listarSociosConPromedioEdadAmigos() {
		if (socios.size() > 0) {
			System.out.println("Socios con edad promedio de sus amigos:");
			for (Persona socio : this.socios) {
				double promedio = socio.promedioEdadAmigos();
				if (promedio > 0) {
					System.out.println(socio.getNombre() + " - " + promedio);
				} else {
					System.out.println(socio.getNombre() + " - no tiene amigos");
				}
			}
		} else {
			System.out.println("No hay socios");
		}
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			nombre = "Club";
		}
		this.nombre = nombre;
	}

	public ArrayList<NombreYEdad> obtenerAmigosDe(String nombrePersona) {
		ArrayList<NombreYEdad> amigosDe = null;
		Persona socio = buscarSocio(nombrePersona);
		if (socio != null) {
			amigosDe = socio.obtenerAmigos();
		}
		return amigosDe;
	}
}