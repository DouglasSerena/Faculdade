DROP TABLE IF EXISTS periodicos;
DROP TABLE IF EXISTS artigos;
DROP TABLE IF EXISTS pesquisadores;

CREATE TABLE IF NOT EXISTS pesquisadores (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS artigos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  pesquisador_id INT NOT NULL,
  titulo VARCHAR(200) NOT NULL,
  pagina_inicial int NOT NULL,
  pagina_final int NOT NULL,
  editor VARCHAR(100) NOT NULL,
  CONSTRAINT artigos_pesquisadores
    FOREIGN KEY (pesquisador_id)
      REFERENCES pesquisadores(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS periodicos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(200) NOT NULL,
  artigo_id INT NOT NULL,
  CONSTRAINT periodicos_artigos
    FOREIGN KEY (artigo_id)
      REFERENCES artigos(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);