DROP TABLE IF EXISTS funcionarios;
DROP TABLE IF EXISTS livros;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS autores;
DROP TABLE IF EXISTS alunos;
DROP TABLE IF EXISTS emprestimos;

CREATE TABLE IF NOT EXISTS funcionarios (
    idFuncionario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    nomeFuncionario VARCHAR(255) NOT NULL,
    emailFuncionario VARCHAR(255)
);

INSERT INTO funcionarios (nomeFuncionario, emailFuncionario) VALUES
('Ana Silva', NULL),
('Heitor Louzeiro', 'heitor.louzeiro@example.com'),
('João Pedro', 'joao.pedro@example.com');

CREATE TABLE IF NOT EXISTS livros (
    idLivro INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    tituloLivro VARCHAR(255) NOT NULL,
    anoPublicacao INTEGER NOT NULL,
    idCategoria INTEGER NOT NULL,
    idAutor INTEGER NOT NULL,
    FOREIGN KEY (idCategoria) REFERENCES categorias(idCategoria),
    FOREIGN KEY (idAutor) REFERENCES autores(idAutor)
);

CREATE TABLE IF NOT EXISTS categorias (
    idCategoria INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    nomeCategoria VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS autores (
    idAutor INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    nomeAutor VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS alunos (
    idAluno INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    nomeAluno VARCHAR(255) NOT NULL,
    telefone VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    emailAluno VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS emprestimos (
    idEmprestimo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE NOT NULL,
    devolvido BOOLEAN NOT NULL,
    idAluno INTEGER NOT NULL,
    idLivro INTEGER NOT NULL,
    FOREIGN KEY (idAluno) REFERENCES alunos(idAluno),
    FOREIGN KEY (idLivro) REFERENCES livros(idLivro)
);