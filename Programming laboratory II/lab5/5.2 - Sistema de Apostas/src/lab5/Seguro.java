package lab5;

public abstract class Seguro {
	
	/**
     * Metodo abstrato que sera implementado pelas
     * classes filhas: SeguroValor e SeguroTaxa.
     * 
     * @returns O valor assegurado da aposta.
     */
	public abstract int getValorAssegurado(int valor);
	
	/**
     * Metodo abstrato que sera implementado pelas
     * classes filhas: SeguroValor e SeguroTaxa.
     * 
     * @returns Uma representação textutal para o tipo do seguro.
     */	
	@Override
	public abstract String toString();
	
}
