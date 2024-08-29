# Sistema de Gerenciamento de Biblioteca

## Descrição

Este projeto em Java implementa um sistema de gerenciamento de biblioteca, fornecendo funcionalidades para cadastro, consulta, edição e remoção de informações relacionadas a alunos, livros, autores, categorias e empréstimos.

## Funcionalidades Principais

* **Gerenciamento de Alunos:** Cadastro, edição, busca e remoção de alunos.
* **Gerenciamento de Livros:** Cadastro, edição, busca e remoção de livros, associando autores e categorias.
* **Gerenciamento de Autores:** Cadastro, edição, busca e remoção de autores.
* **Gerenciamento de Categorias:** Cadastro, edição, busca e remoção de categorias de livros.
* **Gerenciamento de Empréstimos:** Registro de empréstimos, controle de datas de devolução e status.

## Tecnologias Utilizadas

* **Linguagem de Programação:** Java
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** MySQL

## Estrutura do Projeto

O projeto utiliza uma estrutura de pacotes para organizar as classes:

* `br.com.heitorlouzeiro.classes`: Contém as classes de modelo que representam as entidades do sistema (Aluno, Livro, Autor, Categoria, Emprestimo).

## Como Executar

**Pré-requisitos:**

* Java Development Kit (JDK) instalado
* Maven instalado
* Banco de dados configurado e em execução

**Passos:**

1. Clone o repositório do projeto:
   ```bash
   git clone https://github.com/HeitorLouzeiro/java-biblioteca.git
   ```
2. Importe o projeto em sua IDE Java.
3. Configure as propriedades de conexão com o banco de dados.
4. Compile e execute o projeto.