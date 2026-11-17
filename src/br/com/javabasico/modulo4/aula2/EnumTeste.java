package br.com.javabasico.modulo4.aula2;

public class EnumTeste {
    public static void main(String[] args) {
        System.out.println(TipoDePessoa.PESSOA_JURIDICA);
        TipoDePessoa tp1 = TipoDePessoa.PESSOA_FISICA;
        TipoDePessoa tp2 = TipoDePessoa.PESSOA_JURIDICA;
        System.out.println(tp1);
        System.out.println(tp1.name());
        System.out.println(tp1.toString());
    }
}
