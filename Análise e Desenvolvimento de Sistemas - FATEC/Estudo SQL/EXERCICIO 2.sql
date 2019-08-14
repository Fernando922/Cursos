--LISTA 2
-- 1 -1 - Liste os nomes e as datas de nascimentos dos médicos,
-- a data e o valor das consultas que eles fizeram ordenadas 
-- da consulta mais cara para a mais barata.



SELECT Nome, DataNasc, DataCons, Valor
	from Consulta C inner join Veterinario V
		ON V.CodMed = C.CodMed
		ORDER BY VALOR DESC



--2 Sobre o paciente REX, liste o nome do paciente, o valor e as datas das consultas que ele já fez
SELECT NomeAnimal, Valor, DataCons
FROM CONSULTA C INNER JOIN ANIMAL A
	ON C.CodPac = A.codPac
WHERE A.NomeAnimal = 'REX'
--ORDER BY VALOR (VALOR CRESCENTE)
--ORDER BY VALOR DESC  (VALOR DECRESCENTE)

--3 - Liste o seu nome e os nomes dos pacientes que você atendeu, ordenados pela data da consulta.
SELECT V.Nome AS MEDICO, A.NomeAnimal AS PACIENTE, DataCons
FROM Veterinario AS V
	INNER JOIN CONSULTA AS C ON V.CodMed = C.CodMed
	INNER JOIN ANIMAL AS A ON C.CodPac = A.CodPac
WHERE V.Nome = 'Fernando'
ORDER BY DataCons


--4 - Qual o nome dos médicos que consultaram gatos ou cachorros nos últimos 4 meses


SELECT DISTINCT Nome
FROM Veterinario V
	INNER JOIN Consulta C ON V.CodMed = C.CodMed
	INNER JOIN Animal A ON A.codPac = C.CodPac
WHERE
	(Especie = 'Felina' or Especie = 'Canina') AND C.DataCons >= GETDATE() -120
ORDER BY Nome

--5 - Liste as espécies de pacientes que foram atendidos pelos médicos JOÃO, ANA ou BEATRIZ (use o comando IN).
SELECT Nome, Especie
FROM Consulta C INNER JOIN Veterinario V ON C.CodMed = V.CodMed
				INNER JOIN Animal A ON C.CodPac = A.codPac
WHERE V.Nome IN ('Marcos', 'Alberto', 'Fernando')
--WHERE V.NOME = 'JOAO' OR
 --	    V.NOME = 'ANA' OR     ---forma alternativa
 --		V.NOME = 'BEATRIZ'

 --6 - Liste o nome dos médicos que tem idade entre 30 e 45 anos,
 -- os nomes dos paciente atendidos, as datas e valores de todas as consultas. Ordenadas pelo nome do paciente.

 SELECT 
	Nome, NomeAnimal , DataCons, Valor
FROM Consulta C INNER JOIN Veterinario V ON C.CodMed = V.CodMed
				INNER JOIN Animal A ON C.CodPac = A.codPac
WHERE DATEDIFF(YYYY,DataNasc, GETDATE()) BETWEEN 30 AND 45
ORDER BY NomeAnimal


--7 - Liste os nomes de todos os cachorros, QUE NAO FIZERAM CONSULTA.  nao deu certo
SELECT A.NomeAnimal
FROM Animal A LEFT JOIN Consulta C ON C.CodPac = A.CodPac
WHERE
	C.CodPac IS NULL 
	AND
	Especie = 'Canina'

--8 - Quais pacientes pagaram consulta com preço abaixo da média da clínica?

SELECT NomeAnimal, Valor
FROM Consulta C INNER JOIN AnimaL A
	ON C.CodPac = A.codPac
WHERE Valor < (SELECT AVG(Valor) FROM Consulta)   --subselect para encontrar a media do valor



--9 Liste os nomes de todos os pacientes que não fizeram consultas.
SELECT A.NomeAnimal
FROM Animal A LEFT JOIN Consulta C ON C.CodPac = A.CodPac
WHERE
	C.CodPac IS NULL 
	

