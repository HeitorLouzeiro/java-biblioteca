package br.com.heitorlouzeiro.menu;

import java.util.Scanner;

import br.com.heitorlouzeiro.menu.menuItens.menuCadastrar;
import br.com.heitorlouzeiro.menu.menuItens.menuDeletar;
import br.com.heitorlouzeiro.menu.menuItens.menuListar;
import br.com.heitorlouzeiro.menu.menuItens.menuBuscar;

public class GenciadorAcoes {
    private static menuListar listar = new menuListar();
    private static menuCadastrar cadastrar = new menuCadastrar();
    private static menuBuscar menuBuscar = new menuBuscar();
    private static menuDeletar deletar = new menuDeletar();

    public static void executarAcao(String[] opcoes, Scanner scanner, int tipo) {
        boolean condition = true; // Move declaration to the beginning
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
                        listar.menuListarLivros();
                        menu.exibirMenuLivros();
                    } else if (tipo == 2) {
                        listar.menuListarAlunos();
                        menu.exibirMenuAlunos();
                    } else {
                        listar.menuListarEmprestimos();
                        menu.exibirMenuEmprestimos();
                    }
                    break;
                case 2:
                    if (tipo == 1) {
                        cadastrar.cadastrarLivro();
                        listar.menuListarLivros();
                        menu.exibirMenuLivros();
                    } else if (tipo == 2) {
                        cadastrar.cadastrarAluno();
                        listar.menuListarAlunos();
                        menu.exibirMenuAlunos();
                    } else {
                        cadastrar.cadastrarEmprestimo();
                        listar.menuListarEmprestimos();
                        menu.exibirMenuEmprestimos();
                    }
                    break;
                case 3:
                    if (tipo == 1) {

                        menu.exibirMenuLivros();
                    } else if (tipo == 2) {

                    } else {
                        System.out.println("1 - Buscar empréstimo pelo livro.");
                        System.out.println("2 - Buscar empréstimo pelo aluno.");
                        System.out.println("0 - Voltar.");
                        System.out.println("Escolha uma opção: ");
                        int opcaoEmprestimo = scanner.nextInt();
                        scanner.nextLine();

                        while (condition) {
                            if (opcaoEmprestimo == 1) {
                                menuBuscar.menuBuscarEmprestimoLivro();
                                condition = false;
                            } else if (opcaoEmprestimo == 2) {
                                menuBuscar.menuBuscarEmprestimoAluno();
                                condition = false;
                            } else if (opcaoEmprestimo == 0) {
                                System.out.println("Voltando ao menu anterior.");
                                condition = false;
                                return;
                            } else {
                                System.out.println("Opção inválida.");
                            }
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                            }
                        }
                    }                   
                    break;

                case 4:
                    if (tipo == 1) {
                        while (condition) {
                            menuBuscar.menuBuscarLivro();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                            }
                        }
                        deletar.menuDeletarLivro();
                        listar.menuListarLivros();
                        menu.exibirMenuLivros();
                    } else if (tipo == 2) {
                        while (condition) {
                            menuBuscar.menuBuscarAluno();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                            }

                            deletar.menuDeletarAluno();
                            listar.menuListarAlunos();
                            menu.exibirMenuAlunos();
                        }
                    } else {
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