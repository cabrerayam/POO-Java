package tp3_ejercicio06_appmusic;

public class Test {

	
	/*
	 * Nos solicitan una aplicaci�n para escuchar m�sica. La misma consiste de una lista de usuarios y otra de canciones.
	De los objetos de tipo Cancion conocemos su nombre (String), autor (String) y el tipo (Rock, Pop, Cl�sica, Trap o Cumbia). Para el �ltimo atributo definir idealmente un enumerador. 
	Vale aclarar que dentro de la lista de canciones no se puede repetir nombre y autor.  
	De cada Usuario sabemos el mail (String), su apellido (String) y su edad (int). Adem�s, contamos con una lista de canciones que el usuario escuch�.

	M�todo privado buscarCancion(): recibe por par�metro un nombre y un autor. Retorna un objeto de tipo Cancion de encontrar la misma en el listado general de canciones. De lo contrario devuelve null. 
	M�todo privado buscarUsuario(): recibe por par�metro un mail. Retorna un objeto de tipo Usuario de encontrar al mismo en el listado de usuarios. De lo contrario devuelve null. 
	M�todo p�blico altaCancion() : Recibe los datos necesarios para dar de alta una canci�n (si no existe) en la lista de canciones. Devuelve un booleano indicando si la operaci�n fue exitosa o no. 
	M�todo p�blico altaUsuario() : Recibe los datos necesarios para dar de alta un usuario (si no existe) en la lista de usuarios. Devuelve un booleano indicando si la operaci�n fue exitosa o no. 
	M�todo p�blico escucharMusica() : Recibe mail, nombre de canci�n y autor. Si existe usuario y canci�n devuelve un mensaje de operaci�n exitosa y agrega la canci�n a la lista de canciones escuchadas por el usuario en cuesti�n. Si no existe usuario, retorna un mensaje de usuario inexistente. De no existir la canci�n, el retorno consta de un mensaje indicando una canci�n inexistente. (Utilizar preferentemente un enum para definir el tipo de retorno del m�todo).
	M�todo p�blico listarUsuarios(): Muestra un listado con los usuarios registrados en la aplicaci�n, con la cantidad de canciones que escucharon. 
	M�todo p�blico listarCancionesPorUsuario(): Recibe por par�metro el mail de un usuario, y de estar registrado en la aplicaci�n, muestra un listado con las canciones que escuch� hasta el momento y devuelve un mensaje de operaci�n exitosa. Caso contrario, retorna un mensaje de usuario inexistente. (Utilizar un enumerador para definir el tipo de retorno de este m�todo).
 
	*/
	

		public static void main(String[] args) {

			Aplicacion aplicacion;
			aplicacion = new Aplicacion();

			aplicacion.listarUsuarios();

			System.out.println("*Alta de canciones*");
			System.out.println(aplicacion.altaCancion("Dani California", "Red Hot Chilli Pepers", "ROCK"));
			System.out.println(aplicacion.altaCancion("Goteo", "Duki", "TRAP"));
			System.out.println(aplicacion.altaCancion("Snow", "Red Hot Chilli Pepers", "ROCK"));

			System.out.println("*Canci�n repetida*");
			System.out.println(aplicacion.altaCancion("Dani California", "Red Hot Chilli Pepers", "TRAP"));

			System.out.println("*Alta de usuarios*");
			System.out.println(aplicacion.altaUsuario("elusuario@gmail.com", "Elu", 20, Categoria.ESTANDAR));
			System.out.println(aplicacion.altaUsuario("markzucker@outlook.com", "Zucker", 35, Categoria.PREMIUM));
			System.out.println(aplicacion.altaUsuario("mediavilla@live.com.ar", "Mediavilla", 50, Categoria.GRATUITO));

			System.out.println("*Usuario repetido*");
			System.out.println(aplicacion.altaUsuario("markzucker@outlook.com", "Zucker", 35, Categoria.ESTANDAR));

			aplicacion.listarUsuarios();

			System.out.println("*Mediavilla escucha Snow y Dani California*");
			System.out.println(aplicacion.escucharCancion("mediavilla@live.com.ar", "Snow", "Red Hot Chilli Pepers"));
			System.out.println(
					aplicacion.escucharCancion("mediavilla@live.com.ar", "Dani California", "Red Hot Chilli Pepers"));

			System.out.println("*Zucker escucha Seminare*");
			System.out.println(aplicacion.escucharCancion("markzucker@outlook.com", "Seminare", "Charly"));

			System.out.println("*Anonymous escucha Goteo*");
			System.out.println(aplicacion.escucharCancion("anonymous@anonymous.com", "Goteo", "Duki"));

			System.out.println("*Lista de canciones escuchadas por Mediavilla*");
			System.out.println(aplicacion.listarCancionesPorUsuario("mediavilla@live.com.ar"));

			System.out.println("*Lista de canciones escuchadas por Anonymous*");
			System.out.println(aplicacion.listarCancionesPorUsuario("anonymous@anonymous.com"));

		}
	
	
	
}
