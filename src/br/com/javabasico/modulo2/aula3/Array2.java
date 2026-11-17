package br.com.javabasico.modulo2.aula3;

public class Array2 {
    public static void main(String[] args) {
        // Array de tipos primitivos
        int[] numeros = { 10, 20, 30, 40, 50 };

        // Array de objetos Integer
        Integer[] numerosInteger = { 100, 200, 300 };

        // Array de objetos String
        String[] nomes = { "João", "Maria", "Pedro", "Ana" };

        // Array de objetos Curso
        Curso[] listaDeCursos = new Curso[6];

        listaDeCursos[0] = new Curso();
        listaDeCursos[0].codigo = 1;
        listaDeCursos[0].descricao = "Java Básico";
        listaDeCursos[0].cargaHoraria = 40;

        listaDeCursos[1] = new Curso();
        listaDeCursos[1].codigo = 2;
        listaDeCursos[1].descricao = "Banco de Dados";
        listaDeCursos[1].cargaHoraria = 30;

        listaDeCursos[2] = new Curso();
        listaDeCursos[2].codigo = 3;
        listaDeCursos[2].descricao = "Python Básico";
        listaDeCursos[2].cargaHoraria = 35;

        // Percorrendo o array de inteiros
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Percorrendo o array Integer
        for (Integer numero : numerosInteger) {
            System.out.println(numero);
        }

        // Percorrendo o array de Strings
        for (String nome : nomes) {
            System.out.println(nome);
        }

        // Percorrendo o array de objetos Curso
        for (int i = 0; i < listaDeCursos.length; i++) {

            if (listaDeCursos[i] != null) {
                System.out.println("Código: " + listaDeCursos[i].codigo);
                System.out.println("Descrição: " + listaDeCursos[i].descricao);
                System.out.println("Carga horária: " + listaDeCursos[i].cargaHoraria);
                System.out.println("-------------------------");
            }
        }

        for (Curso c : listaDeCursos) {
            if (c != null) {
                System.out.println(c.codigo);
                System.out.println(c.descricao);
                System.out.println(c.cargaHoraria);
            }

        }

        for (String s : nomes) {
            System.out.println(s);
        }

    }
}
