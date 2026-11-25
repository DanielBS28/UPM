DELIMITER $$
CREATE FUNCTION wordlChampionPoints(y INTEGER)
RETURNS DECIMAL(6,2)
DETERMINISTIC
BEGIN
	DECLARE sp DECIMAL(6,2);
    
	SELECT SUM(re.points) INTO sp
	FROM results re 
		INNER JOIN races r ON re.raceId = r.raceId
	WHERE r.year = y
	GROUP BY re.driverId
	ORDER BY SUM(re.points) DESC
	LIMIT 1;
    
    RETURN sp;
END $$
DELIMITER ;
