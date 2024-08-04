package br.com.heitorlouzeiro;

import java.io.IOException;

import br.com.heitorlouzeiro.dao.FuncionariosDAO;

public class FuncionariosDAOTest {
    public static void main(String[] args) throws IOException {
        FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

        System.out.println("Funcionários:");
        funcionariosDAO.mostrarFuncionarios();

        System.out.println("---------------------------------");
    }
    
}
