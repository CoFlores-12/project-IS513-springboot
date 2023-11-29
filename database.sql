CREATE DATABASE proyectoIS513;
USE proyectoIS513;

CREATE TABLE torneos (
	idTorneo int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    informacion varchar(50),
    estado int,
    fecha varchar(100),
    logo varchar(255)
);

CREATE TABLE equipos (
	id int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    anioFundacion varchar(50),
    pais varchar(50),
    urllogo varchar(150)
);

ALTER TABLE equipos
ADD COLUMN idTorneo int,
ADD FOREIGN KEY (idTorneo) REFERENCES torneos(id);

CREATE TABLE equiposDelTorneo (
	id int AUTO_INCREMENT PRIMARY KEY,
    idTorneo int,
    idEquipo int,
    puntos int,
    FOREIGN KEY(idTorneo) REFERENCES torneos(idTorneo),
    FOREIGN KEY(idEquipo) REFERENCES equipos(idequipos)
);

CREATE TABLE partidos (
	idPartido int AUTO_INCREMENT PRIMARY KEY,
    fecha date,
    idTorneo int,
    idEquipo1 int,
    idEquipo2 int,
    golesEquipo1 int,
    golesEquipo2 int,
    ganador int,
    FOREIGN KEY(idTorneo) REFERENCES torneos(idTorneo),
    FOREIGN KEY(idEquipo1) REFERENCES equipos(idequipos),
    FOREIGN KEY(idEquipo2) REFERENCES equipos(idequipos),
    FOREIGN KEY(ganador) REFERENCES equipos(idequipos)
);



CREATE TABLE rols (
	idRol int AUTO_INCREMENT PRIMARY KEY,
    descripcion varchar(50)
);

CREATE TABLE personas(
	idPersona int AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(50),
    apellido varchar (50),
    IdRol int,
    foto varchar(255),
    FOREIGN KEY(idRol) REFERENCES rols(idRol)
);

CREATE TABLE goles (
	id int AUTO_INCREMENT PRIMARY KEY,
    idPartido int,
    idEquipo int,
    idPersona int,
    FOREIGN KEY(idPersona) REFERENCES personas(idPersona),
    FOREIGN KEY(idPartido) REFERENCES partidos(idPartido),
    FOREIGN KEY(idEquipo) REFERENCES equipos(idequipos)
);

CREATE TABLE clasificatoriatorneo (
	id int AUTO_INCREMENT PRIMARY KEY,
    idTorneo int,
    idEquipo int,
    posicion int,
    grupo int,
    FOREIGN KEY(idTorneo) REFERENCES torneos(idTorneo),
    FOREIGN KEY(idTorneo) REFERENCES equipos(idequipos)
);

--
-- Volcado de datos para la tabla `torneos`
--

INSERT INTO `torneos` (`idTorneo`, `nombre`, `informacion`, `estado`, `fecha`, `logo`) VALUES
(1, 'IS513', 'Proyecto de clase', 0, 'November, 2023', '03b0b151b42a829d87b3707368ec601d.jpg');
--
-- Volcado de datos para la tabla `equipos`
--
INSERT INTO `equipos` (`idEquipos`,`nombre`,`anioFundacion`,`pais`,`escudo`) VALUES (1,'Barcelona',1998,'España','03b0b151b42a829d87b3707368ec601d.jpg');
