package br.com.heitorlouzeiro;

import java.io.IOException;
import java.sql.SQLException;

import br.com.heitorlouzeiro.classes.Livros;
import br.com.heitorlouzeiro.dao.LivrosDAO;

public class LivrosDAOTest {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Testando LivrosDAO");

        Livros livros = new Livros();
        LivrosDAO livrosDAO = new LivrosDAO();

        // Mostrando livros
        System.out.println("Livros:");
        livrosDAO.mostrarLivros();

        // Cadastrando livro
        System.out.println("---------------------------------");

        System.out.println("Cadastrando Livro...");
        livros.setTituloLivro("tituloLivro");
        livros.setAnoPublicacao(2021);
        livros.setIdAutor(1);
        livros.setIdCategoria(1);

        livrosDAO.cadastrarLivro(livros);

        livrosDAO.mostrarLivros();

        // Deletando livro
        System.out.println("---------------------------------");

        System.out.println("Deletando Livro...");
        livrosDAO.deletarLivro(1);

        livrosDAO.mostrarLivros();


        // Buscando livro
        System.out.println("---------------------------------");

        livros.setTituloLivro("tituloLivro");
        livrosDAO.buscarLivro(livros);

        // Atualizando livro
        System.out.println("---------------------------------");

        livros.setIdLivro(2);
        livros.setTituloLivro("tituloLivro");
        livros.setAnoPublicacao(2021);
        livros.setIdAutor(1);
        livros.setIdCategoria(1);
        livrosDAO.atualizarLivro(livros);
        
    }
}
