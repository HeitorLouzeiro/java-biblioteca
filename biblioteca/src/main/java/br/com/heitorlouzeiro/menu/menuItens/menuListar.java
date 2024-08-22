package br.com.heitorlouzeiro.menu.menuItens;

import java.io.IOException;
import java.sql.SQLException;


import br.com.heitorlouzeiro.dao.AlunosDAO;
import br.com.heitorlouzeiro.dao.AutoresDAO;
import br.com.heitorlouzeiro.dao.CategoriasDAO;
import br.com.heitorlouzeiro.dao.EmprestimosDAO;
import br.com.heitorlouzeiro.dao.LivrosDAO;

public class menuListar {
    public void listarAlunos() throws IOException, SQLException  {
        AlunosDAO alunosDAO = new AlunosDAO();
        alunosDAO.mostrarAlunos();
    }

    public void listarLivros() throws IOException,SQLException {
       LivrosDAO livrosDAO = new LivrosDAO();
         livrosDAO.mostrarLivros();
    }

    public void listarEmprestimos() throws IOException,SQLException {
        EmprestimosDAO emprestimosDAO = new EmprestimosDAO();
        emprestimosDAO.mostrarEmprestimos();
    }

    public void listarAutores() throws IOException,SQLException {
        AutoresDAO autoresDAO = new AutoresDAO();
        autoresDAO.mostrarAutores();
    }

    public void listarCategorias() throws IOException,SQLException {
        CategoriasDAO categoriasDAO = new CategoriasDAO();
        categoriasDAO.mostrarCategorias();
    }
}
