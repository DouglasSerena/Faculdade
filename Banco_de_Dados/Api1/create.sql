CREATE DATABASE `AP1`;
USE `AP1`;

DROP TABLE IF EXISTS filmes_locacoes;
DROP TABLE IF EXISTS autores_filmes;
DROP TABLE IF EXISTS filmes;
DROP TABLE IF EXISTS autores;
DROP TABLE IF EXISTS locacoes;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS clientes;

CREATE TABLE IF NOT EXISTS categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS autores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    nome_real VARCHAR(45) NOT NULL,
    data_nascimento DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS filmes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(45) NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    quantidade_exemplares INT NOT NULL,
    categoria_id INT NOT NULL,
    CONSTRAINT filmes_categorias
        FOREIGN KEY (categoria_id)
        REFERENCES categorias(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS autores_filmes (
    autore_id INT NOT NULL,
    filme_id INT NOT NULL,
    CONSTRAINT autores_filmes_autores
        FOREIGN KEY (autore_id)
        REFERENCES autores(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    CONSTRAINT autores_filmes_filmes
        FOREIGN KEY (filme_id)
        REFERENCES filmes(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prenome VARCHAR(45) NOT NULL,
    sobrenome VARCHAR(45) NOT NULL,
    fone VARCHAR(45) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    numero_associado INT NOT NULL
);

CREATE TABLE IF NOT EXISTS locacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_retirada DATE NOT NULL,
    data_entrega DATE,
    cliente_id INT NOT NULL,
    CONSTRAINT locacoes_clientes
        FOREIGN KEY (cliente_id)
        REFERENCES clientes(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS filmes_locacoes (
    filme_id INT NOT NULL,
    locacao_id INT NOT NULL,
    CONSTRAINT filmes_locacoes_locacoe
        FOREIGN KEY (locacao_id)
        REFERENCES locacoes(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,
    CONSTRAINT filmes_locacoes_filmes
        FOREIGN KEY (filme_id)
        REFERENCES filmes(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE
);