package lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguroTaxaTest {

	private SeguroTaxa seguroTaxa;
	
	@Before
	public void criaSeguroTaxa() {
		seguroTaxa = new SeguroTaxa(0.5);
	}
	
	@Test
	public void seguroTaxaInvalida() {
		try {
			
			SeguroTaxa seguroTaxaInvalido = new SeguroTaxa(0.0);
			SeguroTaxa seguroTaxaInvalido2 = new SeguroTaxa(-0.55);
			
		} catch (IllegalArgumentException e) {
			assertEquals("Seguro inválido: Taxa menor ou igual a zero.", e.getMessage());
		}
	}
	
	@Test
	public void testGetValorAssegurado() {
		String msg = "Espera-se obter o valor assegurado por este tipo de seguro.";
		
		assertTrue(msg, seguroTaxa.getValorAssegurado(1000) == 500);
	}
	
	@Test
	public void testToString() {
		String msg = "Espera-se obter uma representação textual especifica para este tipo de seguro.";
		
		assertEquals(msg, "(TAXA) - 50%", seguroTaxa.toString());
	}
}
