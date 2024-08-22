package br.com.heitorlouzeiro.menu;

import java.util.Scanner;

public class menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        System.out.println("Bem vindo ao sistema de biblioteca");
        int opcao = -1;
        do {
            exibirMenuPrincipal();
            System.out.println("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Opção inválida.");
                scanner.next();
                continue;
            }
            switch (opcao) {
                case 1:
                    exibirMenuLivros();
                    break;
                case 2:
                    exibirMenuAlunos();
                    break;
                case 3:
                    exibirMenuEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("1 - Livros.");
        System.out.println("2 - Alunos.");
        System.out.println("3 - Empréstimos de livros.");
        System.out.println("0 - Sair.");
    }

    private static void exibirMenuLivros() {
        String opcoes[] = { "Listar livros.", "Cadastrar livro.", "Buscar livro.", "Excluir livro." };
        GenciadorAcoes.executarAcao(opcoes, scanner, 1);
    }

    private static void exibirMenuAlunos() {
        String opcoes[] = { "Listar alunos.", "Cadastrar aluno.", "Buscar aluno.", "Excluir aluno." };
        GenciadorAcoes.executarAcao(opcoes, scanner, 2);
    }

    private static void exibirMenuEmprestimos() {
        String opcoes[] = { "Listar empréstimos.", "Cadastrar empréstimo.", "Buscar empréstimo.",
                "Atualizar empréstimo." };
        GenciadorAcoes.executarAcao(opcoes, scanner, 3);
    }
}
