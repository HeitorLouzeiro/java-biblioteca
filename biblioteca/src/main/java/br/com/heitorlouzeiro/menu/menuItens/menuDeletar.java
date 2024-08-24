package br.com.heitorlouzeiro.menu.menuItens;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.heitorlouzeiro.dao.AlunosDAO;
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
}
