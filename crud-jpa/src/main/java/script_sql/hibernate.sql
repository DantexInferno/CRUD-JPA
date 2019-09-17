CREATE DATABASE hibernate;
USE hibernate;


CREATE TABLE Usuarios(
id int(11) PRIMARY KEY AUTO_INCREMENT,
correo VARCHAR(80) NOT NULL,
password VARCHAR(12)
);

