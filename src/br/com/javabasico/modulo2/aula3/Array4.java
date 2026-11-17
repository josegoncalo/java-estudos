package br.com.javabasico.modulo2.aula3;

import java.util.Arrays;

public class Array4 {
    public static void main(String[] args) {
        int[] numeros = new int[5];
        numeros[0] = 40;
        numeros[1] = 30;
        numeros[2] = 26;
        numeros[3] = 56;
        numeros[4] = 10;
        for (byte i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        Arrays.sort(numeros);
        for (byte i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        System.out.println(Arrays.binarySearch(numeros, 40));
        System.out.println(Arrays.binarySearch(numeros, 89));
        int[] numeros1 = new int[6];
        int[] numeros2 = new int[6];
        Arrays.fill(numeros1, 45);
        Arrays.fill(numeros2, 45);
        System.out.println(Arrays.equals(numeros1, numeros2));
    }
}
