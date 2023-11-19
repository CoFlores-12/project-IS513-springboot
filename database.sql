CREATE DATABASE proyectoIS513;
USE proyectoIS513;

CREATE TABLE torneos (
	id int AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(50),
    titulo varchar(50),
    informacion varchar(50),
    estado int,
    logo varchar(255)
);