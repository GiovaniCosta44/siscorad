create table Servico
(
    id bigint not null auto_increment,
    cliente_taxid char(14) not null,
    tipo varchar(255) not null,
    data_inicio datetime not null,
    data_finalizacao datetime,
    status varchar(20) not null,
    valor decimal(10,2) not null,

    primary key (id)

);

alter table Servico add constraint fk_servico_cliente
foreign key (cliente_taxid) references cliente (taxId);


