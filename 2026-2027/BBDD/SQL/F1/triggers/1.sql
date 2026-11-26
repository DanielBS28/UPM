DELIMITER $$

-- ============================================================================
-- TRIGGER 1: Controlar nuevas inserciones (BEFORE INSERT)
-- Impide insertar un tercer piloto para la misma escudería en una carrera.
-- ============================================================================
CREATE TRIGGER checkMaxDrivers_Insert
BEFORE INSERT ON results
FOR EACH ROW
BEGIN
	DECLARE driverCount INTEGER;
    
	-- Contamos cuántos pilotos ya tiene ese constructor en esa carrera
	SELECT COUNT(*) INTO driverCount
	FROM results
	WHERE raceId = NEW.raceId 
	  AND constructorId = NEW.constructorId;
      
	-- Si ya hay 2 (o más), lanzamos un error personalizado para abortar el INSERT
	IF driverCount >= 2 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Error: Un constructor no puede tener más de 2 pilotos en una misma carrera.';
	END IF;
END $$


-- ============================================================================
-- TRIGGER 2: Controlar modificaciones (BEFORE UPDATE)
-- Impide que al cambiar la carrera o el constructor de un resultado existente,
-- se supere el límite de 2 pilotos.
-- ============================================================================
CREATE TRIGGER checkMaxDrivers_Update
BEFORE UPDATE ON results
FOR EACH ROW
BEGIN
	DECLARE driverCount INTEGER;
    
	-- Solo comprobamos si realmente se está cambiando la carrera o el constructor.
	-- Si solo se actualizan los puntos o la posición, no hace falta comprobar.
	IF NEW.raceId <> OLD.raceId OR NEW.constructorId <> OLD.constructorId THEN
		SELECT COUNT(*) INTO driverCount
		FROM results
		WHERE raceId = NEW.raceId 
		  AND constructorId = NEW.constructorId;
          
		IF driverCount >= 2 THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Error: Un constructor no puede tener más de 2 pilotos en una misma carrera.';
		END IF;
	END IF;
END $$

DELIMITER ;


-- 1. PRIMER PILOTO (Pasa de 0 a 1 piloto) -> Debe ejecutarse SIN problemas
INSERT INTO results (resultId, raceId, driverId, constructorId, number, positionOrder, points, laps, milliseconds, fastestLap, fastestLapTime, fastestLapSpeed, statusId)
VALUES (99991, 1, 1, 131, 44, 1, 10, 58, 5655784, 39, '1:27.452', '218.300', 1);

-- 2. SEGUNDO PILOTO (Pasa de 1 a 2 pilotos) -> Debe ejecutarse SIN problemas
INSERT INTO results (resultId, raceId, driverId, constructorId, number, positionOrder, points, laps, milliseconds, fastestLap, fastestLapTime, fastestLapSpeed, statusId)
VALUES (99992, 1, 2, 131, 6, 2, 8, 58, 5658000, 40, '1:27.900', '217.500', 1);

-- 3. TERCER PILOTO (Ya hay 2 pilotos) -> Debe FALLAR y saltar el mensaje del trigger
INSERT INTO results (resultId, raceId, driverId, constructorId, number, positionOrder, points, laps, milliseconds, fastestLap, fastestLapTime, fastestLapSpeed, statusId)
VALUES (99993, 1, 3, 131, 77, 3, 6, 58, 5660000, 41, '1:28.100', '216.800', 1);
