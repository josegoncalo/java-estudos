package br.com.javabasico.modulo1.aula5;

import java.util.Scanner;

import br.com.javabasico.modulo1.util.DataPadraoBrasil;

public class Aluno {
    Integer matricula;
    String nome;
    DataPadraoBrasil dataDeNascimento;

    public Aluno(int matricula, String nome,
            DataPadraoBrasil dataDeNascimento) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }
    public static void main(String[] args) {
        // System.in indica leitura do teclado
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite a matrícula: ");
        int matriculaLida = leitor.nextInt();
        System.out.print("Digite o nome: ");
        String nomeLido = leitor.next();
        // Só para fins didáticos, isto será melhorado mais para frente
        System.out.print("Digite o dia do nascimento: ");
        String dia = leitor.next();
        System.out.print("Digite o mês do nascimento: ");
        String mes = leitor.next();
        System.out.print("Digite o ano do nascimento: ");
        String ano = leitor.next();
        leitor.close();
    }
}
