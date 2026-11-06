SELECT s.nombre, fecha_nac
FROM Superviviente s
	INNER JOIN Colonia c on c.codigo = s.colonia
WHERE s.profesion = 'Piloto' and c.nombre = 'Caprica';
