package tp3_ejercicio06_appmusic;

	
	public class Cancion {
		private static final int SEMANA = 7;
		private static final int TOPE_RESTRICCION = 1000;
		private String nombre;
		private String autor;
		private String genero;
		private int diasPublicacion;
		private int cantidadReproducciones;

		/**
		 * Constructor parametrizado
		 * 
		 * @param nombre
		 * @param autor
		 * @param genero
		 */
		public Cancion(String nombre, String autor, String genero) {
			setNombre(nombre);
			setAutor(autor);
			setGenero(genero);
			diasPublicacion = 0;
			cantidadReproducciones = 0;
		}

		public void escuchar() {
			cantidadReproducciones++;
		}

		public boolean esRestringida() {
			return cantidadReproducciones <= TOPE_RESTRICCION && diasPublicacion <= SEMANA;
		}

		/**
		 * @return El autor de la Cancion.
		 */
		public String getAutor() {
			return autor;
		}

		/**
		 * @return El genero de la Cancion.
		 */
		public String getGenero() {
			return genero;
		}

		/**
		 * @return El nombre de la Cancion.
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * @param autor El autor de la Cancion.
		 */
		private void setAutor(String autor) {
			this.autor = autor;
		}
		
		/**s
		 * @param genero El tipo de la Cancion.
		 */
		public void setGenero(String genero) {
			this.genero = genero;
		}

		/**
		 * @param nombre El nombre de la Cancion.
		 */
		private void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public String toString() {
			return "Cancion [nombre=" + nombre + ", autor=" + autor + ", genero=" + genero + ", diasPublicacion="
					+ diasPublicacion + ", cantidadReproducciones=" + cantidadReproducciones + "]";
		}

	}
