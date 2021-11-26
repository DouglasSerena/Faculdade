DROP TABLE IF EXISTS consultas;

DROP TABLE IF EXISTS medicos;

DROP TABLE IF EXISTS pacientes;

DROP TABLE IF EXISTS cidades;

CREATE TABLE IF NOT EXISTS cidades (
    ID SERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    UF CHAR(2) NOT NULL
);

CREATE TABLE IF NOT EXISTS medicos (
    ID SERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    fone VARCHAR(50) NOT NULL,
    cidade_id INT NOT NULL,
    CONSTRAINT cidades FOREIGN KEY (cidade_id) REFERENCES cidades(ID)
);

CREATE TABLE IF NOT EXISTS pacientes (
    ID SERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cidade_id INT NOT NULL,
    CONSTRAINT cidades FOREIGN KEY (cidade_id) REFERENCES cidades(ID)
);

CREATE TABLE IF NOT EXISTS consultas (
    ID SERIAL NOT NULL PRIMARY KEY,
    data_consulta DATE NOT NULL,
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    CONSTRAINT medicos FOREIGN KEY (medico_id) REFERENCES medicos(ID),
    CONSTRAINT pacientes FOREIGN KEY (paciente_id) REFERENCES pacientes(ID)
);

INSERT INTO cidades (nome, uf)
VALUES ('Rondônia', 'RO'), ('Acre', 'AC'), ('Amazonas', 'AM'), ('Roraima', 'RR'), ('Pará', 'PA'), ('Amapá', 'AP'), ('Tocantins', 'TO'), ('Maranhão', 'MA'), ('Piauí', 'PI'), ('Ceará', 'CE'), ('Rio Grande do Norte', 'RN'), ('Paraíba', 'PB'), ('Pernambuco', 'PE'), ('Alagoas', 'AL'), ('Sergipe', 'SE'), ('Bahia', 'BA'), ('Minas Gerais', 'MG'), ('Espírito Santo', 'ES'), ('Rio de Janeiro', 'RJ'), ('São Paulo', 'SP'), ('Paraná', 'PR'), ('Santa Catarina', 'SC'), ('Rio Grande do Sul', 'RS'), ('Mato Grosso do Sul', 'MS'), ('Mato Grosso', 'MT'), ('Goiás', 'GO'), ('Distrito Federal', 'DF');

INSERT INTO pacientes (nome, cidade_id)
VALUES ('Estelle',11),('Katelin',12),('Laurie',12),('Rosalyn',14),('Jose',11),('Randall',3),('Marcos',2),('Jacky',1),('Talia',8),('Mariana',14),('Greta',8),('Emmitt',3),('Celestine',13),('Vallie',17),('Loraine',8),('Alexander',1),('Monica',4),('Sierra',16),('Davonte',9),('Paris',7),('Koby',15),('Ellsworth',4),('Beverly',18),('Hipolito',6),('Hoyt',9),('Anne',5),('Beryl',19),('Katlyn',14),('Ivory',16),('Caleigh',1),('Clementina',2),('Brock',17),('Violet',12),('Marquise',15),('Aurelia',7),('Christine',5),('Kyle',5),('Abbey',1),('Kailey',4),('Brent',1),('Foster',13),('Ibrahim',8),('Elias',12),('Verner',4),('Jade',11),('Aylin',8),('Oswaldo',13),('Golda',18),('Adriel',11),('Judah',8),('Esther',2),('Paris',6),('Taylor',15),('Ephraim',4),('Jarvis',5),('Lyla',15),('Justice',1),('Monroe',9),('Jaron',19),('Barton',8),('Lorenza',13),('Glennie',11),('Rocky',5),('Brendan',9),('Alysson',8),('Berenice',17),('Marguerite',13),('Eva',6),('Tyree',10),('Vernie',1),('Myrtice',10),('Albina',11),('Zion',7),('Johnpaul',17),('Emie',1),('Tomasa',12),('April',18),('Erling',5),('Jazmyne',8),('Hershel',11),('Mckenzie',9),('Teresa',10),('Carter',9),('Justine',7),('Eldora',19),('Imogene',12),('Elmo',7),('Virginia',16),('Jevon',7),('Rusty',11),('Florida',5),('Alberta',14),('Lacy',11),('Jade',8),('Alicia',11),('Chandler',7),('Itzel',4),('Benedict',6),('Gene',3),('Sigmund',19);

