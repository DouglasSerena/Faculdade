/* ========================================================== */
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS passageiros;
DROP TABLE IF EXISTS viagens;
DROP TABLE IF EXISTS estacoes;
DROP TABLE IF EXISTS enderecos;
DROP TABLE IF EXISTS metros;

/* ========================================================== */

CREATE TABLE IF NOT EXISTS metros (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantidada_maxima_pessoa INT NULL DEFAULT NULL,
    nome VARCHAR(45) NULL DEFAULT NULL
);

/* ========================================================== */

CREATE TABLE IF NOT EXISTS passageiros (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    cpf VARCHAR(14) NULL DEFAULT NULL
);

/* ========================================================== */

CREATE TABLE IF NOT EXISTS enderecos (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(45) NULL DEFAULT NULL,
    numero VARCHAR(50) NULL DEFAULT NULL,
    bairro VARCHAR(45) NULL DEFAULT NULL,
    cep VARCHAR(45) NULL DEFAULT NULL
);

/* ========================================================== */

CREATE TABLE IF NOT EXISTS estacoes (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NULL DEFAULT NULL,
    endereco_id INT NOT NULL,
    CONSTRAINT estacao_endereco
        FOREIGN KEY (endereco_id)
            REFERENCES enderecos(id)
                ON DELETE CASCADE
                ON UPDATE CASCADE
);

/* ========================================================== */

CREATE TABLE IF NOT EXISTS viagens (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_inicio DATETIME NOT NULL,
    data_fim DATETIME NULL DEFAULT NULL,
    status ENUM("AGUARDANDO", "INICIADA", "FINALIZADA") DEFAULT "AGUARDANDO",
    metro_id INT NOT NULL,
    estacao_id INT NOT NULL,
    CONSTRAINT viagem_metro
        FOREIGN KEY (metro_id)
            REFERENCES metros(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT viagem_estacao
        FOREIGN KEY (estacao_id)
            REFERENCES estacoes(id)
            ON DELETE CASCADE ON UPDATE CASCADE
);

/* ========================================================== */

CREATE TABLE IF NOT EXISTS tickets (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    valor FLOAT NOT NULL,
    data_compra DATETIME NOT NULL,
    utilizado BOOLEAN DEFAULT 0,
    passageiros_id INT NOT NULL,
    viagem_id INT NOT NULL,
    CONSTRAINT ticket_passageiros
        FOREIGN KEY (passageiros_id) 
            REFERENCES passageiros(id) 
                ON DELETE CASCADE
                ON UPDATE CASCADE,
    CONSTRAINT ticket_viagem
        FOREIGN KEY (viagem_id) 
            REFERENCES viagens(id)
                ON DELETE CASCADE
                    ON UPDATE CASCADE
);

/* ========================================================== */