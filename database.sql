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
idEquipo int AUTO_INCREMENT PRIMARY KEY,
nombre varchar(50),
anioFundacion varchar(50),
pais varchar(50),
urllogo varchar(150),
puntos int DEFAULT 0,
idTorneo int,
FOREIGN KEY (idTorneo) REFERENCES torneos(idTorneo)
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
FOREIGN KEY(idEquipo1) REFERENCES equipos(idEquipo),
FOREIGN KEY(idEquipo2) REFERENCES equipos(idEquipo),
FOREIGN KEY(ganador) REFERENCES equipos(idEquipo)
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

CREATE TABLE fichajejugador(
idfichaje int AUTO_INCREMENT PRIMARY KEY,
    idPersona int,
    idEquipoIn int,
    idEquipoOut int,
    FOREIGN KEY(idPersona) REFERENCES personas(idPersona),
    FOREIGN KEY(idEquipoIn) REFERENCES equipos(idEquipo),
    FOREIGN KEY(idEquipoOut) REFERENCES equipos(idEquipo)
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

CREATE TABLE clasificatoriatorneo (
id int AUTO_INCREMENT PRIMARY KEY,
idTorneo int,
idEquipo int,
posicion int,
grupo int,
FOREIGN KEY(idTorneo) REFERENCES torneos(idTorneo),
FOREIGN KEY(idTorneo) REFERENCES equipos(idEquipo)
);

--
-- Volcado de datos para la tabla `torneos`
--

INSERT INTO `torneos` (`idTorneo`, `nombre`, `informacion`, `estado`, `fecha`, `logo`) VALUES
(1, 'IS513', 'Proyecto de clase', 0, 'November, 2023', '03b0b151b42a829d87b3707368ec601d.jpg');
--
-- Volcado de datos para la tabla `equipos`
--
INSERT INTO `equipos` (`idEquipo`,`nombre`,`anioFundacion`,`pais`,`urllogo`) VALUES (1,'Barcelona',1998,'España','03b0b151b42a829d87b3707368ec601d.jpg');
