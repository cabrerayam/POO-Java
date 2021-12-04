package tp3_ejercicio06_appmusic;

import java.util.ArrayList;

public class Aplicacion {
	private static final int TOPE_CANCIONES_GRATUITAS = 50;
	private ArrayList<Cancion> canciones;
	private ArrayList<Usuario> usuarios;

	/**
	 * Constructor vacío que inicializa los ArrayList
	 */
	public Aplicacion() {
		canciones = new ArrayList<>();
		usuarios = new ArrayList<>();
	}

	/**
	 * Recibe por parámetro un nombre y un autor. Retorna un objeto de tipo
	 * Cancion de encontrar la misma en el listado general de canciones. De lo
	 * contrario devuelve null.
	 * 
	 * @param nombre
	 *            El nombre de la canción a buscar
	 * @param autor
	 *            El nombre del autor de la canción a buscar
	 * @return Cancion o null
	 */
	private Cancion buscarCancion(String nombre, String autor) {
		Cancion cancionABuscar = null;
		int i = 0;

		while (cancionABuscar == null && i < canciones.size()) {

			if (canciones.get(i).getNombre() == nombre && canciones.get(i).getAutor() == autor) {
				cancionABuscar = canciones.get(i);
			} else {
				i++;
			}
		}
		return cancionABuscar;
	}

	/**
	 * Recibe por parámetro un mail. Retorna un objeto de tipo Usuario de
	 * encontrar al mismo en el listado de usuarios. De lo contrario devuelve
	 * null.
	 * 
	 * @param mail
	 * @return Usuario o null
	 */
	private Usuario buscarUsuario(String mail) {
		Usuario usuarioABuscar = null;
		int i = 0;

		while (usuarioABuscar == null && i < usuarios.size()) {

			if (usuarios.get(i).getMail() == mail) {
				usuarioABuscar = usuarios.get(i);
			} else {
				i++;
			}
		}
		return usuarioABuscar;
	}

	/**
	 * Recibe los datos necesarios para dar de alta una canción (si no existe)
	 * en la lista de canciones. Devuelve un booleano indicando si la operación
	 * fue exitosa o no.
	 * 
	 * @param nombre
	 * @param autor
	 * @param tipo
	 * @return Confirmación de la acción
	 */
	public boolean altaCancion(String nombre, String autor, String tipo) {
		boolean pudeAgregar = false;

		if (buscarCancion(nombre, autor) == null) {
			pudeAgregar = canciones.add(new Cancion(nombre, autor, tipo));
		}
		return pudeAgregar;
	}

	/**
	 * Recibe los datos necesarios para dar de alta un usuario (si no existe) en
	 * la lista de usuarios. Devuelve un booleano indicando si la operación fue
	 * exitosa o no.
	 * 
	 * @param email
	 * @param apellido
	 * @param edad
	 * @return
	 */
	public boolean altaUsuario(String email, String apellido, int edad, Categoria categoria) {
		boolean pudeAgregar = false;

		if (buscarUsuario(email) == null) {
			pudeAgregar = usuarios.add(new Usuario(email, apellido, edad, categoria));
		}
		return pudeAgregar;
	}

	/**
	 * Recibe mail, nombre de canción y autor. Si existen usuario y canción y se
	 * cumplen las reglas para que el usuario pueda escuchar la canción,
	 * devuelve un mensaje de operación exitosa y agrega la canción a la lista
	 * de canciones escuchadas por el usuario en cuestión. Si no existe usuario,
	 * retorna un mensaje de usuario inexistente. De no existir la canción, el
	 * retorno consta de un mensaje indicando una canción inexistente. (Utilizar
	 * preferentemente un enum para definir el tipo de retorno del método).
	 * 
	 * @param email
	 * @param nombre
	 * @param autor
	 * @return Resultado de la acción
	 */
	public Resultado escucharCancion(String email, String nombre, String autor) {
		Resultado resultado = Resultado.USUARIO_INEXISTENTE;
		Usuario usuario = buscarUsuario(email);
		if (usuario != null) {
			Cancion cancion = buscarCancion(nombre, autor);
			if (cancion == null) {
				resultado = Resultado.CANCION_INEXISTENTE;
			} else {
				if (usuario.getCategoria() == Categoria.PREMIUM) {
					resultado = Resultado.OPERACION_EXITOSA;
					usuario.escucharCancion(cancion);
				} else {
					if (cancion.esRestringida()) {
						resultado = Resultado.CANCION_NO_DISPONIBLE;
					} else {
						if (usuario.getCategoria().equals(Categoria.GRATUITO)
								&& usuario.getCantidadEscuchasDiarias() > TOPE_CANCIONES_GRATUITAS) {
							resultado = Resultado.LIMITE_ALCANZADO;
						} else {
							resultado = Resultado.OPERACION_EXITOSA;
							usuario.escucharCancion(cancion);
						}
					}
				}
			}
		}
		return resultado;
	}

	/**
	 * Recibe por parámetro el mail de un usuario, y de estar registrado en la
	 * aplicación, muestra un listado con las canciones que escuchó hasta el
	 * momento y devuelve un mensaje de operación exitosa. Caso contrario,
	 * retorna un mensaje de usuario inexistente. (Utilizar un enumerador para
	 * definir el tipo de retorno de este método).
	 * 
	 * @param mail
	 * @return Resultado de la acción
	 */
	public Resultado listarCancionesPorUsuario(String mail) {
		Resultado resultado = Resultado.USUARIO_INEXISTENTE;

		Usuario usuario = buscarUsuario(mail);

		if (usuario != null) {

			ArrayList<Cancion> cancionesUsuario = usuario.listarCanciones();
			if (cancionesUsuario.size() > 0) {
				for (Cancion cancion : cancionesUsuario) {
					System.out.println(cancion);
				}
			} else {
				System.out.println("EL USUARIO NO ESCUCHÓ AÚN NINGUNA CANCIÓN!");
			}
			resultado = Resultado.OPERACION_EXITOSA;
		}
		return resultado;
	}

	/**
	 * Muestra un listado con los usuarios registrados en la aplicación, con la
	 * cantidad de canciones que escucharon.
	 */
	public void listarUsuarios() {
		if (usuarios.size() > 0) {
			System.out.println("LISTADO DE USUARIOS:");
			for (Usuario usuario : usuarios) {
				System.out.println(usuario);
			}
		} else {
			System.out.println("NO HAY USUARIOS REGISTRADOS!");
		}
	}

}
