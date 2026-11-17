package br.com.javabasico.modulo2.aula4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComandoDoWhile {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(ir);
        String s = "";
        do {
            System.out.println("Digite uma frase (digite sair para parar)");
            s = bf.readLine();
            System.out.println("Frase digitada: " + s);
        } while (!s.toLowerCase().equals("sair"));
    }
}
