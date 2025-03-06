import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador{

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        try {
            int parametroUm = lerParametro(terminal, "Digite o primeiro parâmetro:");
            int parametroDois = lerParametro(terminal, "Digite o segundo parâmetro:");

            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

    private static int lerParametro(Scanner terminal, String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return terminal.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                terminal.next(); // Limpa o buffer do scanner
            }
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm >= parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        for (int i = parametroUm + 1; i <= parametroDois; i++) {
            System.out.printf("Imprimindo o número %d%n", i);
        }
    }
}