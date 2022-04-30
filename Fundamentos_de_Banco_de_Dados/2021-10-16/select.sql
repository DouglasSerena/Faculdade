-- 5 🆗 Listar os nomes das cidades do estado RS. 
SELECT nome FROM cidades WHERE uf = 'RS';

-- 6 🆗 Listar todos os nomes de medicamentos e preço.
SELECT nome, preco FROM medicamentos;

-- 7 🆗 Listar o nome e telefone dos médicos da cidade de ‘Torres’.
SELECT nome, telefone FROM medicos WHERE cidade_id = 2

-- 8 🆗 Listar todas os nomes dos medicamentos, juntamente com a posologia,
-- prescritos na consulta de código 1.
SELECT medicos.nome, prescricoes.posologia, consultas.id
  FROM medicos
    INNER JOIN consultas
      ON consultas.medico_id = medicos.id
    INNER JOIN prescricoes
      ON prescricoes.consulta_id = 1
    WHERE consultas.id = 1;
    
-- 9 🆗 Listar o nome e telefone de todos os pacientes que moram na
-- cidade de nome ‘Capão da Canoa’.
SELECT nome, telefone FROM pacientes WHERE cidade_id = 1;

-- 10 🆗 Listar os nomes dos pacientes que tem consulta marcada.
-- SEM JOIN
SELECT pacientes.nome, consultas.data 
  FROM pacientes, consultas
     WHERE consultas.paciente_id = pacientes.id AND consultas.data = '2021-11-23';
-- COM JOIN
SELECT pacientes.nome, consultas.data 
  FROM pacientes 
    INNER JOIN consultas
      ON consultas.data = '2021-11-23'
    WHERE consultas.paciente_id = pacientes.id;
    
-- 11 🆗 Listar todos os nomes e telefones dos pacientes das 
-- consultas marcadas para o dia ’07/12/2020’
-- SEM JOIN

SELECT pacientes.nome, pacientes.telefone, consultas.data
  FROM pacientes, consultas,
    WHERE consultas.paciente_id = pacientes.id AND consultas.data = '2021-12-07';
-- COM JOIN
SELECT pacientes.nome, pacientes.telefone, consultas.data 
  FROM pacientes 
    INNER JOIN consultas
      ON consultas.data = '2021-12-07'
    WHERE consultas.paciente_id = pacientes.id;

-- 12 🆗 Mostrar a média de preços dos medicamentos.
SELECT AVG(preco) FROM medicamentos;

-- 13 🆗 Mostrar o número total de consultas cadastradas.
SELECT COUNT(*) FROM consultas;

-- 14 🆗 Listar o nome do medicamento mais caro.
SELECT nome, preco
  FROM medicamentos
    WHERE preco = (SELECT MAX(preco) FROM medicamentos);

SELECT nome, preco, (SELECT MAX(preco) FROM medicamentos) as maior_preco
  FROM medicamentos
    HAVING preco = maior_preco;

-- 15 🆗 Listar os nomes dos medicamentos que tem preço acima da média. 
SELECT nome, preco
  FROM medicamentos
    WHERE preco > (SELECT AVG(preco) FROM medicamentos);    

SELECT nome, preco, (SELECT AVG(preco) FROM medicamentos) as media_preco
  FROM medicamentos
    HAVING preco > media_preco;

-- 16 🆗 Listar todas as consultas com nome do médico, nome do paciente, data e hora.
SELECT medicos.nome AS medico_nome, pacientes.nome AS paciente_nome, consultas.`data`, consultas.hora
  FROM consultas
    INNER JOIN medicos
      ON consultas.medico_id = medicos.id
    INNER JOIN pacientes
      ON consultas.paciente_id = pacientes.id;

SELECT medicamentos.id, medicamentos.nome AS medicamento, medicos.nome AS medico
  FROM medicos
    INNER JOIN consultas
      ON medicos.id = consultas.medico_id
    INNER JOIN prescricao
      ON consultas.id = prescricao.consulta_id
    INNER JOIN medicamentos
      ON prescricao.medicamento_id = medicamentos.id
WHERE medicos.id = 3999 AND consulta.data >= "2021-10-01" AND consulta.data <= "2021-10-31";