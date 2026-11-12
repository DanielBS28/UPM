SELECT DISTINCT r.driverId
FROM results r
	INNER JOIN drivers d ON r.driverId = d.driverId
WHERE r.year = 2010 
	AND positionOrder = 1;
				
