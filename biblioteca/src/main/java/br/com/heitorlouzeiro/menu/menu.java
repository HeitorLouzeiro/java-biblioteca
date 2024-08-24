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
                case 4:
                    exibirMenuAutores();
                    break;
                case 5:
                    exibirMenuCategorias();
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
        System.out.println("4 - Autores.");
        System.out.println("5 - Categorias.");
        System.out.println("0 - Sair.");
    }

    static void exibirMenuLivros() {
        String opcoes[] = { "Listar livros.", "Cadastrar livro.","Atualizar livros", "Excluir livro." };
        GenciadorAcoes.executarAcao(opcoes, scanner, 1);
    }

    static void exibirMenuAlunos() {
        String opcoes[] = { "Listar alunos.", "Cadastrar aluno.", "Atualizar aluno","Excluir aluno." };
        GenciadorAcoes.executarAcao(opcoes, scanner, 2);
    }
    static void exibirMenuEmprestimos() {
        String opcoes[] = { "Listar empréstimos.", "Cadastrar empréstimo.","Atualizar empréstimo.", ""};
        GenciadorAcoes.executarAcao(opcoes, scanner, 3);
    }
    
    static void exibirMenuAutores() {
        String opcoes[] = { "Listar autores.", "Cadastrar autor.","Atualizar autor.", "Excluir autor." };
        GenciadorAcoes.executarAcao(opcoes, scanner, 4);
    }

    static void exibirMenuCategorias() {
        String opcoes[] = { "Listar categorias.", "Cadastrar categoria.","Atualizar categoria.", "Excluir categoria." };
        GenciadorAcoes.executarAcao(opcoes, scanner, 5);
    }

}
