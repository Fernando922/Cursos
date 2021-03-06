CREATE DATABASE GRAVADORA
GO 
USE GRAVADORA


CREATE TABLE MUSICO(
	IDMUS INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	NOMEMUS VARCHAR(50),
	IDRES INT NOT NULL REFERENCES RESIDENCIA(IDRES)
)

CREATE TABLE RESIDENCIA(
	IDRES INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	ENDERECO VARCHAR(50),
	TELEFONE VARCHAR(50)
)

CREATE TABLE INSTRUMENTO(
	IDINS INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	NOMEINS VARCHAR(50)
)

CREATE TABLE TOCA(
	IDTOCA INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	IDMUS INT NOT NULL REFERENCES MUSICO(IDMUS),
	IDINS INT NOT NULL REFERENCES INSTRUMENTO(IDINS)
)

CREATE TABLE ALBUM(
	IDALBUM INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	TITULO VARCHAR(50),
	FORMATO VARCHAR(50),
	DATA DATETIME,
	IDMUS INT NOT NULL REFERENCES MUSICO(IDMUS)
)

CREATE TABLE MUSICA(
	IDMUSICA INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	TMUS VARCHAR(50),
	AUTOR VARCHAR(50),
	IDALBUM INT NOT NULL REFERENCES ALBUM(IDALBUM)
)

CREATE TABLE PARTICIPACAO(
	IDPART INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
	IDMUS INT NOT NULL REFERENCES MUSICO(IDMUS),
	IDMUSICA INT NOT NULL REFERENCES MUSICA(IDMUSICA)
)

