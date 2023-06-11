package airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectDBTest {
	String persons;
	String passengers;
	String flight_desc;
	String sched_flight;
	static String test;

	@BeforeEach
	public void setUp() {
		ProjectDB.initialize();
	}
	
	// Casos de Teste (Adição de Pessoas no Banco de Dados)
	// Caso 1 (INVALIDO): Pessoa já existe
	@Test
	 public void adicionandoPessoaJaExistenteNoBD () throws IOException {
		
		Person p = new Person("Elhuseny Gamal Nour", "Manzalah");
		
		// Ler mensagem do console em caso de dado já existente
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		ProjectDB.add(p);
		assertEquals("Can't save this data!\r\n"
				+ "Elhuseny Gamal Nour : Already saved!\r\n"
				+ "", out.toString());
	}
	
	// Caso 2 (VALIDO): Pessoa não existe
	@Test
	 public void adicionandoPessoaNaoExistenteNoBD () throws IOException {
		Person p = new Person("Mirna", "Parnamirim");
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
		
		ProjectDB.add(p);
		assertEquals("", out.toString());
	}
	
	// Casos de Teste (Adição de Passageiros no Banco de Dados)
	// Caso 3 (INVALIDO): Passageiro já existe
	@Test
	 public void adicionandoPassageiroJaExistenteNoBD () throws IOException {
		
		Person p = new Person("Elhuseny Gamal Nour", "Manzalah");
		Passenger pa = new Passenger(p, 2);
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		ProjectDB.add(pa);  
		assertEquals("Can't save this data!\r\n"
				+ "Elhuseny Gamal Nour : Already reserved this flight!\r\n"
				+ "", out.toString());
	}
	
	// Caso 4 (VALIDO): Passageiro não existe
	@Test
	 public void adicionandoPassageiroNaoExistenteNoBD () throws IOException {
		Person p = new Person("Greg", "Unkown");
		Passenger pa = new Passenger(p, 2);
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));
		
		ProjectDB.add(pa);
		assertEquals("", out.toString());
	}
	
	// Casos de Teste (Adição de Descricao do Voo no Banco de Dados)
	// Caso 5 (INVALIDO): Descricao já existe
	@Test
	 public void adicionandoDescricaoJaExistenteNoBD () throws IOException {
		
		FlightDescription fd = new FlightDescription("Alex","Mekkah","22:15","23:56",22);
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		ProjectDB.add(fd);
		assertEquals("Can't save this data!\r\n"
				+ "This Flight discription Already exists!\r\n"
				+ "", out.toString());
	}
	
	// Caso 6 (VALIDO): Descricao não existe
	@Test
	 public void adicionandoDescricaoNaoExistenteNoBD () throws IOException {
		FlightDescription fd = new FlightDescription("Natal","Minas Gerais","22:15","23:56",22);
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		
		ProjectDB.add(fd);
		assertEquals("", out.toString());
	}
	
	// Casos de Teste (Adição de Voo no Banco de Dados)
	// Caso 7 (INVALIDO): Voo já existe
	@Test
	 public void adicionandoVooJaExistenteNoBD () throws IOException {
		
		FlightDescription fd = new FlightDescription("Germany","Luxor","03:25","23:50",12);
		ScheduledFlight sf = new ScheduledFlight(fd,"2021/12/18");
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    
	
		
		ProjectDB.add(sf);
		assertEquals("Can't save this data!\r\n"
				+ "This Flight Already scheduled!\r\n"
				+ "", out.toString());
	}
	
	// Caso 8 (VALIDO): Voo não existe
	@Test
	 public void adicionandoVooNaoExistenteNoBD () throws IOException {
		
		FlightDescription fd = new FlightDescription("Sao Paulo","Natal","03:25","23:50",12);
		ScheduledFlight sf = new ScheduledFlight(fd,"2021/12/18");
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    
		
		ProjectDB.add(sf);
		assertEquals("", out.toString());
	}
	
	//Remove os dados criados pelos testes
	@AfterAll
	public static void tearDown () throws IOException {
		
		apagarUltimaLinha("person_file.txt");
		apagarUltimaLinha("passenger_file.txt");
		apagarUltimaLinha("flight_description_file.txt");
		apagarUltimaLinha("scheduled_flight_file.txt");
	}
	
	private static void apagarUltimaLinha (String arquivo) throws IOException {
		RandomAccessFile f = new RandomAccessFile(arquivo, "rw");
		long length = f.length() - 1;
		byte b;
		do {                     
		  length -= 1;
		  f.seek(length);
		  b = f.readByte();
		} while(b != 10);
		f.setLength(length+1);
		f.close();
	}
}
