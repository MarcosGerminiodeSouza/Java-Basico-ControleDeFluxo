package candidatura;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoCeletivo {
    public static void main(String[] args) {
        System.out.println();
        String[] candidatos = { "FELIPE", "MARCOS", "LETICIA", "CARLOS", "JOSÉ" };

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

        // analizarCandidato(1900.0);
        // analizarCandidato(2200.0);
        // analizarCandidato(2000.0);
        // selecaoCandidatos();
        // imprimirSelecionados();
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true, atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) {
                if (tentativasRealizadas < 3)
                    tentativasRealizadas++;
                else
                    break;
            }
        } while (continuarTentando && tentativasRealizadas <= 3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "ª TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS REALIZADAS: " + tentativasRealizadas);
    }

    // auxiliar
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = { "FELIPE", "MARCOS", "LETICIA", "CARLOS", "JOSÉ" };

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento:");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n°" + (indice + 1) + " é o " + candidatos[indice]);

            if ((indice + 1) == candidatos.length)
                System.out.println();

        }

        System.out.println("Forma abreviada de interação for each:");

        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String pessoas = "FELIPE, MARCOS, LETICIA, CARLOS, JOSÉ, ANDRÉ, MARCELO, GABRIELA, MAURICIO, REGINA, JESSICA, CAIO, MURILO, MARLUCE, MICHELE";
        String[] candidatos = pessoas.split(", ");
        int candidatosSelecionados = 0, candidatoAtual = 0;
        double salarioBase = 2000.0;

        DecimalFormat d = new DecimalFormat("R$ #,##0.00");

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println(
                    "O candidato " + candidato + " solicitou este valor de salário " + d.format(salarioPretendido));

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }

            candidatoAtual++;
        }

        // System.out.println("TOTAL DE CANDIDATOS: " + candidatos.length);
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analizarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
