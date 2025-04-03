import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BANCO XYZ ---");
        System.out.print("Digite um valor inicial para abrir sua conta: ");
        double saldo = scanner.nextDouble();

        double limiteChequeEspecial = saldo <= 500 ? 50 : saldo * 0.5;
        double chequeEspecial = limiteChequeEspecial;
        double taxaChequeEspecial = 0.2; // 20% sobre o valor usado do cheque especial

        ContaBancaria conta1 = new ContaBancaria(saldo, chequeEspecial, limiteChequeEspecial, taxaChequeEspecial);

        System.out.println("Conta criada com sucesso!");
        System.out.println("Seu saldo atual é de R$" + conta1.getSaldo());
        System.out.println("Seu cheque especial disponível é de R$" + conta1.getChequeEspecial());
        System.out.println("");

        int op;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar Dinheiro");
            System.out.println("4 - Sacar Dinheiro");
            System.out.println("5 - Pagar Boleto");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Seu saldo atual é: R$" + conta1.consultarSaldo());
                    break;
                case 2:
                    System.out.println("O Cheque Especial disponível é: R$" + conta1.consultarChequeEspecial());
                    break;
                case 3:
                    System.out.print("Digite o valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta1.depositar(valorDeposito);
                    System.out.println("Valor depositado com sucesso! Saldo Atual: R$" + conta1.consultarSaldo());
                    break;
                case 4:
                    System.out.print("Digite o valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta1.sacar(valorSaque);
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto: ");
                    double valorBoleto = scanner.nextDouble();
                    conta1.pagarBoleto(valorBoleto);
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            } 
        } while (op != 6);  
        
        scanner.close();
    }
}
