create database funcionariobd;

use funcionariobd;

CREATE TABLE IF NOT EXISTS  funcionario(
	id int not null auto_increment,
    nome varchar(250) not null,
    salario double not null,
    falta int not null,
    cargo varchar(250) not null,
    idade int not null,
    regiao varchar(250) not null,
    nomebonus varchar(250) not null,
    bonus double not null,
    
    primary key(id)
);
