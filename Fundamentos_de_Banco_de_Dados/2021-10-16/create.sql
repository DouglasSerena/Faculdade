-- 1 🆗 Criar todas as tabelas do esquema.

DROP TABLE IF EXISTS consultas;
DROP TABLE IF EXISTS prescricoes;
DROP TABLE IF EXISTS medicamentos;
DROP TABLE IF EXISTS medicos;
DROP TABLE IF EXISTS pacientes;
DROP TABLE IF EXISTS cidades;

CREATE TABLE IF NOT EXISTS cidades (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  uf CHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS medicos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  crm VARCHAR(20) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  cidade_id INT NOT NULL,
  CONSTRAINT medicos_cidades_foreign_key
       	FOREIGN KEY (cidade_id)
           	REFERENCES cidades(id)
              ON DELETE CASCADE
              ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS pacientes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  cidade_id INT NOT NULL,
  CONSTRAINT pacientes_cidades_foreign_key
       	FOREIGN KEY (cidade_id)
           	REFERENCES cidades(id)
              ON DELETE CASCADE
              ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS consultas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  medico_id INT NOT NULL,
  paciente_id INT NOT NULL,
  `data` DATE NOT NULL,
  hora TIME NOT NULL,
  CONSTRAINT consultas_medicos_foreign_key
       	FOREIGN KEY (medico_id)
           	REFERENCES medicos(id)
              ON DELETE CASCADE
              ON UPDATE CASCADE,
  CONSTRAINT consultas_pacientes_foreign_key
       	FOREIGN KEY (paciente_id)
           	REFERENCES pacientes(id)
              ON DELETE CASCADE
              ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS medicamentos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  composicao VARCHAR(255) NOT NULL,
  preco FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS prescricoes (
  consulta_id INT NOT NULL,
  medicamento_id INT NOT NULL,
  posologia VARCHAR(255) NOT NULL,
  CONSTRAINT prescricoes_consultas_foreign_key
       	FOREIGN KEY (consulta_id)
           	REFERENCES consultas(id)
              ON DELETE CASCADE
              ON UPDATE CASCADE,
  CONSTRAINT prescricoes_medicamentos_foreign_key
       	FOREIGN KEY (medicamento_id)
           	REFERENCES medicamentos(id)
              ON DELETE CASCADE
              ON UPDATE CASCADE
);
