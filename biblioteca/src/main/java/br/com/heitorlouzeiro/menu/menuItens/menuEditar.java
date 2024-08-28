package br.com.heitorlouzeiro.menu.menuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.heitorlouzeiro.classes.Alunos;
import br.com.heitorlouzeiro.classes.Autores;
import br.com.heitorlouzeiro.classes.Categorias;
import br.com.heitorlouzeiro.classes.Emprestimos;
import br.com.heitorlouzeiro.classes.Livros;
import br.com.heitorlouzeiro.dao.LivrosDAO;
import br.com.heitorlouzeiro.dao.AlunosDAO;
import br.com.heitorlouzeiro.dao.AutoresDAO;
import br.com.heitorlouzeiro.dao.CategoriasDAO;
import br.com.heitorlouzeiro.dao.EmprestimosDAO;

public class menuEditar {
    Scanner scanner = new Scanner(System.in);
    menuListar menuListar = new menuListar();
    
    public void menuEditarLivro() throws IOException, SQLException {
        LivrosDAO livrosDAO = new LivrosDAO();
        Livros livro = new Livros();

        
        System.out.println("Digite o id do livro: ");
        livro.setIdLivro(scanner.nextInt());
        scanner.nextLine();
    
        System.out.println("Digite o título do livro: ");
        livro.setTituloLivro(scanner.nextLine());
        scanner.nextLine();

        System.out.println("Digite o ano de publicação do livro: ");
        livro.setAnoPublicacao(scanner.nextInt());
        scanner.nextLine();

        menuListar.menuListarAutores();
        System.out.println("Digite o id do autor: ");
        livro.setIdAutor(scanner.nextInt());

        menuListar.menuListarCategorias();
        System.out.println("Digite o id da categoria: ");
        livro.setIdCategoria(scanner.nextInt());

        livrosDAO.atualizarLivro(livro);
    }

    public void menuEditarAluno () throws IOException {
        AlunosDAO alunoDAO = new AlunosDAO();
        Alunos aluno = new Alunos();

        System.out.println("Digite o id do aluno: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.println("Digite o email do aluno: ");
        String emailAluno = scanner.nextLine();
        System.out.println("Digite o telefone do aluno: ");
        long telefoneAluno = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Digite o endereço do aluno: ");
        String enderecoAluno = scanner.nextLine();
        
        aluno.setIdAluno(idAluno);
        aluno.setNomeAluno(nomeAluno);
        aluno.setEmailAluno(emailAluno);
        aluno.setTelefoneAluno(telefoneAluno);
        aluno.setEnderecoAluno(enderecoAluno);

        alunoDAO.atualizarAluno(aluno);
    }

    public void menuEditarEmprestimo() throws SQLException, IOException {
        EmprestimosDAO emprestimosDAO = new EmprestimosDAO();
        Emprestimos emprestimo = new Emprestimos();

        System.out.println("Digite o id do empréstimo: ");
        int idEmprestimo = scanner.nextInt();
        scanner.nextLine();

        emprestimo.setIdEmprestimo(idEmprestimo);
        emprestimosDAO.devolverLivro(emprestimo);
    }

    public void menuEditarAutor() throws SQLException, IOException {
        Autores autor = new Autores();
        AutoresDAO autoresDAO = new AutoresDAO();

        System.out.println("Digite o id do autor: ");
        autor.setIdAutor(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o nome do autor: ");
        autor.setNomeAutor(scanner.nextLine());

        autoresDAO.atualizarAutor(autor);
    }

    public void menuEditarCategoria() throws IOException, SQLException {
        Categorias categoria = new Categorias();
        CategoriasDAO categoriaDAO = new CategoriasDAO();

        System.out.println("Digite o id da categoria: ");
        categoria.setIdCategoria(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Digite o nome da categoria: ");
        categoria.setNomeCategoria(scanner.nextLine());

        categoriaDAO.atualizarCategoria(categoria);
    }
    
}
