package br.com.javabasico.modulo4.aula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GravaArquivo1 {

    public static void main(String[] args) throws IOException {

        // Define o caminho do arquivo dentro da pasta src/arquivo
        File f = new File("src/arquivo/arq2.txt");

        // Cria o arquivo e abre o fluxo de saída
        FileOutputStream fos = new FileOutputStream(f);

        // Prepara a leitura dos dados digitados pelo usuário
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String novaLinha = System.lineSeparator();

        System.out.println("Digite um texto ($ para sair)");

        String texto = bf.readLine();

        // Continua gravando enquanto o usuário não digitar $
        while (!texto.equals("$")) {

            // Grava o texto no arquivo
            fos.write(texto.getBytes());

            // Grava uma quebra de linha
            fos.write(novaLinha.getBytes());

            texto = bf.readLine();
        }

        // Fecha o fluxo de saída
        fos.close();

        System.out.println("Arquivo gravado com sucesso!");
    }
}