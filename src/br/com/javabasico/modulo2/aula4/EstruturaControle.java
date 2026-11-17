package br.com.javabasico.modulo2.aula4;

public class EstruturaControle {
    public static void main(String[] args) {
        int idade = 18;
        char sexo = 'F';
        if (idade >= 18 && sexo == 'M') {
            System.out.println("Você precisa servir ao exército");
        } else if (idade >= 18) {
            System.out.println("Maior de idade e sexo feminino");
        } else {
            System.out.println("Menor de idade");
        }
        char conceito = 'B';
        double valor = 500.0;
        if (conceito == 'A') {
            valor = valor * 0.5;
        } else if (conceito == 'B') {
            valor = valor * 0.6;
        } else if (conceito == 'C') {
            valor = valor * 0.7;
        } else if (conceito == 'D') {
            valor = valor * 0.8;
        } else if (conceito == 'E') {
            valor = valor * 0.9;
        } else {
            valor = valor;
        }
        System.out.println("Valor da mensalidade: " + valor);

    }
}
