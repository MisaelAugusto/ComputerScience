/**

* Representação de uma Disciplina do curso de Ciência da Computação da UFCG.
* Toda Disciplina precisa ter: um nome, o número de horas estudadas e opcionalmente
* o número de provas e os seus respectivos pesos.
* 
*

* @author Misael Augusto Silva da Costa

*/

public class Disciplina {
	public String nomeDisciplina;
	
	private int horas = 0;
	private int numeroProvas = 4;
	private int[] pesos = {1, 1, 1, 1};
	
	private double[] notas = new double[4];
	private double media = 0.0;
	
    /**
    * Constrói uma Disciplina a partir do nome
    * do dela.
    *
 
    * @param nome o nome da disciplina.
    */
    	
	public Disciplina(String nome) {
		this.nomeDisciplina = nome;
	}

    /**
    * Constrói uma Disciplina a partir do nome
    * do dela e do número de provas.
    *
 
    * @param nome o nome da disciplina.
    * @param provas o número de provas.
    */
    	
	public Disciplina(String nome, int provas) {
		this.nomeDisciplina = nome;
		this.numeroProvas = provas;
	}

    /**
    * Constrói uma Disciplina a partir do nome
    * do dela, do número de provas e dos pesos de cada prova.
    *
 
    * @param nome o nome da disciplina.
    * @param provas o número de provas.
    * @param pesos os pesos de cada prova.
    */
    	
	public Disciplina(String nome, int provas, int[] pesos) {
		this.nomeDisciplina = nome;
		this.numeroProvas = provas;
		this.pesos = pesos;
	}
	
    /**

    * Retorna a String que representa o aluno. A representação segue o formato

    * “MATRICULA - Nome do Aluno”.

    *
    * @returns a representação em String de um aluno.
    */
   
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	public boolean aprovado() {	
		int pesoTotal = 0;
		double soma = 0.0;
		
		for (int i = 0; i < this.numeroProvas; i++) {
			soma += (this.notas[i] * this.pesos[i]);
			pesoTotal += this.pesos[i];
		}
		
		this.media = soma / pesoTotal;
		
		return (this.media >= 7.0);
		
	}
	
	public String toString() {
		String mensagemNotas = "[";
		int n = this.numeroProvas - 1;
		
		for (int i = 0; i < n; i++) {
			mensagemNotas += this.notas[i] + ", ";
		}
		
		mensagemNotas += this.notas[n] + "]";
		
		String mensagem = this.nomeDisciplina + " " + this.horas + " " + this.media + " " + mensagemNotas;
		
		return mensagem;
	}
	
}
