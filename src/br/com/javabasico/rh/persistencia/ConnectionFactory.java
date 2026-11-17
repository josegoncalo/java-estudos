package br.com.javabasico.rh.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	public static Connection getConnection() {
        String url = "jdbc:postgresql://postgres-java:5432/rh";/*Coloque o //servidor onde está instalado o banco*/

        String usuario = "javabasico";/*Coloque o usuário criado para acesso ao banco*/
        String senha = "123456";/*Coloque a senha para acesso ao banco*/

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            
        }  catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return con;
    }
    public static void close(Connection con){
        try{
            con.close();
        }catch(SQLException e){            
        }
    }
}
