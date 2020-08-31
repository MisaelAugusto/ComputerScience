/**
* Laboratório de Programação 2 - Lab 1
*
* @author Misael Augusto Silva da Costa - 117110525
*/

import java.util.Scanner;

public class Dobro_e_Triplo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = 2 * X;
		int Z = 3 * X;
		
		System.out.println("dobro: " + Y + ", triplo: " + Z);	
		
	}
}
