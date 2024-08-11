package br.com.heitorlouzeiro;

import java.io.IOException;
import java.sql.SQLException;

import br.com.heitorlouzeiro.classes.Categorias;
import br.com.heitorlouzeiro.dao.CategoriasDAO;


public class CategoriasDAOTest {
    public static void main(String[] args) throws SQLException, IOException {
        // Mostrando categorias
        System.out.println("Categorias:");
        CategoriasDAO categoriasDAO = new CategoriasDAO();

        categoriasDAO.mostrarCategorias();

        // Cadastrando categoria
        System.out.println("---------------------------------");

        Categorias categoria = new Categorias();
        categoria.setNomeCategoria("Heitor Louzeiro");

        categoriasDAO.cadastrarCategoria(categoria);

        categoriasDAO.mostrarCategorias();

        // Deletando categoria
        System.out.println("---------------------------------");

        categoriasDAO.deletarCategoria(1);

        categoriasDAO.mostrarCategorias();

        // Buscando categoria
        System.out.println("---------------------------------");

        categoria.setNomeCategoria("Louzeiro");
        categoriasDAO.buscarCategoria(categoria);

        // Atualizando categoria
        System.out.println("---------------------------------");

        categoria.setIdCategoria(2);
        categoria.setNomeCategoria("Heitor Louzeiro");
        categoriasDAO.atualizarCategoria(categoria);

        categoriasDAO.mostrarCategorias();

        
    }
    
}
