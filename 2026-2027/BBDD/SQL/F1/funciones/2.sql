DELIMITER $$
CREATE FUNCTION avgConstructorPointsPerYear(constructorName VARCHAR(255))
RETURNS DECIMAL(8,2)
DETERMINISTIC
BEGIN
	DECLARE avgPoints DECIMAL(8,2);
    
    -- REGLA SQL: No se pueden anidar funciones de agregación directamente (como AVG(SUM(...))).
	-- Cuando necesites hacer una agregación sobre otra agregación, es obligatorio crear una 
	-- tabla derivada (subconsulta en el FROM) y asignarle un alias al final (AS seasonTotals).
	SELECT AVG(yearlyPoints) INTO avgPoints
	FROM (
		SELECT SUM(re.points) AS yearlyPoints
		FROM results re
			INNER JOIN constructors c ON re.constructorId = c.constructorId
			INNER JOIN races r ON re.raceId = r.raceId
		WHERE c.name = constructorName
		GROUP BY r.year
	) AS seasonTotals;

    
    RETURN avgPoints;
END $$
DELIMITER ;