INSERT INTO medicos (nome, fone, cidade_id)
VALUES ('Elena','(545) 358-8425',10),('Lera','825.291.9491',10),('Crawford','(390) 916-7906 x33550',19),('Gracie','564.208.4335',12),('Lina','1-755-521-2534 x8779',12),('Walton','1-767-991-3282',5),('Kailey','(347) 499-3500 x6119',18),('Nadia','(659) 261-1261 x158',2),('Declan','(812) 684-1475 x03807',9),('Elvera','822-898-2574 x8493',1),('Larissa','(470) 331-4931 x1856',13),('Wendy','(707) 637-9895 x396',18),('Elinor','(674) 504-7669 x02469',12),('Lesley','579.232.2035',5),('Maybell','(808) 986-4996',15),('Kody','794.840.1030 x76036',6),('Ted','959.683.1122 x5216',10),('Camron','838.451.7024 x75892',8),('Nakia','(962) 558-6007 x7442',3),('Kory','(250) 308-2019 x762',18),('Wilfrid','899.441.8722 x8075',16),('Rachel','641.231.7882 x0265',18),('Doug','1-258-480-3404',7),('Gardner','565.257.4439',4),('Lindsay','1-452-466-6775 x01724',3),('Lloyd','833-442-7042 x5760',16),('Maud','1-685-334-6390 x217',15),('Annabelle','1-268-295-8929 x289',10),('Eulah','714-702-3443 x9418',1),('Cullen','830.909.5807',10),('Mozell','(531) 401-9567',12),('Pete','564.567.5801 x3354',9),('Allene','260.684.9507 x294',15),('Sandrine','(680) 798-3828',16),('Chaya','(900) 323-0400',1),('Lessie','944.567.3251',3),('Brandi','297.437.2900 x381',1),('Jesus','720-976-7670 x13498',10),('Gene','435.276.0645 x204',2),('Jazmin','655.567.3062 x992',8),('Landen','724.394.4560',10),('Ila','781-501-2387 x02336',4),('Seamus','(736) 541-0424 x75980',8),('Americo','(880) 261-5432',13),('Darrion','(813) 914-2613',4),('Vicky','(892) 269-3989 x9583',1),('Devyn','1-709-969-7958 x6427',12),('Corbin','321.741.2627',19),('Odessa','(276) 752-7547 x15174',16),('Uriel','315-593-4219',9),('Diamond','1-585-429-6856',19),('Frieda','1-809-944-6006 x205',1),('Velva','1-650-856-3325 x45088',1),('Abigail','(508) 997-9202 x76792',17),('Samantha','299.560.1485 x71671',8),('Wendy','461.993.9652 x72990',4),('Delbert','(942) 987-8770 x977',5),('Adah','(602) 887-5082 x1826',18),('Cleora','847-958-4820 x376',15),('Francisca','(391) 469-7949',3),('Sandy','(559) 843-7011 x363',7),('Jayda','407.923.7667 x902',15),('Florine','(952) 561-2215 x08988',3),('Griffin','1-671-276-6135',3),('Blaise','451.444.4775 x2432',16),('Camille','1-904-570-7385 x070',17),('Nedra','1-871-554-5186',15),('Gloria','455.403.3560',17),('Jayden','579-386-4495',9),('Simone','(592) 573-1581 x12098',1),('Miller','806.917.6963 x3826',9),('Adolphus','976-394-8918',13),('Polly','1-539-944-4339 x82324',12),('Katelynn','1-839-825-9470 x0743',1),('Verdie','736.959.0846 x183',19),('Aniya','927.874.9958',8),('Deon','(447) 314-4192',5),('Orlo','251.633.2489',13),('Felicity','1-801-243-4310',2),('Gerry','1-681-302-9448',4),('Jennifer','271.344.9801',13),('Wilfrid','348-830-1003',8),('Faye','(430) 401-9056 x704',19),('Mitchell','566-997-4213 x126',15),('Efrain','466-769-3686 x0054',6),('Clemens','496.828.0099',16),('Cassandra','456.858.5598 x232',16),('Korbin','(239) 533-0879 x130',1),('Adah','1-568-701-6582 x4539',2),('Judd','272-626-7237 x0508',15),('Nedra','1-287-888-2180 x2269',5),('Bridie','786-826-4496',3),('Nikolas','1-326-750-8303 x53501',1),('Fannie','(660) 597-6007',15),('Brannon','337.483.0076 x4007',8),('Makenna','(875) 647-3044',16),('Elva','314.475.5336',10),('Marcelino','(266) 413-3688 x3035',17),('Hillary','733-941-5770',4),('Corbin','1-889-651-2712 x858',2);

