package tp3_ejercicio06_appmusic;

import java.util.ArrayList;

public class Usuario {
		private String mail;
		private String apellido;
		private int edad;
		private Categoria categoria;
		private ArrayList<Cancion> canciones;

		/**
		 * Constructor parametrizado
		 * 
		 * @param mail
		 * @param apellido
		 * @param edad
		 */
		public Usuario(String mail, String apellido, int edad, Categoria categoria) {
			setMail(mail);
			setApellido(apellido);
			setEdad(edad);
			this.setCategoria(categoria);
			canciones = new ArrayList<>();
		}

		/**
		 * Agrega la canción a la lista de canciones escuchadas por el usuario
		 * 
		 * @param cancion
		 * @return Confirmación de la acción
		 */
		public boolean escucharCancion(Cancion cancion) {
			// El usuario maneja su propia lista de canciones y las marca como
			// escuchadas!
			cancion.escuchar();
			return canciones.add(cancion);
		}

		/**
		 * @return El apellido del usuario.
		 */
		public String getApellido() {
			return apellido;
		}

		/**
		 * @return La cantidad de canciones escuchadas por el usuario
		 */
		public int getCantidadEscuchasDiarias() {
			return canciones.size();
		}

		/**
		 * @return La Categoria del usuario.
		 */
		public Categoria getCategoria() {
			return categoria;
		}

		/**
		 * @return La edad del usuario.
		 */
		public int getEdad() {
			return edad;
		}

		/**
		 * @return El mail del usuario.
		 */
		public String getMail() {
			return mail;
		}

		/**
		 * @return El listado de canciones escuchadas por dicho usuario
		 */
		public ArrayList<Cancion> listarCanciones() {
			return canciones;
		}

		/**
		 * @param apellido
		 *            El apellido del usuario.
		 */
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		/**
		 * @param categoria
		 *            La categoria del usuario.
		 */
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		/**
		 * @param edad
		 *            La edad del usuario
		 */
		public void setEdad(int edad) {
			this.edad = edad;
		}

		/**
		 * @param mail
		 *            El mail del usuario
		 */
		public void setMail(String mail) {
			this.mail = mail;
		}

		@Override
		public String toString() {
			return "Usuario [mail=" + mail + ", apellido=" + apellido + ", edad=" + edad
					+ ", cantidad de canciones escuchadas: " + canciones.size() + "]";
		}

}
