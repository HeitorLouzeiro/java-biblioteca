package br.com.heitorlouzeiro.menu.menuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.heitorlouzeiro.classes.Alunos;
import br.com.heitorlouzeiro.classes.Emprestimos;
import br.com.heitorlouzeiro.classes.Livros;
import br.com.heitorlouzeiro.dao.AlunosDAO;
import br.com.heitorlouzeiro.dao.EmprestimosDAO;
import br.com.heitorlouzeiro.dao.LivrosDAO;

public class menuBuscar {
    Scanner scanner = new Scanner(System.in);

    public void menuBuscarAluno() throws IOException, SQLException {
        Alunos aluno = new Alunos();
        AlunosDAO alunosDAO = new AlunosDAO();
        
        System.out.println("Digite o nome do aluno: ");
        aluno.setNomeAluno(scanner.nextLine());
        System.out.println("Buscando aluno: " + aluno.getNomeAluno());

        alunosDAO.buscarAluno(aluno);

    }

   public void menuBuscarLivro() throws IOException {
        Livros livro = new Livros();
        LivrosDAO livrosDAO = new LivrosDAO();

        System.out.println("Digite o título do livro: ");
        livro.setTituloLivro(scanner.nextLine());
        livrosDAO.buscarLivro(livro);
    }


    public void menuBuscarEmprestimoLivro() throws IOException {
        Emprestimos emprestimo = new Emprestimos(); 
        EmprestimosDAO emprestimosDAO = new EmprestimosDAO();

        System.out.println("Digite o nome do livro: ");
        emprestimo.setTituloLivro(scanner.nextLine());
        System.out.println("Buscando empréstimo pelo livro: " + emprestimo.getTituloLivro());
        emprestimosDAO.buscarEmprestimo(emprestimo);
    }

    public void menuBuscarEmprestimoAluno() throws IOException {
        Emprestimos emprestimo = new Emprestimos(); 
        EmprestimosDAO emprestimosDAO = new EmprestimosDAO();

        System.out.println("Digite o nome do aluno: ");
        emprestimo.setNomeAluno(scanner.nextLine());
        System.out.println("Buscando empréstimo pelo aluno: " + emprestimo.getNomeAluno());
        emprestimosDAO.buscarEmprestimo(emprestimo);
    }

    
}
