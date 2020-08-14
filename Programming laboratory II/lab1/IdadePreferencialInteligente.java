package lp2.lab01;

public class IdadePreferencialInteligente {
	public static void main(String[] args) {
		int idade;
		int ano_nascimento = 2000;
		int ano_atual = 2017;
		
		idade = ano_atual - ano_nascimento;
		
		if (idade >= 60) {
			System.out.println("Voce tem " + idade + " anos. Voce pode usar o atendimento especial.");
		} else {
			System.out.println("Voce tem " + idade + " anos. Voce nao pode ainda usar o atendimento especial.");
		}
	}
}
