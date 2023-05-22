create database gestaoloja;

create table produtos(
id int not null auto_increment primary key, 
nome varchar(255),
descricao varchar(255),
quantidade int,
preco double)
