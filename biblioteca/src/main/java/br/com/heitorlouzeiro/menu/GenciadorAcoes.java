package br.com.heitorlouzeiro.menu;

import java.util.Scanner;

import br.com.heitorlouzeiro.menu.menuItens.menuCadastrar;
import br.com.heitorlouzeiro.menu.menuItens.menuDeletar;
import br.com.heitorlouzeiro.menu.menuItens.menuEditar;
import br.com.heitorlouzeiro.menu.menuItens.menuListar;
import br.com.heitorlouzeiro.menu.menuItens.menuBuscar;

public class GenciadorAcoes {
    private static menuListar listar = new menuListar();
    private static menuCadastrar cadastrar = new menuCadastrar();
    private static menuBuscar menuBuscar = new menuBuscar();
    private static menuDeletar deletar = new menuDeletar();
    private static menuEditar editar = new menuEditar();

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
                    } else if (tipo == 3) {
                        listar.menuListarEmprestimos();
                        menu.exibirMenuEmprestimos();
                    } else if (tipo == 4) {
                        listar.menuListarAutores();
                        menu.exibirMenuAutores();
                    } else {
                        listar.menuListarCategorias();
                        menu.exibirMenuCategorias();
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
                    } else if (tipo == 3) {
                        cadastrar.cadastrarEmprestimo();
                        listar.menuListarEmprestimos();
                        menu.exibirMenuEmprestimos();
                    }else if (tipo == 4) {
                        cadastrar.menuCadastrarAutor();
                        listar.menuListarAutores();
                        menu.exibirMenuAutores();
                    } else {
                        cadastrar.cadastrarCategoria();
                        listar.menuListarCategorias();
                        menu.exibirMenuCategorias();
                    }

                    break;
                case 3:
                    if (tipo == 1) {
                        while (condition) {
                            menuBuscar.menuBuscarLivro();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                                System.out.println("Deseja editar o livro? (s/n)");
                                String opcaoEditar = scanner.nextLine();
                                if (opcaoEditar.equals("s")) {
                                    editar.menuEditarLivro();
                                    listar.menuListarLivros();
                                }else{
                                    menu.exibirMenuLivros();
                                }
                            }
                        }
                    } else if (tipo == 2) {
                        while (condition) {
                            menuBuscar.menuBuscarAluno();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                                System.out.println("Deseja editar o aluno? (s/n)");
                                String opcaoEditar = scanner.nextLine();
                                if (opcaoEditar.equals("s")) {
                                    editar.menuEditarAluno();
                                    listar.menuListarAlunos();
                                }else{
                                    menu.exibirMenuAlunos();
                                }
                            }
                        }
                    } else if (tipo == 3) {
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
                                editar.menuEditarEmprestimo();

                            }
                        }
                        listar.menuListarEmprestimos();
                    }
                    else if (tipo == 4){
                        while (condition) {
                            menuBuscar.menuBuscarAutor();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                                System.out.println("Deseja editar o autor? (s/n)");
                                String opcaoEditar = scanner.nextLine();
                                if (opcaoEditar.equals("s")) {
                                    editar.menuEditarAutor();
                                    listar.menuListarAutores();
                                }else{
                                    menu.exibirMenuAutores();
                                }
                            }
                        }                        
                    }else if (tipo == 5){
                        while (condition) {
                            menuBuscar.menuBuscarCategoria();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                                System.out.println("Deseja editar a categoria? (s/n)");
                                String opcaoEditar = scanner.nextLine();
                                if (opcaoEditar.equals("s")) {
                                    editar.menuEditarCategoria();
                                    listar.menuListarCategorias();
                                }else{
                                    menu.exibirMenuCategorias();
                                }
                            }
                        }                        
                    }else{
                        System.out.println("Opção inválida.");
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
                    } else if (tipo == 4 ){
                        while (condition) {
                            menuBuscar.menuBuscarAutor();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                            }
                            deletar.menuDeletarAutor();
                            menu.exibirMenuAutores();
                            
                        }
                    }else if (tipo == 5 ){
                        while (condition) {
                            menuBuscar.menuBuscarCategoria();
                            System.out.println("Deseja realizar outra pesquisa? (s/n)");
                            String opcaoPesquisa = scanner.nextLine();
                            if (opcaoPesquisa.equals("s")) {
                                condition = true;
                            } else {
                                condition = false;
                            }
                            deletar.menuDeletarCategoria();
                            menu.exibirMenuCategorias();
                            
                        }
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