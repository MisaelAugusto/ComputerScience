package lab5;

public class SeguroTaxa extends Seguro {
	
	private double taxa;

	 /**
	  * Constroi um objeto SeguroTaxa a partir do valor
	  * da taxa passado como parametro. Além disso, verifica
	  * e trata a invalidez da taxa.
	  *
	  *
	  * @param taxa A taxa do valor total da aposta que sera assegurada
	  */
	public SeguroTaxa(double taxa) {
		if (taxa <= 0.0) {	
			throw new IllegalArgumentException("Seguro inválido: Taxa menor ou igual a zero.");
		} 
		
		this.taxa = taxa;
	}

	/**
     * Calcula e retorna o valor a ser assegurado a
     * partir do atributo taxa e do valor da aposta
     * passado como parametro.
     * 
     * @returns O valor assegurado da aposta.
     */
	public int getValorAssegurado(int valor) {
		return (int) (valor * this.taxa);
	}
	
	/**
     * Monta e retorna uma representação em String do seguro
     * por taxa.
     * 
     * "(TAXA) - taxaAssegurada%"
     * 
     * @returns Uma representação textual do seguro por taxa.
     */
	public String toString() {
		return "(TAXA) - " + (int) (this.taxa * 100) + "%";
	}
}
