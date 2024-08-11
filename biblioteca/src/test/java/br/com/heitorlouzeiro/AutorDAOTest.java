package br.com.heitorlouzeiro;

import java.io.IOException;
import java.sql.SQLException;

import br.com.heitorlouzeiro.classes.Autores;
import br.com.heitorlouzeiro.dao.AutoresDAO;

public class AutorDAOTest {

    public static void main(String[] args) throws SQLException, IOException {
        // Mostrando autores
        System.out.println("Autores:");
        AutoresDAO autoresDAO = new AutoresDAO();

        autoresDAO.mostrarAutores();

        // Cadastrando autor
        System.out.println("---------------------------------");

        Autores autor = new Autores();
        autor.setNomeAutor("Heitor Louzeiro");

        autoresDAO.cadastrarAutor(autor);

        autoresDAO.mostrarAutores();

        // Deletando autor
        System.out.println("---------------------------------");

        autoresDAO.deletarAutor(1);

        autoresDAO.mostrarAutores();

        // Buscando autor
        System.out.println("---------------------------------");

        autor.setNomeAutor("Louzeiro");
        autoresDAO.buscarAutor(autor);

        // Atualizando autor
        System.out.println("---------------------------------");

        autor.setIdAutor(2);
        autor.setNomeAutor("Heitor Louzeiro");
        autoresDAO.atualizarAutor(autor);

        autoresDAO.mostrarAutores();
    }
}
