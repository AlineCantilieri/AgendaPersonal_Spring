create table aluno (id_aluno bigint not null auto_increment, nome varchar(255), idade int, telefone varchar(255), primary key(id_aluno));
create table horario (id_horario bigint not null auto_increment, id_aluno bigint not null, horario varchar(255), professor varchar(255),  primary key(id_horario), foreign key(id_aluno) references aluno(id_aluno));
