package br.com.heitorlouzeiro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.heitorlouzeiro.classes.Autores;
import br.com.heitorlouzeiro.dataBase.DataBase;


public class AutoresDAO {
    private Connection connection;

    public AutoresDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }
    

    public void mostrarAutores() {
        System.out.println("Mostrando autores...");

        try{
             Statement statement = connection.createStatement(); // Cria uma instrução SQL

             // Executa uma consulta SQL
             String query = "SELECT * FROM autores";
             ResultSet resultSet = statement.executeQuery(query);

             // Imprime os resultados
             while (resultSet.next()) {
                    System.out.println("ID do autor: " + resultSet.getInt("idAutor"));
                    System.out.println("Nome do autor: " + resultSet.getString("nomeAutor"));
                    System.out.println("-------------------------------");
             }
             statement.close();
        } catch (Exception e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void cadastrarAutor(Autores autor) throws SQLException {
        System.out.println("Cadastrando autor...");

        PreparedStatement statement = connection
        .prepareStatement("INSERT INTO autores (nomeAutor) VALUES (?)");

        statement.setString(1, autor.getNomeAutor());
        statement.executeUpdate();

        statement.close();
    }

    public void deletarAutor(int idAutor) throws SQLException {
        System.out.println("Deletando autor...");
        PreparedStatement statement = connection
        .prepareStatement("DELETE FROM autores WHERE idAutor = ?");

        statement.setInt(1, idAutor);
        statement.executeUpdate();

        statement.close();
    }

    public void buscarAutor(Autores autor) {
        System.out.println("Buscando autor...");

        try {
            PreparedStatement statement = connection
            .prepareStatement("SELECT * FROM autores WHERE nomeAutor LIKE ?");
            statement.setString(1, "%" + autor.getNomeAutor() + "%");

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                do{
                    System.out.println("ID do autor: " + resultSet.getInt("idAutor"));
                    System.out.println("Nome do autor: " + resultSet.getString("nomeAutor"));
                    System.out.println("-------------------------------");
                }while(resultSet.next());
            }else{
                System.out.println("Autor não encontrado.");
            }

            statement.close();
        } catch (Exception e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void atualizarAutor(Autores autor) throws SQLException {
        System.out.println("Atualizando autor...");

        PreparedStatement statement = connection
        .prepareStatement("UPDATE autores SET nomeAutor = ? WHERE idAutor = ?");

        statement.setString(1, autor.getNomeAutor());
        statement.setInt(2, autor.getIdAutor());

        statement.executeUpdate();

        statement.close();
    }
}
