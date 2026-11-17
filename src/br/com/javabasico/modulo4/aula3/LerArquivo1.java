
package br.com.javabasico.modulo4.aula3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LerArquivo1 {

    public static void main(String[] args) {

        // Define o caminho do arquivo a partir da raiz do projeto.
        Path caminho = Paths.get("src", "arquivo", "arq1.txt");

        String linha = "";
        BufferedReader arquivo = null;

        try {

            // Abre o arquivo para leitura.
            arquivo = new BufferedReader(
                    new FileReader(caminho.toFile()));

            // Lê o arquivo linha por linha até chegar ao final.
            // readLine() retorna null quando não existem mais linhas.
            while ((linha = arquivo.readLine()) != null) {

                // Exibe a linha lida.
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {

            // Ocorre quando o arquivo não é encontrado no caminho informado.
            System.out.println("Arquivo não encontrado: " + e.getMessage());

        } catch (IOException e) {

            // Trata problemas durante a leitura do arquivo.
            System.out.println("Erro na leitura: " + e.getMessage());

        } finally {

            // Verifica se o arquivo foi aberto antes de tentar fechá-lo.
            if (arquivo != null) {

                try {
                    arquivo.close();

                } catch (IOException e) {
                    System.out.println(
                            "Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }
}
