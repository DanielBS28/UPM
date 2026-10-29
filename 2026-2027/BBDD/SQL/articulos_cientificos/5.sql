SELECT journal.journal_name, ISSN, SUM(num_citations) as total_citations
FROM journal
	INNER JOIN article on article.journal_id = journal.journal_id
WHERE JIF_Quartile = 'Q1'
GROUP BY journal.journal_id, ISSN
HAVING total_citations >= ALL (SELECT SUM(num_citations)
					FROM journal 
						INNER JOIN article on article.journal_id = journal.journal_id
						WHERE JIF_Quartile = 'Q1'
						GROUP BY journal.journal_id);
