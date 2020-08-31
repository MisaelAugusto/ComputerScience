/**

* Representação do estado de saúde de um aluno do curso de Ciência da 
* Computação da UFCG. Toda estado de saúde deve ser divido em: saúde mental,
* saúde física e opcionalmente um emoji que representa o estado atual
* do aluno.
* 

* @author Misael Augusto Silva da Costa

*/

public class Saude {
	public String saude;
	private String saudeMental;
	private String saudeFisica;
	private String emoji;
	
	public Saude() {
		this.saude = "boa";
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
		this.emoji = "";
	}
	
	public Saude(String Emoji) {
		this.saude = "boa";
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
		this.emoji = Emoji;
	}
	
	public void defineSaudeMental(String saude) {
		this.saudeMental = saude;
		this.emoji = "";
	}
	
	public void defineSaudeFisica(String saude) {
		this.saudeFisica = saude;
		this.emoji = "";
	}
	
	public String geral() {
		if (saudeMental.equals("boa") && saudeMental.equals("boa")) {
			saude = "boa";
		} else if (saudeMental.equals("boa") && saudeMental.equals("fraca")) {
			saude = "ok";
		} else if (saudeMental.equals("fraca") && saudeMental.equals("boa")) {
			saude = "ok";
		} else {
			saude = "fraca";
		}
		
		saude += this.emoji;
		
		return saude;
	}
}
