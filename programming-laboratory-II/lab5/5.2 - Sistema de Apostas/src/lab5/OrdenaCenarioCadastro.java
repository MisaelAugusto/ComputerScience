package lab5;

import java.util.Comparator;

/**
 * Implementacao da interface Comparator para objetos do tipo
 * Cenario. Esta implementacao compara dois cenarios a partir
 * das suas respectivas numeracoes.
 *
 * @author Misael Augusto Silva da Costa
 */
public class OrdenaCenarioCadastro implements Comparator<Cenario> {

	/**
	 * Implementacao do metodo compare() da interface Comparator
	 * para objetos da classe cenario, utilizando como criterio
	 * de comparacao a numeracao de cada cenario a ser comparado.
	 * Esta implementacao retorna um valor de comparacao, que servira
	 * de suporte para o metodo sort na ordenacao dos cenarios.
	 *
	 * @param cenario1 Cenario a ser comparado
	 * @param cenario2 Cenario a ser comparado
	 * @returns valor de comparacao
	 */
	@Override
	public int compare(Cenario cenario1, Cenario cenario2) {	
		return cenario1.getNumeracao() - cenario2.getNumeracao();
	}

}
