import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num1 = sc.nextFloat();
		float num2 = sc.nextFloat();
		float media;
		
		media = (num1 + num2) / 2;
		
		if (media < 7) {
			System.out.println("pass: False!");
		} else {
			System.out.println("pass: True!");
		}
	}
}
