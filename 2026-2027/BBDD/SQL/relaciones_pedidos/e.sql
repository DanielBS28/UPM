select nombre, nombre_producto, cantidad, ciudad
from Clientes
INNER JOIN Pedidos on Pedidos.id_cliente = Clientes.id_cliente
INNER JOIN Detalles_Pedido on Detalles_Pedido.id_pedido = Pedidos.id_pedido
INNER JOIN Productos on Productos.id_producto = Detalles_Pedido.id_producto
where ciudad <> 'Madrid' and cantidad > 1;