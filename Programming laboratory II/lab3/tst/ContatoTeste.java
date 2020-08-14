package lab3;

public class ContatoTeste {
	public static void main(String[] args) {
		Contato contato1 = new Contato("Misael", "Augusto", "(83) - 986084917");
		Contato contato2 = new Contato("Misael", "Augusto", "(83) - 333333333");
		
		System.out.println(contato1.equals(contato2));
		
	}
}
