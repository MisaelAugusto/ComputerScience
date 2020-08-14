--Questão 1--
SELECT * FROM department;
--Questão 2--
SELECT * FROM dependent;
--Questão 3--
SELECT * FROM dept_locations;
--Questão 4--
SELECT * FROM employee;
--Questão 5--
SELECT * FROM project;
--Questão 6--
SELECT * FROM works_on;
--Questão 7--
SELECT E.fname, E.lname 
FROM employee AS E
WHERE E.sex = 'M';
--Questão 8--
SELECT E.fname
FROM employee AS E
WHERE E.superssn IS NULL;
--Questão 9--
SELECT E.fname, S.fname
FROM employee AS E, employee AS S
WHERE E.superssn = S.ssn AND E.superssn IS NOT NULL;
--Questão 10--
SELECT E.fname
FROM employee AS E, employee AS S
WHERE E.superssn = S.ssn AND S.fname = 'Franklin';
--Questão 11--
SELECT D.dname, D.dnumber
FROM department AS D;
--Questão 12--
SELECT D.dname
FROM department AS D, dept_locations AS DL
WHERE D.dnumber = DL.dnumber AND DL.dlocation LIKE 'S%';
--Questão 13--
SELECT E.fname, E.lname, D.dependent_name
FROM employee AS E, dependent AS D
WHERE E.ssn = D.essn;
--Questão 14--
SELECT E.fname || ' ' || E.minit || '. ' || E.lname AS full_name, E.salary
FROM employee AS E
WHERE salary > 50000;
--Questão 15--
SELECT P.pname, D.dname
FROM project AS P, department AS D
WHERE P.dnum = D.dnumber;
--Questão 16--
SELECT P.pname, G.fname
FROM project AS P, employee AS G, department AS D
WHERE P.dnum = D.dnumber AND D.mgrssn = G.ssn AND P.pnumber > 30;
--Questão 17--
SELECT P.pname, E.fname
FROM project AS P, employee AS E, department AS D
WHERE P.dnum = D.dnumber AND D.mgrssn = E.ssn;
--Questão 18--
SELECT E.fname, Dp.dependent_name, Dp.relationship
FROM employee AS E, project AS P, dependent AS Dp
WHERE E.dno = P.dnum AND E.ssn = Dp.essn AND P.pnumber = 91;


