create database monitorando;
use monitorando;
create table disciplinas(
cod_disc int auto_increment primary key,
disc_nome varchar(50));

INSERT INTO disciplinas(disc_nome)
VALUES ('Biologia');
INSERT INTO disciplinas(disc_nome)
VALUES ('Português');
INSERT INTO disciplinas(disc_nome)
VALUES ('Matemática');
SELECT * FROM disciplinas;

create table professores(
prof_matricula int auto_increment primary key,
prof_nome varchar(255),
prof_telefone varchar(255),
prof_email varchar(255),
cod_disc int not null,
foreign key(cod_disc)references disciplinas(cod_disc)
);

insert into professores(prof_nome, prof_telefone, prof_email, cod_disc)
values ('Zeka','123456','zeka@hotmail.com', 1);
insert into professores(prof_nome, prof_telefone, prof_email, cod_disc)
values ('Zeka','123456','zeka@hotmail.com', 2);
insert into professores(prof_nome, prof_telefone, prof_email, cod_disc)
values ('Zeka','123456','zeka@hotmail.com', 3);
select * from professores;

create table turmas(
cod_turma int auto_increment primary key,
turma_tipo varchar(255),
turma_data datetime,
prof_matricula int not null,
foreign key(prof_matricula)references professores(prof_matricula)
);

insert into turmas(turma_tipo, turma_data, prof_matricula)
values('individual', '2011-12-18 13:17:17', 1);
select * from turmas;

create table alunos(
alu_matricula int auto_increment primary key,
alu_nome varchar(255),
alu_telefone varchar(255),
alu_email varchar(255),
cod_turma int not null,
foreign key(cod_turma)references turmas(cod_turma)
);

insert into alunos(alu_nome, alu_telefone, alu_email)
values('zezin', '123456', 'zezin@hotmail.com');
select * from alunos;
