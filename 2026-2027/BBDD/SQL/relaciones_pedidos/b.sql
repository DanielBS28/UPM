SELECT nombre_producto
FROM Clientes
INNER JOIN Pedidos on Clientes.id_cliente = Pedidos.id_cliente
INNER JOIN Detalles_Pedido on Pedidos.id_pedido = Detalles_Pedido.id_pedido
INNER JOIN Productos on Productos.id_producto = Detalles_Pedido.id_producto

where nombre = 'Ana García';