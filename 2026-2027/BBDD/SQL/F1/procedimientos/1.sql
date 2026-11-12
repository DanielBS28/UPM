DELIMITER $$
CREATE PROCEDURE getRacesInAYear (IN anio INTEGER)
BEGIN
	SELECT r.name, COUNT(DISTINCT constructorId)
	FROM races r
		INNER JOIN qualifying q on r.raceId = q.raceId
	WHERE r.year = anio	
	GROUP BY r.raceId, r.name;
END$$
DELIMITER ;


call formula1.getRacesInAYear(2010);
