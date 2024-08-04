package br.com.heitorlouzeiro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.heitorlouzeiro.dataBase.DataBase;

public class FuncionariosDAO {
    private Connection connection;

    public FuncionariosDAO() throws IOException{
        connection = DataBase.getInstance().getConnection();   
    }

    public void mostrarFuncionarios() {
        try {
            Statement statement = connection.createStatement(); // Cria uma instrução SQL

            // Executa uma consulta SQL
            String query = "SELECT * FROM funcionarios";
            ResultSet resultSet = statement.executeQuery(query);

            // Imprime os resultados
            while (resultSet.next()) {
                System.out.println("Nome: " + resultSet.getString("nomeFuncionario"));
                
            }
            statement.close();
            
        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }
}
