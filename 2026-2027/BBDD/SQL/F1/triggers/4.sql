-- ============================================================================
-- 1. CREACIÓN DE LA TABLA sponsors
-- ============================================================================
CREATE TABLE sponsors (
    sponsorId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(20),
    raceId INT NOT NULL,
    annualMoney DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (raceId) REFERENCES races(raceId)
);

-- ============================================================================
-- 2. TRIGGER BEFORE INSERT: Clasifica al patrocinador al darlo de alta
-- ============================================================================
DELIMITER $$

CREATE TRIGGER classifySponsor_Insert
BEFORE INSERT ON sponsors
FOR EACH ROW
BEGIN
    IF NEW.annualMoney >= 5000000 THEN
        SET NEW.type = 'oficial';
    ELSE
        SET NEW.type = 'cooficial';
    END IF;
END $$

-- ============================================================================
-- 3. TRIGGER BEFORE UPDATE: Reclasifica si se modifica la aportación anual
-- ============================================================================
CREATE TRIGGER classifySponsor_Update
BEFORE UPDATE ON sponsors
FOR EACH ROW
BEGIN
    IF NEW.annualMoney >= 5000000 THEN
        SET NEW.type = 'oficial';
    ELSE
        SET NEW.type = 'cooficial';
    END IF;
END $$

DELIMITER ;

INSERT INTO sponsors (name, raceId, annualMoney) VALUES ('Rolex', 1, 6000000.00);
INSERT INTO sponsors (name, raceId, annualMoney) VALUES ('Heineken', 1, 2500000.00);
SELECT * FROM sponsors;
