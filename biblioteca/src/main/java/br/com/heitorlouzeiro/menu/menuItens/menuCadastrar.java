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

public class menuCadastrar {
    Scanner scanner = new Scanner(System.in);

    public void cadastrarAluno() throws IOException, SQLException {
        AlunosDAO alunosDAO = new AlunosDAO();
        Alunos aluno = new Alunos();

        System.out.println("Digite o nome do aluno: ");
        aluno.setNomeAluno(scanner.nextLine());
        System.out.println("Digite o email do aluno: ");
        aluno.setEmailAluno(scanner.nextLine());
        System.out.println("Digite o telefone do aluno: ");
        aluno.setTelefoneAluno(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o endereço do aluno: ");
        aluno.setEnderecoAluno(scanner.nextLine());

        alunosDAO.cadastrarAluno(aluno);

    }

    public void cadastrarLivro() throws IOException, SQLException {
        LivrosDAO livrosDAO = new LivrosDAO();
        Livros livro = new Livros();
        menuListar menulistar = new menuListar();
        

        System.out.println("Digite o título do livro: ");
        livro.setTituloLivro(scanner.nextLine());
        System.out.println("Digite o ano de publicação do livro: ");
        livro.setAnoPublicacao(scanner.nextInt());
        scanner.nextLine();

        menulistar.listarAutores();
        System.out.println("Digite o id do autor do livro: ");
        livro.setIdAutor(scanner.nextInt());
        scanner.nextLine();

        menulistar.listarCategorias();
        System.out.println("Digite o id da categoria do livro: ");
        livro.setIdCategoria(scanner.nextInt());
        scanner.nextLine();

        livrosDAO.cadastrarLivro(livro);
        

    }

    public void cadastrarEmprestimo() throws IOException, SQLException {
        EmprestimosDAO emprestimosDAO = new EmprestimosDAO();
        Emprestimos emprestimo = new Emprestimos();
        menuListar menulistar = new menuListar();
        
        menulistar.listarAlunos();
        System.out.println("Digite o id do aluno: ");
        emprestimo.setIdAluno(scanner.nextInt());
        scanner.nextLine();

        menulistar.listarLivros();
        System.out.println("Digite o id do livro: ");
        emprestimo.setIdLivro(scanner.nextInt());
        scanner.nextLine();
        
        emprestimosDAO.cadastrarEmprestimo(emprestimo);

    }
    
}
