CREATE DATABASE REVISAO1

GO

USE REVISAO1




CREATE TABLE ARTISTA(
	 codArt int not null identity(1,1) primary key,
	 nome varchar(50),
	 nomeArt varchar(50),
	 dtNas datetime,
	 pais varchar(15)
)



CREATE TABLE CATEGORIA(
	codCat int not null identity(1,1) primary key,
	descricao varchar(50),
	ativo char(1)
)

create table CD(
	codCd int not null identity(1,1) primary key,
	titulo varchar(50),
	ano int,
	codArt int not null references ARTISTA(codArt),
	codCat int not null references CATEGORIA(codCat)
)

--Inserir 4 categorias e 4 artistas.
insert into CATEGORIA(descricao, ativo)
	values  ('Rock','a'),
			('Pop','a'),
			('Mpb','a'),
			('Samba','a')
			
insert into ARTISTA(nome,nomeArt,dtNas,pais)
	values  ('Pedro Cardoso','Pedrin boing-boing','1/12/1964','Brasil'),
			('Maria Aparecida','Falsa Santa','1/4/1985','Brasil'),
			('Weslerson Diógenes','Zélerson','11/5/1954','Brasil'),
			('Josefina do Amaral','Cangaceira','12/12/1987','Brasil')



--Cadastre 6 CDs ou mais.

insert into CD (titulo,ano,codArt,codCat)
	values  ('Fatecanos','2001',1,2),
			('iFunny','1996',1,4),
			('Madrugada','1998',2,3),
			('Alvorada','2005',1,4),
			('Solzao','2018',1,3),
			('MaisSol','2012',4,4)
			
--Crie um campo para guardar o preço dos CDs.
alter table cd
	add preco money

--Atualize os preços de cada CD.

update CD set preco = 10.50
where codCd = 1

update CD set preco = 12.50
where codCd = 2

update CD set preco = 32
where codCd = 3

update CD set preco = 40.50
where codCd = 4

update CD set preco = 19.50
where codCd = 5

update CD set preco = 25.50
where codCd = 6

--Cadastre um artista da Alemanha.
insert into ARTISTA(nome,nomeArt,dtNas,pais)
	values ('Maurice','Mauss','01/12/1998','Alemanha')

--Cadastre 3 CDs para este artista.
insert into CD (titulo,ano,codArt,codCat,preco)
	values ('amor de madrugada','2001',5,1,15),
			('amor de verão','2012',5,4,15),
			('amor de primavera','2005',5,3,15)
			
			
--Liste os CDs das categorias ativas.
select titulo,ano,ativo
	from CD as c inner join CATEGORIA as cat
	on c.codCat = cat.codCat
	where cat.ativo = 'a'

--Mude o preço dos CDs lançados de 1950 a 2002 para 10% a mais.
update CD set preco = preco + (preco*0.1)
	where ano > 1950 and ano < 2002
		
--Liste os CDs com preço acima da média.
select * from cd
where preco > (select avg(preco) from CD)


--Exclua os CDs dos artistas do Brasil que estão em categorias inativas.
delete cd where codCd in (select codCd
from CD as c inner join CATEGORIA as cat
on c.codCat = cat.codCat
inner join ARTISTA as art on
c.codArt = art.codArt
where pais = 'Brasil' and ativo = 'i')


--Quantos CDs foram lançados em 2015 por artistas da Alemanha?
select count (*) from CD as c inner join ARTISTA as art
on c.codArt = art.codArt
where ano = '2015' and pais = 'Alemanha'



