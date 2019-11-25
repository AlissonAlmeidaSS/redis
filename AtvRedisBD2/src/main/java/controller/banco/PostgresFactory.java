package controller.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresFactory {

    private static String url;
    private static String usuario;
    private static String senha;

    public PostgresFactory() {
        url = "jdbc:postgresql://localhost:5432/ecommerce";
        usuario = "postgres";
        senha = "nqa5799";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, usuario, senha);
    }
}
