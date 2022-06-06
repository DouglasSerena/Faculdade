CREATE TABLE departamentos (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE categorias_projetos (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  departamento_id INT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  resultado_esperado TEXT,
  publico_beneficiario VARCHAR(50),
  CONSTRAINT categoria_projeto_departamentos_foreign_key
    FOREIGN KEY (departamento_id)
      REFERENCES departamentos(id)
);

CREATE TABLE colaboradores (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  numero_matricula INT NOT NULL
);

CREATE TABLE projetos (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  coordenador_id INT NOT NULL,
  categoria_id INT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  descricao TEXT,
  duracao DATE NOT NULL,
  CONSTRAINT projetos_coordenador_foreign_key
    FOREIGN KEY (coordenador_id)
      REFERENCES colaboradores(id),
  CONSTRAINT projetos_categorias_projetos_foreign_key
    FOREIGN KEY (categoria_id)
      REFERENCES categorias_projetos(id)
);

CREATE TABLE projetos_colaboradores (
  projeto_id INT NOT NULL,
  colaborador_id INT NOT NULL,
  CONSTRAINT projetos_colaboradores_colaborador_foreign_key
    FOREIGN KEY (colaborador_id)
      REFERENCES colaboradores(id),
  CONSTRAINT projetos_colaboradores_projetos_foreign_key
    FOREIGN KEY (projeto_id)
      REFERENCES projetos(id)
);

CREATE TABLE comentarios (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  colaborador_id INT NOT NULL,
  projeto_id INT NOT NULL,
  texto TEXT NOT NULL,
  data_horario_criacao DATETIME NOT NULL,
  CONSTRAINT comentarios_colaborador_foreign_key
    FOREIGN KEY (colaborador_id)
      REFERENCES colaboradores(id),
  CONSTRAINT comentarios_projetos_foreign_key
    FOREIGN KEY (projeto_id)
      REFERENCES projetos(id)
);