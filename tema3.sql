drop database if exists tema3;
create database if not exists tema3;
use tema3;

create table Angajat
(
id int unique auto_increment,
nume varchar(100) unique,
parola varchar(100),
Primary key(id)
);


create table Products
(
id int unique auto_increment,
nume varchar(100) unique,
cantitate int,
pret int,
Primary key(id)
);

create table Clients
(
id int unique auto_increment,
nume varchar(100) unique,
Primary key(id)
);

create table Orders
(
id int unique auto_increment,
nume_client varchar(100) ,
nume_produs varchar(100) ,
pret int,
cantitate int,
Primary key(id)
);

insert into Angajat (nume,parola) 
values ('f','3');