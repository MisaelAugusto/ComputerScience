package lab5;

import java.util.Comparator;

/**
 * Implementacao da interface Comparator para objetos do tipo
 * Cenario. Esta implementacao compara dois cenarios a partir
 * das suas respectivas quantidades de apostas.
 *
 * @author Misael Augusto Silva da Costa
 */
public class OrdenaCenarioApostas implements Comparator<Cenario> {

	/**
	 * Implementacao do metodo compare() da interface Comparator
	 * para objetos da classe cenario, utilizando como criterio
	 * de comparacao a quantidade total de apostas de cada cenario a ser comparado.
	 * (Caso a quantidade seja igual, a numeracao sera o criterio de comparacao).
	 * Esta implementacao retorna um valor de comparacao, que servira
	 * de suporte para o metodo sort na ordenacao dos cenarios.
	 *
	 * @param cenario1 Cenario a ser comparado
	 * @param cenario2 Cenario a ser comparado
	 * @returns valor de comparacao
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {
		if (cenario1.getQuantidadeTotalApostas() == cenario2.getQuantidadeTotalApostas()) {
			return cenario1.getNumeracao() - cenario2.getNumeracao();
		}
		
		return cenario2.getQuantidadeTotalApostas() - cenario1.getQuantidadeTotalApostas();
	}
	
}
