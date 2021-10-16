INSERT INTO categorias (nome) 
	VALUES 
    	('padaria'),
        ('Carnes'),
        ('Mercearia'),
        ('Matinais'),
        ('frios'),
        ('Laticínios'),
        ('Bebidas'),
        ('Utilidades Domésticas'),
        ('Limpezas'),
        ('Higiene'),
        ('Hortifruti'),
        ('Pet Shop');
        
INSERT INTO produtos (descricao, valor_unitario, categoria_id)
	VALUES 
      ('Café', 2.00, 1), -- INICIO Padaria
      ('Biscoito', 1.00, 1),
      ('Cereais', 5.00, 1),
      ('Achocolatado', 3.00, 1),
      ('Cha', 0.50, 1),
      ('Adoçante', 3.50, 1),
      ('Açúcar', 1.99, 1),
      ('Geleia', 3.99, 1),
      ('Pão', 0.40, 1),
      ('Requeijão', 4.00, 1),
      ('Manteiga', 5.10, 1),
      ('Iogurte', 2.00, 1),
      ('Bolo', 12.36, 1), -- FIM Padaria
      ('Arroz', 2.00, 2), -- INICIO Mercearia
      ('Feijão', 1.00, 2),
      ('Aveia em flocos', 5.00, 2),
      ('Caldo de carne', 3.00, 2),
      ('Gelatina', 0.50, 2),
      ('Macarrão instantâneo', 3.50, 2),
      ('Farinha de trigo', 1.99, 2),
      ('Barra de cereal', 3.99, 2),
      ('Fubá', 0.40, 2),
      ('Grão de bico', 4.00, 2),
      ('Palmito', 5.10, 2),
      ('Ervilha', 2.00, 2),
      ('Milho', 12.36, 2),
      ('Farinha de milho', 2.00, 2),
      ('Farinha de rosca', 1.00, 2),
      ('Fermento', 5.00, 2),
      ('Óleo', 3.00, 2),
      ('Azeite', 0.50, 2),
      ('Amido de milho', 3.50, 2),
      ('Macarrão', 1.99, 2),
      ('Azeitona', 3.99, 2),
      ('Maionese', 0.40, 2),
      ('Catchup e mostarda', 4.00, 2),
      ('Tempero pronto', 5.10, 2),
      ('Sal', 2.00, 2),
      ('Ovos', 12.36, 2),
      ('Queijo ralado', 4.00, 2),
      ('Vinagre', 5.10, 2),
      ('Molho de tomate', 2.00, 2); -- FIM Mercearia

INSERT INTO fornecedores (nome) 
	VALUES 
      ("Carlos pae"),
      ("Mercadão");
        
INSERT INTO pedidos (fornecedor_id, numero_pedido, data_pedido) 
	VALUES 
      (1, '120009', '2021-10-09'),
      (1, '120011', '2021-08-12'),
      (2, '1a25w213', '2021-08-19'),
      (1, '120011', '2021-10-04'),
      (2, '1a25w2d2', '2021-10-02');
        
INSERT INTO pedidos_produtos (produto_id, pedido_id, quantidade) 
	VALUES 
      (1, 1, 10),
      (3, 2, 5),
      (2, 3, 30),
      (9, 4, 200),
      (7, 5, 20);