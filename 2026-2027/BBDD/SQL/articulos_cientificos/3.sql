SELECT distinct author_name , af . affiliation_name
FROM author a
	INNER JOIN author_affiliation aaf ON a . author_id = aaf.author_id
	INNER JOIN affiliation af ON aaf . affiliation_id = af.affiliation_id
WHERE a . author_id NOT IN ( SELECT author_id
FROM author_article aar
INNER JOIN article ar ON aar . DOI = ar . DOI
WHERE YEAR ( publication_date ) = 2020)
AND a . author_id NOT IN ( SELECT author_id
FROM author_article aar
INNER JOIN article ar ON aar . DOI = ar . DOI
WHERE YEAR ( ar . publication_date ) = 2021)
AND country_name = ' Spain '
ORDER BY af . affiliation_name DESC , author_name ;
