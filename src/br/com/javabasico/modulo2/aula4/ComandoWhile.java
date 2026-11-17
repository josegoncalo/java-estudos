package br.com.javabasico.modulo2.aula4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ComandoWhile {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(ir);
        System.out.println("Digite uma frase (digite sair para parar)");
        String s = bf.readLine();
        while (!s.toLowerCase().equals("sair")) {
            System.out.println("Frase digitada: " + s);
            s = bf.readLine();
        }
    }
}
