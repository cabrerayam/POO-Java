package tp3_ejercicio06_appmusic;

public class Test {

	
	/*
	 * Nos solicitan una aplicación para escuchar música. La misma consiste de una lista de usuarios y otra de canciones.
	De los objetos de tipo Cancion conocemos su nombre (String), autor (String) y el tipo (Rock, Pop, Clásica, Trap o Cumbia). Para el último atributo definir idealmente un enumerador. 
	Vale aclarar que dentro de la lista de canciones no se puede repetir nombre y autor.  
	De cada Usuario sabemos el mail (String), su apellido (String) y su edad (int). Además, contamos con una lista de canciones que el usuario escuchó.

	Método privado buscarCancion(): recibe por parámetro un nombre y un autor. Retorna un objeto de tipo Cancion de encontrar la misma en el listado general de canciones. De lo contrario devuelve null. 
	Método privado buscarUsuario(): recibe por parámetro un mail. Retorna un objeto de tipo Usuario de encontrar al mismo en el listado de usuarios. De lo contrario devuelve null. 
	Método público altaCancion() : Recibe los datos necesarios para dar de alta una canción (si no existe) en la lista de canciones. Devuelve un booleano indicando si la operación fue exitosa o no. 
	Método público altaUsuario() : Recibe los datos necesarios para dar de alta un usuario (si no existe) en la lista de usuarios. Devuelve un booleano indicando si la operación fue exitosa o no. 
	Método público escucharMusica() : Recibe mail, nombre de canción y autor. Si existe usuario y canción devuelve un mensaje de operación exitosa y agrega la canción a la lista de canciones escuchadas por el usuario en cuestión. Si no existe usuario, retorna un mensaje de usuario inexistente. De no existir la canción, el retorno consta de un mensaje indicando una canción inexistente. (Utilizar preferentemente un enum para definir el tipo de retorno del método).
	Método público listarUsuarios(): Muestra un listado con los usuarios registrados en la aplicación, con la cantidad de canciones que escucharon. 
	Método público listarCancionesPorUsuario(): Recibe por parámetro el mail de un usuario, y de estar registrado en la aplicación, muestra un listado con las canciones que escuchó hasta el momento y devuelve un mensaje de operación exitosa. Caso contrario, retorna un mensaje de usuario inexistente. (Utilizar un enumerador para definir el tipo de retorno de este método).
 
	*/
	

		public static void main(String[] args) {

			Aplicacion aplicacion;
			aplicacion = new Aplicacion();

			aplicacion.listarUsuarios();

			System.out.println("*Alta de canciones*");
			System.out.println(aplicacion.altaCancion("Dani California", "Red Hot Chilli Pepers", "ROCK"));
			System.out.println(aplicacion.altaCancion("Goteo", "Duki", "TRAP"));
			System.out.println(aplicacion.altaCancion("Snow", "Red Hot Chilli Pepers", "ROCK"));

			System.out.println("*Canción repetida*");
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
