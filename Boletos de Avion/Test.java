package parcial;

public class Test {

	public static void main(String[] args) {
		
		Vuelo vuelo = new Vuelo("AA3313", 180);
		
		// reservas buenas para todas las clases
		System.out.println(vuelo.reservarAsiento(11111111, "1234567890", ClaseEnum.PRIMERA));
		System.out.println(vuelo.reservarAsiento(22222222, "1234567891", ClaseEnum.PRIMERA));
		System.out.println(vuelo.reservarAsiento(33333333, "1234567893", ClaseEnum.TURISTA));
		System.out.println(vuelo.reservarAsiento(44444444, "1234567894", ClaseEnum.TURISTA));
		System.out.println(vuelo.reservarAsiento(55555555, "1234567895", ClaseEnum.BUSINESS));
		
		//reserva con dni duplicado
		System.out.println(vuelo.reservarAsiento(11111111, "1234567892", ClaseEnum.PRIMERA));
	
		// mostrar monto recaudado por clase
		vuelo.mostrarMontoRecaudadoDeClase(ClaseEnum.PRIMERA);
		vuelo.mostrarMontoRecaudadoDeClase(ClaseEnum.BUSINESS);
		vuelo.mostrarMontoRecaudadoDeClase(ClaseEnum.TURISTA);
		
		vuelo.listarAsientosReservados();
		
		// anular reserva existente
		vuelo.anularReserva(55555555);
		
		// anular reserva inexistente
		vuelo.anularReserva(99999999);
		
		vuelo.mostrarMontoRecaudadoDeClase(ClaseEnum.BUSINESS);
		vuelo.listarAsientosReservados();
	}

}
