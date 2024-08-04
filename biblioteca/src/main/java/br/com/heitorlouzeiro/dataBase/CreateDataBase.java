package br.com.heitorlouzeiro.dataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {
        public static void main(String[] args) throws IOException {
        Connection connection = null;
    
    try {
            // Obtém uma conexão com o banco de dados
            connection = DataBase.getInstance().getConnection();
            Statement statement = connection.createStatement(); // Cria uma instrução SQL

            // Executa uma consulta SQL
            ResultSet rs = statement.executeQuery("SELECT * FROM funcionarios");

            // Imprime os resultados
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("nomeFuncionario"));
                // Adicione mais campos conforme necessário
            }
        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        } finally {
            // Fecha a conexão com o banco de dados, mesmo se ocorrer uma exceção.
            DataBase.getInstance().closeConnection();
        }
    
    }
    
    
}
