create database biblioteca

use biblioteca

create table Usuario (
nombre varchar(20),
email varchar(20),
id varchar(20),
pass varchar(20),
adm boolean,
primary key(id)
);

create table Cuento (
nombre varchar(30),
usuario varchar(20) references Usuario,
contenido LONGTEXT,
genero varchar(20),
vistas double,
imagen blob,
primary key(nombre,usuario)
);