SELECT * FROM categorias;

SELECT *, (valor_unitario * 1.10) as valor_acrescimo FROM produtos;

SELECT * FROM pedidos WHERE MONTH(data_pedido) = MONTH('2021-10-09');
SELECT * FROM pedidos;

SELECT * FROM produtos WHERE descricao LIKE 'Farinha%';

SELECT 
    pedidos_produtos.pedido_id,
    pedidos_produtos.produto_id,
    produtos.valor_unitario,
    pedidos_produtos.quantidade,
    (produtos.valor_unitario * pedidos_produtos.quantidade) as valor_total
        FROM pedidos_produtos 
            INNER JOIN produtos 
                on pedidos_produtos.produto_id = produtos.id;