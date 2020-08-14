package lab5;

import easyaccept.EasyAccept;

/**
 * Representa��o de uma fachada para o sistema de apostas.
 * Toda fachada deve possuir um sistema no qual ela trabalha
 * delegando suas tarefas.
 *
 * @author Misael Augusto Silva da Costa
 */
public class Facade {
	
	private Sistema sistema;
	
    /**
     * N�o retorna nada. Apenas carrega e executa os arquivos de teste do
     * EasyAccept.
     *
     * @returns void.
     */
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "acceptance_tst/us1_test.txt", "acceptance_tst/us2_test.txt", "acceptance_tst/us3_test.txt", "acceptance_tst/us4_test.txt",
							 "acceptance_tst/us5_test.txt", "acceptance_tst/us6_test.txt", "acceptance_tst/us7_test.txt"};
		EasyAccept.main(args);
	}

    /**
     * N�o retorna nada. Apenas cria o sistema no qual
     * a fachada irá operar.
     * 
     * @param caixa O caixa do sistema
     * @param taxa A taxa do sistema
     * @returns void.
     */
    public void inicializa(int caixa, double taxa) {
    	sistema = new Sistema(caixa, taxa);
    }
 
    /**
     * Resgata e retorna o valor atual do caixa do sistema.
     * 
     * @returns o valor atual do caixa (em centavos) do sistema.
     */
    public int getCaixa() {
    	return this.sistema.getCaixa();
    }

    /**
     * Adiciona um cen�rio ao sistema.
     * 
     * @param descricao A descri��o do cen�rio a ser adicionado
     * @returns a numera��o do cen�rio cadastrado.
     */
    public int cadastrarCenario(String descricao) {
    	return this.sistema.cadastraCenario(descricao);
    }

    /**
     * Adiciona um cen�rio bonificado ao sistema.
     * 
     * @param descricao A descri��o do cen�rio a ser adicionado
     * @param bonus O bonus do cenario
     * @returns a numera��o do cen�rio cadastrado.
     */
    public int cadastrarCenario(String descricao, int bonus) {
    	return this.sistema.cadastraCenarioBonus(descricao, bonus);
    }
    
    /**
     * Resgata e retorna a representa��o em String de
     * um cen�rio.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns a representa��o textual de um cen�rio.
     */
    public String exibirCenario(int cenario) {
    	return this.sistema.exibeCenario(cenario);
    }

    /**
     * Resgata e retorna a representa��o em String de
     * todos os cen�rios.
     * 
     * @returns a representa��o textual de todos os cen�rios do sistema.
     */
    public String exibirCenarios() {
    	return this.sistema.listaCenarios();
    }

    /**
     * N�o retorna nada. Apenas adiciona, a partir da numera��o do
     * cen�rio, uma aposta a um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @param apostador O nome do apostador
     * @param valor O valor da aposta
     * @param previsao A previs�o da aposta
     * @returns void.
     */
    public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
    	this.sistema.cadastraAposta(cenario, apostador, valor, previsao);
    }
    
    /**
     * N�o retorna nada. Apenas adiciona, a partir da numera��o do
     * cen�rio, uma aposta assegurada por valor a um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @param apostador O nome do apostador
     * @param valor O valor da aposta
     * @param previsao A previs�o da aposta
     * @param valorSeguro O valor a ser assegurado
     * @param custo O custo para cadastrar este tipo de aposta
     * @returns O codigo de identificacao da aposta.
     */   
    public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
    	return this.sistema.cadastraApostaSeguraValor(cenario, apostador, valor, previsao, valorSeguro, custo);
    }
   
    /**
     * N�o retorna nada. Apenas adiciona, a partir da numera��o do
     * cen�rio, uma aposta assegurada por taxa a um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @param apostador O nome do apostador
     * @param valor O valor da aposta
     * @param previsao A previs�o da aposta
     * @param taxa A taxa do valor da aposta que sera assegurada
     * @param custo O custo para cadastrar este tipo de aposta
     * @returns O codigo de identificacao da aposta.
     */   
    public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
    	return this.sistema.cadastraApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
    }
 
    /**
     * Apenas altera o tipo do seguro de uma aposta assegurada
     * de SeguroTaxa para SeguroValor.
     * 
     * @param cenario A numera��o do cen�rio
     * @param apostaAssegurada O codigo usado para identificacao da aposta
     * @param valor O valor a ser assegurado
     * @returns O codigo de identificacao da aposta.
     */
    public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
    	return this.sistema.alteraSeguroValor(cenario, apostaAssegurada, valor);
    }

    /**
     * Altera o tipo do seguro de uma aposta assegurada
     * de SeguroValor para SeguroTaxa.
     * 
     * @param cenario A numera��o do cen�rio
     * @param apostaAssegurada O codigo usado para identificacao da aposta
     * @param taxa A taxa do valor da aposta que sera assegurada
     * @returns O codigo de identificacao da aposta.
     */
    public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
    	return this.sistema.alteraSeguroTaxa(cenario, apostaAssegurada, taxa);
    }
    
    /**
     * Resgata e retorna, a partir da numera��o do cen�rio, o valor total
     * de todas as apostas de um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns o valor total de todas as apostas de um cen�rio do sistema.
     */
    public int valorTotalDeApostas(int cenario) {
    	return this.sistema.valorTotalApostas(cenario);
    }

    /**
     * Resgata e retorna, a partir da numera��o do cen�rio, a quantidade de
     * apostas cadastradas de um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns a quantidade de apostas cadastradas em um cen�rio do sistema.
     */
    public int totalDeApostas(int cenario) {
    	return this.sistema.quantidadeApostas(cenario);
    }

    /**
     * Resgata e retorna, a partir da numera��o do cen�rio, uma representa��o
     * em String de todas as apostas de um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns a representa��o textutal de todas as apostas de um cen�rio do sistema.
     */
    public String exibeApostas(int cenario) {
    	return this.sistema.listarApostas(cenario);
    }
    
    /**
     * N�o retorna nada. Apenas altera, a partir da numera��o do
     * cen�rio, o estado de um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @param ocorreu Valor booleano que determina se o cen�rio ocorreu ou n�o
     * @returns void.
     */
    public void fecharAposta(int cenario, boolean ocorreu) {
    	this.sistema.finalizarCenario(cenario, ocorreu);
    }

    /**
     * Resgata e retorna, a partir da numera��o do cen�rio, o valor
     * em cetavos do cen�rio que ser� adicionado ao caixa do sistema
     * de acordo com a taxa do mesmo.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns o valor (em centavos) do cen�rio que ser� destinado para o caixa do sistema.
     */
    public int getCaixaCenario(int cenario) {
    	return this.sistema.getCaixaCenario(cenario);
    }

    /**
     * Resgata e retorna, a partir da numera��o do cen�rio, o valor
     * em cetavos do cen�rio que ser� distribuido igualmente para
     * todos os participantes de um cen�rio do sistema.
     * 
     * @param cenario A numera��o do cen�rio
     * @returns o valor (em centavos) do cen�rio que ser� distribuido para os vencedores da aposta.
     */
    public int getTotalRateioCenario(int cenario) {
    	return this.sistema.getTotalRateioCenario(cenario);
    }
    
    /**
     * Não retorna nada, apenas altera a ordem dos cenarios
     * do sistema a partir do criterio de ordem passado como
     * parametro.
     * 
     * @param ordem O criterio de ordem dos cenarios
     * @returns void.
     */
    public void alterarOrdem(String ordem) {
    	this.sistema.alteraOrdemCenarios(ordem);
    }
    
    /**
     * Resgata e retorna a representacao em String de
     * um cenario da lista de cenarios ordenados.
     * 
     * @param cenario A numeracao do cenario
     * @returns a representacao textual de um cenario ordenado.
     */
    public String exibirCenarioOrdenado(int cenario) {
    	return this.sistema.exibeCenarioOrdenado(cenario);
    }
}
