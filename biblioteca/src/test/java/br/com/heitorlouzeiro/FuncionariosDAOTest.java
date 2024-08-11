package br.com.heitorlouzeiro;

import java.io.IOException;
import java.sql.SQLException;

import br.com.heitorlouzeiro.classes.Funcionarios;
import br.com.heitorlouzeiro.dao.FuncionariosDAO;

public class FuncionariosDAOTest {
    public static void main(String[] args) throws IOException, SQLException {
        Funcionarios funcionario = new Funcionarios();
        FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

        // Mostrando funcionários
        System.out.println("Funcionários:");
        funcionariosDAO.mostrarFuncionarios();

        // Cadastrando funcionário
        System.out.println("---------------------------------");

        System.out.println("Cadastrando Funcionário...");
        funcionario.setNomeFuncionario("carlos Louzeiro");
        funcionario.setEmailFuncionario("heitorlouzeiro@gmail.com");

        funcionariosDAO.cadastrarFuncionario(funcionario);

        funcionariosDAO.mostrarFuncionarios();


        // Deletando funcionário
        System.out.println("---------------------------------");

        System.out.println("Deletando Funcionário...");
        funcionariosDAO.deletarFuncionario(1);

        funcionariosDAO.mostrarFuncionarios();


        // Buscando funcionário
        System.out.println("---------------------------------");
        
        funcionario.setNomeFuncionario("Louzeiro");
        funcionariosDAO.buscarFuncionario(funcionario);

        // Atualizando funcionário
        System.out.println("---------------------------------");
              
        funcionario.setIdFuncionario(2);
        funcionario.setNomeFuncionario("Heitor Louzeiro");
        funcionario.setEmailFuncionario("");
        funcionariosDAO.atualizarFuncionario(funcionario);

    }

}
