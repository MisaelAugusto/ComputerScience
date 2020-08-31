import java.util.Scanner;

public class Notas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total = 0, qtdNotas = 0, media = 0, acimaMedia = 0, abaixoMedia = 0;
		
		String notas = "";
		
		while (true) {
			String alunoNota = sc.nextLine();
			
			if (alunoNota.equals("-")) {
				break;
			}
			
			int nota = Integer.parseInt(alunoNota.split(" ")[1]);	
			
			notas += (alunoNota.split(" ")[1]) + " ";
			
			if (nota >= 700) {
				acimaMedia += 1;
			} else {
				abaixoMedia += 1;
			}
			
			total += nota;
			qtdNotas ++;
		
		}
		
		media = total / qtdNotas;
		
		String[] listaNotas = notas.split(" ");
		
		System.out.println("maior: " + MaiorNota(listaNotas));
		System.out.println("menor: " + MenorNota(listaNotas));
		System.out.println("media: " + media);
		System.out.println("acima: " + acimaMedia);
		System.out.println("abaixo: " + abaixoMedia);
		
	}

	private static int MaiorNota(String[] notas) {
		int maiorNota = Integer.parseInt(notas[0]);
		
		for (int i = 0; i < notas.length; i++) {
			int valorNota = Integer.parseInt(notas[i]);
			
			if (valorNota > maiorNota) {
				maiorNota = valorNota;
			}
		}
		return maiorNota;
	}
	
	private static int MenorNota(String[] notas) {
		int menorNota = Integer.parseInt(notas[0]);
		
		for (int i = 0; i < notas.length; i++) {
			int valorNota = Integer.parseInt(notas[i]);
			
			if (valorNota < menorNota) {
				menorNota = valorNota;
			}
		}
		return menorNota;
	}
}
