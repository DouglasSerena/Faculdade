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

INSERT INTO pesquisadores (nome)
	VALUES 
    	("Douglas Schneider"),
			("João Silva"),
			("Cassio Costa"),
			("Lucas Silva"),
			("João oliviera");

INSERT INTO artigos (id, pesquisador_id, titulo, pagina_inicial, pagina_final,  editor)
	VALUES 
    	(1, 1, "Carro de 9 rodas", 1, 2, "Saraiva"),
    	(20, 1, "Carro de 11 rodas", 1, 2, "Saraiva"),
    	(1234, 1, "Carro de 13 rodas", 1, 2, "Silva");
        
INSERT INTO periodicos (titulo, artigo_id)
	VALUES
    	("20/10/20021 - versão 1", 1234),
			("20/10/20021 - versão 1", 1),
			("20/11/20021 - versão 2", 1234),
			("20/12/20021 - versão 3", 1234);

UPDATE periodicos SET titulo="20/11/20021 - versão 1" WHERE id=2;
UPDATE periodicos SET titulo="20/12/20021 - versão 1" WHERE id=3;
UPDATE artigos SET pagina_final=3 WHERE id=2;

SELECT * FROM artigos WHERE id=1234;
SELECT * FROM artigos WHERE editor LIKE '%Saraiva%';
SELECT * FROM pesquisadores WHERE nome LIKE '%João%';