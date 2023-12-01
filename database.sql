CREATE DATABASE proyectoIS513;
USE proyectoIS513;

CREATE TABLE torneos (
	idTorneo int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    informacion varchar(50),
    estado int DEFAULT 1,
    fecha varchar(100),
    logo varchar(255)
);

CREATE TABLE equipos (
	idEquipo int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    anioFundacion varchar(50),
    pais varchar(50),
    urllogo varchar(150),
    puntos int DEFAULT 0,
    grupo varchar(2)
);


CREATE TABLE rols (
	idRol int AUTO_INCREMENT PRIMARY KEY,
    descripcion varchar(50)
);

CREATE TABLE personas(
	idPersona int AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(50),
    apellido varchar (50),
    idrol int,
    fecha varchar(50),
    foto varchar(255),
    idequipo int,
    FOREIGN KEY(idrol) REFERENCES rols(idRol),
    FOREIGN KEY(idequipo) REFERENCES equipos(idEquipo)
);

ALTER TABLE equipos
ADD COLUMN idTorneo int,
ADD FOREIGN KEY (idTorneo) REFERENCES torneos(idTorneo);

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
    FOREIGN KEY(idEquipo1) REFERENCES equipos(idEquipo),
    FOREIGN KEY(idEquipo2) REFERENCES equipos(idEquipo),
    FOREIGN KEY(ganador) REFERENCES equipos(idEquipo)
);




CREATE TABLE goles (
	id int AUTO_INCREMENT PRIMARY KEY,
    idPartido int,
    idEquipo int,
    idPersona int,
    FOREIGN KEY(idPersona) REFERENCES personas(idPersona),
    FOREIGN KEY(idPartido) REFERENCES partidos(idPartido),
    FOREIGN KEY(idEquipo) REFERENCES equipos(idEquipo)
);

CREATE TABLE clasificatoria (
	id int AUTO_INCREMENT PRIMARY KEY,
    idTorneo int,
    idEquipo int,
    posicion int,
    FOREIGN KEY(idTorneo) REFERENCES torneos(idTorneo),
    FOREIGN KEY(idEquipo) REFERENCES equipos(idEquipo)
);

CREATE TABLE fichajejugador(
idfichaje int AUTO_INCREMENT PRIMARY KEY,
    idPersona int,
    idEquipoIn int,
    idEquipoOut int,
    FOREIGN KEY(idPersona) REFERENCES personas(idPersona),
    FOREIGN KEY(idEquipoIn) REFERENCES equipos(idEquipo),
    FOREIGN KEY(idEquipoOut) REFERENCES equipos(idEquipo)
);

--
-- Volcado de datos para la tabla `torneos`
--

INSERT INTO `torneos` (`idTorneo`, `nombre`, `informacion`, `estado`, `fecha`, `logo`) VALUES
(1, 'IS513', 'Proyecto de clase', 1, 'November, 2023', '03b0b151b42a829d87b3707368ec601d.jpg');
--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`idEquipo`,`nombre`,`anioFundacion`,`pais`,`urllogo`) VALUES (1,'Barcelona',1998,'España','03b0b151b42a829d87b3707368ec601d.jpg');
INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) VALUES (1,'Barcelona','1998','España','03b0b151b42a829d87b3707368ec601d.jpg', '0', '1', "A1");

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (2, 'equipo 2', '2023', 'Honduras', 'blank.png', '0', '1', 'A2');

INSERT INTO `rols` (`idRol`, `descripcion`) VALUES ('1', 'Jugador');

INSERT INTO `personas` (`idPersona`, `nombre`, `apellido`, `IdRol`, `foto`, `fecha`, `idequipo`) VALUES (NULL, 'test', 'test', '1', 'blank.png', '2023', '1');

INSERT INTO `partidos` (`idPartido`, `fecha`, `idTorneo`, `idEquipo1`, `idEquipo2`, `golesEquipo1`, `golesEquipo2`, `ganador`) VALUES (NULL, '2023-11-30', '1', '1', '1', '2', '1', '1');

INSERT INTO `clasificatoria` (`id`, `idTorneo`, `idEquipo`, `posicion`) VALUES (1, '1', '1', '1'), (2, '1', '2', '2');
