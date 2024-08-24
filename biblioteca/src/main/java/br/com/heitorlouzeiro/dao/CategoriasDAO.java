package br.com.heitorlouzeiro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.heitorlouzeiro.classes.Categorias;
import br.com.heitorlouzeiro.dataBase.DataBase;

public class CategoriasDAO {
    private Connection connection;

    public CategoriasDAO() throws IOException {
        connection = DataBase.getInstance().getConnection();
    }

    public void mostrarCategorias() {
        System.out.println("Mostrando categorias...");

        try {
            Statement statement = connection.createStatement(); // Cria uma instrução SQL

            // Executa uma consulta SQL
            String query = "SELECT * FROM categorias";
            ResultSet resultSet = statement.executeQuery(query);

            // Imprime os resultados
            while (resultSet.next()) {
                System.out.println("ID da categoria: " + resultSet.getInt("idCategoria"));
                System.out.println("Nome da categoria: " + resultSet.getString("nomeCategoria"));
                System.out.println("-------------------------------");
            }
            statement.close();
        } catch (Exception e) {
            // Mensagem de erro caso não consiga conectar ao banco de dados.
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void cadastrarCategoria(Categorias categoria) throws SQLException {
        System.out.println("Cadastrando categoria...");

        PreparedStatement statement = connection.prepareStatement("INSERT INTO categorias (nomeCategoria) VALUES (?)");

        statement.setString(1, categoria.getNomeCategoria());
        statement.executeUpdate();

        statement.close();
    }

    public void deletarCategoria(int idCategoria) throws SQLException {
        System.out.println("Deletando categoria...");
        PreparedStatement statement = connection.prepareStatement("DELETE FROM categorias WHERE idCategoria = ?");

        statement.setInt(1, idCategoria);
        statement.executeUpdate();

        statement.close();
    }

    public void buscarCategoria(Categorias categoria) {
        System.out.println("Buscando categoria...");

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM categorias WHERE nomeCategoria LIKE ?");
            statement.setString(1, "%" + categoria.getNomeCategoria() + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Nome: " + resultSet.getString("nomeCategoria"));
            }

            statement.close();
        } catch (Exception e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void atualizarCategoria(Categorias categoria) throws SQLException {
        System.out.println("Atualizando categoria...");

        PreparedStatement statement = connection.prepareStatement("UPDATE categorias SET nomeCategoria = ? WHERE idCategoria = ?");

        statement.setString(1, categoria.getNomeCategoria());
        statement.setInt(2, categoria.getIdCategoria());
        statement.executeUpdate();

        statement.close();
    }
    
}