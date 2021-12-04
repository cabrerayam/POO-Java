package BilleteraVirtual;

import java.util.ArrayList;

public class BilleteraVirtual {
	private ArrayList<Cliente> clientes;

	public BilleteraVirtual() {
		this.clientes = new ArrayList<>();
	}
	
	private Cliente buscarCliente(String dni) {
		Cliente cliente = null;
		int index = 0;
		int size = this.getClientes().size();
		while (cliente == null && index < size) {
			if (this.getClientes().get(index).getDni().equals(dni)) {
				cliente = this.getClientes().get(index);
			}
			else {
				index++;
			}
		}
		return cliente;
	}


	/*agregarCliente, que recibe los datos necesarios para crear un cliente y registrarlo en la aplicación. 
	 * Si el cliente ya existe, no lo agrega. El método devuelve un booleano de confirmación.
	 */
	
	public boolean agregarCliente(String dni) {
		boolean pudoAgregar = false;
		if (this.buscarCliente(dni) == null) {
			this.getClientes().add(new Cliente(dni));
			pudoAgregar = true;
		}
		
		return pudoAgregar;

	}

		/*registrarTarjeta, que recibe un dni y los datos de una  tarjeta. Debe cumplir las siguientes especificaciones: 
		El usuario estaba registrado en la aplicación
		El número de tarjeta no debe existir para ese usuario en su lista de tarjetas.
		Devuelve un booleano indicando si pudo registrar la tarjeta o no. */

	public boolean registrarTarjeta(String dni, String numero, NombreTarjeta nombre, double montoDisponible) {
		boolean pudoRegistrar = false;
		Cliente cliente = this.buscarCliente(dni);
		if (cliente != null) {
			pudoRegistrar = cliente.agregarTarjeta(numero, nombre, montoDisponible);
		}
		return pudoRegistrar;
	}

		/*mostrarTarjetasPuedenComprar, dado el dni de un cliente y un monto, 
	muestra la información de las tarjetas que pueden realizar dicha compra.*/
	
	public void mostrarTarjetasPuedenComprar(String dni, double monto) {
		Cliente cliente = this.buscarCliente(dni);
		if (cliente != null) {
			System.out.println("Lista de tarjetas ok de " + dni);
			cliente.mostrarTarjetasPuedenComprar(monto);
		}
	}

		/*mostrarTarjetasConSaldo Lista la información de todos los usuarios registrados en la app.
	De cada usuario además, se quiere visualizar todas las tarjetas que tengan saldo disponible */
	
	public void mostrarTarjetasConSaldo() {
		for (Cliente cliente: this.getClientes()) {
			System.out.println("Tarjetas de " + cliente.getDni());
			cliente.mostrarTarjetasConSaldo();
		}
	}

	/*obtenerCompras, retorna una lista que incluye: el dni de cada usuario, 
	 * junto con la cantidad de compras realizadas hasta el momento.
	 */
	
	public ArrayList<ClienteComprasRealizadas> obtenerCompras() {
		ArrayList<ClienteComprasRealizadas> clienteComprasRealizadas = new ArrayList<>();
		for (Cliente cliente: this.getClientes()) {
			clienteComprasRealizadas.add(new ClienteComprasRealizadas(cliente.getDni(), cliente.getCantidadComprasRealizadas()));
		}
		return clienteComprasRealizadas;
	}


	/*realizarCompra, según un dni, un monto y una cantidad de cuotas, realiza la compra actualizando el saldo de la tarjeta y 
	 * contando dicha compra. Debe utilizar la tarjeta que MÁS SALDO tenga, y que pueda abonar ese monto. 
	 * Retorna uno de los siguientes resultados:
		TRANSACCION_OK, si pudo realizar la acción
		SIN_TARJETA_PARA_COMPRA, cuando no exista alguna tarjeta con monto suficiente para realizar dicha compra. 
		USUARIO_INEXISTENTE, cuando el usuario indicado no exista en la aplicación
		ERROR, cuando el monto y/o la cantidad de cuotas especificadas sean erróneas
	 */
	
	public ResultadoRealizarCompra realizarCompra(String dni, double monto, int cantidadCuotas) {
		ResultadoRealizarCompra resultado = ResultadoRealizarCompra.TRANSACCION_OK;
		Cliente cliente = this.buscarCliente(dni);
		
		if (cliente == null) {
			resultado = ResultadoRealizarCompra.USUARIO_INEXISTENTE;
		}
		else if (monto<=0 || cantidadCuotas<=0) {
			resultado = ResultadoRealizarCompra.ERROR;
		}
		else {
			Tarjeta tarjetaMayorSaldo = cliente.getTarjetaMayorSaldo();
			
			if (tarjetaMayorSaldo == null || tarjetaMayorSaldo.getMontoDisponible()<monto) {
				resultado = ResultadoRealizarCompra.SIN_TARJETA_PARA_COMPRA;
			}
			else {
				if (!tarjetaMayorSaldo.comprar(monto)) {
					resultado = ResultadoRealizarCompra.ERROR;
				}
				else {
					cliente.registrarCompra();
				}
			}
			
		}
		
		return resultado;
	}


	/* comprar, recibe un dni, el monto y una cantidad de cuotas y muestra el resultado de la operación.
	 *  En caso de que la transacción sea realizada, además informa cuánto se deberá abonar por cada cuota.
	 */
	
	public void comprar(String dni, double monto, int cantidadCuotas) {
		ResultadoRealizarCompra resultado = this.realizarCompra(dni, monto, cantidadCuotas);
		if (resultado == ResultadoRealizarCompra.TRANSACCION_OK) {
			System.out.println("Compra realizada por " + dni); 
			System.out.println("Monto Compra: " + monto + " - coutas " + cantidadCuotas); 
			System.out.println("Monto por Cuota:" + monto/cantidadCuotas);
		}
	}
	
	

	private ArrayList<Cliente> getClientes() {
		return clientes;
	}
}
