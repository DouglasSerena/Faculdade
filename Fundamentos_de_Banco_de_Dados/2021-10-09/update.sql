UPDATE categorias SET nome='Padaria' WHERE id=1;
UPDATE categorias SET nome='Frios' WHERE id=5;

UPDATE produtos SET descricao='Chá', valor_unitario=0.60 WHERE id=5;

UPDATE fornecedores SET nome='Carlos pães' WHERE id=1;

UPDATE pedidos SET numero_pedido='120010' WHERE id=2;

UPDATE pedidos_produtos SET quantidade=8.00 WHERE pedido_id=2;