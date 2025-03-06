import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("--- PROCESSO SELETIVO ---");
        String [] candidatos = {"Giulia", "Fernanda", "Marianne", "Lauren", "Monica"};

        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidado){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");;
        } while(continuarTentando && tentativasRealizadas<3);

        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidado + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidado + ", NUMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");
        }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] candidatos = {"Giulia", "Fernanda", "Marianne", "Lauren", "Monica"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemneto");

        for(int i = 0; i < candidatos.length; i++){
            System.out.println("O candidato de nº " + (i+1) + " é " + candidatos[i]);
        }

        for(String candidato: candidatos){
            System.out.println("O candidato selecionado foi " + candidato );
        }
    }
    static void selecaoCandidatos(){
        String [] candidatos = {"Giulia", "Fernanda", "Marianne", "Lauren", "Monica", "Willians", "Felipe", "Marcio", "Lucas", "Marcelo"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual]; 
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }           
            candidatoAtual++; 
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato!");            
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contraproposta!");              
        } else {
            System.out.println("Aguardando demais candidatos!");            
        }
    }
}
