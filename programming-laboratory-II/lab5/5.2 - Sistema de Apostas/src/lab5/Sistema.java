package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Representa��o de um sistema de apostas. Todo sistema deve ter:
 * um caixa, uma taxa, e uma lista de cen�rios.
 *
 * @author Misael Augusto Silva da Costa
 */
public class Sistema {
	
	private int caixa;
	
	private double taxa;
	
	private ArrayList<Cenario> cenarios;
	
	private Comparator<Cenario> ordenador;

	 /**
	  * Constroi um objeto Sistema a partir do caixa e da taxa
	  * passados como parametro. Alem disso, trata os cados de
	  * invalidez dos parametros: caixa negativo, taxa negativa 
	  * ou taxa maior que 1.
	  *
	  * @param caixa A quantidade inicial com a qual o sistema inicia
	  * @param taxa A taxa a ser aplicada nas apostas perdedoras
	  */
	public Sistema(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		} else {
			this.caixa = caixa;
		}
		
		if (taxa < 0 || taxa > 1) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		} else {
			this.taxa = taxa;
		}
		
		this.cenarios = new ArrayList<>();
		
		this.ordenador = new OrdenaCenarioCadastro();
	}	

	/**
     * Apenas retorna o valor do caixa do sistema.
     * 
     * @returns O valor total do caixa.
     */
	public int getCaixa() {
		return this.caixa;
	}

	/**
     * Apenas retorna a lista de cenarios do sistema.
     * 
     * @returns A lista de cenarios do sistema.
     */
	public ArrayList<Cenario> getCenarios() {
		return this.cenarios;
	}	
	
	/**
     * Adiciona um cenario na lista de cenarios do sistema a partir
     * da descricao passada como parametro.
     * 
     * @param descricao A descricao do cenario
     * @returns A numeracao do cenario cadastrado.
     */
	public int cadastraCenario(String descricao) {
		this.cenarios.add(new Cenario(this.cenarios.size() + 1, descricao));
		
		return this.cenarios.size();
	}
	
	/**
     * Cadastra um cenario bonus no sistema a partir da
     * descricao e do bonus passados como parametro. Além disso,
     * retira do caixa o valor do bonus do cenario.
     * 
     * @param descricao A descricao do cenario
     * @param bonus O bonus do cenario
     * @returns A numeracao do cenario cadastrado.
     */
	public int cadastraCenarioBonus(String descricao, int bonus) {
		this.cenarios.add(new CenarioBonus(this.cenarios.size() + 1, descricao, bonus));		
		
		this.caixa -= bonus;
		
		return this.cenarios.size();
	}
	
	/**
     * Verifica se o parametro "cenario" e valido para as
     * operacoes do sistema.
     * 
     * @param cenario A numeracao do cenario
     * @returns void.
     */
	public void validaOperacaoCenario(int cenario) {
		if (cenario < 0) {
			throw new IllegalArgumentException("Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Cenario nao cadastrado");
		}
		if (this.cenarios.get(cenario) == null) {
			throw new IllegalArgumentException("Cenario invalido");
		}
	}
	
	
	/**
     * Resgata e retorna a representa��o textual de um cen�rio do sistema
     * a partir da numera��o passada como par�metro. Al�m disso, lan�a uma
     * exce��o caso exista alguma invalidez no par�metro "cen�rio".
     * 
     * @param cenario A numera��o do cen�rio
     * @returns A representa��o textual de um cen�rio.
     */	
	public String exibeCenario(int cenario) {
		try {
			validaOperacaoCenario(cenario - 1);	
			return this.cenarios.get(cenario - 1).toString();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de cenario: " + e.getMessage());
		}
	}

    /**
     * Não retorna nada, apenas verifica e trata a invalidez da
     * String "ordem" passada como parametro.
     * 
     * @param ordem O criterio de ordem dos cenarios
     * @returns void.
     */
	private void validaOrdem(String ordem) {
		if (ordem.trim().equals("") || ordem.trim() == null) {
			throw new IllegalArgumentException("Ordem nao pode ser vazia ou nula");
		}
	}
	
    /**
     * Não retorna nada, apenas altera o atributo ordenador
     * a partir da ordem passada como parametro.
     * Além disso, verifica e trata a invalidez da
     * String "ordem" passada como parametro.
     * 
     * @param ordem O criterio de ordem dos cenarios
     * @returns void.
     */
	public void alteraOrdemCenarios(String ordem) {
		try {	
			
			validaOrdem(ordem);
			
			validaOperacaoCenario(1);

			if (ordem.toLowerCase().equals("cadastro")) {
				
				this.ordenador = new OrdenaCenarioCadastro();
				
			} else if (ordem.toLowerCase().equals("nome")) {
				
				this.ordenador = new OrdenaCenarioNome();
				
			} else if (ordem.toLowerCase().equals("apostas")) {
	
				this.ordenador = new OrdenaCenarioApostas();
			
			} else {
				
				throw new IllegalArgumentException("Ordem invalida");
				
			}
			
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro ao alterar ordem: " + e.getMessage());
		}
	}
	
    /**
     * Resgata e retorna a representacao em String de
     * um cenario da lista de cenarios ordenados. Alem disso,
     * verifica e trata a invalidez na consulta de um cenario
     * nao cadastrado.
     * 
     * @param cenario A numeracao do cenario
     * @returns a representacao textual de um cenario ordenado.
     */
	public String exibeCenarioOrdenado(int cenario) {
		try {
			
			validaOperacaoCenario(cenario - 1);
			
			List<Cenario> cenariosOrdenados =  new ArrayList<Cenario>();
			
			cenariosOrdenados.addAll(cenarios);
			
			cenariosOrdenados.sort(this.ordenador);
			
			return cenariosOrdenados.get(cenario - 1).toString();
			
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: " + e.getMessage());
		}
	}
	
	/**
     * Resgata e retorna a representa��o textual de todos os cen�rios do sistema.
     * 
     * @returns A representa��o textual de todos os cen�rios do sistema.
     */	
	public String listaCenarios() {	
		String cenariosListados = "";
		
		for (Cenario cenario : this.cenarios) {
			cenariosListados += cenario.toString() + System.lineSeparator();
		}
		
		return cenariosListados;
	}
	
	/**
     * Cadastra uma aposta em algum cenario do sistema a partir da numeracao
     * do cenario, do nome do apostador, do valor da aposta e da previsao
     * passados como parametro. Além disso, verifica e trata a invalidez na
     * consulta de um cenario nao cadastrado e na criacao do objeto aposta.
     * 
     * @param cenario A numeracao do cenario
     * @param apostador O nome do apostador
     * @param valor O valor da aposta
     * @param previsao O palpíte do apostador
     * @returns void.
     */
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		try {		
			
			validaOperacaoCenario(cenario - 1);
			this.cenarios.get(cenario - 1).registraAposta(apostador, valor, previsao);
			
		} catch (NullPointerException e1) {
			throw new NullPointerException("Erro no cadastro de aposta: " + e1.getMessage());
		} catch (IllegalArgumentException e2) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: " + e2.getMessage());
		}
	}
	
	/**
     * Cadastra uma aposta assegurada por valor em algum cenario do sistema
     * a partir da numeracao do cenario, do nome do apostador, do valor da 
     * aposta, da previsao do valor assegurado e do custo da aposta passados
     * como parametro. Além disso, verifica e trata a invalidez na consulta de
     * um cenario nao cadastrado e na criacao do objeto aposta.
     * 
     * @param cenario A numeracao do cenario
     * @param apostador O nome do apostador
     * @param valor O valor da aposta
     * @param previsao O palpíte do apostador
     * @param valorSeguro O valor a ser assegurado
     * @param custo O custo para cadastrar este tipo de aposta
     * @returns O codigo da aposta assegurada.
     */
	public int cadastraApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
		try {
			
			validaOperacaoCenario(cenario - 1);
			this.caixa += custo;
			return this.cenarios.get(cenario - 1).registraApostaSeguraValor(apostador, valor, previsao, valorSeguro);
			
		} catch (NullPointerException e1) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por valor: " + e1.getMessage());
		} catch (IllegalArgumentException e2) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: " + e2.getMessage());
		}
		
	}

	/**
     * Cadastra uma aposta assegurada por taxa em algum cenario do sistema
     * a partir da numeracao do cenario, do nome do apostador, do valor da 
     * aposta, da previsao do valor assegurado e do custo da aposta passados
     * como parametro. Além disso, verifica e trata a invalidez na consulta de
     * um cenario nao cadastrado e na criacao do objeto aposta.
     * 
     * @param cenario A numeracao do cenario
     * @param apostador O nome do apostador
     * @param valor O valor da aposta
     * @param previsao O palpíte do apostador
     * @param taxa A taxa do valor da aposta a ser assegurada
     * @param custo O custo para cadastrar este tipo de aposta
     * @returns O codigo da aposta assegurada.
     */
	public int cadastraApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		try {
			
			validaOperacaoCenario(cenario - 1);
			this.caixa += custo;
			return this.cenarios.get(cenario - 1).registraApostaSeguraTaxa(apostador, valor, previsao, taxa);
			
		} catch (NullPointerException e1) {
			throw new NullPointerException("Erro no cadastro de aposta assegurada por taxa: " + e1.getMessage());
		} catch (IllegalArgumentException e2) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: " + e2.getMessage());
		}
	}

	/**
     * Resgata e retorna o valor total de todas as apostas
     * de algum cenario do sistema a partir da sua numeracao.
     * Além disso, verifica e trata a invalidez na consulta de
     * um cenario nao cadastrado.
     * 
     * @param cenario A numeracao do cenario
     * @returns O valor total das apostas do cenario.
     */	
	public int valorTotalApostas(int cenario) {
		try {
			
			validaOperacaoCenario(cenario - 1);	
			return this.cenarios.get(cenario - 1).valorApostas();
			
		} catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: " + e1.getMessage());
		}
	}

	/**
     * Resgata e retorna a quantidade total de apostas
     * em algum cenario do sistema a partir de sua numeracao.
     * Além disso, verifica e trata a invalidez na consulta de
     * um cenario nao cadastrado.
     * 
     * @param cenario A numeracao do cenario
     * @returns A quantidade total de apostas do cenario.
     */	
	public int quantidadeApostas(int cenario) {
		try {
			
			validaOperacaoCenario(cenario - 1);
			return this.cenarios.get(cenario - 1).getQuantidadeApostas();
			
		} catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: " + e1.getMessage());
		}
	}
	
	/**
     * Resgata e retorna uma String com a representacao textual
     * de todas as apostas (linha a linha) de algum cenario do
     * sistema a partir da sua numeracao. Além disso, verifica e
     * trata a invalidez na consulta de um cenario nao cadastrado.
     * 
     * @param cenario A numeracao do cenario
     * @returns Listagem das representacoes textuais de todas as apostas do cenario.
     */	
	public String listarApostas(int cenario) {
		validaOperacaoCenario(cenario - 1);
		
		return this.cenarios.get(cenario - 1).listaApostas();
	}

    /**
     * Apenas altera o tipo do seguro de uma aposta assegurada
     * de SeguroTaxa para SeguroValor. Além disso, verifica e 
     * trata a invalidez na consulta de um cenario nao cadastrado.
     * 
     * @param cenario A numera��o do cen�rio
     * @param apostaAssegurada O codigo usado para identificacao da aposta
     * @param valor O valor a ser assegurado
     * @returns O codigo de identificacao da aposta.
     */
	public int alteraSeguroValor(int cenario, int apostaAssegurada, int valor) {
		try {
			validaOperacaoCenario(cenario - 1);
			return this.cenarios.get(cenario - 1).alteraApostaSeguroValor(apostaAssegurada, valor);
		} catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na alteração do tipo da aposta: " + e1.getMessage());
		}
	}

    /**
     * Apenas altera o tipo do seguro de uma aposta assegurada
     * de SeguroValor para SeguroTaxa. Além disso, verifica e 
     * trata a invalidez na consulta de um cenario nao cadastrado.
     * 
     * @param cenario A numera��o do cen�rio
     * @param apostaAssegurada O codigo usado para identificacao da aposta
     * @param taxa A taxa do valor da aposta que sera assegurada
     * @returns O codigo de identificacao da aposta.
     */
	public int alteraSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		try {	
			validaOperacaoCenario(cenario - 1);
			return this.cenarios.get(cenario - 1).alteraApostaSeguroTaxa(apostaAssegurada, taxa);
		} catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na alteração do tipo da aposta: " + e1.getMessage());
		}
	}

    /**
     * Finaliza o cenario a partir da sua numeracao passada como
     * parametro, adiciona o lucro do cenario ao caixa do sistema
     * e depois retira do caixa o valor assegurado de todas as apostas
     * asseguradas do cenario. Além disso, verifica e trata a invalidez
     * na consulta de um cenario nao cadastrado.
     * 
     * 
     * @param cenario A numera��o do cen�rio
     * @param ocorreu Valor booleano que determina a ocorrencia do cenario.
     * @returns void.
     */
	public void finalizarCenario(int cenario, boolean ocorreu) {
		try {	
			validaOperacaoCenario(cenario - 1);
			this.cenarios.get(cenario - 1).finalizaCenario(ocorreu);
			this.caixa += this.cenarios.get(cenario - 1).lucroCenario(this.taxa);
			this.caixa -= this.cenarios.get(cenario - 1).totalValorAssegurado();
		} catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro ao fechar aposta: " + e1.getMessage());
		} catch (UnsupportedOperationException e2) {
			throw new IllegalArgumentException("Erro ao fechar aposta: " + e2.getMessage());
		}
	}

    /**
     * Resgata e retorna o valor das apostas perdedoras de algum cenario que será 
     * destinado ao caixa do sistema a partir da sua numeracao. Além disso,
     * verifica e trata a invalidez na consulta de um cenario nao cadastrado.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns O valor das apostas perdedoras do cenario que sera destinado ao caixa do sistema.
     */
	public int getCaixaCenario(int cenario) {
		try {	
			
			validaOperacaoCenario(cenario - 1);
			return this.cenarios.get(cenario - 1).lucroCenario(this.taxa);
		
		} catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: " + e1.getMessage());
		}
	}

    /**
     * Resgata e retorna o valor total do rateio de algum cenario do sistema
     * a partir da sua numeracao. Além disso, verifica e trata a invalidez na
     * consulta de um cenario nao cadastrado.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns O valor das apostas perdedoras do cenario que sera destinado aos vencedores.
     */
	public int getTotalRateioCenario(int cenario) {
		try {
			validaOperacaoCenario(cenario - 1);
			return this.cenarios.get(cenario - 1).getTotalRateio(this.taxa);
		} catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: " + e1.getMessage());
		}
	}

    /**
     * Monta e retorna uma representacao textual do sistema a partir
     * do valor do caixa e da taxa do mesmo respectivamente.
     * 
     * "Caixa: valorCaixa
     *  Taxa: taxa"
     * 
     * @returns A representacao textual do sistema.
     */
	@Override
	public String toString() {
		return "Caixa: " + this.caixa + System.lineSeparator() + "Taxa: " + this.taxa;
	}
	
    /**
     * Calcula e retorna o Hashcode do objeto sistema.
     * 
     * @returns O Hashcode do sistema.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + caixa;
		result = prime * result + ((cenarios == null) ? 0 : cenarios.hashCode());
		long temp;
		temp = Double.doubleToLongBits(taxa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

    /**
     * Analisa se o objeto passado como parametro é
     * igual ao sistema. Para um objeto ser igual ao
     * sistema ele precisa ser da classe Sistema e 
     * possuir caixa, taxa e conjunto de cenarios iguais
     * ao do sistema.
     * 
     * @param obj Objeto a ser comparado com o sistema
     * @returns Um valor booleano indicando se o objeto é ou não igual ao sistema.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		if (caixa != other.caixa)
			return false;
		if (cenarios == null) {
			if (other.cenarios != null)
				return false;
		} else if (!cenarios.equals(other.cenarios))
			return false;
		if (Double.doubleToLongBits(taxa) != Double.doubleToLongBits(other.taxa))
			return false;
		return true;
	}
}

