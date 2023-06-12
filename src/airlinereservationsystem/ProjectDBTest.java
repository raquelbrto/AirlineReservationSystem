package airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* OBSERVACAO:
 * Alguns testes estão comentados em razão de 
 * conflitos encontrados ao executar o Pitest 
 * na suite de testes. Os testes JUnit executam 
 * normalmente, mas ao executar o Pitest, 
 * apresentavam falha.
 * */

public class ProjectDBTest {

	@BeforeEach
	public void setUp() {
		ProjectDB.initialize();
	}
	
	// Casos de Teste (Adicao de Pessoas no Banco de Dados)
	// Caso 1 (INVALIDO): Pessoa ja existe
	@Test
	 public void adicionandoPessoaJaExistenteNoBD () throws IOException {
		
		Person p = new Person("Elhuseny Gamal Nour", "Manzalah");
		
		// Ler mensagem do console em caso de dado ja existente
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		ProjectDB.add(p);
		boolean pessoaJaExiste = (out.toString().indexOf("Can't save this data!") !=-1? true: false) && (out.toString().indexOf("Already saved!") !=-1? true: false);
//		Can't save this data!
		assertTrue(pessoaJaExiste);
	}
	
	// Caso 2 (VALIDO): Pessoa nao existe
//	@Test
//	 public void adicionandoPessoaNaoExistenteNoBD () throws IOException {
//		Person p = new Person("Mirna", "Parnamirim");
//		
//		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
//		System.setOut(new java.io.PrintStream(out));
//		
//		ProjectDB.add(p);
//		assertEquals("", out.toString());
//		apagarUltimaLinha("person_file.txt");
//	}
	
	// Casos de Teste (Adicao de Passageiros no Banco de Dados)
	// Caso 3 (INVALIDO): Passageiro ja existe
	@Test
	 public void adicionandoPassageiroJaExistenteNoBD () throws IOException {
		
		Person p = new Person("Elhuseny Gamal Nour", "Manzalah");
		Passenger pa = new Passenger(p, 2);
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		ProjectDB.add(pa);  
		boolean passageiroJaExiste = (out.toString().indexOf("Can't save this data!") !=-1? true: false) && (out.toString().indexOf("Already reserved this flight!") !=-1? true: false);
		assertTrue(passageiroJaExiste);
	}
	
	// Caso 4 (VALIDO): Passageiro nao existe
//	@Test
//	 public void adicionandoPassageiroNaoExistenteNoBD () throws IOException {
//		Person p = new Person("Greg", "Unkown");
//		Passenger pa = new Passenger(p, 2);
//		
//		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
//		System.setOut(new java.io.PrintStream(out));
//		
//		ProjectDB.add(pa);
//		assertEquals("", out.toString());
//		apagarUltimaLinha("passenger_file.txt");
//	}
	
	// Casos de Teste (Adicao de Descricao do Voo no Banco de Dados)
	// Caso 5 (INVALIDO): Descricao ja existe
	@Test
	 public void adicionandoDescricaoJaExistenteNoBD () throws IOException {
		
		FlightDescription fd = new FlightDescription("Alex","Mekkah","22:15","23:56",22);
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    

		ProjectDB.add(fd);
		boolean descricaoVooJaExiste = (out.toString().indexOf("Can't save this data!") !=-1? true: false) && (out.toString().indexOf("This Flight discription Already exists!") !=-1? true: false);
		assertTrue(descricaoVooJaExiste);
	}
	
	// Caso 6 (VALIDO): Descricao nao existe
//	@Test
//	 public void adicionandoDescricaoNaoExistenteNoBD () throws IOException {
//		FlightDescription fd = new FlightDescription("Natal","Minas Gerais","22:15","23:56",22);
//		
//		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
//		System.setOut(new java.io.PrintStream(out));    
//
//		
//		ProjectDB.add(fd);
//		assertEquals("", out.toString());
//		apagarUltimaLinha("flight_description_file.txt");
//	}
	
	// Casos de Teste (Adicao de Voo no Banco de Dados)
	// Caso 7 (INVALIDO): Voo ja existe
	@Test
	 public void adicionandoVooJaExistenteNoBD () throws IOException {
		
		FlightDescription fd = new FlightDescription("Germany","Luxor","03:25","23:50",12);
		ScheduledFlight sf = new ScheduledFlight(fd,"2021/12/18");
		
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
		System.setOut(new java.io.PrintStream(out));    
	
		
		ProjectDB.add(sf);
		boolean vooJaExiste = (out.toString().indexOf("Can't save this data!") !=-1? true: false) && (out.toString().indexOf("This Flight Already scheduled!") !=-1? true: false);
		assertTrue(vooJaExiste);
	}
	
	// Caso 8 (VALIDO): Voo nao existe
//	@Test
//	 public void adicionandoVooNaoExistenteNoBD () throws IOException {
//		
//		FlightDescription fd = new FlightDescription("Sao Paulo","Natal","03:25","23:50",12);
//		ScheduledFlight sf = new ScheduledFlight(fd,"2021/12/18");
//		
//		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();    
//		System.setOut(new java.io.PrintStream(out));    
//		
//		ProjectDB.add(sf);
//		assertEquals("", out.toString());
//		apagarUltimaLinha("scheduled_flight_file.txt");
//	}
	
	//Remove os dados criados pelos testes
//	@AfterAll
//	public static void tearDown () throws IOException {
//		
//		apagarUltimaLinha("person_file.txt");
//		apagarUltimaLinha("passenger_file.txt");
//		apagarUltimaLinha("flight_description_file.txt");
//		apagarUltimaLinha("scheduled_flight_file.txt");
//	}
//	
//	private static void apagarUltimaLinha (String arquivo) throws IOException {
//		RandomAccessFile f = new RandomAccessFile(arquivo, "rw");
//		long length = f.length() - 1;
//		byte b;
//		do {                     
//		  length -= 1;
//		  f.seek(length);
//		  b = f.readByte();
//		} while(b != 10);
//		f.setLength(length+1);
//		f.close();
//	}
}