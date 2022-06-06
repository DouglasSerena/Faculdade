CREATE TABLE IF NOT EXISTS fornecedores (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	nome VARCHAR(100) NOT NULL,
  	`status` VARCHAR(100) DEFAULT 'EM_ABERTO',
  	cidade VARCHAR(100)
);

CREATE TABLE instituicoes (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	nome VARCHAR(100) NOT NULL
);

CREATE TABLE pecas (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	nome VARCHAR(100) NOT NULL,
  	cor VARCHAR(100),
  	peso FLOAT NOT NULL,
  	cidade VARCHAR(100)
);

CREATE TABLE projetos (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	instituicao_id INT NOT NULL,
  	nome VARCHAR(100) NOT NULL,
  	cidade VARCHAR(100),

  	CONSTRAINT projects_instituicao_foreign_key
  		FOREIGN key (instituicao_id)
  			REFERENCES instituicoes(id)
);

CREATE TABLE fornecimentos (
	fornecedor_id INT NOT NULL,
	projeto_id INT NOT NULL,
	peca_id INT NOT NULL,
  	quantidade FLOAT NOT NULL,

  	CONSTRAINT fornecimentos_fornecedores_foreign_key
  		FOREIGN key (fornecedor_id)
  			REFERENCES fornecedores(id),
  	CONSTRAINT fornecimentos_projetos_foreign_key
  		FOREIGN key (projeto_id)
  			REFERENCES projetos(id),
  	CONSTRAINT fornecimentos_pecas_foreign_key
  		FOREIGN key (peca_id)
  			REFERENCES pecas(id)
);