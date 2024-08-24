package br.com.heitorlouzeiro.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.*;

import br.com.heitorlouzeiro.classes.Emprestimos;
import br.com.heitorlouzeiro.dataBase.DataBase;

public class EmprestimosDAO {
    private Connection connection;

    public EmprestimosDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    /* 
     * Status do emprestimo:
     * 0 - Devolvido
     * 1 - Emprestado
     */
    public void mostrarEmprestimos() {
        System.out.println("Mostrando emprestimos...");

        try {
            Statement statement = connection.createStatement(); // Cria uma instrução SQL

            // Executa uma consulta SQL
            String query = "SELECT * FROM emprestimos INNER JOIN alunos ON emprestimos.idAluno = alunos.idAluno INNER JOIN livros ON emprestimos.idLivro = livros.idLivro";
            ResultSet resultSet = statement.executeQuery(query);

            // Imprime os resultados
            while (resultSet.next()) {
                System.out.println("Nome do aluno: " + resultSet.getString("nomeAluno"));
                System.out.println("Nome do livro: " + resultSet.getString("tituloLivro"));
                System.out.println("Data de emprestimo: " + resultSet.getString("dataEmprestimo"));
                System.out.println("Data de devolucao: " + resultSet.getString("dataDevolucao"));
                String status = resultSet.getInt("devolvido") == 0 ? "Devolvido" : "Emprestado";
                System.out.println("Status: " + status);
                System.out.println("-------------------------------");

            }
            statement.close();
        } catch (Exception e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void cadastrarEmprestimo(Emprestimos emprestimo) throws SQLException {
        System.out.println("Cadastrando emprestimo...");

        DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
    
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO emprestimos (idAluno, idLivro, dataEmprestimo, devolvido) VALUES (?, ?, ?, ?)");
    
        statement.setInt(1, emprestimo.getIdAluno());
        statement.setInt(2, emprestimo.getIdLivro());
        statement.setString(3, dateTimeString);
        statement.setInt(4, 1);
        statement.executeUpdate();
        statement.close();
    }

    public void deletarEmprestimo(int idEmprestimo) throws SQLException {
        System.out.println("Deletando emprestimo...");
        PreparedStatement statement = connection
                .prepareStatement("DELETE FROM emprestimos WHERE idEmprestimo = ?");

        statement.setInt(1, idEmprestimo);
        statement.executeUpdate();

        statement.close();
    }

    public void buscarEmprestimo(Emprestimos emprestimo) {
        try {
            // Consulta SQL para buscar por nome do aluno ou nome do livro
            String sql = "SELECT * FROM emprestimos " +
                         "INNER JOIN alunos ON emprestimos.idAluno = alunos.idAluno " +
                         "INNER JOIN livros ON emprestimos.idLivro = livros.idLivro " +
                         "WHERE alunos.nomeAluno LIKE ? OR livros.tituloLivro LIKE ?";
    
            PreparedStatement statement = connection.prepareStatement(sql);
    
            // Definindo os parâmetros da consulta para buscar pelo nome do aluno ou nome do livro
            statement.setString(1, "%" + emprestimo.getNomeAluno() + "%");
            statement.setString(2, "%" + emprestimo.getTituloLivro() + "%");
    
            ResultSet resultSet = statement.executeQuery();
    
            // Imprime os resultados
            if (resultSet.next()){
               do {
                    System.out.println("ID do empréstimo: " + resultSet.getInt("idEmprestimo"));
                    System.out.println("Nome do aluno: " + resultSet.getString("nomeAluno"));
                    System.out.println("Nome do livro: " + resultSet.getString("tituloLivro"));
                    System.out.println("Data de emprestimo: " + resultSet.getString("dataEmprestimo"));
                    System.out.println("Data de devolucao: " + resultSet.getString("dataDevolucao"));
                    String status = resultSet.getInt("devolvido") == 0 ? "Devolvido" : "Emprestado";
                    System.out.println("Status: " + status);
                    System.out.println("-------------------------------");
                } while (resultSet.next());
            } else {
                System.out.println("Nenhum empréstimo encontrado com esse dado.");
            }
    
            statement.close();
        } catch (Exception e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }
    
    

    public void devolverLivro(Emprestimos emprestimo) throws SQLException {
        System.out.println("Devolvendo Livro...");
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
    
        // Atualiza o empréstimo para marcar como devolvido e definir a data de devolução
        PreparedStatement statement = connection.prepareStatement(
            "UPDATE emprestimos SET devolvido = 0, dataDevolucao = ? WHERE idEmprestimo = ?"
        );
    
        statement.setString(1, dateTimeString);
        statement.setInt(2, emprestimo.getIdEmprestimo());
        statement.executeUpdate();
    
        statement.close();
    }
    
}
