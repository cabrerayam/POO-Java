package examen.amigosclub;

import java.util.ArrayList;

public class Persona {
	private String nombre;
	private int edad;
	private ArrayList<Persona> amigos;

	public Persona(String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
		this.amigos = new ArrayList<Persona>();
	}

	public boolean agregarAmigo(Persona nuevoAmigo) {
		boolean encontrado = buscarAmigo(nuevoAmigo);
		if (!encontrado) {
			this.amigos.add(nuevoAmigo);
		}
		return !encontrado;
	}

	private boolean buscarAmigo(Persona nuevoAmigo) {
		int i = 0;
		boolean encontrado = false;
		while (i < this.amigos.size() && !encontrado) {
			if (this.amigos.get(i) == nuevoAmigo) {
				encontrado = true;
			} else {
				i++;
			}
		}
		return encontrado;
	}

	// Tema 1
	public double promedioEdadAmigos() {
		double promedio = -1;
		if (this.amigos.size() > 0) {
			int sumaEdades = 0;
			for (Persona amigo : this.amigos) {
				sumaEdades += amigo.getEdad();
			}
			promedio = (double) sumaEdades / this.amigos.size();
		}
		return promedio;
	}

	// Tema 2
	public Persona amigoMasJoven() {
		Persona amigoMenor = null;
		int edadMenor = Integer.MAX_VALUE;
		for (Persona amigo : this.amigos) {
			if (amigo.getEdad() < edadMenor) {
				edadMenor = amigo.getEdad();
				amigoMenor = amigo;
			}
		}
		return amigoMenor;
	}

	// Tema 3
	public int cantidadMismaEdad(int tolerancia) {
		int cantidad = 0;
		for (Persona amigo : this.amigos) {
			if (amigo.getEdad() >= this.edad - tolerancia && amigo.getEdad() <= this.edad + tolerancia) {
				cantidad++;
			}
		}
		return cantidad;
	}

	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<NombreYEdad> obtenerAmigos() {
		ArrayList<NombreYEdad> misAmigos = new ArrayList<>();
		for (Persona amigo : amigos) {
			misAmigos.add(new NombreYEdad(amigo.getNombre(), amigo.getEdad()));
		}
		return misAmigos;
	}

	public boolean quitarAmigo(Persona amigo) {
		return this.amigos.remove(amigo);
	}

	private void setEdad(int edad) {
		if (edad < 0) {
			edad = 0;
		}
		this.edad = edad;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
}
