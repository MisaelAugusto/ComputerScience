--Questão 1--
SELECT COUNT(*)
FROM employee AS E
WHERE E.sex = 'F';
--Questão 2--
SELECT AVG(salary)
FROM employee AS E
WHERE E.sex = 'M' AND E.address LIKE '%TX';
--Questão 3--
SELECT DISTINCT S.ssn AS ssn_supervisor, COUNT(*) AS qtd_supervisionados
FROM employee AS E LEFT OUTER JOIN employee AS S
ON E.superssn = S.ssn
GROUP BY ssn_supervisor
ORDER BY qtd_supervisionados;
--Questão 4--
SELECT DISTINCT S.fname AS nome_supervisor, COUNT(*) AS qtd_supervisionados
FROM employee AS E INNER JOIN employee AS S
ON E.superssn = S.ssn
GROUP BY nome_supervisor
ORDER BY qtd_supervisionados;
--Questão 5--
SELECT DISTINCT S.fname AS nome_supervisor, COUNT(*) AS qtd_supervisionados
FROM employee AS E LEFT JOIN employee AS S
ON E.superssn = S.ssn
GROUP BY nome_supervisor
ORDER BY qtd_supervisionados;
--Questão 6--
SELECT DISTINCT pno , COUNT(*) AS qtd
FROM works_on AS W
GROUP BY pno;
--Questão 7--
--Questão 8--
--Questão 9--
--Questão 10--
--Questão 11--
--Questão 12--
--Questão 13--
--Questão 14--
--Questão 15--
--Questão 16--
--Questão 17--
--Questão 18--