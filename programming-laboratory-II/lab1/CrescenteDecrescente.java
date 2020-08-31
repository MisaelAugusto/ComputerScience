import java.util.Scanner;

public class CrescenteDecrescente {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[4];
		int i, j;
		boolean Stop = false;
		
		for (i = 0; i < 4; i++) {
			numbers[i] = sc.nextInt();
		}

		for (i = 0; i < 4; i ++) {
			for (j = 1; j < 4; j ++) {
				if (i != j && numbers[i] == numbers[j]) {
					System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
					Stop = true;
					break;
				}
			} if (Stop) {
				break;
			}
		}
		
		if (!Stop) {
			if (numbers[3] > numbers[0]) {
				System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
			} else {
				System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
			}	
		}
	}
}
