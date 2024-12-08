package br.com.rendafixa;

import java.text.DecimalFormat;

public class Calculator {
    // Método para formatar o valor monetário no formato brasileiro
    public String formatarValor(double valor) {
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        return df.format(valor);
    }

    // Método que converte taxa de juros de percentual para decimal
    public double jurosDecimais(double taxaJuros) {
        return taxaJuros / 100;
    }

    public double montanteFinal(double capitalInicial, double taxaJuros, int meses) {
        double montante = capitalInicial * (Math.pow(1 + taxaJuros, meses));  // Cálculo de juros compostos
        return montante;
    }

    // Método para transformar juros anual para mensal
    public double jurosMensal(double percentualAnual) {
        return Math.pow(1 + percentualAnual, 1.0 / 12) - 1;
    }

    // Método para calcular o CDB indexado ao CDI
    public double cdbCdi(double capital, double taxaJurosMensal, int meses) {
        return capital * Math.pow(1 + taxaJurosMensal, meses);
    }

    // Método para calcular a alíquota do IR com base nos meses investidos
    public double calcularAliquotaIR(int meses) {
        if (meses <= 6) {
            return 22.5;
        } else if (meses <= 12) {
            return 20.0;
        } else if (meses <= 24) {
            return 17.5;
        } else {
            return 15.0;
        }
    }

    // Método para calcular o imposto sobre o rendimento do CDB
    public double calcularImpostoCDB(double montante, double capital, int meses) {
        double rendimentoBruto = montante - capital;
        double aliquota = calcularAliquotaIR(meses) / 100;
        return rendimentoBruto * aliquota;
    }


    // Método para Descontar a inflação em Cima do Montante
    public double montanteDescontoInflacao(double montante, double inflacao) {

        return montante / (1 + inflacao);
    }

    // Método para calcular o CDI anual com base na taxa Selic e percentual desejado do CDI
    public double percentualCdi(double selic, double percentualCdi) {
        return jurosDecimais(selic) * (percentualCdi / 100);
    }


        // Método para calcular a inflação acima de 12 meses
        public double inflacaoPeriodo(double montanteLiquido, double inflacao, int periodo) {
            if (periodo == 12) { // 12 meses
                montanteLiquido = montanteLiquido / (1 + inflacao );
                } else if (periodo == 24) { // 24 meses
                montanteLiquido = montanteLiquido / Math.pow((1 + inflacao ), 2);
                } else if (periodo == 36) { // 36 meses
                montanteLiquido = montanteLiquido / Math.pow((1 + inflacao), 3);

                } else if (periodo == 48) {
                montanteLiquido = montanteLiquido / Math.pow((1 + inflacao), 4);

                } else if (periodo == 60) {
                montanteLiquido = montanteLiquido / Math.pow((1 + inflacao), 5);
                }else {
                // Outros períodos podem ser adicionados conforme necessário
                System.out.println("Período não suportado.");
             }
                return montanteLiquido;

            }

            // Método para Calcular o IPCA+
            public double ipcaMais(double taxaNominal,double inflacao){
               double juros = ((1 + taxaNominal ) * (1 + inflacao)) - 1;
               return juros;
            }



        }







