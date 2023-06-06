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
	
	
	
}
