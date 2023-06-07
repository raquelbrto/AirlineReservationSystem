package airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassengerTest { 
	
	@BeforeEach
	public void setUp() {
		ProjectDB.initialize();
	}
	
	//	Casos de Teste (Numero de passageiros no voo)
	
	//	Caso 1 (INVALIDO): Se passado numero negativo => retorna 0
	@Test
	 public void contagemPassageirosEntradaNegativa () {
		assertEquals(0, Passenger.getSCFlightPassengersCount(-1));
	}
	
	//	Caso 2 (INVALIDO): Se passado numero de voo inexistente => retorna 0
	@Test
	 public void contagemPassageirosVooInexistente () {
		assertEquals(0, Passenger.getSCFlightPassengersCount(10));
	}
	
	//	Caso 3 (VALIDO): Se passado numero voo existente => retorna a quantidade de passageiros no voo
	@Test
	 public void contagemPassageirosVooExistente () {
		assertEquals(4, Passenger.getSCFlightPassengersCount(6));
	}
	
	
	//	Casos de Teste (Mostrar Lista de Passageiros)
	//	Caso 4: Ha pasageiros na lista
	@Test
	 public void listagemPassageiros () {
		// Ler mensagem do console
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		Passenger.show_all();
		boolean comReserva = out.toString().indexOf("No Reservations added yet") !=-1? false: true;
		assertTrue(comReserva);
	}
	
	//	Casos de Teste (Mostrar lista de reservas para determinado voo)
	//	Caso 5: Listar reservas de voo existente
	@Test
	 public void listagemReservas () {
		// Ler mensagem do console
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		Passenger.show_only_flight_no(2);
		boolean comReserva = out.toString().indexOf("No Reservations added yet") !=-1? false: true;
		assertTrue(comReserva);
	}
	
	//	Caso 6: Listar reservas de voo inexistente
	@Test
	 public void listagemReservasVooInexistente () {
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		Passenger.show_only_flight_no(10);
		boolean semReserva = out.toString().indexOf("No Reservations added yet") !=-1? true: false;
		assertTrue(semReserva);
	}
}