INSERT INTO consultas (data_consulta, medico_id, paciente_id)
VALUES ('2021-06-17', 57, 55), ('2021-07-14', 47, 81), ('2021-08-31', 80, 85), ('2021-01-29', 1, 99), ('2021-04-06', 74, 12), ('2021-04-01', 45, 12), ('2021-06-01', 29, 55), ('2021-08-05', 48, 6), ('2021-07-13', 5, 90), ('2021-02-03', 2, 45), ('2021-02-22', 19, 29), ('2021-09-09', 77, 90), ('2021-05-02', 57, 11), ('2021-06-21', 66, 54), ('2021-06-10', 3, 86), ('2021-05-02', 55, 82), ('2021-06-21', 10, 30), ('2020-12-11', 13, 62), ('2021-03-21', 79, 6), ('2021-09-21', 39, 72), ('2021-10-21', 30, 22), ('2020-12-17', 100, 86), ('2020-12-23', 93, 79), ('2020-12-30', 91, 97), ('2021-07-18', 20, 27), ('2021-09-27', 71, 95), ('2021-01-06', 2, 1), ('2020-11-24', 69, 80), ('2021-01-04', 80, 16), ('2020-11-23', 38, 91), ('2021-05-25', 98, 92), ('2021-10-04', 89, 58), ('2021-06-03', 15, 68), ('2021-06-17', 31, 88), ('2021-04-12', 88, 17), ('2021-03-05', 9, 88), ('2020-12-03', 22, 87), ('2020-12-14', 56, 48), ('2021-03-06', 28, 89), ('2021-06-16', 1, 90), ('2021-04-25', 11, 85), ('2021-10-31', 92, 3), ('2021-04-24', 13, 99), ('2021-05-14', 14, 9), ('2021-01-28', 11, 88), ('2021-10-26', 28, 20), ('2020-12-12', 23, 16), ('2021-08-14', 38, 58), ('2021-10-21', 44, 33), ('2020-12-23', 60, 39), ('2021-07-19', 31, 4), ('2021-01-10', 76, 2), ('2021-09-23', 52, 47), ('2021-08-12', 69, 83), ('2021-04-08', 67, 16), ('2021-05-10', 49, 30), ('2021-04-05', 84, 72), ('2021-06-05', 97, 72), ('2021-02-06', 25, 6), ('2021-07-12', 49, 97), ('2021-02-21', 16, 44), ('2021-09-20', 98, 88), ('2021-04-30', 81, 67), ('2021-10-21', 65, 81), ('2021-07-15', 71, 84), ('2021-04-15', 82, 22), ('2020-12-26', 55, 47), ('2021-08-18', 36, 60), ('2021-05-13', 36, 26), ('2021-06-25', 99, 38), ('2021-02-19', 15, 47), ('2021-10-27', 26, 10), ('2021-09-13', 81, 63), ('2021-07-22', 34, 93), ('2021-11-01', 48, 53), ('2021-06-30', 22, 1), ('2021-10-10', 77, 46), ('2021-04-18', 13, 34), ('2021-03-04', 31, 51), ('2021-07-05', 4, 73), ('2021-01-13', 74, 24), ('2021-05-05', 35, 72), ('2021-10-21', 52, 17), ('2020-12-27', 78, 42), ('2021-06-21', 48, 93), ('2021-09-01', 76, 7), ('2021-08-20', 49, 37), ('2021-04-03', 26, 55), ('2021-09-19', 12, 13), ('2021-04-23', 76, 90), ('2021-10-12', 12, 97), ('2021-02-06', 80, 15), ('2021-10-25', 5, 83), ('2021-03-23', 63, 90), ('2021-01-27', 11, 94), ('2021-06-30', 62, 91), ('2021-11-07', 36, 56), ('2021-01-31', 49, 37), ('2021-06-12', 88, 10), ('2021-04-07', 14, 37);



