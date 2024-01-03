create table paciente (
    id int auto_increment primary key,
    nome varchar(100) not null,
    cpf int,
    descricao varchar(250) not null
);