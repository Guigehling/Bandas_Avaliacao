create sequence seqavaliacao;
create sequence seqbanda;

create table usuario (
    cod numeric(6),
    login varchar(20) not null,
    senha varchar(20) not null,
    primary key (cod)
);
insert into usuario(cod, login, senha)values(1,'root','123');

create table banda (
    cod numeric(6),
    nome varchar(30) not null,
    biografia varchar(500) not null,
    primary key (cod)
);

create table avaliacao (
cod numeric(6),
coduser numeric(6) not null,
codbanda numeric(6) not null,
nota numeric(1) not null,

primary key (cod),
foreign key(coduser) references usuario(cod),
foreign key(codbanda) references banda(cod)
);