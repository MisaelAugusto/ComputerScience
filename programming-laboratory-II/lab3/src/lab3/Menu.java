package lab3;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			imprimeMenu();
			
			String operacao = sc.nextLine().toUpperCase();
			
			if (operacao == "S") {	
				break;
			} else {
				selecionaOperacao(sc, agenda, operacao);
			}
		}
		
		
	}
	
	public static void imprimeMenu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air");
		System.out.println("");
		System.out.print("Opção> ");
	}
	
	public static void selecionaOperacao(Scanner sc, Agenda agenda, String operacao) {
		switch (operacao) {
			case "C":
				System.out.println("Posição: ");
				int posicao = sc.nextInt();

				System.out.println("Nome: ");
				String nome = sc.nextLine();

				System.out.println("Sobrenome: ");
				String sobrenome = sc.nextLine();
				
				System.out.println("Telefone: ");
				String telefone = sc.nextLine();
				
				if (posicao >= 1 && posicao <= 100) {
					agenda.cadastraContato(posicao, nome, sobrenome, telefone);
				} else {
					System.out.println("POSIÇÃO INVÁLIDA!");
				}
				
				break;
			case "L":
				break;
			case "E":
				System.out.print("Contato> ");
				int posicaoContato = sc.nextInt();
				
				agenda.exibirContato(posicaoContato);
				break;
			default:
				System.out.println("OPERAÇÃO INVÁLIDA!");
		
		}
	}	
}
