-- Consulta

SELECT forename 
FROM drivers
	WHERE nationality = 'Spanish';
	
DELIMITER $$
CREATE PROCEDURE pilotoPais(IN pais TEXT, OUT pilotosPais TEXT)
	BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE nombre TEXT;
	DECLARE cur CURSOR FOR SELECT forename 
					FROM drivers
						WHERE nationality = pais;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	
	SET pilotosPais = '';
	OPEN cur; -- Apertura
	read_loop: LOOP
	FETCH cur INTO nombre; -- Uso
	IF done THEN
	LEAVE read_loop;
	END IF;
	IF pilotosPais = '' THEN
		SET pilotosPais = nombre;
	ELSE
		SET pilotosPais = CONCAT(pilotosPais, ', ', nombre);
	END IF;
	END LOOP;
	CLOSE cur; -- Cierre
END $$
DELIMITER ;
