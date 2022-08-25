
create database ProjStudioDB;

use ProjStudioDB;

show tables;

create table cliente(
	idCliente int auto_increment,
	nome varchar(30),
    cpf int,
    numCell int,
    primary key(idCliente)
    ) default charset = utf8mb4;

describe acesso;

create table acesso(
	id int not null auto_increment,
	nome varchar(30) not null,
    usuario char(20),
    senha int,
    primary key(id)
) default charset = utf8mb4;

rename table acesso to usuario;

insert into usuario value
(default, 'Ste', 'ste', '12341');

select * from usuario;

select *from usuario where usuario = 'lek' and senha = '123451';

