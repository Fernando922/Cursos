create database clinica_1
go
use clinica_1

create table Veterinario(
	CodMed int primary key identity(1,1),
	Nome varchar(20),
	DataNasc datetime
)

create table Consulta(
	CodCons int primary key identity(1,1),
	DataCons datetime,
	Valor int,
	CodMed int foreign key references Veterinario (CodMed),
	CodPac int foreign key references Animal (CodPac),
)

create table Animal(
	codPac int primary key identity(1,1),
	NomeAnimal varchar(20),
	Especie varchar(10)
)




insert into Veterinario
values
	('Marcos',		'11/11/1964'),
	('Alberto',		'01/02/1983'),
	('Fernando',	'12/12/1978'),
	('Marcia',		'15/07/1975'),
	('Narcisa',		'04/05/1981')

insert into Animal
values
	('bidu','Felina'),
	('lua','Canina'),
	('sol','Canina'),
	('malu','Felina'),
	('lulu','Canina'),
	('enzo','Felina'),
	('toto','Canina'),
	('miau','Felina'),
	('dogao','Canina'),
	('auau','Felina')


insert into Consulta
values
	('07/05/2013',260,00,1,1),
	('14/03/2014',346,00,3,5),
	('03/03/2015',333,00,5,3),
	('04/04/2015',456,00,4,1),
	('09/06/2016',546,00,3,2),
	('17/07/2017',876,00,1,4),
	('10/04/2014',443,00,3,7),
	('12/02/2016',234,00,5,6),
	('14/01/2014',654,00,5,8),
	('04/04/2014',443,00,4,10),
	('09/07/2013',765,00,3,10),
	('01/08/2012',786,00,4,3),
	('02/09/2013',456,00,4,4),
	('03/10/2017',654,00,1,3),
	('06/11/2018',234,00,3,9),
	('18/05/2018',754,00,1,6),
	('20/07/2013',345,00,1,7),
	('21/08/2015',876,00,4,5),
	('16/12/2016',556,00,5,4),
	('28/12/2014',345,00,3,7)