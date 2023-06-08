package airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProjectDBTest2 {
	
	static java.io.ByteArrayOutputStream out;
	
	/* Para que o teste funcione é preciso renomear os arquivos .tx seguintes:
	 * 
	 * person_file.txt
	 * passenger_file.txt
	 * flight_description_file.txt
	 * schedule_flight_file.txt
	 * */
	@BeforeAll
	public static void setUp() {
		out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
	}

	@Test
	public void arquivoPersonFileInexistente () throws IOException {
		
		ProjectDB.initialize();
		boolean arquivoPessoaNaoExiste = out.toString().indexOf("Person File Not Found !") !=-1? true: false;
		assertTrue(arquivoPessoaNaoExiste);
		
	}
	
	@Test
	public void arquivoPassengerFileInexistente () throws IOException {
		
		ProjectDB.initialize();
		boolean arquivoPessoaNaoExiste = out.toString().indexOf("Passenger File Not Found !") !=-1? true: false;
		assertTrue(arquivoPessoaNaoExiste);
		
	}
	
	@Test
	public void arquivoFlightDescriptionFileInexistente () throws IOException {
		
		ProjectDB.initialize();
		boolean arquivoPessoaNaoExiste = out.toString().indexOf("Flight Decsription File Not Found !") !=-1? true: false;
		assertTrue(arquivoPessoaNaoExiste);
		
	}
	
	@Test
	public void arquivoScheduleFlightInexistente () throws IOException {
		
		ProjectDB.initialize();
		boolean arquivoPessoaNaoExiste = out.toString().indexOf("Scheduled flights File Not Found !") !=-1? true: false;
		assertTrue(arquivoPessoaNaoExiste);
		
	}
}
