package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Representa��o de um cen�rio. Todo cen�rio deve ter
 * uma numera��o, uma descri��o, um estado, e uma lista
 * de apostas.
 *
 * @author Misael Augusto Silva da Costa
 */
public class Cenario {
	
	protected int numeracao;
	
	protected String descricao;
	
	protected Estado estado;
	
	protected ArrayList<Aposta> apostas;
	
	public HashMap<Integer, ApostaAssegurada> apostasAsseguradas;
	
	private int codigoApostaAssegurada = 1;
	
	 /**
	  * Constr�i um objeto Cenario a partir da numera��o e da descricao
	  * passados como par�metro. Al�m disso, trata o caso de invalidez para
	  * descri��o nula ou vazia.
	  *
	  * @param numeracao A numera��o do cen�rio
	  * @param descricao A descricao do cen�rio
	  */	
	public Cenario(int numeracao, String descricao) {
		this.numeracao = numeracao;
		
		if (descricao == null) {
			throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser nula");
		} else if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		} else {
			this.descricao = descricao.trim();
		}
		
		this.estado = Estado.NAO_FINALIZADO;
		
		this.apostas = new ArrayList<>();
		
		this.apostasAsseguradas = new HashMap<>();
	}
	
    /**
     * Retorna a numeracao de identificacao do cenario.
     * 
     * @returns A numeracao do cenario.
     */
	public int getNumeracao() {
		return this.numeracao;
	}
	
    /**
     * Retorna a representacao textual da descricao do cenario.
     * 
     * @returns A descricao do cenario.
     */
	public String getDescricao() {
		return this.descricao;
	}
	
    /**
     * Retorna a representacao textual do estado do cenario.
     * 
     * @returns representacao textual do estado.
     */
	public String getEstado() {
		return this.estado.toString();
	}

    /**
     * Retorna a quantidade de apostas do cenario.
     * 
     * @returns quantidade de apostas.
     */
	public int getQuantidadeApostas() {
		return this.apostas.size();
	}
	
    /**
     * Retorna a quantidade total de apostas do cenario.
     * 
     * @returns quantidade total de apostas.
     */
	public int getQuantidadeTotalApostas() {
		return this.getQuantidadeApostas() + this.getQuantidadeApostasAsseguradas();
	}	
	
    /**
     * N�o retorna nada. Apenas adiciona uma aposta a lista de apostas
     * do cen�rio.
     * 
     * @returns void.
     */
	public void registraAposta(String apostador, int valor, String previsao) {
		this.apostas.add(new Aposta(apostador, valor, previsao));
	}

    /**
     * Nao retorna nada. Apenas adiciona uma aposta assegurada por
     * valor no mapa de apostas asseguradas que deve estar associada
     * ao codigoApostaAssegurada.
     * 
     * @returns void.
     */
	public int registraApostaSeguraValor(String apostador, int valor, String previsao, int valorSeguro) {
		this.apostasAsseguradas.put(this.codigoApostaAssegurada, new ApostaAssegurada(apostador, valor, previsao, valorSeguro));
		
		return this.codigoApostaAssegurada ++;
	}

    /**
     * Nao retorna nada. Apenas adiciona uma aposta assegurada por
     * taxa no mapa de apostas asseguradas que deve estar associada
     * ao codigoApostaAssegurada.
     * 
     * @returns void.
     */
	public int registraApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		this.apostasAsseguradas.put(this.codigoApostaAssegurada, new ApostaAssegurada(apostador, valor, previsao, taxa));
				
		return this.codigoApostaAssegurada ++;
	}

    /**
     * Retorna a quantidade de apostas asseguradas do cenario.
     * 
     * @returns quantidade de apostas asseguradas.
     */
	public int getQuantidadeApostasAsseguradas() {
		return this.apostasAsseguradas.keySet().size();
	}
	
    /**
     * Calcula e retorna o valor total de todas as apostas do cen�rio.
     * 
     * @returns a soma dos valores de todas as apsotas do cen�rio.
     */
	public int valorApostas() {
		int valorTotalApostas = 0;
		
		for (Aposta aposta : apostas) {
			valorTotalApostas += aposta.getValor();
		}
		
		return valorTotalApostas;
	}
	
    /**
     * Monta uma representa��o textutal de todas as apostas do
     * cen�rio.
     * 
     * @returns uma representa��o textutal de todas as apostas do cen�rio.
     */
	public String listaApostas() {
		String apostasListadas = "";
		
		for (Aposta aposta : apostas) {
			apostasListadas += aposta.toString() + System.lineSeparator();
		}
		
		return apostasListadas;
	}
	
    /**
     * N�o retorna nada. Apenas altera o estado do cen�rio para finalizado,
     * caso este n�o tenha sido finalizado, do contr�rio, uma exce��o para o
     * caso � lan�ada.
     * 
     * @returns void.
     */
	public void finalizaCenario(boolean ocorreu) {
		if (!this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ja esta fechado");
		}
		
		this.estado = (ocorreu) ? Estado.FINALIZADO_OCORREU : Estado.FINALIZADO_NAO_OCORREU;
	}
	
    /**
     * Calcula e retorna o valor de todas as apostas perdedoras do cen�rio.
     * 
     * @returns a soma dos valores de todas as apostas perdedoras.
     */
	public int totalApostasPerdedoras() {
		if (this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ainda esta aberto");
		}
		
		int valorApostasPerdedoras = 0;
		
		boolean ocorreu = (this.estado.equals(Estado.FINALIZADO_OCORREU)) ? true : false;
		
		for (Aposta aposta : apostas) {
			if (aposta.getPrevisao() != ocorreu) {
					valorApostasPerdedoras += aposta.getValor();
			}
		}
		
		for (Integer ID : apostasAsseguradas.keySet()) {
			if (apostasAsseguradas.get(ID).getPrevisao() != ocorreu) {
					valorApostasPerdedoras += apostasAsseguradas.get(ID).getValor();
			}
		}
		
		return valorApostasPerdedoras;
	}

    /**
     * Calcula e retorna o valor assegurado de todas as apostas
     * asseguradas perdedoras.
     * 
     * @returns a soma dos valores de todas as apostas asseguradas perdedoras.
     */
	public int totalValorAssegurado() {
		if (this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ainda esta aberto");
		}
		
		int valorAssegurado = 0;
		
		boolean ocorreu = (this.estado.equals(Estado.FINALIZADO_OCORREU)) ? true : false;
		
		for (Integer ID : apostasAsseguradas.keySet()) {
			if (apostasAsseguradas.get(ID).getPrevisao() != ocorreu) {
					valorAssegurado += apostasAsseguradas.get(ID).getValorAssegurado();
			}
		}
		
		return valorAssegurado;
	}

    /**
     * Calcula e retorna o valor de lucro do cenario a partir
     * da taxa do sistema e do valor total das apostas perdedoras.
     * 
     * @returns o lucro do cenario que sera destinado ao caixa.
     */
	public int lucroCenario(double taxa) {
		return (int) Math.floor(this.totalApostasPerdedoras() * taxa);
	}

    /**
     * Calcula e retorna o valor a ser distribuido entre as
     * apostas vencedoras.
     * 
     * @returns o valor a ser distribuido aos ganhadores.
     */
	public int getTotalRateio(double taxa) {
		return this.totalApostasPerdedoras() - this.lucroCenario(taxa);
	}
	
    /**
     * Altera o tipo do seguro de uma aposta assegurada por taxa para
     * uma aposta assegurada por valor.
     * 
     * @returns o codigo (identificacao) da aposta assegurada.
     */
	public int alteraApostaSeguroValor(int apostaAssegurada, int valor) {
		this.apostasAsseguradas.get(apostaAssegurada).turnSeguroValor(valor);
		
		return apostaAssegurada;
	}

    /**
     * Altera o tipo do seguro de uma aposta assegurada por valor para
     * uma aposta assegurada por taxa.
     * 
     * @returns o codigo (identificacao) da aposta assegurada.
     */
	public int alteraApostaSeguroTaxa(int apostaAssegurada, double taxa) {
		this.apostasAsseguradas.get(apostaAssegurada).turnSeguroTaxa(taxa);
		
		return apostaAssegurada;
	}
	
    /**
     * Monta uma representa��o em String do cen�rio a partir da
     * numera��o, da descri��o e do estado respectivamente.
     * 
     * "numeracao - descricao - estado"
     * 
     * @returns a representa��o textual de um cen�rio.
     */
	@Override
	public String toString() {
		return this.numeracao + " - " + this.descricao + " - " + this.estado;
	}

    /**
     * Calcula e retorna o Hashcode do objeto cenario.
     * 
     * @returns O Hashcode do cenario.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apostas == null) ? 0 : apostas.hashCode());
		result = prime * result + ((apostasAsseguradas == null) ? 0 : apostasAsseguradas.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + numeracao;
		return result;
	}

    /**
     * Analisa se o objeto passado como parametro é
     * igual ao cenario. Para um objeto ser igual ao
     * cenario ele precisa ser da classe Cenario e 
     * possuir conjunto de apostas, mapa de apostas
     * asseguradas, descricao, numeracao e estado iguais
     * ao do cenario.
     * 
     * @param obj Objeto a ser comparado com o cenario
     * @returns Um valor booleano indicando se o objeto é ou não igual ao cenario.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (apostas == null) {
			if (other.apostas != null)
				return false;
		} else if (!apostas.equals(other.apostas))
			return false;
		if (apostasAsseguradas == null) {
			if (other.apostasAsseguradas != null)
				return false;
		} else if (!apostasAsseguradas.equals(other.apostasAsseguradas))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estado != other.estado)
			return false;
		if (numeracao != other.numeracao)
			return false;
		return true;
	}
}
