package lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguroValorTest {

	private SeguroValor seguroValor;
	
	@Before
	public void criaSegurValor() {
		seguroValor = new SeguroValor(10000);
	}
	
	@Test
	public void seguroValorInvalido() {
		try {
			
			SeguroValor seguroValorInvalido = new SeguroValor(0);
			SeguroValor seguroValorInvalido2 = new SeguroValor(-55);
			
		} catch (IllegalArgumentException e) {
			assertEquals("Seguro inválido: Valor menor ou igual a zero.", e.getMessage());
		}
	}
	
	@Test
	public void testGetValorAssegurado() {
		String msg = "Espera-se obter o valor assegurado por este tipo de seguro.";
		
		assertTrue(msg, seguroValor.getValorAssegurado(1000) == 10000);
	}
	
	@Test
	public void testToString() {
		String msg = "Espera-se obter uma representação textual especifica para este tipo de seguro.";
		
		assertEquals(msg, "(VALOR) - R$ 100,00", seguroValor.toString());
	}

}
