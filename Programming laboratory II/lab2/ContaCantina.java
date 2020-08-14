/**

* Representação de uma conta de uma Cantina da UFCG. Toda conta precisa ter:
* o nome da cantina, a quantidade de pedidos, o valor de débito em centavos e
* opcionalmente um array com os detalhes dos pedidos.
*

* @author Misael Augusto Silva da Costa

*/

public class ContaCantina {
	public String nomeCantina;
	private String[] detalhes = new String[5];
	
	private int contaDetalhes = 0;
	private int quantidade = 0;
	private int debitoCentavos = 0;
	
	public ContaCantina(String nome) {
		this.nomeCantina = nome;
	}
	
	public void cadastraLanche(int quantidade, int valor) {
		this.quantidade += quantidade;
		this.debitoCentavos += valor;
	}
	
	public void cadastraLanche(int quantidade, int valor, String detalhes) {
		this.quantidade += quantidade;
		this.debitoCentavos += valor;
		this.detalhes[this.contaDetalhes] = detalhes;
		if (this.contaDetalhes++ > 4) {
			this.contaDetalhes = 0;
			for (int i = 0; i < 4; i ++) {
				this.detalhes[i] = this.detalhes[i + 1];
			}
		} else {
			this.contaDetalhes++;
		}
	}
	
	public String listarDetalhes() {		
		String mensagem = this.detalhes[0] + this.detalhes[1] + this.detalhes[2] + this.detalhes[3] + this.detalhes[4];
		
		return mensagem;
	}
	
	public void pagaConta(int valor) {
		this.debitoCentavos -= valor;
	}
	
	public String toString() {
		String mensagem = this.nomeCantina + " " + this.quantidade + " " + this.debitoCentavos;
		
		return mensagem;
	}
}