INSERT INTO cidades (nome,uf,id) VALUES ('Savannah','South Carolina',1),('Ashburn','Montana',2),('Brooklyn Park','Kansas',3),('Oakland Park','Colorado',4),('Jackson','Kansas',5),('Arlington','Texas',6),('Collierville','Virginia',7),('Covina','Missouri',8),('Troy','Rhode Island',9),('Montgomery','Hawaii',10),('Santa Maria','North Carolina',11),('Metairie','Arkansas',12),('Poway','New Jersey',13),('Concord','Iowa',14),('Lacey','Utah',15),('Cranston','Nevada',16),('Thornton','West Virginia',17),('Rock Hill','Maine',18),('Chico','Michigan',19),('Layton','Iowa',20),('San Leandro','West Virginia',21),('Jefferson City','New Hampshire',22),('Titusville','Pennsylvania',23),('Pico Rivera','Nevada',24),('Cupertino','Maine',25),('Pine Hills','Georgia',26),('Port Charlotte','Kentucky',27),('Santee','Massachusetts',28),('Aurora','Kansas',29),('East Orange','Pennsylvania',30),('Port Arthur','Oregon',31),('Huntington','Alabama',32),('Lake Charles','Massachusetts',33),('Bradenton','Missouri',34),('Revere','North Carolina',35),('Huntsville','Nebraska',36),('East Lansing','Georgia',37),('Buena Park','Wyoming',38),('Cary','Missouri',39),('Tuscaloosa','West Virginia',40),('Ocala','Nevada',41),('Merced','Washington',42),('Troy','Nevada',43),('Pine Bluff','Georgia',44),('Lees Summit','New Mexico',45),('Greenwood','Oregon',46),('Whittier','Georgia',47),('State College','New York',48),('High Point','Georgia',49),('Pembroke Pines','Wisconsin',50),('Cuyahoga Falls','Oklahoma',51),('Edinburg','Oklahoma',52),('Perris','Idaho',53),('Aloha','Texas',54),('Blacksburg','California',55),('St. George','Oregon',56),('Cheyenne','New Mexico',57),('Springfield','Delaware',58),('Beavercreek','Maine',59),('Santee','Iowa',60),('League City','Florida',61),('Bristol','Delaware',62),('Mansfield','Connecticut',63),('Pasadena','Idaho',64),('Highland','Arizona',65),('Tulsa','Alaska',66),('Vineland','South Dakota',67),('Bethlehem','North Carolina',68),('Petaluma','Arkansas',69),('Chattanooga','Iowa',70),('Potomac','Missouri',71),('Olathe','Washington',72),('St. Louis Park','California',73),('Manteca','Pennsylvania',74),('Nampa','North Dakota',75),('Sparks','West Virginia',76),('Irvine','Washington',77),('Rio Rancho','South Dakota',78),('Hilo','Nevada',79),('Bend','New Hampshire',80),('Arlington','Massachusetts',81),('Chattanooga','California',82),('Bayonne','Nevada',83),('Kissimmee','Alabama',84),('Lincoln','Minnesota',85),('Athens-Clarke County','Missouri',86),('Palmdale','New York',87),('North Las Vegas','Hawaii',88),('Odessa','Texas',89),('Kendall','Wisconsin',90),('Apex','Maryland',91),('Azusa','New Jersey',92),('Sparks','South Dakota',93),('Turlock','Montana',94),('Philadelphia','Colorado',95),('Noblesville','Maine',96),('Fort Myers','Pennsylvania',97),('Hattiesburg','Iowa',98),('Highlands Ranch','Pennsylvania',99),('Santee','New York',100); 