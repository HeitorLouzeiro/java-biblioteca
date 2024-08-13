package br.com.heitorlouzeiro.menu;

import java.util.Scanner;

public class menu {
    private static Scanner scanner = new Scanner(System.in);
    public static void exibirMenu() {
        System.out.println("Bem vindo ao sistema de biblioteca"); 
        exibirMenuPrincipal();
        System.out.println("Escolha uma opção: ");
        int opcao = -1;
        do{
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Opção inválida.");
                scanner.next();
                continue;
            }
            switch(opcao){
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
        }while(opcao != 0);
    }

    private static void exibirMenuPrincipal(){
        String opcoes[] = {"Livros.", "Alunos.", "Empréstimos."};
        for(int i = 0; i < opcoes.length; i++){
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
        System.out.println("0 - Sair.");
    }
    

    private static void exibirMenuLivros(){
        String opcoes[] = {"Listar livros.", "Cadastrar livro.", "Buscar livro.", "Excluir livro."};
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
    }
    private static void exibirMenuAlunos(){
        String opcoes[] = {"Listar alunos.", "Cadastrar aluno.", "Buscar aluno.", "Excluir aluno."};
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
    }
    private static void exibirMenuEmprestimos(){
        String opcoes[] = {"Listar empréstimos.", "Cadastrar empréstimo.", "Buscar empréstimo.", "Atualizar empréstimo."};
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
    }
    
}
