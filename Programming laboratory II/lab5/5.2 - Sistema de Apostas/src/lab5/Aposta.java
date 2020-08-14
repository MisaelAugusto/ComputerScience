package lab5;

import java.text.DecimalFormat;

/**
 * Representa��o de uma aposta. Toda aposta deve ter:
 * o nome do apostador, o valor da aposta e a previs�o,
 * sendo esta restrita a "VAI ACONTECER" e "N VAI ACONTECER".
 *
 * @author Misael Augusto Silva da Costa
 */
public class Aposta {
	
	protected String nomeApostador;
	
	protected int valor;
	
	protected String previsao;
	
	 /**
	  * Constr�i um objeto Aposta a partir do nome do apostador,
	  * do valor da aposta e da previs�o passados como par�metro.
	  * Al�m disso, trata casos de invalidez, como por exemplo: nome
	  * do apostador nulo ou vazio, valor para aposta nulo ou negativo e
	  * qualquer previs�o que seja diferente de "VAI ACONTECER" ou
	  * "N VAI ACONTECER".
	  *
	  * @param nomeApostador O nome do apostador
	  * @param valor O valor da aposta
	  * @param previsao A previsao da aposta
	  */
	public Aposta(String nomeApostador, int valor, String previsao) {
		if (nomeApostador == null) {
			throw new NullPointerException("Apostador nao pode ser vazio ou nulo");
		} else if (nomeApostador.trim().equals("")) {
			throw new IllegalArgumentException("Apostador nao pode ser vazio ou nulo");
		} else {
			this.nomeApostador = nomeApostador.trim();
		}
		
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor nao pode ser menor ou igual a zero");
		} else {
			this.valor = valor;
		}
		
		if (previsao == null) {
			throw new NullPointerException("Previsao nao pode ser vazia ou nula");
		} else if (previsao.trim().equals("")) {
			throw new IllegalArgumentException("Previsao nao pode ser vazia ou nula");
		} else if (previsao.trim().toUpperCase().equals("VAI ACONTECER") || previsao.trim().toUpperCase().equals("N VAI ACONTECER")) {
			this.previsao = previsao.toUpperCase().trim();
		} else {
			throw new IllegalArgumentException("Previsao invalida");
		}
	}
	
	 /**
	  * Apenas retorna o nome do apostador.
	  *
	  *@returns O nome do apostador
	  */
	public String getNomeApostador() {
		return this.nomeApostador;
	}
	
	 /**
	  * Apenas retorna o valor da aposta.
	  *
	  *@returns O valor da aposta.
	  */
	public int getValor() {
		return this.valor;
	}
	
	/**
	  * Apenas retorna o valor assegurado da aposta.
	  *
	  *@returns O valor assegurado.
	  */
	public int getValorAssegurado() {
		return 0;
	}
	
	/**
	  * Apenas retorna um valor booleano que representa
	  * a previsao da aposta. O valor true para "VAI ACONTECER"
	  * e false para "N VAI ACONTECER".
	  *
	  *@returns Um valor booleano que representa a previsao do apostador.
	  */
	public boolean getPrevisao() {
		return (this.previsao.equals("VAI ACONTECER")) ? true : false;
	}

    /**
     * Monta uma representa��o em String da aposta a partir do nome
     * do apostador, do valor da aposta e da previsao respectivamente.
     * 
     * "nomeApostador - R$valor - previsao"
     * 
     * @returns a representa��o textual de uma aposta.
     */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		
		return this.getNomeApostador() + " - R$ " + df.format(this.getValor() / 100.0) + " - " + this.previsao;
	}

    /**
     * Calcula e retorna o Hashcode do objeto aposta.
     * 
     * @returns O Hashcode do aposta.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeApostador == null) ? 0 : nomeApostador.hashCode());
		result = prime * result + ((previsao == null) ? 0 : previsao.hashCode());
		result = prime * result + valor;
		return result;
	}

    /**
     * Analisa se o objeto passado como parametro é
     * igual a aposta. Para um objeto ser igual a
     * aposta ele precisa ser da classe Aposta e 
     * possuir nome do apostador, previsao e valor iguais
     * ao da aposta.
     * 
     * @param obj Objeto a ser comparado com a aposta
     * @returns Um valor booleano indicando se o objeto é ou não igual a aposta.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		if (nomeApostador == null) {
			if (other.nomeApostador != null)
				return false;
		} else if (!nomeApostador.equals(other.nomeApostador))
			return false;
		if (previsao == null) {
			if (other.previsao != null)
				return false;
		} else if (!previsao.equals(other.previsao))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
}

