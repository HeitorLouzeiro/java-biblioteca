package br.com.heitorlouzeiro.dataBase;

import java.io.IOException; // É usada para tratar exceções de entrada e saída.
import java.sql.Connection; // É usada para estabelecer uma conexão com o banco de dados.
import java.sql.DriverManager; // É usada para carregar o driver do banco de dados.
import java.sql.SQLException; // É usada para tratar exceções de SQL.
import java.sql.Statement; // É usada para executar uma instrução SQL.

public class DataBase {
    private Connection connection = null;
    private static DataBase INSTANCE = null;
    
    private DataBase() throws IOException {
        try {

            connection = DriverManager.getConnection("jdbc:sqlite:biblioteca/sample.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            String sql = FileUltils.loadTextFile("biblioteca/src/main/java/br/com/heitorlouzeiro/resource/description.sql");
            
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.err.println("Error closing database connection");
            e.printStackTrace();
        }
    }

    public static DataBase getInstance() throws IOException {
        // Create a singleton instance of the database
        if (INSTANCE == null) {
            INSTANCE = new DataBase();
        }
        return INSTANCE;
    }
}