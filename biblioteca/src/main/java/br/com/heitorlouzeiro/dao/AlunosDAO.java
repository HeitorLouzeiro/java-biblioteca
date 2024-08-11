package br.com.heitorlouzeiro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.heitorlouzeiro.classes.Alunos;
import br.com.heitorlouzeiro.dataBase.DataBase;

public class AlunosDAO {
    private Connection connection;

    public AlunosDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }
    

    public void mostrarAlunos() {
        System.out.println("Mostrando alunos...");

        try{
             Statement statement = connection.createStatement(); // Cria uma instrução SQL

             // Executa uma consulta SQL
             String query = "SELECT * FROM alunos";
             ResultSet resultSet = statement.executeQuery(query);

             // Imprime os resultados
             while (resultSet.next()) {
                 System.out.println("Nome: " + resultSet.getString("nomeAluno"));
             }
             statement.close();
        } catch (Exception e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void cadastrarAluno(Alunos aluno) throws SQLException {
        System.out.println("Cadastrando aluno...");

        PreparedStatement statement = connection
        .prepareStatement("INSERT INTO alunos (nomeAluno, emailAluno, telefone, endereco) VALUES (?, ?, ?, ?)");

        statement.setString(1, aluno.getNomeAluno());
        statement.setString(2, aluno.getEmailAluno());
        statement.setInt(3, aluno.getTelefoneAluno());
        statement.setString(4, aluno.getEnderecoAluno());


        statement.executeUpdate();

        statement.close();
    }

    public void deletarAluno(int idAluno) throws SQLException {
        System.out.println("Deletando aluno...");

        PreparedStatement statement = connection.prepareStatement("DELETE FROM alunos WHERE idAluno = ?");
        statement.setInt(1, idAluno);

        statement.executeUpdate();

        statement.close();
    }

    public void buscarAluno(Alunos alunos) throws SQLException {
        System.out.println("Buscando aluno...");

        try {
            // Executa uma consulta SQL
            String query = "SELECT * FROM alunos WHERE nomeAluno LIKE ?";

            PreparedStatement statement = connection.prepareStatement(query);
            // Adicione o wildcard '%' antes e/ou depois do nome, dependendo do que você quer buscar
            statement.setString(1, "%" + alunos.getNomeAluno() + "%");

            ResultSet resultSet = statement.executeQuery();


            // Imprime os resultados
            while (resultSet.next()) {
                System.out.println("Nome: " + resultSet.getString("nomeAluno"));
            }
            statement.close();



        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

    }

    public void atualizarAluno(Alunos aluno) {
        System.out.println("Atualizando aluno...");

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE alunos SET nomeAluno = ?, emailAluno = ?, telefone = ?, endereco = ? WHERE idAluno = ?");

            statement.setString(1, aluno.getNomeAluno());
            statement.setString(2, aluno.getEmailAluno());
            statement.setInt(3, aluno.getTelefoneAluno());
            statement.setString(4, aluno.getEnderecoAluno());
            statement.setInt(5, aluno.getIdAluno());


            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }
    
}
