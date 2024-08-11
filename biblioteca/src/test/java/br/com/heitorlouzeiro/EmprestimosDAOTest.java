package br.com.heitorlouzeiro;

import java.io.IOException;
import java.sql.SQLException;

import br.com.heitorlouzeiro.classes.Emprestimos;
import br.com.heitorlouzeiro.dao.EmprestimosDAO;

public class EmprestimosDAOTest {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Emprestimos:");

        EmprestimosDAO emprestimosDAO = new EmprestimosDAO();

        emprestimosDAO.mostrarEmprestimos();

        Emprestimos emprestimo = new Emprestimos();
        
        emprestimo.setIdAluno(1);
        emprestimo.setIdLivro(1);
        emprestimo.setStatusEmprestimo(0);
        emprestimosDAO.cadastrarEmprestimo(emprestimo);

        System.out.println("---------------------------------");

        emprestimosDAO.deletarEmprestimo(2);

        System.out.println("---------------------------------");
        
        System.out.println("Buscando emprestimo pelo livro...");
        emprestimo.setTituloLivro("Harry Potter");
        emprestimosDAO.buscarEmprestimo(emprestimo);

        System.out.println("---------------------------------");
        System.out.println("Buscando emprestimo pelo aluno...");
        emprestimo.setNomeAluno("JoÃ£o Silva");
        emprestimosDAO.buscarEmprestimo(emprestimo);

        System.out.println("---------------------------------");

        emprestimo.setIdEmprestimo(6);
        emprestimosDAO.devolverLivro(emprestimo);

        emprestimosDAO.mostrarEmprestimos();

    }
    
}
