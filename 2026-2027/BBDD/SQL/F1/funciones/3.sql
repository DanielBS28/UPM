-- ============================================================================
-- OPCIÓN 1: Rango total de trayectoria (MAX - MIN + 1) -> Criterio del profesor
-- Calcula la amplitud desde su año de debut hasta su última temporada.
-- Incluye posibles años intermedios en los que no haya corrido.
-- Si el piloto no existe, devuelve NULL.
-- ============================================================================
DELIMITER $$
CREATE FUNCTION activeYearsByDriver_Range(p_driverId INTEGER)
RETURNS INTEGER
DETERMINISTIC
BEGIN
	DECLARE totalYears INTEGER;
    
	SELECT MAX(r.year) - MIN(r.year) + 1 INTO totalYears
	FROM results re
		INNER JOIN races r ON re.raceId = r.raceId
	WHERE re.driverId = p_driverId;
    
    RETURN totalYears;
END $$
DELIMITER ;


-- ============================================================================
-- OPCIÓN 2: Solo temporadas efectivamente disputadas (COUNT DISTINCT)
-- Cuenta únicamente los años en los que el piloto participó en al menos una carrera.
-- Descarta automáticamente los años sabáticos o retiradas temporales.
-- Si el piloto no existe, devuelve 0.
-- ============================================================================
DELIMITER $$
CREATE FUNCTION activeYearsByDriver_Count(p_driverId INTEGER)
RETURNS INTEGER
DETERMINISTIC
BEGIN
	DECLARE totalYears INTEGER;
    
	SELECT COUNT(DISTINCT r.year) INTO totalYears
	FROM results re
		INNER JOIN races r ON re.raceId = r.raceId
	WHERE re.driverId = p_driverId;
    
    RETURN totalYears;
END $$
DELIMITER ;
