SELECT tipo_nave
FROM Nave
GROUP BY tipo_nave
HAVING count(*) >= ALL (SELECT count(*) 
                        FROM Nave
                        GROUP BY tipo_nave);
                        
                        
-- SELECT tipo_nave, count(*) as cuenta
-- FROM Nave
-- GROUP BY tipo_nave
-- HAVING cuenta >= ALL (SELECT count(*) 
--                        FROM Nave
--                        GROUP BY tipo_nave);

