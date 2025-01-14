package airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlightDescriptionTest {

	@Test
	public void checkTimeBadFormatCorrect() {
		boolean resp = FlightDescription.check_time("23:59");
		assertEquals(true, resp); 
	}
	
	/* Caso de teste:
	*  Minuto 60 (23:60)
	*/
	@Test
	public void checkTimeBadFormatLimiteSuperiorMinuto() {
		boolean resp = FlightDescription.check_time("23:60");
		assertEquals(false, resp); 
	}
	
	@Test
	public void checkTimeBadFormatLimiteInferiorMinuto() {
		boolean resp = FlightDescription.check_time("00:-1");
		assertEquals(false, resp); 
	}
	
	@Test
	public void checkTimeBadFormatLimiteInferiorHora() {
		boolean resp = FlightDescription.check_time("-1:00");
		assertEquals(false, resp); 
	}
	
	@Test
	public void checkTimeBadFormatLimiteSuperiorHora() {
		boolean resp = FlightDescription.check_time("24:00");
		assertEquals(false, resp); 
	}
		
	
	@Test
	public void checkTimeBadFormatMinutoInseridoErrado() {
		boolean resp = FlightDescription.check_time("01:0");
		assertEquals(false, resp); 
	}
	
	@Test
	public void checkTimeBadFormatHoraErrada() {
		boolean resp = FlightDescription.check_time("70:00");
		assertEquals(false, resp); 
	}
	
	/* Caso de teste: 
	*  Inserindo 3 caracteres, sendo o limite inferior da quantidade 
	*  de caracteres valida: 4 e 5 
	*/
	@Test
	public void checkTimeBadFormatoInseridoErrado() {
		boolean resp = FlightDescription.check_time("1:0");
		assertEquals(false, resp); 
	}
	
	
	/* Caso de teste: 
	*  Inserindo 6 caracteres, sendo o limite superior da quantidade 
	*  de caracteres valido que é 4 e 5 
	*/
	@Test
	public void checkTimeBadFormatoInseridoErradoCaracteres() {
		boolean resp = FlightDescription.check_time("01:001");
		assertEquals(false, resp); 
	}
	
	/* Caso de teste: 
	*  Não foi inserido os minutos apos os " : "
	*/
	@Test
	public void checkTimeBadFormatMinutoNaoInserido() {
		boolean resp = FlightDescription.check_time("001:");
		assertEquals(false, resp); 
	}
}
