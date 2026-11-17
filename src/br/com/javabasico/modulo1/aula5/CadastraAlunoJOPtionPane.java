package br.com.javabasico.modulo1.aula5;

import javax.swing.JOptionPane;

import br.com.javabasico.modulo1.util.DataPadraoBrasil;

public class CadastraAlunoJOPtionPane {
    public static void main(String[] args) {
        String matricula = JOptionPane.showInputDialog("Digite a matrícula");
        String nome = JOptionPane.showInputDialog("Digite o nome");
        // Só para fins didáticos, isto será melhorado mais para frente
        String dia = JOptionPane.showInputDialog("Digite o dia do nascimento");
        String mes = JOptionPane.showInputDialog("Digite o mês do nascimento");
        String ano = JOptionPane.showInputDialog("Digite o ano do nascimento");
        DataPadraoBrasil dataDeNascimento = new DataPadraoBrasil(dia, mes, ano);
        Aluno aluno = new Aluno(Integer.parseInt(matricula), nome, dataDeNascimento);
    }

}
