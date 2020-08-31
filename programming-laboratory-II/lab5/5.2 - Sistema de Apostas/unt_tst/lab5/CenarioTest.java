package lab5;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class CenarioTest {

	private Cenario cenario1;
	
	private Cenario cenario2;
	
	@Before
	public void criaCenario() {
		cenario1 = new Cenario(1, "Eu vou entregar o lab5");
		cenario2 = new Cenario(2, "Eu n�o vou entregar o lab5");
		
		this.cenario2.registraAposta("Misael", 999999, "N VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testDescricaoNula() {
		String msg = "Espera-se obter uma exce��o para a cria��o de um cen�rio com descri��o nula.";
		
		Cenario cenarioInvalido = new Cenario(1, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDescricaoVazia() {
		String msg = "Espera-se obter uma exce��o para a cria��o de um cen�rio com descri��o vazia.";
		
		Cenario cenarioInvalido2 = new Cenario(1, "     ");
	}
	
	@Test
	public void testGetQuantidadeApostas() {
		String msg = "Espera-se obter a quantidade (sempre inteira) de apostas do cen�rio.";
		
		assertTrue(this.cenario1.getQuantidadeApostas() == 0);
	}
	
	@Test
	public void testRegistraApostasIdentricas() {
		this.cenario1.registraAposta("Misael", 9999999, "VAI ACONTECER");
		this.cenario1.registraAposta("Misael", 1, "N VAI ACONTECER");
		this.cenario1.registraAposta("Misael", 1, "N VAI ACONTECER");
		
		String msg = "Espera-se obter a quantidade (sempre inteira) de apostas do cen�rio cadastradas at� o momento.";
		
		assertTrue(msg, this.cenario1.getQuantidadeApostas() == 3);
	}
	
	@Test
	public void testRegistraApostasDistintas() {
		this.cenario2.registraAposta("Misael_2", 1, "VAI ACONTECER");
		this.cenario2.registraAposta("Misael_3", 555555, "N VAI ACONTECER");
		
		String msg2 = "Espera-se obter a quantidade (sempre inteira) de apostas do cen�rio cadastradas at� o momento.";
		
		assertTrue(msg2, this.cenario2.getQuantidadeApostas() == 3);
	}
	
	@Test
	public void testValorApostas() {
		String msg = "Espera-se obter o valor total das apostas do cen�rio.";
	
		assertTrue(msg, this.cenario1.valorApostas() == 0);
		
		assertTrue(msg, this.cenario2.valorApostas() == 999999);
		
		this.cenario2.registraAposta("Misael", 1, "VAI ACONTECER");
		
		assertTrue(msg, this.cenario2.valorApostas() == 1000000);
	}
	
	@Test
	public void testListaApostas() {
		String msg = "Espera-se obter uma mensagem com a representa��o textual de todas as apostas do cen�rio, se este possuir alguma, do contr�rio, uma mensagem vazia.";
		
		String listagemApostasEsperada = "";
		assertEquals(msg, listagemApostasEsperada, this.cenario1.listaApostas());
		
		listagemApostasEsperada += "Misael - R$ 9999,99 - N VAI ACONTECER" + System.lineSeparator();
		assertEquals(msg, listagemApostasEsperada, this.cenario2.listaApostas());
		
		this.cenario2.registraAposta("Misael", 100, "VAI ACONTECER");
		
		listagemApostasEsperada += "Misael - R$ 1,00 - VAI ACONTECER" + System.lineSeparator();
		assertEquals(msg, listagemApostasEsperada, this.cenario2.listaApostas());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizaCenarioException() {
		String msg = "Espera-se obter uma exce��o para a opera��o inv�lida de finalizar um cen�rio que j� foi finalizado.";
		
		this.cenario1.finalizaCenario(true);
		this.cenario1.finalizaCenario(true);
	}
	
	@Test
	public void testFinalizaCenario() {
		String msg = "Espera-se obter uma mensagem de estado correspondente � finaliza��o do cen�rio.";
		
		this.cenario1.finalizaCenario(true);
		assertEquals(msg, "Finalizado (ocorreu)", this.cenario1.getEstado());
		
		this.cenario2.finalizaCenario(false);
		assertEquals(msg, "Finalizado (n ocorreu)", this.cenario2.getEstado());
	}
	
	@Test
	public void testTotalApostasPerdedoras() {
		String msg = "Espera-se obter, nos mais variados casos, o valor total das apostas perdedoras de determinado cenario.";
		
		this.cenario2.registraAposta("Misael 2", 1, "N VAI ACONTECER");	
		this.cenario2.finalizaCenario(true);
		assertTrue(msg, this.cenario2.totalApostasPerdedoras() == 1000000);
		
		this.cenario1.registraApostaSeguraTaxa("Misael 3", 1000, "VAI ACONTECER", 0.5);
		this.cenario1.registraApostaSeguraValor("Misael 4", 2000, "VAI ACONTECER", 800);
		this.cenario1.registraApostaSeguraTaxa("Misael 5", 2500, "N VAI ACONTECER", 0.01);
		this.cenario1.finalizaCenario(false);
		assertTrue(msg, this.cenario1.totalApostasPerdedoras() == 3000);
		
	}
	
	@Test
	public void testTotalValorAssegurado() {
		String msg = "Espera-se obter o valor assegurado das apostas perdedoras que possuem algum tipo de seguro.";
		
		this.cenario1.registraApostaSeguraTaxa("Misael 3", 1000, "VAI ACONTECER", 0.5);
		this.cenario1.registraApostaSeguraValor("Misael 4", 2000, "VAI ACONTECER", 800);
		this.cenario1.registraApostaSeguraTaxa("Misael 5", 2500, "N VAI ACONTECER", 0.01);
		this.cenario1.finalizaCenario(false);
		assertTrue(msg, this.cenario1.totalValorAssegurado() == 1300);
	}
	
	@Test
	public void testLucroCenario() {
		String msg = "Espera-se obter o valor das apostas perdedoras do cenario que sera destinado ao caixa.";
		
		this.cenario2.registraAposta("Misael 2", 1, "N VAI ACONTECER");	
		this.cenario2.finalizaCenario(true);
		
		assertTrue(msg, this.cenario2.lucroCenario(0.1) == 100000);
	}
	
	@Test
	public void testGetTotalRateio() {
		String msg = "Espera-se obter o valor de rateio do cenario.";
		
		this.cenario1.registraAposta("Misael", 1000, "VAI ACONTECER");
		this.cenario1.registraApostaSeguraTaxa("Misael 2", 2000, "VAI ACONTECER", 0.1);
		this.cenario1.registraApostaSeguraValor("Misael 3", 3000, "N VAI ACONTECER", 500);
		this.cenario1.finalizaCenario(false);
		
		assertTrue(msg, this.cenario1.getTotalRateio(0.1) == 2700);
	}
	
	@Test
	public void testAlteraApostaSeguroValor() {
		String msg = "Espera-se obter uma aposta do tipo assegurada por valor.";
		
		this.cenario1.registraApostaSeguraTaxa("Misael", 1000, "VAI ACONTECER", 0.2);
		this.cenario1.registraApostaSeguraTaxa("Misael 2", 2000, "N VAI ACONTECER", 0.5);
		
		this.cenario1.alteraApostaSeguroValor(1, 250);
		assertTrue(msg, (this.cenario1.apostasAsseguradas.get(1).getSeguro() instanceof SeguroValor) ? true : false);
		
		this.cenario1.alteraApostaSeguroValor(2, 500);
		assertTrue(msg, (this.cenario1.apostasAsseguradas.get(2).getSeguro() instanceof SeguroValor) ? true : false);
	}
	
	@Test
	public void testAlteraApostaSeguroTaxa() {
		String msg = "Espera-se obter uma aposta do tipo assegurada por taxa.";
		
		this.cenario1.registraApostaSeguraValor("Misael", 1000, "VAI ACONTECER", 200);
		this.cenario1.registraApostaSeguraValor("Misael 2", 2000, "N VAI ACONTECER", 400);
		
		this.cenario1.alteraApostaSeguroTaxa(1, 0.2);
		assertTrue(msg, (this.cenario1.apostasAsseguradas.get(1).getSeguro() instanceof SeguroTaxa) ? true : false);
		
		this.cenario1.alteraApostaSeguroTaxa(2, 0.5);
		assertTrue(msg, (this.cenario1.apostasAsseguradas.get(2).getSeguro() instanceof SeguroTaxa) ? true : false);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testCaixaCenarioNaoFinalizado() {
		String msg = "Espera-se obter uma exce��o para a opera��o inv�lida de recolher o valor das apostas perdedoras de um cen�rio ainda n�o finalizado.";
		
		this.cenario1.totalApostasPerdedoras();
	}
	
	@Test
	public void testCaixaCenario() {
		String msg = "Espera-se obter o valor total das apostas perdedoras do cen�rio.";
		
		this.cenario1.registraAposta("Misael", 5555, "VAI ACONTECER");
		
		this.cenario1.finalizaCenario(true);
		assertTrue(msg, this.cenario1.totalApostasPerdedoras() == 0);
		
		this.cenario2.finalizaCenario(true);
		assertTrue(msg, this.cenario2.totalApostasPerdedoras() == 999999);
	}
	
	@Test
	public void testRegistraApostaSeguraValor() {
		String msg = "Espera-se obter a quantidade (sempre inteira) de apostas asseguradas por valor do cenario cadastradas ate o momento.";
		
		this.cenario1.registraApostaSeguraValor("Misael", 10000, "VAI ACONTECER", 4000);
		this.cenario1.registraApostaSeguraValor("Misael 2", 7000, "N VAI ACONTECER", 3000);
		
		assertTrue(msg, this.cenario1.getQuantidadeApostasAsseguradas() == 2);
	}
	
	@Test
	public void testRegistraApostaSeguraTaxa() {
		String msg = "Espera-se obter a quantidade (sempre inteira) de apostas asseguradas por taxa do cenario cadastradas ate o momento.";
		
		this.cenario1.registraApostaSeguraTaxa("Misael", 10000, "VAI ACONTECER", 0.01);
		this.cenario1.registraApostaSeguraTaxa("Misael 2", 7000, "N VAI ACONTECER", 0.02);
		this.cenario1.registraApostaSeguraTaxa("Misael 3", 1000, "N VAI ACONTECER", 0.05);
		
		assertTrue(msg, this.cenario1.getQuantidadeApostasAsseguradas() == 3);
	}
	
	@Test
	public void testToString() {
		String msg = "Espera-se obter uma representa��o textual em String do cen�rio com a numera��o, a descri��o e o estado do cen�rio respectivamente.";
		
		assertEquals(msg, "1 - Eu vou entregar o lab5 - Nao finalizado", cenario1.toString());
		
		this.cenario1.finalizaCenario(true);
		assertEquals(msg, "1 - Eu vou entregar o lab5 - Finalizado (ocorreu)", cenario1.toString());
		
		this.cenario2.finalizaCenario(false);
		assertEquals(msg, "2 - Eu n�o vou entregar o lab5 - Finalizado (n ocorreu)", cenario2.toString());
		
		
		
	}
	
}
