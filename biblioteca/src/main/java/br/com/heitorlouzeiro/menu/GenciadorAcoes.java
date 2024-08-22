package br.com.heitorlouzeiro.menu;

import java.util.Scanner;

import br.com.heitorlouzeiro.menu.menuItens.menuCadastrar;
import br.com.heitorlouzeiro.menu.menuItens.menuListar;

public class GenciadorAcoes {
    private static menuListar listar = new menuListar();
    private static menuCadastrar cadastrar = new menuCadastrar();

    public static void executarAcao(String[] opcoes, Scanner scanner, int tipo) {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + " - " + opcoes[i]);
        }
        System.out.println("0 - Voltar.");
        System.out.println("Escolha uma opção: ");

        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    if (tipo == 1) {
                        listar.listarLivros();
                    } else if (tipo == 2) {
                        listar.listarAlunos();
                    } else {
                        listar.listarEmprestimos();
                    }
                    break;
                case 2:
                    if (tipo == 1) {
                        cadastrar.cadastrarLivro();
                    } else  if (tipo == 2) {
                        cadastrar.cadastrarAluno();
                    }else{
                        cadastrar.cadastrarEmprestimo();
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida. Digite um número.");
            scanner.nextLine(); 
        }
    }
}
