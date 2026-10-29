SELECT JIF, journal_name
FROM journal
WHERE JIF >= (SELECT AVG(JIF) FROM journal)
	AND journal_id IN (SELECT journal_id
				FROM article 
				WHERE YEAR(publication_date) = (SELECT MIN(YEAR(publication_date)) FROM article)
				GROUP BY journal_id
				HAVING COUNT(*) > 300);


	

