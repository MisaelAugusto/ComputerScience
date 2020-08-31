package lab5;

import java.text.DecimalFormat;

public class SeguroValor extends Seguro {
	
	private int valor;

	 /**
	  * Constroi um objeto SeguroValor a partir do valor
	  * do seguro passado como parametro. Além disso, verifica
	  * e trata a invalidez do valor.
	  *
	  * @param valor O valor a ser assegurado
	  */
	public SeguroValor(int valor) {
		if (valor <= 0.0) {	
			throw new IllegalArgumentException("Seguro inválido: Valor menor ou igual a zero.");
		} 
		
		this.valor = valor;
	}

	/**
     * Calcula e retorna o valor a ser assegurado a
     * partir do atributo valor.
     * 
     * @returns O valor assegurado da aposta.
     */
	public int getValorAssegurado(int valor) {
		return this.valor;
	}

	/**
     * Monta e retorna uma representação em String do seguro
     * por valor.
     * 
     * "(VALOR) - R$ valorAssegurado"
     * 
     * @returns Uma representação textual do seguro por valor.
     */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		
		return "(VALOR) - R$ " + df.format(this.valor / 100.0);
	}
}
