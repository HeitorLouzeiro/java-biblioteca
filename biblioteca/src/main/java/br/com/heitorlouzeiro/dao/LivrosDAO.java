package br.com.heitorlouzeiro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.heitorlouzeiro.classes.Livros;
import br.com.heitorlouzeiro.dataBase.DataBase;

public class LivrosDAO {

    private Connection connection;

    public LivrosDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public void mostrarLivros() {
        System.out.println("Mostrando livros...");

        try {
            Statement statement = connection.createStatement(); // Cria uma instrução SQL

            // Executa uma consulta SQL
            String query = "SELECT * FROM livros";
            ResultSet resultSet = statement.executeQuery(query);

            // Imprime os resultados
            while (resultSet.next()) {
                System.out.println("Nome: " + resultSet.getString("tituloLivro"));

            }
            statement.close();

        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void cadastrarLivro(Livros livros) throws SQLException {
        System.out.println("Cadastrando livro...");

        PreparedStatement statement = connection.prepareStatement("INSERT INTO livros (tituloLivro, anoPublicacao, idAutor, idCategoria) VALUES (?, ?, ?, ?)");

        statement.setString(1, livros.getTituloLivro());
        statement.setInt(2, livros.getAnoPublicacao());
        statement.setInt(3, livros.getIdAutor());
        statement.setInt(4, livros.getIdCategoria());

        statement.executeUpdate();

        statement.close();

    }

    public void deletarLivro(int idLivro) {
        System.out.println("Deletando livro...");

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM livros WHERE idLivro = ?");
            statement.setInt(1, idLivro);

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
        
    }

    public void buscarLivro(Livros livros) {
        System.out.println("Buscando livro: " + livros.getTituloLivro());

        try {
            String query = "SELECT * FROM livros WHERE tituloLivro LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "%" + livros.getTituloLivro() + "%");

            ResultSet resultSet = statement.executeQuery();

            /* 
             * Se o resultSet tiver algum resultado, imprime o nome do livro.
             * Caso contrário, imprime que o livro não foi encontrado.
             * do-while para iterar sobre os resultados restantes.
             */
            if (resultSet.next()) {
                do {
                    System.out.println("Titulo do livro: " + resultSet.getString("tituloLivro"));
                } while (resultSet.next()); // Itera sobre os resultados restantes

            } else {
                System.out.println("Livro não encontrado.");
            }

            statement.close();

        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }


    }

    public void atualizarLivro(Livros livros) {
        System.out.println("Atualizando livro...");

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE livros SET tituloLivro = ?, anoPublicacao = ?, idAutor = ?, idCategoria = ? WHERE idLivro = ?");

            statement.setString(1, "tituloLivro");
            statement.setInt(2, 2021);
            statement.setInt(3, 1);
            statement.setInt(4, 1);
            statement.setInt(5, 1);

            statement.executeUpdate();

            statement.close();

            System.out.println("Livro atualizado com sucesso!");

        } catch (SQLException e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }
    
}
