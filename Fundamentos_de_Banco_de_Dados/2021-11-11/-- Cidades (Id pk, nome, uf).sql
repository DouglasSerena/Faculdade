-- Cidades (Id pk, nome, uf)
-- Medicos(Id, nome, fone, CidadeId)
--     CidadeID references Cidades (Id);
-- Pacientes (id, nome, cidadeId)
-- consultas(id, data, medicoId, pacienteID)

CREATE TABLE cidades (
  id INT PRIMARY KEY,
  nome VARCHAR(255),
  uf CHAR(2)
);

CREATE TABLE medicos (
  id INT PRIMARY KEY,
  nome VARCHAR(255),
  fone VARCHAR(255),
  cidade_id INT,
  CONSTRAINT medicos_cidades_foreign_key FOREIGN KEY (cidade_id) REFERENCES cidades(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE pacientes (
  id INT PRIMARY KEY,
  nome VARCHAR(255),
  cidade_id INT,
  CONSTRAINT pacientes_cidades_foreign_key FOREIGN KEY (cidade_id) REFERENCES cidades(id) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE TABLE consultas (
  id INT PRIMARY KEY,
  `data` DATE,
  medico_id INT,
  paciente_id INT,
  CONSTRAINT consultas_medicos_foreign_key FOREIGN KEY (medico_id) REFERENCES medicos(id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT consultas_pacientes_foreign_key FOREIGN KEY (paciente_id) REFERENCES pacientes(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

select fi.*
from filialacesso fi
  INNER JOIN filial f ON fi.filial = f.id
WHERE usuario = 2252
  and f.codigo = 5001;

  INSERT INTO cidades (nome, uf)
    VALUES ('Rondônia','RO'),('Acre','AC'),('Amazonas','AM'),('Roraima','RR'),('Pará','PA'),('Amapá','AP'),('Tocantins','TO'),('Maranhão','MA'),('Piauí','PI'),('Ceará','CE'),('Rio Grande do Norte','RN'),('Paraíba','PB'),('Pernambuco','PE'),('Alagoas','AL'),('Sergipe','SE'),('Bahia','BA'),('Minas Gerais','MG'),('Espírito Santo','ES'),('Rio de Janeiro','RJ'),('São Paulo','SP'),('Paraná','PR'),('Santa Catarina','SC'),('Rio Grande do Sul','RS'),('Mato Grosso do Sul','MS'),('Mato Grosso','MT'),('Goiás','GO'),('Distrito Federal','DF');

    INSERT INTO pacientes (nome, cidade_id)
      VALUES ('nome 1',2),('nome 2',19),('nome 3',4),('nome 4',19),('nome 5',12),('nome 6',7),('nome 7',2),('nome 8',16),('nome 9',1),('nome 10',11),('nome 11',14),('nome 12',11),('nome 13',5),('nome 14',3),('nome 15',17),('nome 16',6),('nome 17',3),('nome 18',7),('nome 19',3),('nome 20',17),('nome 21',3),('nome 22',13),('nome 23',3),('nome 24',12),('nome 25',17),('nome 26',14),('nome 27',2),('nome 28',19),('nome 29',2),('nome 30',14),('nome 31',13),('nome 32',1),('nome 33',15),('nome 34',10),('nome 35',17),('nome 36',9),('nome 37',15),('nome 38',18),('nome 39',7),('nome 40',2),('nome 41',10),('nome 42',10),('nome 43',7),('nome 44',10),('nome 45',6),('nome 46',16),('nome 47',15),('nome 48',13),('nome 49',11),('nome 50',4),('nome 51',12),('nome 52',6),('nome 53',18),('nome 54',5),('nome 55',1),('nome 56',5),('nome 57',3),('nome 58',8),('nome 59',11),('nome 60',7),('nome 61',6),('nome 62',3),('nome 63',15),('nome 64',6),('nome 65',1),('nome 66',16),('nome 67',7),('nome 68',4),('nome 69',4),('nome 70',10),('nome 71',11),('nome 72',10),('nome 73',12),('nome 74',9),('nome 75',11),('nome 76',1),('nome 77',5),('nome 78',7),('nome 79',3),('nome 80',9),('nome 81',12),('nome 82',19),('nome 83',19),('nome 84',7),('nome 85',17),('nome 86',10),('nome 87',5),('nome 88',16),('nome 89',9),('nome 90',18),('nome 91',2),('nome 92',2),('nome 93',5),('nome 94',9),('nome 95',4),('nome 96',8),('nome 97',4),('nome 98',10),('nome 99',19),('nome 100',16');

      INSERT INTO medicos
        VALUE ('nome 1','49000000','9'),('nome 2','1000000','6'),('nome 3','74000000','1'),('nome 4','89000000','4'),('nome 5','68000000','8'),('nome 6','14000000','1'),('nome 7','23000000','5'),('nome 8','54000000','9'),('nome 9','90000000','15'),('nome 10','80000000','1'),('nome 11','78000000','14'),('nome 12','71000000','16'),('nome 13','92000000','18'),('nome 14','77000000','19'),('nome 15','73000000','13'),('nome 16','77000000','19'),('nome 17','10000000','5'),('nome 18','74000000','9'),('nome 19','99000000','3'),('nome 20','86000000','8'),('nome 21','82000000','7'),('nome 22','7000000','19'),('nome 23','22000000','19'),('nome 24','8000000','0'),('nome 25','65000000','1'),('nome 26','79000000','16'),('nome 27','24000000','5'),('nome 28','82000000','11'),('nome 29','25000000','8'),('nome 30','92000000','2'),('nome 31','17000000','8'),('nome 32','19000000','10'),('nome 33','6000000','12'),('nome 34','23000000','14'),('nome 35','52000000','11'),('nome 36','98000000','18'),('nome 37','3000000','3'),('nome 38','83000000','3'),('nome 39','59000000','15'),('nome 40','67000000','16'),('nome 41','72000000','19'),('nome 42','58000000','13'),('nome 43','18000000','19'),('nome 44','28000000','16'),('nome 45','11000000','14'),('nome 46','92000000','19'),('nome 47','25000000','17'),('nome 48','26000000','5'),('nome 49','78000000','1'),('nome 50','53000000','14'),('nome 51','30000000','16'),('nome 52','62000000','19'),('nome 53','45000000','16'),('nome 54','46000000','16'),('nome 55','17000000','3'),('nome 56','48000000','10'),('nome 57','62000000','16'),('nome 58','24000000','18'),('nome 59','25000000','7'),('nome 60','79000000','13'),('nome 61','93000000','8'),('nome 62','2000000','6'),('nome 63','23000000','12'),('nome 64','27000000','4'),('nome 65','3000000','8'),('nome 66','17000000','9'),('nome 67','29000000','3'),('nome 68','86000000','4'),('nome 69','35000000','17'),('nome 70','65000000','12'),('nome 71','66000000','12'),('nome 72','35000000','5'),('nome 73','66000000','3'),('nome 74','67000000','5'),('nome 75','77000000','17'),('nome 76','20000000','19'),('nome 77','50000000','3'),('nome 78','71000000','19'),('nome 79','82000000','17'),('nome 80','35000000','1'),('nome 81','4000000','10'),('nome 82','4000000','18'),('nome 83','10000000','12'),('nome 84','80000000','11'),('nome 85','80000000','1'),('nome 86','90000000','12'),('nome 87','66000000','16'),('nome 88','78000000','4'),('nome 89','5000000','12'),('nome 90','99000000','15'),('nome 91','46000000','0'),('nome 92','87000000','15'),('nome 93','13000000','15'),('nome 94','72000000','18'),('nome 95','67000000','16'),('nome 96','93000000','13'),('nome 97','44000000','8'),('nome 98','98000000','18'),('nome 99','35000000','6'),('nome 100','10000000','1');