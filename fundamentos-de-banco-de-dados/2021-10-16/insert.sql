-- 2 🆗 Inserir 3 registros em cada tabela.

INSERT INTO cidades (nome, uf) 
  VALUES 
  	('Capão da canoa', 'RS'), 
    ('Torres', 'RS'), 
    ('Terra de area', 'RS');

INSERT INTO medicos (nome, endereco, telefone, crm, cpf, cidade_id)
  VALUES 
    ('Douglas S Serena', 'Rua tres prado', '51900009999', '679546', '00000000000', 1),
    ('Cassio Costa', 'Rua quatro prado', '51900009999', '576458', '00000000000', 2),
    ('Amanda Oliveira', 'Rua cinco prado', '51900009999', '458964', '00000000000', 3);

INSERT INTO pacientes (nome, endereco, telefone, cidade_id)
  VALUES
    ('Jonh Carlos', 'Rua tres prado', '51900009999', 1),
    ('Aline Silva', 'Rua quatro prado', '51900009999', 2),
    ('Alfredo mello', 'Rua cinco prado', '51900009999', 3);

INSERT INTO consultas (medico_id, paciente_id, `data`, hora)
  VALUES
    (1, 1, '2021-12-07', '07:30'),
    (2, 2, '2021-11-23', '10:30'),
    (3, 3, '2022-02-12', '16:00');

INSERT INTO medicamentos (nome, composicao, preco)
  VALUES
    ("Paracetamol", "Mostarda", 12.50),
    ("Dipirona", "Ketchup", 11.50),
    ("Morfina", "Maionese", 23.50);

INSERT INTO prescricoes (medico_id, medicamento_id, posologia)
  VALUES
    (1, 2, "Mostarda"),
    (2, 3, "Ketchup"),
    (3, 1, "Maionese");