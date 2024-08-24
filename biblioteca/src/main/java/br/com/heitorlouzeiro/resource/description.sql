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
INSERT INTO livros (tituloLivro, anoPublicacao, idCategoria, idAutor) VALUES
('Harry Potter e a Pedra Filosofal', 1997, 2, 1),
('Harry Potter e o prisioneiro de Azkaban', 1999, 2, 1),
('A Guerra dos Tronos', 1996, 2, 2),
('It: A Coisa', 1986, 3, 3),
('Orgulho e Preconceito', 1813, 4, 4),
('O Assassinato de Roger Ackroyd', 1926, 5, 5),
('Sapiens: Uma Breve História da Humanidade', 2011, 6, 6),
('A Coragem de Ser Imperfeito', 2010, 7, 7),
('Código Limpo', 2008, 8, 8),
('Python para Análise de Dados', 2012, 9, 9);

CREATE TABLE IF NOT EXISTS categorias (
    idCategoria INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    nomeCategoria VARCHAR(255) NOT NULL
);
INSERT INTO categorias (nomeCategoria) VALUES
('Ficção Científica'),
('Fantasia'),
('Terror'),
('Romance'),
('Biografia'),
('História'),
('Autoajuda'),
('Programação'),
('Ciência de Dados');

CREATE TABLE IF NOT EXISTS autores (
    idAutor INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    nomeAutor VARCHAR(255) NOT NULL
);
INSERT INTO autores (nomeAutor) VALUES
('J.K. Rowling'),
('George R. R. Martin'),
('Stephen King'),
('Jane Austen'),
('Agatha Christie'),
('Yuval Noah Harari'),
('Brené Brown'),
('Robert C. Martin'),
('Wes McKinney');

CREATE TABLE IF NOT EXISTS alunos (
    idAluno INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    nomeAluno VARCHAR(255) NOT NULL,
    telefone int(15),
    endereco VARCHAR(255) NOT NULL,
    emailAluno VARCHAR(255)
);
INSERT INTO alunos (nomeAluno, telefone, endereco, emailAluno) VALUES
('João Silva', '11987654321', 'Rua A, 123', 'joao.silva@email.com'),
('Maria Oliveira', '21912345678', 'Rua B, 456', 'maria.oliveira@email.com'),
('Pedro Souza', '31943210987', 'Rua C, 789', 'pedro.souza@email.com'),
('Ana Santos', '41956781234', 'Rua D, 012', 'ana.santos@email.com'),
('Lucas Pereira', '51978903456', 'Rua E, 345', 'lucas.pereira@email.com');

CREATE TABLE IF NOT EXISTS emprestimos (
    idEmprestimo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE,
    devolvido INTEGER NOT NULL,
    idAluno INTEGER NOT NULL,
    idLivro INTEGER NOT NULL,
    FOREIGN KEY (idAluno) REFERENCES alunos(idAluno),
    FOREIGN KEY (idLivro) REFERENCES livros(idLivro)
);
INSERT INTO emprestimos (dataEmprestimo, dataDevolucao, devolvido, idAluno, idLivro) VALUES
  ('2023-03-25', '2023-04-08', 1, 1, 3), -- João Silva pegou "It: A Coisa"
  ('2023-03-28', '2023-04-11', 0, 4, 2), -- Ana Santos devolveu "A Guerra dos Tronos" 
  ('2023-04-01', '2023-04-15', 1, 3, 9), -- Pedro Souza pegou "Python para Análise de Dados"
  ('2023-04-02', '2023-04-16', 0, 2, 7), -- Maria Oliveira devolveu "A Coragem de Ser Imperfeito"
  ('2023-04-05', '2023-04-19', 1, 5, 6); -- Lucas Pereira pegou "Sapiens"