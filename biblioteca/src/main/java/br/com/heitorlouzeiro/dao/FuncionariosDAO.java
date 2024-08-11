package br.com.heitorlouzeiro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.heitorlouzeiro.classes.Funcionarios;
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

    public void cadastrarFuncionario(Funcionarios funcionario) throws SQLException {
        System.out.println("Inserindo Funcionario...");

        PreparedStatement statement = connection
                .prepareStatement("INSERT INTO funcionarios (nomeFuncionario, emailFuncionario) VALUES (?, ?)");

        statement.setString(1, funcionario.getNomeFuncionario());
        statement.setString(2, funcionario.getEmailFuncionario());

        statement.executeUpdate();

        statement.close();
    }

    public void buscarFuncionario(Funcionarios funcionarios) throws SQLException {
        System.out.println("Buscando Funcionario...");
    
        String query = "SELECT * FROM funcionarios WHERE nomeFuncionario LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
    
        // Adicione o wildcard '%' antes e/ou depois do nome, dependendo do que você quer buscar
        statement.setString(1, "%" + funcionarios.getNomeFuncionario() + "%");
    
        ResultSet resultSet = statement.executeQuery();
    
        while (resultSet.next()) {
            System.out.println("id:"+ resultSet.getInt("idFuncionario") + " Nome: " + resultSet.getString("nomeFuncionario") + " Email: " + resultSet.getString("emailFuncionario"));
        }
       statement.close();
    }
    
    


    public void atualizarFuncionario(Funcionarios funcionario) throws SQLException {
        System.out.println("Atualizando Funcionario...");

        PreparedStatement statement = connection
                .prepareStatement("UPDATE funcionarios SET nomeFuncionario = ?, emailFuncionario = ? WHERE idFuncionario = ?");

        statement.setString(1, funcionario.getNomeFuncionario());
        statement.setString(2, funcionario.getEmailFuncionario());
        statement.setInt(3, funcionario.getIdFuncionario());

        statement.executeUpdate();

        statement.close();
        System.out.println("Funcionario atualizado com sucesso!");
    }

    public void deletarFuncionario(int idFuncionario) throws SQLException {
        System.out.println("Deletando Funcionario...");

        PreparedStatement statement = connection.prepareStatement("DELETE FROM funcionarios WHERE idFuncionario = ?");
        statement.setInt(1, idFuncionario);

        statement.executeUpdate();

        statement.close();

    }

}
