SELECT nombre, fecha_pedido 
FROM Clientes
INNER JOIN Pedidos ON Clientes.id_cliente = Pedidos.id_cliente
WHERE month(Pedidos.fecha_pedido) = 11
	AND year(Pedidos.fecha_pedido) = 2023;
    
    /*
SELECT c.nombre, p.fecha_pedido 
FROM Clientes c
INNER JOIN Pedidos p ON c.id_cliente = p.id_cliente
WHERE p.fecha_pedido LIKE '2023-11-%';
*/

/*
SELECT c.nombre, p.fecha_pedido 
FROM Clientes c
INNER JOIN Pedidos p ON c.id_cliente = p.id_cliente
WHERE p.fecha_pedido >= '2024-11-01' 
  AND p.fecha_pedido <= '2024-11-30';
  */