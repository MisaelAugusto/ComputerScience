/**

* Representação de uma conta de um laboratório da UFCG. Toda conta precisa ter:
* o nome do laboratório, a cota total e a cota atual (quantidade da
* cota já utilizada).
*

* @author Misael Augusto Silva da Costa

*/

public class ContaLaboratorio {
	public String nomeLaboratorio;
	private int cotaTotal = 2000;
	private int cotaAtual = 0;

    /**
    * Constrói uma conta de um laboratório a partir do nome
    * do laboratório.
    *
 
    * @param nome o nome do laboratório
    */
   	
	public ContaLaboratorio(String nome) {
		this.nomeLaboratorio = nome;	
	}

    /**
    * Constrói uma conta de um laboratório a partir do nome
    * do laboratório e da capacidade máxima da cota.
    *

    * @param nome o nome do laboratório
    * @param cota a capacidade máxima da conta 
    */
   	
	public ContaLaboratorio(String nome, int cota) {
		this.nomeLaboratorio = nome;
		this.cotaTotal = cota;
	}

    /**

    * Não retorna nada. Apenas altera o valor da cotaAtual aumentando
	* a quantidade de memória (cota) utilizada, ou seja, consome espaço.

    * @returns void
    */
    	
	public void consomeEspaco(int quantidade) {
		this.cotaAtual += quantidade;
	}

    /**

    * Não retorna nada. Apenas altera o valor da cotaAtual diminuindo
	* a quantidade de memória (cota) utilizada, ou seja, libera espaço.

    * @returns void.
    */
    
	public void liberaEspaco(int quantidade) {
		this.cotaAtual -= quantidade;
	}
	
    /**

    * Verifica se a conta do laboratório atingiu a cota máxima.
	* Se atingiu retorna o valor booleano true, se não retorna
	* o valor booleano false. 

    * @returns um valor booleano.
    */
    
	public boolean atingiuCota() {
		return (this.cotaAtual >= this.cotaTotal);	
	}

    /**

    * Monta uma mensagem com os detalhes do laboratório: nome, cota atual
    * e a cota total.
	
	* "nomeLaboratorio cotaAtual/cotaTotal"

    * @returns os detalhes em String da conta do laboratório.
    */
    	
	public String toString() {
		String mensagem = this.nomeLaboratorio + " " + this.cotaAtual + "/" + this.cotaTotal;
		
		return mensagem;
	}

}
