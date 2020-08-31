import java.util.Scanner;

public class Calculadora {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String operation = sc.nextLine();
		double result;
		
		if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
			System.out.println("ERRO");
		} else {
			double number_1 = sc.nextDouble();
			double number_2 = sc.nextDouble();
			
			if (operation.equals("+")) {
				result = number_1 + number_2;
			} else if (operation.equals("-")) {
				result = number_1 - number_2;
			} else if (operation.equals("*")) {
				result = number_1 * number_2;
			} else if (operation.equals("/")) {
				if (number_2 == 0) {
					System.out.println("ERRO");
				} else {
					result = number_1 / number_2;
				}
			}
			
		System.out.println(result);
		
		}
	}
}

				
		
	
			
		
		
