package airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScheduledFlightTest {

	@Test
	public void  check_date_formatDataValida() {
		boolean resp = ScheduledFlight.check_date_format("2023/01/01");
		assertEquals(true, resp);
	}
	
	@Test
	public void  check_date_formatDataInvalida() {
		boolean resp = ScheduledFlight.check_date_format("2023/13/32");
		assertEquals(false, resp);
	}
	
	@Test
	public void  check_date_formatDataInvalidaMes() {
		boolean resp = ScheduledFlight.check_date_format("2023/13/13");
		assertEquals(false, resp);
	}
	@Test
	public void  check_date_formatDataInvalidaMesLimite() {
		boolean resp = ScheduledFlight.check_date_format("2023/0/13");
		assertEquals(false, resp);
	}
	
	@Test
	public void  check_date_formatDataInvalidaDia() {
		boolean resp = ScheduledFlight.check_date_format("2023/12/32");
		assertEquals(false, resp);
	}
	
	@Test
	public void  check_date_formatDataInvalidaDiaLimite() {
		boolean resp = ScheduledFlight.check_date_format("2023/12/-1");
		assertEquals(false, resp);
	}
	
	@Test
	public void  check_date_formatacaoErradaAno() {
		boolean resp = ScheduledFlight.check_date_format("203/12/09");
		assertEquals(false, resp);
	}
	
	@Test
	public void  check_date_formatacaoErrada() {
		boolean resp = ScheduledFlight.check_date_format("2023/12");
		assertEquals(false, resp);
	}
	
	@Test
	public void  check_date_formatacaoErradaCaracteres() {
		boolean resp = ScheduledFlight.check_date_format("2023/02/0000");
		assertEquals(false, resp);
	}

	@Test
	public void  check_date_formatacaoErradaCaracteresAMenos() {
		boolean resp = ScheduledFlight.check_date_format("223/2/9");
		assertEquals(false, resp);
	}
	
	@Test
	public void  check_date_formatacaoErradaCaracteresErrados() {
		boolean resp = ScheduledFlight.check_date_format("34");
		assertEquals(false, resp);
	}
}

