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
prof_senha varchar(255)
);

insert into professores(prof_nome, prof_telefone, prof_email)
values ('Zeka','123456','zeka@hotmail.com');
insert into professores(prof_nome, prof_telefone, prof_email)
values ('Zeka','123456','zeka@hotmail.com');
insert into professores(prof_nome, prof_telefone, prof_email)
values ('Zeka','123456','zeka@hotmail.com');
select * from professores;

create table turmas(
cod_turma int auto_increment primary key,
turma_tipo varchar(255),
turma_data datetime
);

insert into turmas(turma_tipo, turma_data, prof_matricula)
values('individual', '2011-12-18 13:17:17');
select * from turmas;

create table alunos(
alu_matricula int auto_increment primary key,
alu_nome varchar(255),
alu_telefone varchar(255),
alu_email varchar(255),
alu_senha varchar(255)
);

insert into alunos(alu_nome, alu_telefone, alu_email)
values('zezin', '123456', 'zezin@hotmail.com');
select * from alunos;

create table aluno_turma(
alu_matricula int not null,
cod_turma int not null,
foreign key(alu_matricula)references alunos(alu_matricula),
foreign key(cod_turma)references turmas(cod_turma)
);

create table turma_professor(
prof_matricula int not null,
cod_turma int not null,
foreign key(prof_matricula)references professores(prof_matricula),
foreign key(cod_turma)references turmas(cod_turma)
);

