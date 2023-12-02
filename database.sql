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
    precio int,
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

-- Creacion 8 equipos
INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (1, 'Real Madrid', '1902', 'España', '584a9b47b080d7616d298778.png', '0', '1', 'A1');

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (2, 'Girona', '1930', 'España', 'Girona-FC-PNG-Clipart-Background.png', '0', '1', 'A2');

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (3, 'Atletico Madrid', '1903', 'España', 'logo-atletico-madrid-1536.png', '0', '1', 'B1');

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (4, 'Barcelona', '1899', 'España', 'FC_Barcelona_(crest).svg.png', '0', '1', 'B2');

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (5, 'Athletic', '1899', 'España', '584ad135b519ea740933a896.png', '0', '1', 'C1');

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (6, 'Real Sociedad', '1909', 'España', 'Real-Sociedad-Logo.png', '0', '1', 'C2');

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (7, 'Betis', '1907', 'España', 'real-betis-balompie-escudo-actual-de-marzo-logo-EBB3A9E4C1-seeklogo.com.png', '0', '1', 'D1');

INSERT INTO `equipos` (`idEquipo`, `nombre`,`anioFundacion`,`pais`,`urllogo`,`puntos`, `idTorneo`, `grupo`) 
VALUES (8, 'Getafe', '1983', 'España', 'Getafe_CF_S_A_D_-logo-ECC0F2A882-seeklogo.com.png', '0', '1', 'D2');


INSERT INTO `rols` (`idRol`, `descripcion`) VALUES ('1', 'PORTERO');
INSERT INTO `rols` (`idRol`, `descripcion`) VALUES ('2', 'DEFENSA');
INSERT INTO `rols` (`idRol`, `descripcion`) VALUES ('3', 'CENTROCAMPISTA'), ('4', 'DELANTERO');


INSERT INTO `personas` (`idPersona`, `nombre`, `apellido`, `idrol`, `fecha`, `foto`, `idequipo`) VALUES
(1, 'Marcel', 'Lubik', 1, '2023-12-02', 'dfl-obj-j01dw0-dfl-clu-000010-dfl-sea-0001k7.webp', 1),
(3, 'Niklas', 'Dorsch', 3, '2023-12-02', 'dfl-obj-0027bi-dfl-clu-000010-dfl-sea-0001k7.webp', 1),
(4, 'Dion', 'Beljo', 4, '2023-12-02', 'dfl-obj-j01seg-dfl-clu-000010-dfl-sea-0001k7.webp', 1),
(5, 'Robert', 'Gumny', 2, '2023-12-02', 'dfl-obj-002gjf-dfl-clu-000010-dfl-sea-0001k7.webp', 1),
(6, 'Mikkel', 'Kaufmann', 1, '2023-12-02', 'dfl-obj-j01eaq-dfl-clu-00000v-dfl-sea-0001k7.webp', 2),
(7, 'Jakob', 'Busk', 1, '2023-12-02', 'dfl-obj-0026tr-dfl-clu-00000v-dfl-sea-0001k7.webp', 2),
(8, 'Christopher', 'Trimmel', 3, '2023-12-02', 'dfl-obj-0002fx-dfl-clu-00000v-dfl-sea-0001k7.webp', 2),
(9, 'Marvin', 'Schwabe', 2, '1995-02-05', 'dfl-obj-0002he-dfl-clu-000008-dfl-sea-0001k7.webp', 3),
(10, 'Rasmus', 'Carstensen', 2, '2000-10-11', 'dfl-obj-j01gtc-dfl-clu-000008-dfl-sea-0001k7.webp', 3),
(11, 'Luca', 'Kilian', 3, '1999-01-09', 'dfl-obj-002g0r-dfl-clu-000008-dfl-sea-0001k7.webp', 3),
(12, 'Timo', 'Hubers', 4, '1996-02-01', 'dfl-obj-0027b6-dfl-clu-000008-dfl-sea-0001k7.webp', 3),
(13, 'Mohamed', 'simakan', 4, '2000-03-05', 'dfl-obj-j01cy1-dfl-clu-000017-dfl-sea-0001k7.webp', 4),
(14, 'Josha', 'Vagnoman', 3, '2000-11-12', 'dfl-obj-0028ls-dfl-clu-00000d-dfl-sea-0001k7.webp', 5),
(15, 'Manuel', 'Neuer', 1, '31986-02-07', 'dfl-obj-0000i4-dfl-clu-00000g-dfl-sea-0001k7.webp', 6),
(16, 'Ko', 'Itakura', 2, '1997-01-27', 'dfl-obj-j01h9v-dfl-clu-000004-dfl-sea-0001k7.webp', 7),
(17, 'Piero', 'Hincapie', 2, '2002-01-08', 'dfl-obj-j01k76-dfl-clu-00000b-dfl-sea-0001k7.webp', 8);



INSERT INTO `partidos` (`idPartido`, `fecha`, `idTorneo`, `idEquipo1`, `idEquipo2`, `golesEquipo1`, `golesEquipo2`, `ganador`) VALUES (NULL, '2023-11-30', '1', '1', '1', '2', '1', '1');

INSERT INTO `clasificatoria` (`id`, `idTorneo`, `idEquipo`, `posicion`) VALUES (1, '1', '1', '1'), (2, '1', '2', '2');

INSERT INTO `fichajejugador` (`idfichaje`, `idPersona`, `idEquipoIn`, `idEquipoOut`, `precio`) VALUES (NULL, '1', '1', '2', '35000');


INSERT INTO `clasificatoria` (`id`, `idTorneo`, `idEquipo`, `posicion`) VALUES (NULL, '1', '3', '3'), (NULL, '1', '4', '4'), (NULL, '1', '5', '5'), (NULL, '1', '6', '6'), (NULL, '1', '7', '7'), (NULL, '1', '8', '8');

INSERT INTO `goles` (`id`, `idPartido`, `idEquipo`, `idPersona`) VALUES (NULL, '1', '4', '1');