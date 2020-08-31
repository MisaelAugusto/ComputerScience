package lab5;

import java.text.DecimalFormat;

public class CenarioBonus extends Cenario {
	
	private int bonus;

	 /**
	  * Constr�i um objeto Cenario com B�nus a partir da numera��o e da descricao
	  * e do b�nus passados como par�metro.
	  *
	  * @param numeracao A numera��o do cen�rio.
	  * @param descricao A descricao do cen�rio.
	  */
	public CenarioBonus(int numeracao, String descricao, int bonus) {
		super(numeracao, descricao);
		
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		
		this.bonus = bonus;
	}

    /**
     * Calcula e retorna o valor a ser distribuido entre as
     * apostas vencedoras.
     * 
     * @returns o valor a ser distribuido aos ganhadores.
     */
	@Override
	public int getTotalRateio(double taxa) { 
		return super.getTotalRateio(taxa) + this.bonus;
	}
	
    /**
     * Monta uma representa��o em String do cen�rio a partir da
     * numera��o, da descri��o, do estado e do b�nus respectivamente.
     * 
     * "numeracao - descricao - estado - bonus"
     * 
     * @returns a representa��o textual de um cen�rio.
     */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		
		return this.numeracao + " - " + this.descricao + " - " + this.estado + " - R$ " + df.format(this.bonus / 100.0);
	}

    /**
     * Calcula e retorna o Hashcode do objeto CenarioBonus.
     * 
     * @returns O Hashcode do CenarioBonus.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bonus;
		return result;
	}

    /**
     * Analisa se o objeto passado como parametro é
     * igual ao CenarioBonus. Para um objeto ser igual ao
     * CenarioBonus ele precisa ser da classe CenarioBonus e 
     * possuir, além dos outros atributos da classe mãe, 
     * bonus iguais ao do CenarioBonus.
     * 
     * @param obj Objeto a ser comparado com o CenarioBonus
     * @returns Um valor booleano indicando se o objeto é ou não igual ao CenarioBonus.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CenarioBonus other = (CenarioBonus) obj;
		if (bonus != other.bonus)
			return false;
		return true;
	}
	
}
