drop database if exists intervention;
create database intervention;
use intervention;

create table client(
	idclient int (3) not null auto_increment,
	nom varchar (50),
	adresse varchar (50),
	typeclient enum ("privé", "public"),
	primary key(idclient)
	);

create table technicien(
	idtech int (3) not null auto_increment,
	nom varchar (50),
	adresse varchar (50),
	compétence varchar (50),
	primary key(idtech)
	);
	
create table intervention(
	idinter int (3) not null auto_increment,
	description text,
	dateInter date,
	montant float,
	idclient int (3) not null,
	idtech int (3) not null,
	primary key(idinter),
	foreign key (idclient) references client(idclient),
	foreign key (idtech) references technicien(idtech)
	);

create table user (
	login varchar (50) not null,
	mdp varchar (50) not null,
	droits enum ("admin", "user", "autre"),
	primary key(login)
	);
	
Insert into user values
("admin", "admin", "admin"), ("ben", "123", "user");