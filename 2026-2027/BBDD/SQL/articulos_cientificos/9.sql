
SELECT author_name, count(*), publication_date
FROM author
	INNER JOIN author_article on author.author_id = author_article.author_id
	INNER JOIN article on article.DOI = author_article.DOI
GROUP BY author.author_id, publication_date

SELECT COUNT(DISTINCT YEAR(publication_date))
FROM article;
