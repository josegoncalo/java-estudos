package br.com.javabasico.modulo2.aula4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComandoSwitch {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(ir);
        System.out.print("Digite o conceito (A, B, C, D, E ou F): ");
        char conceito = bf.readLine().charAt(0);
        System.out.print("Digite o valor da mensalidade: ");
        double valor = Double.parseDouble(bf.readLine());
        double desconto = 0.0;
        double mensalidade = 0.0;
        switch (conceito) {
            case 'A':
                mensalidade = valor * 0.5;
                break;
            case 'B':
                mensalidade = valor * 0.6;
                break;
            case 'C':
                mensalidade = valor * 0.7;
                break;
            case 'D':
                mensalidade = valor * 0.8;
                break;
            case 'E':
                mensalidade = valor * 0.9;
                break;
            case 'F':
                mensalidade = valor;
                break;
            default:
                System.out.println("Conceito desconhecido");
        }

        desconto = valor - mensalidade;
        System.out.println("Conceito: " + conceito
                + "\nValor do desconto: " + desconto +
                "\nValor sem desconto: " + valor +
                "\nValor a pagar: " + valor);

    }
}
