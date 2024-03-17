package controle_fluxo;

import java.util.Scanner;

public class contador {
    public static void main(String[] args) {

        Scanner terminal = new Scanner(System.in);
        int parametroUm = 0, parametroDois = 0;
        boolean valorLido = false;

        while (!valorLido) {
            try {
                System.out.println("Digite um número:");
                parametroUm = Integer.parseInt(terminal.nextLine());

                System.out.println("Entre com o segundo número:");
                parametroDois = Integer.parseInt(terminal.nextLine());

                contar(parametroUm, parametroDois);

                valorLido = true;

                terminal.close();

            } catch (ParametrosInvalidosException e) {
                System.out.println(e);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {

        if (parametroUm == parametroDois)
            throw new ParametrosInvalidosException();
        if (parametroUm > parametroDois)
            throw new ParametrosInvalidosException();
        if (parametroUm < 0 || parametroDois < 0)
            throw new ParametrosInvalidosException("Por favor, vite valores negativos");

        int contagem = parametroDois - parametroUm;

        if (contagem > 250)
            throw new ParametrosInvalidosException("Evite que a contagem se estenda excessiva. Contagem = " + contagem);

        for (int i = 1; i <= contagem; i++) {
            System.out.print(i + " ");
        }
    }
}
