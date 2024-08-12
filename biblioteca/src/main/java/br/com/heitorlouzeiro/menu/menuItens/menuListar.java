package br.com.heitorlouzeiro.menu.menuItens;

import java.io.IOException;
import java.sql.SQLException;

import br.com.heitorlouzeiro.dao.AlunosDAO;

public class menuListar {
    public void listarAlunos() throws IOException, SQLException  {
        AlunosDAO alunosDAO = new AlunosDAO();
        alunosDAO.mostrarAlunos();
    }
    
}
