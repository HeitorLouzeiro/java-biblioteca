// Pacote para as classes de menu
package br.com.heitorlouzeiro.menu;

import java.util.Scanner;

// Classe para gerenciar as ações do menu
public class GenciadorAcoes {

    // Método para executar a ação selecionada pelo usuário
    public static void executarAcao(String[] opcoes, Scanner scanner) {
        // Exibe as opções disponíveis
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + " - " + opcoes[i]);
        }
        System.out.println("0 - Voltar.");
        System.out.println("Escolha uma opção: ");

        // Lê a opção do usuário
        int opcao;
        try {
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado
        } catch (Exception e) {
            System.out.println("Opção inválida. Digite um número.");
            scanner.nextLine(); // Limpa o buffer do teclado
            return; // Volta ao menu
        }

        // Executa a ação correspondente à opção selecionada
        switch (opcao) {
            case 1:
                System.out.println("Opção 1 selecionada.");
                break;
            case 2:
                System.out.println("Opção 2 selecionada.");
                break;
            case 0:
                System.out.println("Voltando ao menu anterior.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}