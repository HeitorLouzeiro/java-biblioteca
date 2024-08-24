package br.com.heitorlouzeiro.menu.menuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


import br.com.heitorlouzeiro.dao.AlunosDAO;
import br.com.heitorlouzeiro.dao.AutoresDAO;
import br.com.heitorlouzeiro.dao.CategoriasDAO;
import br.com.heitorlouzeiro.dao.LivrosDAO;

public class menuDeletar {
    
    Scanner scanner = new Scanner(System.in);
    menuListar listar = new menuListar();

    public void menuDeletarAluno() throws SQLException, IOException {
        AlunosDAO alunosDAO = new AlunosDAO();
        
        System.out.println("Digite o id do aluno que deseja deletar: ");
        int nomeAluno = scanner.nextInt();
        alunosDAO.deletarAluno(nomeAluno);
    }

    public void menuDeletarLivro() throws IOException {
        LivrosDAO livrosDAO = new LivrosDAO();
        System.out.println("Digite o id do livro que deseja deletar: ");
        int idLivro = scanner.nextInt();
        livrosDAO.deletarLivro(idLivro);
        
    }

    public void menuDeletarAutor() throws IOException, SQLException {
        AutoresDAO autoresDAO = new AutoresDAO();

        System.out.println("Digite o id do autor que deseja deletar: ");
        int idAutor = scanner.nextInt();
        autoresDAO.deletarAutor(idAutor);


        listar.menuListarAutores();
        System.out.println("Autor deletado com sucesso!");
    }

    public void menuDeletarCategoria() throws IOException, SQLException {
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        System.out.println("Digite o id da categoria que deseja deletar: ");
        int idCategoria = scanner.nextInt();

        categoriasDAO.deletarCategoria(idCategoria);

        listar.menuListarCategorias();
    }
}
