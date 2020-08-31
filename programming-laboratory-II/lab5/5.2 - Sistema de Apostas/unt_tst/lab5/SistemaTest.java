package lab5;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class SistemaTest {

	private Sistema sistema1;
	
	private Sistema sistema2;
	
	@Before
	public void criaSistema() {
		this.sistema1 = new Sistema(10000, 0.1);
		this.sistema2 = new Sistema(999999, 0.2);

		this.sistema2.cadastraCenario("Cenario 1");
		this.sistema2.cadastraCenario("Cenario 2");
		this.sistema2.cadastraAposta(2, "Misael", 10000, "VAI ACONTECER");
		this.sistema2.cadastraAposta(2, "Misael_2", 5000, "N VAI ACONTECER");
		this.sistema2.cadastraAposta(2, "Misael_3", 5000, "N VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSistemaCaixaNegativo() {
		String msg = "Espera-se obter uma exce��o para a cria��o de um sistema com valor do caixa negativo.";
		
		Sistema sistemaInvalido = new Sistema(-10, 0.01);	
	}
	
	@Test
	public void testSistemaTaxaInvalida() {
		String msg = "Espera-se obter uma exce��o para a cria��o de um sistema com valor da taxa negativo ou maior que 1.";
		
		try {
			
			Sistema sistemaInvalido = new Sistema(10, -0.01);
			
			Sistema sistemaInvalido3 = new Sistema(250, 1.5);
		
		} catch (Exception e) {
			assertEquals("Erro na inicializacao: Taxa nao pode ser inferior a 0", e.getMessage());
		}
	}
	
	@Test
	public void testCadastraCenario() {
		String msg = "Espera-se obter a quantidade de cen�rios ap�s o �ltimo cadastro realizado.";
		
		assertEquals(msg, 1, this.sistema1.cadastraCenario("Eu vou entregar o lab5"));
		
		assertEquals(msg, 3, this.sistema2.cadastraCenario("Cen�rio 3"));
	}
	
	@Test
	public void testCadastraCenarioBonus() {
		String msg = "Espera-se obter a quantidade de cenarios apos o ultimo cadastro realizado.";
		
		assertEquals(msg, 1, this.sistema1.cadastraCenarioBonus("Tudo vai ficar bem", 1000));
		
		assertEquals(msg, 3, this.sistema2.cadastraCenarioBonus("Tudo vai dar certo", 5000));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testValidaOperacaoCenario() {	
		String msg = "Espera-se obter uma exce��o para a valida��o de qualquer opera��o com a numera��o de cen�rio negativa ou inexistente como par�metro.";
		
		this.sistema1.validaOperacaoCenario(-1);	
		this.sistema1.validaOperacaoCenario(1);
			
		this.sistema2.validaOperacaoCenario(-2);
		this.sistema2.validaOperacaoCenario(10);
	}
	
	@Test
	public void testExibeCenario() {
		String msg = "Espera-se obter uma mensagem que representa textualmente o cen�rio correspondente � numera��o.";
		
		assertEquals(msg, "1 - Cenario 1 - Nao finalizado", this.sistema2.exibeCenario(1));
		
		assertEquals(msg, "2 - Cenario 2 - Nao finalizado", this.sistema2.exibeCenario(2));
	}
	
	@Test
	public void testListaCenarios() {
		String msg = "Espera-se obter uma mensagem com a representa��o textutal de todos os cen�rios do sistema, se este possuir algum, do contr�rio, uma mensagem vazia.";
		
		String listagemCenariosEsperada = "";
		assertEquals(msg, listagemCenariosEsperada, sistema1.listaCenarios()); 
		
		listagemCenariosEsperada += "1 - Cenario 1 - Nao finalizado" + System.lineSeparator() + "2 - Cenario 2 - Nao finalizado" + System.lineSeparator();
		assertEquals(msg, listagemCenariosEsperada, this.sistema2.listaCenarios());
	}
	
	@Test
	public void testValorTotalApostas() {
		String msg = "Espera-se obter o valor total de todas as apostas do cen�rio a partir da numera��o passada como par�metro.";
		
		assertTrue(msg, this.sistema2.valorTotalApostas(1) == 0);
		
		assertTrue(msg, this.sistema2.valorTotalApostas(2) == 20000);
	}
	
	@Test
	public void testQuantidadeApostas() {
		String msg = "Espera-se obter a quantidade de apostas do cen�rio a partir da numera��o passada como par�metro.";
		
		assertTrue(msg, this.sistema2.quantidadeApostas(1) == 0);
		
		assertTrue(msg, this.sistema2.quantidadeApostas(2) == 3);
	}
	
	@Test
	public void testValorCaixaCenario() {
		String msg = "Espera-se obter o valor total das apostas perdedoras multiplicado pela taxa do sistema.";
		
		this.sistema2.finalizarCenario(2, false);
		assertTrue(msg, sistema2.getCaixaCenario(2) == 2000);
	}
	
	@Test
	public void testTotalRateioCenario() {
		String msg = "Espera-se obter o valor que ser� repartido entre os vencedores da aposta.";
		
		this.sistema2.finalizarCenario(2, false);
		assertTrue(msg, sistema2.getTotalRateioCenario(2) == 8000);
	}
	
	@Test
	public void testToString() {
		String msg = "Espera-se obter uma representa��o textual do sistema a partir do caixa e da caixa.";
		
		assertEquals(msg, "Caixa: 10000" + System.lineSeparator() + "Taxa: 0.1", sistema1.toString());
	}
	
	@Test
	public void testAlteraOrdemCenariosExceptions() {
		try {
			
			this.sistema2.alteraOrdemCenarios("   ");
			this.sistema2.alteraOrdemCenarios(null);
			
		} catch (Exception e) {
			assertEquals("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula", e.getMessage());
		}
	}
	
	@Test
	public void testExibeCenarioOrdenadoNome() {
		String msg = "Espera-se obter a representacao textual do cenario correto apos a ordenacao por nome (descricao).";
		
		this.sistema2.cadastraCenario("Cenario 0");
		this.sistema2.alteraOrdemCenarios("nome");
		
		String cenarioEsperado = "3 - Cenario 0 - Nao finalizado";
		
		assertEquals(msg, cenarioEsperado, this.sistema2.exibeCenarioOrdenado(1));
	}
	
	@Test
	public void testExibeCenarioOrdenadoCadastro() {
		String msg = "Espera-se obter a representacao textual do cenario correto apos a ordenacao por cadastro (numeracao).";
		
		this.sistema2.alteraOrdemCenarios("cadastro");
		
		assertEquals(msg, "1 - Cenario 1 - Nao finalizado", this.sistema2.exibeCenarioOrdenado(1));
	}
	
	@Test
	public void testExibeCenarioOrdenadoApostas() {
		String msg = "Espera-se obter a representacao textual do cenario correto apos a ordenacao por quantidade de apostas.";
		
		this.sistema2.alteraOrdemCenarios("apostas");
		
		assertEquals(msg, "2 - Cenario 2 - Nao finalizado", this.sistema2.exibeCenarioOrdenado(1));
		assertEquals(msg, "2 - Cenario 2 - Nao finalizado", this.sistema2.exibeCenario(2));
	}

	
}
