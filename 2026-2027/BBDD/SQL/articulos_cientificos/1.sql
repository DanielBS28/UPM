SELECT author_name
FROM author a
    INNER JOIN author_article aa on a.author_id = aa.author_id
    INNER JOIN article art on art.DOI = aa.DOI
    INNER JOIN author_affiliation af on af.author_id = a.author_id
    INNER JOIN affiliation affl on affl.affiliation_id = af.affiliation_id
WHERE affiliation_name = 'Universidad Politécnica de Madrid';
