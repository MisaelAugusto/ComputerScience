package lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApostaAsseguradaTest {

	private ApostaAssegurada apostaAsseguradaValor;
	private ApostaAssegurada apostaAsseguradaTaxa;
	
	@Before
	public void criaApostaAssegurada() {
		apostaAsseguradaValor = new ApostaAssegurada("Misael", 10000, "VAI ACONTECER", 1000);
		apostaAsseguradaTaxa = new ApostaAssegurada("Misael 2", 5000, "N VAI ACONTECER", 0.1);
	}
	
	@Test
	public void testTurnSeguroValor() {
		String msg = "Após a troca espera-se obter uma aposta assegurada sendo o seguro do tipo por valor.";
		
		apostaAsseguradaTaxa.turnSeguroValor(450);
		
		assertTrue(msg, (apostaAsseguradaTaxa.getSeguro() instanceof SeguroValor) ? true : false);
	}
	
	@Test
	public void testTurnSeguroTaxa() {
		String msg = "Após a troca espera-se obter uma aposta assegurada sendo o seguro do tipo por taxa.";
		
		apostaAsseguradaValor.turnSeguroTaxa(0.5);
		
		assertTrue(msg, (apostaAsseguradaTaxa.getSeguro() instanceof SeguroTaxa) ? true : false);
	}
	
	@Test
	public void testGetValorAssegurado() {
		String msg = "Espera-se obter o valor assegurado de uma aposta a partir do seguro por valor.";	
		
		assertTrue(msg, apostaAsseguradaValor.getValorAssegurado() == 1000);
		
		String msg1 = "Espera-se obter o valor assegurado de uma aposta a partir do seguro por taxa.";
		
		assertTrue(msg, apostaAsseguradaTaxa.getValorAssegurado() == 500);
	}
	
	@Test
	public void testToString() {
		String msg = "Espera-se obter uma representação textual adequada de acordo com o tipo da aposta assegurada.";
		
		assertEquals(msg, "Misael - R$ 100,00 - VAI ACONTECER - ASSEGURADA (VALOR) - R$ 10,00", apostaAsseguradaValor.toString());
		
		assertEquals(msg, "Misael 2 - R$ 50,00 - N VAI ACONTECER - ASSEGURADA (TAXA) - 10%", apostaAsseguradaTaxa.toString());
	}
}
