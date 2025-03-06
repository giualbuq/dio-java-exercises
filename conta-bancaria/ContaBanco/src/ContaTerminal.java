import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o número da Numero da conta: ");
        int numero = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite o número da Agência: ");
        String agencia = scanner.nextLine();

        System.out.println("Digite o número do Saldo: ");
        double saldo = scanner.nextDouble();

        System.out.println("Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agência é" + agencia+ ", conta "+ numero + " e seu saldo " + saldo + " já está disponível para saque");
        scanner.close();
    }
}
