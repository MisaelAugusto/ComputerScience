package lab5;

public class ApostaAssegurada extends Aposta {
	
	private Seguro seguro;

	 /**
	  * Constroi um objeto ApostaAssegurada com o seguro por valor
	  * a partir do nome do apostador, do valor da aposta, da 
	  * previsao e do valor assegurado passados como parametro.
	  *
	  * @param apostador O nome do apostador
	  * @param valor O valor da aposta
	  * @param previsao O palpite do apostador
	  * @param valorSeguro O valor a ser assegurado
	  */
	public ApostaAssegurada(String apostador, int valor, String previsao, int valorSeguro) {
		super(apostador, valor, previsao);
		this.seguro = new SeguroValor(valorSeguro);
	}
	
	 /**
	  * Constroi um objeto ApostaAssegurada com o seguro por taxa
	  * a partir do nome do apostador, do valor da aposta, da 
	  * previsao e da taxa assegurada passados como parametro.
	  *
	  * @param apostador O nome do apostador
	  * @param valor O valor da aposta
	  * @param previsao O palpite do apostador
	  * @param taxa A taxa do valor total da aposta que sera assegurada
	  */
	public ApostaAssegurada(String apostador, int valor, String previsao, double taxa) {
		super(apostador, valor, previsao);
		this.seguro = new SeguroTaxa(taxa);
	}

	/**
     * Não retorna nada, apenas muda o tipo do seguro
     * por taxa para seguro por valor a partir do valor
     * do seguro passado como parametro.
     * 
     * @param valorSeguro O valor do total da aposta a ser assegurado
     * @returns void.
     */
	public void turnSeguroValor(int valorSeguro) {
		this.seguro = new SeguroValor(valorSeguro);
	}

	/**
     * Não retorna nada, apenas muda o tipo do seguro
     * por valor para seguro por taxa a partir da taxa
     * passada como parametro.
     * 
     * @param taxa A taxa do valor total da aposta que sera assegurada
     * @returns void.
     */
	public void turnSeguroTaxa(double taxa) {
		this.seguro = new SeguroTaxa(taxa);
	}

	/**
     * Apenas retorna o objeto seguro da aposta assegurada.
     * 
     * @returns O atributo seguro da aposta assegurada.
     */
	public Seguro getSeguro() {
		return this.seguro;
	}
	
	/**
     * Apenas retorna o valor assegurado da aposta.
     * 
     * @returns O valor assegurado da aposta.
     */
	@Override
	public int getValorAssegurado() {
		return this.seguro.getValorAssegurado(this.valor);
	}
	
	/**
     * Monta e retorna uma representação geral em String
     * para a aposta assegurada. Dependendo do tipo de seguro
     * a representação irá variar.
     * 
     * "nomeApostador - valor - previsao - ASSEGURADA (VALOR) - R$ valorAssegurado"
     * "nomeApostador - valor - previsao - ASSEGURADA (TAXA) - taxaAssegurada%"
     * 
     * @returns Uma representação textual da aposta assegurada.
     */
	@Override
	public String toString() {
		return super.toString() + " - " + "ASSEGURADA " + this.seguro.toString();
	}
	
}
