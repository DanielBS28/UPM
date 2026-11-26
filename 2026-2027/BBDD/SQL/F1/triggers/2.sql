-- ============================================================================
-- 1. CREACIÓN DE LA TABLA crashes
-- ============================================================================
CREATE TABLE crashes (
    crashId INT AUTO_INCREMENT PRIMARY KEY,
    driverId INT NOT NULL,
    descripción VARCHAR(255) NOT NULL,
    FOREIGN KEY (driverId) REFERENCES drivers(driverId)
);

-- ============================================================================
-- 2. CREACIÓN DEL TRIGGER AFTER INSERT EN results
-- ============================================================================
DELIMITER $$

CREATE TRIGGER logCrash_AfterInsert
AFTER INSERT ON results
FOR EACH ROW
BEGIN
    DECLARE statusDesc VARCHAR(255);

    -- Comprobamos si el statusId insertado es 3 (Accident) o 4 (Collision)
    IF NEW.statusId IN (3, 4) THEN
        -- Obtenemos el texto descriptivo desde la tabla status
        SELECT status INTO statusDesc
        FROM status
        WHERE statusId = NEW.statusId;

        -- Insertamos el registro en la tabla crashes
        INSERT INTO crashes (driverId, descripción)
        VALUES (NEW.driverId, statusDesc);
    END IF;
END $$

DELIMITER ;

-- 1. Inserción con statusId = 3 (Accident) -> Debe añadir fila en crashes
INSERT INTO results (resultId, raceId, driverId, constructorId, number, positionOrder, points, laps, milliseconds, fastestLap, fastestLapTime, fastestLapSpeed, statusId)
VALUES (99994, 2, 1, 131, 44, 18, 0, 12, NULL, NULL, NULL, NULL, 3);

-- 2. Inserción con statusId = 4 (Collision) -> Debe añadir fila en crashes
INSERT INTO results (resultId, raceId, driverId, constructorId, number, positionOrder, points, laps, milliseconds, fastestLap, fastestLapTime, fastestLapSpeed, statusId)
VALUES (99995, 2, 2, 131, 6, 19, 0, 5, NULL, NULL, NULL, NULL, 4);

-- 3. Comprobación de la tabla crashes
SELECT * FROM crashes;
