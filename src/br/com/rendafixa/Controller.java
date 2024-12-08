package br.com.rendafixa;

public class Controller {
    private final Calculator calculator = new Calculator();

    public void calcularCDB_PRE(double capital, int meses, double taxaJurosAnual, double inflacao) {
        double taxaAnualConvertida = calculator.jurosDecimais(taxaJurosAnual);
        double taxaMensalConvertida = calculator.jurosMensal(taxaAnualConvertida);

        double montante = calculator.montanteFinal(capital, taxaMensalConvertida, meses);
        double imposto = calculator.calcularImpostoCDB(montante, capital, meses);
        double montanteLiquido = montante - imposto;
        double valorReal = calculator.montanteDescontoInflacao(montanteLiquido, calculator.jurosDecimais(inflacao));
        double valorPeriodo = calculator.inflacaoPeriodo(montanteLiquido,calculator.jurosDecimais(inflacao), meses);
        System.out.println("---------------------------------------");
        System.out.println("Montante final bruto : " + calculator.formatarValor(montante) + "     |");
        System.out.println("---------------------------------------");
        System.out.println("Imposto sobre rendimento: " + calculator.formatarValor(imposto));
        System.out.println("Montante final líquido: " + calculator.formatarValor(montanteLiquido));
        System.out.println("Valor Real após Descontos da Inflação e IR 1°Ano : " + calculator.formatarValor(valorReal));
        System.out.println("Valor Real ao Fim do Investimento : " + calculator.formatarValor(valorPeriodo));
    }

    public void calcularCDB_CDI(double capital, double selic, double percentualCdi, int meses, double inflacao) {
        double cdiAnual = calculator.percentualCdi(selic,percentualCdi);
        double taxaCdiMensal = calculator.jurosMensal(cdiAnual);

        double montante = calculator.cdbCdi(capital, taxaCdiMensal, meses);
        double imposto = calculator.calcularImpostoCDB(montante, capital, meses);
        double montanteLiquido = montante - imposto;
        double valorReal = calculator.montanteDescontoInflacao(montanteLiquido, calculator.jurosDecimais(inflacao));
        double valorPeriodo = calculator.inflacaoPeriodo(montanteLiquido,calculator.jurosDecimais(inflacao), meses);
        System.out.println("---------------------------------------");
        System.out.println("Montante final bruto: " + calculator.formatarValor(montante) + "      |");
        System.out.println("---------------------------------------");
        System.out.println("Imposto sobre rendimento: " + calculator.formatarValor(imposto));
        System.out.println("Montante final líquido: " + calculator.formatarValor(montanteLiquido));
        System.out.println("Valor Real após Descontos da Inflação e IR 1°Ano: " + calculator.formatarValor(valorReal));
        System.out.println("Valor Real ao Fim do Investimento : " + calculator.formatarValor(valorPeriodo));
    }

    public void calcularLCI_LCA_CDI(double capital, double selic, double percentualCdi, int meses, double inflacao) {
        double cdiAnual = calculator.percentualCdi(selic,percentualCdi);
        double taxaCdiMensal = calculator.jurosMensal(cdiAnual);

        double montante = calculator.cdbCdi(capital, taxaCdiMensal, meses);
        double valorReal = calculator.montanteDescontoInflacao(montante, calculator.jurosDecimais(inflacao));
        double valorPeriodo = calculator.inflacaoPeriodo(montante,calculator.jurosDecimais(inflacao), meses);
        System.out.println("------------------------------------------");
        System.out.println("Montante final bruto: " + calculator.formatarValor(montante) + "        |");
        System.out.println("------------------------------------------");
        System.out.println("Valor Real após o Desconto da Inflação 1°Ano: " + calculator.formatarValor(valorReal));
        System.out.println("Valor Real ao Fim do Investimento : " + calculator.formatarValor(valorPeriodo));
    }

    public void calcularIPCA(double capital, int meses, double taxaJurosAnual, double inflacao){
        double taxaJurosAnualIpca = calculator.ipcaMais(calculator.jurosDecimais(taxaJurosAnual), calculator.jurosDecimais(inflacao));
        double taxaMensalConvertida = calculator.jurosMensal(taxaJurosAnualIpca);

        double montante = calculator.montanteFinal(capital,taxaMensalConvertida,meses);
        double imposto = calculator.calcularImpostoCDB(montante, capital, meses);
        double montanteLiquido = montante - imposto;
        double valorReal = calculator.montanteDescontoInflacao(montanteLiquido, calculator.jurosDecimais(inflacao));
        double valorPeriodo = calculator.inflacaoPeriodo(montanteLiquido, calculator.jurosDecimais(inflacao), meses);
        System.out.println("-------------------------------------------");
        System.out.println("Montante final bruto : " + calculator.formatarValor(montante) + "        |");
        System.out.println("-------------------------------------------");
        System.out.println("Imposto sobre o rendimento : " + calculator.formatarValor(imposto));
        System.out.println("Valor Real após o Desconto da Inflação 1°Ano: " + calculator.formatarValor(valorReal));
        System.out.println("Valor Real ao Fim do Investimento : " + calculator.formatarValor(valorPeriodo));
    }

    public void calcularLCA_LCI_PRE(double capital, int meses, double taxaJurosAnual,double inflacao){
        double taxaAnualConvertida = calculator.jurosDecimais(taxaJurosAnual);
        double taxaMensalConvertida = calculator.jurosMensal(taxaAnualConvertida);
        double montante = calculator.montanteFinal(capital, taxaMensalConvertida, meses);

        double valorReal = calculator.montanteDescontoInflacao(montante, calculator.jurosDecimais(inflacao));
        double valorPeriodo = calculator.inflacaoPeriodo(montante,calculator.jurosDecimais(inflacao), meses);
        System.out.println("---------------------------------------");
        System.out.println("Montante final bruto : " + calculator.formatarValor(montante) + "     |");
        System.out.println("---------------------------------------");
        System.out.println("Valor Real após Descontos da Inflação e IR 1°Ano : " + calculator.formatarValor(valorReal));
        System.out.println("Valor Real ao Fim do Investimento : " + calculator.formatarValor(valorPeriodo));



    }


}
