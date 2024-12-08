package br.com.rendafixa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner teclado = new Scanner(System.in);
    private final Controller controller = new Controller();

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 6) {
            try {
                System.out.println("\n--- # Bem-Vindo ao Calculador de Renda Fixa # ---");
                System.out.println("1 - Calcular CDB-PRÉ");
                System.out.println("2 - Calcular CDB atrelado ao [CDI]");
                System.out.println("3 - Calcular LCI/LCA [CDI] : ");
                System.out.println("4 - Calcular IPCA  [+]: ");
                System.out.println("5 - Calcular LCI/LCA [PRÉ]");
                System.out.println("6 - Sair : ");
                System.out.print("Escolha uma Opção: ");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1 :
                        calcularCDB_PRE();
                        break;
                    case 2 :
                        calcularCDB_CDI();
                        break;
                    case 3 :
                        calcularLCI_LCA_CDI();
                        break;
                    case 4 :
                        calcularIPCA();
                        break;
                    case 5 :
                        calcularLCA_LCI_PRE();
                        break;
                    case 6 :
                        System.out.println("Saindo.../");
                        break;
                    default:
                        System.out.println("ERRO: Digite um valor válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Tente novamente!");
                teclado.nextLine();
            }
        }
        teclado.close();
    }

    private void calcularCDB_PRE() {
        System.out.print("Digite o valor do capital: ");
        double capital = teclado.nextDouble();
        System.out.print("Digite a quantidade de meses: ");
        int meses = teclado.nextInt();
        System.out.print("Digite a taxa de juros anual (%): ");
        double taxaJurosAnual = teclado.nextDouble();
        System.out.print("Digite a inflação acumulada dos últimos 12 meses: ");
        double inflacao = teclado.nextDouble();

        controller.calcularCDB_PRE(capital, meses, taxaJurosAnual, inflacao);
    }

    private void calcularCDB_CDI() {
        System.out.print("Digite o valor do capital: ");
        double capital = teclado.nextDouble();
        System.out.print("Digite a taxa Selic (%): ");
        double selic = teclado.nextDouble();
        System.out.print("Digite o percentual do CDI (%): ");
        double percentualCdi = teclado.nextDouble();
        System.out.print("Digite a quantidade de meses: ");
        int meses = teclado.nextInt();
        System.out.print("Digite a inflação acumulada dos últimos 12 meses: ");
        double inflacao = teclado.nextDouble();

        controller.calcularCDB_CDI(capital, selic, percentualCdi, meses, inflacao);
    }

    private void calcularLCI_LCA_CDI() {
        System.out.print("Digite o valor do Capital : ");
        double capital = teclado.nextDouble();
        System.out.print("Digite a Taxa Selic (%) : ");
        double selic = teclado.nextDouble();
        System.out.print("Digite o percentual do CDI (%) : ");
        double percentualCdi = teclado.nextDouble();
        System.out.print("Digite a quantidade de Meses : ");
        int meses = teclado.nextInt();
        System.out.print("Digite a Inflação acumulada dos últimos 12 meses : ");
        double inflacao = teclado.nextDouble();

        controller.calcularLCI_LCA_CDI(capital, selic, percentualCdi, meses, inflacao);
    }

    private void calcularIPCA(){
        System.out.print("Digite o valor do capital : ");
        double capital = teclado.nextDouble();
        System.out.print("Digite o valor do Juros anual IPCA +(?) : ");
        double taxaJuros = teclado.nextDouble();
        System.out.print("Digite a inflação acumulada nos últimos 12 meses : ");
        double inflacao = teclado.nextDouble();
        System.out.print("Digite a quantidade de Meses : ");
        int meses = teclado.nextInt();
        controller.calcularIPCA(capital,meses,taxaJuros,inflacao);
    }

    private void calcularLCA_LCI_PRE(){
        System.out.print("Digite o valor do capital: ");
        double capital = teclado.nextDouble();
        System.out.print("Digite a quantidade de meses: ");
        int meses = teclado.nextInt();
        System.out.print("Digite a taxa de juros anual (%): ");
        double taxaJurosAnual = teclado.nextDouble();
        System.out.print("Digite a inflação acumulada dos últimos 12 meses: ");
        double inflacao = teclado.nextDouble();
        controller.calcularLCA_LCI_PRE(capital,meses,taxaJurosAnual,inflacao);

    }
}
