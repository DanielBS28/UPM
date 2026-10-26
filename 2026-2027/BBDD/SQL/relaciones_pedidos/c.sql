select id_pedido, nombre_producto 
FROM Productos
INNER JOIN Detalles_Pedido on Productos.id_producto = Detalles_Pedido.id_producto
where categoria = 'Electrónica' and precio > 100;