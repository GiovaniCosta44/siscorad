create table cliente
(
    id bigint not null auto_increment,
    Nome varchar(60) not null,
    CPF char(14) unique not null,
    Cep char (9) not null,
    Sexo char (1) check (Sexo = 'M' or Sexo = 'F' or Sexo = 'O') not null,
    Endereco varchar(100) not null,
    Telefone char(14) not null,
    email varchar(255) not null,

    primary key (id)
);