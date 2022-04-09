-- #1 Exercício
CREATE TABLE IF NOT EXISTS `vendas` (
  filial_id INT NOT NULL,
  produto_id INT NOT NULL,
  CONSTRAINT vendas_produtos
    FOREIGN KEY (produto_id)
      REFERENCES produtos(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
  CONSTRAINT vendas_filiais
    FOREIGN KEY (filial_id)
      REFERENCES filiais(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `filiais` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  cidade_id INT NOT NULL,
  CONSTRAINT filiais_cidades
    FOREIGN KEY (cidade_id)
      REFERENCES cidades(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

-- #2 Exercício
SELECT * FROM produtos
ORDER BY preco
LIMIT 1

-- #3 Exercício
SELECT AVG(preco) FROM produtos;

-- #4 Exercício
SELECT filiais.nome AS filial_nome, produtos.nome FROM produtos
  JOIN vendas
    ON vendas.produto_id = produtos.id
  JOIN filiais
    ON filiais.id = vendas.filial_id
WHERE filiais.nome LIKE 'Eden Prairie';

-- #5 Exercício
SELECT empregados.nome, empregados.rg, cidades.nome AS cidade, cidades.uf FROM empregados
  JOIN cidades
    ON cidades.id = empregados.cidade_id
WHERE empregados.salario > 500 AND cidades.uf = 'RS';