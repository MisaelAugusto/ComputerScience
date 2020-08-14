import java.util.Scanner;

public class NomeNovo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tamanho, tamanhoLista;
		String nome;
		Boolean notFound = true;
		
		while (notFound) {
			String nomes = sc.nextLine();
			String[] listaNomes = nomes.split(" ");
			
			tamanhoLista = listaNomes.length - 1;
			
			nome = "?";
			
			for (int i = tamanhoLista; i > -1; i--) {
				tamanho = listaNomes[i].length();
				if (tamanho == 5 && !(listaNomes[i].equals("wally"))) {
					nome = listaNomes[i];
					break;
				} 
				
				if (listaNomes[i].equals("wally")) {
					notFound = false;
					break;
				}
			
			}
		
			if (notFound) {
				System.out.println(nome);
			}		
		}
	}
}
