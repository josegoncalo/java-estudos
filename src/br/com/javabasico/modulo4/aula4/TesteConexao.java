package br.com.javabasico.modulo4.aula4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://postgres-java:5432/rh";

        String usuario = "javabasico";
        String senha = "123456";

        Connection con = null;

        try (Connection conexao =
                DriverManager.getConnection(url, usuario, senha)) {

            System.out.println("Conexão realizada com sucesso!");

            System.out.println(
                "Banco conectado: " +
                conexao.getCatalog()
            );

        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
