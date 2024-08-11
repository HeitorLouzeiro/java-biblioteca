package br.com.heitorlouzeiro;

import java.io.IOException;
import java.sql.SQLException;

import br.com.heitorlouzeiro.classes.Alunos;
import br.com.heitorlouzeiro.dao.AlunosDAO;

public class AlunosDAOTest {
    public static void main(String[] args) throws SQLException, IOException {
        // Mostrando alunos
        System.out.println("Alunos:");
        AlunosDAO alunosDAO = new AlunosDAO();

        alunosDAO.mostrarAlunos();

        // Cadastrando aluno
        System.out.println("---------------------------------");

        Alunos aluno = new Alunos();
        aluno.setNomeAluno("Heitor Louzeiro");
        aluno.setEmailAluno(" ");
        aluno.setTelefoneAluno(899990545);
        aluno.setEnderecoAluno("Rua 1, 123");


        alunosDAO.cadastrarAluno(aluno);

        alunosDAO.mostrarAlunos();

        // Deletando aluno
        System.out.println("---------------------------------");

        alunosDAO.deletarAluno(1);

        alunosDAO.mostrarAlunos();

        // Buscando aluno
        System.out.println("---------------------------------");

        aluno.setNomeAluno("Louzeiro");
        alunosDAO.buscarAluno(aluno);

        // Atualizando aluno
        System.out.println("---------------------------------");

        aluno.setIdAluno(2);
        aluno.setNomeAluno("Heitor Louzeiro");
        aluno.setEmailAluno("");
        alunosDAO.atualizarAluno(aluno);
    }
}