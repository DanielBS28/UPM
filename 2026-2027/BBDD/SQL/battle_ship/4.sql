SELECT nombre, tipo_nave FROM Nave

INNER JOIN Contiene
ON Nave.matricula = Contiene.matricula_nave

GROUP BY matricula

HAVING COUNT(codigo_recurso) = (SELECT COUNT(*) FROM Recurso);
			FROM Recurso);
	
