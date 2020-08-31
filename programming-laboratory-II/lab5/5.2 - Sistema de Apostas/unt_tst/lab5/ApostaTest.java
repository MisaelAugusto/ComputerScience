package lab5;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApostaTest {

	private Aposta aposta;
	
	private Aposta aposta2;
	
	private Aposta aposta3;
	
	@Before
	public void criaAposta() {
		aposta = new Aposta("Misael Augusto", 18435, "VAI ACONTECER");
		aposta2 = new Aposta("  Talvez Funcione  ", 19999, "n VAI aconTECER");
		aposta3 = new Aposta("           Esse nem deve funcionar  ", 20, "VaI acoNTEcer");
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaNomeApostadorNulo() {
		Aposta apostaInvalida = new Aposta(null, 10000, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaNomeApostadorVazio() {
		Aposta apostaInvalida2 = new Aposta("   ", 10000, "N VAI ACONTECER");
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaValorNulo() {
		Aposta apostaInvalida = new Aposta("Só tentando mesmo", 0, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApostaValorNegativo() {
		Aposta apostaInvalida2 = new Aposta("Nenhum dá certo", -100, "N VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testApostaPrevisaoNula() {
		Aposta apostaInvalida = new Aposta("Agora vai", 10000, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testApostaPrevisaoVazia() {
		Aposta apostaInvalida2 = new Aposta("Nem foi", 10000, "    ");
	}
	
	@Test
	public void testNomeApostador() {
		String msg = "Espera-se obter o atributo nomeApostador armazenado sem espaços nas extremidades e com Case-sensitive";
		
		assertEquals(msg, "Misael Augusto", aposta.getNomeApostador());
		
		assertEquals(msg, "Talvez Funcione", aposta2.getNomeApostador());

		assertEquals(msg, "Esse nem deve funcionar", aposta3.getNomeApostador());
	}
	
	@Test
	public void testGetPrevisao() {
		String msg = "Espera-se obter o valor booleano adequado para cada tipo de previsão: true para 'VAI ACONTECER' e false para 'N VAI ACONTECER'";
		
		assertTrue(msg, aposta.getPrevisao());
		
		assertFalse(msg, aposta2.getPrevisao());
		
		assertTrue(msg, aposta3.getPrevisao());
	}

	@Test
	public void testToString() {
		String msg = "Espera-se obter uma representação textual em String da aposta com o nome do apostador, o valor e a previsão da aposta respectivamente.";
		
		assertEquals(msg, "Misael Augusto - R$184,35 - VAI ACONTECER", aposta.toString());
		
		assertEquals(msg, "Talvez Funcione - R$199,99 - N VAI ACONTECER", aposta2.toString());
		
		assertEquals(msg, "Esse nem deve funcionar - R$0,20 - VAI ACONTECER", aposta3.toString());
	}
}
