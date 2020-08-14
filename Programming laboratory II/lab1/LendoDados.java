import java.util.Scanner;

public class LendoDados {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu nome:");

        String nome = sc.nextLine();

        System.out.println("Digite a sua idade:");

        int idade = sc.nextInt();

        System.out.println(nome + " - " + idade);

    }

}
