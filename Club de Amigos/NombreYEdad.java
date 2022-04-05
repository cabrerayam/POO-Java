package examen.amigosclub;

public class NombreYEdad {

	private String nombre;
	private int edad;

	public NombreYEdad(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Amigo [nombre=" + nombre + ", edad=" + edad + "]";
	}

}
