package lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioBonusTest {

	private CenarioBonus cenarioBonus;
	
	@Before
	public void criaCenarioBonus() {
		cenarioBonus = new CenarioBonus(1, "Terminar todos os testes", 1000);
	}
	
	@Test
	public void testCriaCenarioBonus() {
		try {	
			Cenario cenarioInvalido = new CenarioBonus(1, "Entregar o lab 5", 0);
			Cenario cenarioInvalido2 = new CenarioBonus(2, "Entregar o lab 5 antes do carnaval", -5);

		} catch (IllegalArgumentException e){
			assertEquals("Erro no cadastro de cenario: Bonus invalido", e.getMessage());
		}
	}
	
	@Test
	public void testGetTotalRateio() {
		String msg = "Espera-se obter o valor total de rateio do cenario bonus.";
		
		this.cenarioBonus.registraAposta("Misael", 1000, "VAI ACONTECER");
		this.cenarioBonus.registraAposta("Misael 2", 2000, "N VAI ACONTECER");
		this.cenarioBonus.finalizaCenario(true);
		
		assertTrue(msg, this.cenarioBonus.getTotalRateio(0.1) == 2800);
	}
	
	@Test
	public void testToString() {
		String msg = "Espera-se obter uma representação textual do cenario bonificado com numeracao, descricao, estado e bonus respectivamente.";
		
		assertEquals(msg, "1 - Terminar todos os testes - Nao finalizado - R$ 10,00", this.cenarioBonus.toString());
	}

}
