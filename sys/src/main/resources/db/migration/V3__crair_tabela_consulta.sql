create table consulta (
    id int auto_increment primary key,
    id_paciente int,
    id_medico int,
    data_consulta datetime not null,
    diagnostico varchar(250) not null,
    prescricao varchar(250) not null,
    FOREIGN KEY (id_paciente) REFERENCES paciente(id),
    FOREIGN KEY (id_medico) REFERENCES medico(id)
);