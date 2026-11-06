SELECT DISTINCT matricula, n.nombre
FROM Nave n 
	INNER JOIN Superviviente s on n.matricula = s.matricula_nave
WHERE matricula NOT IN (SELECT matricula
			FROM Nave n 
				INNER JOIN Superviviente s on n.matricula = s.matricula_nave
                        WHERE s.profesion = 'Civil');
