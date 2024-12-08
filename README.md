Simulador de Renda Fixa
Este é um projeto em Java que permite calcular o retorno de diferentes investimentos de renda fixa, incluindo CDB (Pré e atrelado ao CDI), LCI/LCA (Pré e atrelado ao CDI) e IPCA+. O simulador leva em consideração impostos e inflação para apresentar valores reais ao final do investimento.
Funcionalidades
CDB-PRÉ: Calcula o montante bruto, líquido e real de um CDB com taxa pré-fixada.
CDB CDI: Calcula o montante bruto, líquido e real de um CDB atrelado ao CDI.
LCI/LCA CDI: Calcula o montante bruto e real de LCI ou LCA atrelado ao CDI (isento de IR).
LCI/LCA PRÉ: Calcula o montante bruto e real de LCI ou LCA com taxa pré-fixada (isento de IR).
IPCA+: Calcula o rendimento de um título atrelado ao IPCA (inflação) com taxa nominal fixa, considerando impostos e inflação.
Estrutura do Projeto
br.com.rendafixa.Calculator: Contém os métodos matemáticos necessários para cálculos de juros, impostos e inflação.
br.com.rendafixa.Controller: Centraliza as operações e cálculos para cada tipo de investimento.
br.com.rendafixa.Menu: Gerencia o menu interativo do simulador, permitindo a entrada de dados do usuário.
br.com.rendafixa.Main: Classe principal que inicializa o simulador.
Como Executar
Pré-requisitos
Java JDK 8 ou superior instalado.
Um IDE (IntelliJ IDEA, Eclipse, etc.) ou um terminal configurado para compilar e executar arquivos .java.
