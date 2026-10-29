SELECT affiliation_name, COUNT(*)
FROM affiliation a
	INNER JOIN author_affiliation aaf ON a.affiliation_id = aaf.affiliation_id
WHERE aaf.author_id IN (SELECT author_id
			FROM author_article authart
				INNER JOIN article art on authart.DOI = art.DOI
			WHERE YEAR(publication_date) = (SELECT MAX(YEAR(publication_date)) FROM article)
			GROUP BY author_id
			HAVING count(*) > 5)
GROUP BY a.affiliation_id, a.affiliation_name
HAVING COUNT(*) > 10;
					

