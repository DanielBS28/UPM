SELECT d.driverId, d.forename, d.surname, COUNT(DISTINCT year), MIN(year), MAX(year)
FROM drivers d
	INNER JOIN results re ON re.driverId = d.driverId
	INNER JOIN races r ON r.raceId = re.raceId
GROUP BY driverId;

SELECT d.driverId, MIN(year), MAX(year)
FROM drivers d
	INNER JOIN results re ON re.driverId = d.driverId
	INNER JOIN races r ON r.raceId = re.raceId
GROUP BY driverId;

-- Crear columna 

ALTER TABLE drivers
ADD temporadas_activo INT;

-- Cursor
DELIMITER $$
CREATE PROCEDURE setYearInActive()
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE numDriver, min, max, yia INT;
	DECLARE cur CURSOR FOR SELECT d.driverId, MIN(year), MAX(year)
				FROM drivers d
					INNER JOIN results re ON re.driverId = d.driverId
					INNER JOIN races r ON r.raceId = re.raceId
				GROUP BY driverId; 				
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;-- Creación
	OPEN cur; -- Apertura
	read_loop: LOOP
	FETCH cur INTO numDriver, min, max; -- Uso
	IF done THEN
		LEAVE read_loop;
	END IF;
	
	SET yia = max - min + 1;
	UPDATE drivers
	SET temporadas_activo = yia
	WHERE driverId = numDriver;
	
	END LOOP;
	CLOSE cur; -- Cierre
END $$;
DELIMITER ;
