CREATE DATABASE proyectoIS513;
USE proyectoIS513;

CREATE TABLE torneos (
	id int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    informacion varchar(50),
    estado int,
    fecha varchar(100),
    logo varchar(255)
);

CREATE TABLE equipos (
	idEquipos int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    anioFundacion varchar(50),
    pais varchar(50),
    escudo varchar(150)
);

CREATE TABLE equiposDelTorneo (
	id int AUTO_INCREMENT PRIMARY KEY,
    idTorneo int,
    idEquipo int,
    puntos int,
    FOREIGN KEY(idTorneo) REFERENCES torneos(id),
    FOREIGN KEY(idTorneo) REFERENCES equipos(idequipos)
);

CREATE TABLE partidos (
	id int AUTO_INCREMENT PRIMARY KEY,
    fecha date,
    idTorneo int,
    idEquipo1 int,
    idEquipo2 int,
    golesEquipo1 int,
    golesEquipo2 int,
    ganador int,
    FOREIGN KEY(idTorneo) REFERENCES torneos(id),
    FOREIGN KEY(idEquipo1) REFERENCES equipos(idequipos),
    FOREIGN KEY(idEquipo2) REFERENCES equipos(idequipos),
    FOREIGN KEY(ganador) REFERENCES equipos(idequipos)
);

CREATE TABLE goles (
	id int AUTO_INCREMENT PRIMARY KEY,
    idPartido int,
    idPersona int,
    FOREIGN KEY(idPartido) REFERENCES partidos(id),
    FOREIGN KEY(idPersona) REFERENCES personas(id)
);

CREATE TABLE goles (
	id int AUTO_INCREMENT PRIMARY KEY,
    idPartido int,
    idEquipo int,
    idPersona int,
    FOREIGN KEY(idPartido) REFERENCES partidos(id),
    FOREIGN KEY(idEquipo) REFERENCES equipos(idequipos)
);

CREATE TABLE clasificatoriatorneo (
	id int AUTO_INCREMENT PRIMARY KEY,
    idTorneo int,
    idEquipo int,
    posicion int,
    grupo int,
    FOREIGN KEY(idTorneo) REFERENCES torneos(id),
    FOREIGN KEY(idTorneo) REFERENCES equipos(idequipos)
);