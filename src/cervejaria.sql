create table estilo(
	cod_estilo integer primary key not null,
	nm_estilo varchar
);

create table marca (
	cod_marca integer primary key not null,
	nm_marca varchar
);

create table cerveja (
	cod_cerveja integer primary key not null,
	cod_marca integer,
	cod_estilo integer,
	graduacao float,
	preco float,
	constraint cod_marca_fk foreign key (cod_marca)
		references marca(cod_marca)
		on update restrict on delete restrict,
	constraint cod_estilo_fk foreign key (cod_estilo)
		references estilo(cod_estilo)
		on update restrict on delete restrict
);

create table estoque (
	cod_cerveja integer primary key not null,
	quantidade float,
	constraint cod_cerveja_fk foreign key (cod_cerveja)
		references cerveja(cod_cerveja)
		on update restrict on delete restrict
);

create table cliente (
	cpf varchar primary key not null,
	nome varchar,
	telefone varchar,
	email varchar,
	endereco varchar(200)
);

create table pedido (
	cod_cliente varchar,
	cod_cerveja integer,
	quantidade float,
	valor_pedido float,
	constraint cod_cliente_fk foreign key (cod_cliente)
		references cliente(cpf)
		on update restrict on delete restrict,
	constraint cod_cerveja_fk foreign key (cod_cerveja)
		references cerveja(cod_cerveja)
		on update restrict on delete restrict
);

create table endereco (
	cod_cliente varchar primary key not null,
	cep varchar,
	numero varchar,
	complemento text,
	constraint cod_cliente_fk foreign key (cod_cliente)
		references cliente(cpf)
		on update restrict on delete restrict
);

insert into estilo(cod_estilo,nm_estilo) values (1,'Pilsen');
insert into estilo(cod_estilo,nm_estilo) values (2,'Red Ale');
insert into estilo(cod_estilo,nm_estilo) values (3,'IPA');
insert into estilo(cod_estilo,nm_estilo) values (4,'Abadia');
insert into estilo(cod_estilo,nm_estilo) values (5,'Pale Ale');
insert into estilo(cod_estilo,nm_estilo) values (6,'Stout');
insert into estilo(cod_estilo,nm_estilo) values (7,'Summer Ale');

insert into marca(cod_marca,nm_marca) values (1,'Skol');
insert into marca(cod_marca,nm_marca) values (2,'Brahma');
insert into marca(cod_marca,nm_marca) values (3,'Antarctica');
insert into marca(cod_marca,nm_marca) values (4,'Bohemia');
insert into marca(cod_marca,nm_marca) values (5,'Heineken');
insert into marca(cod_marca,nm_marca) values (6,'Budweiser');
insert into marca(cod_marca,nm_marca) values (7,'Corona');
insert into marca(cod_marca,nm_marca) values (8,'Miller');
insert into marca(cod_marca,nm_marca) values (9,'Pontello');

insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (1,1,1,4.7,2.69);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (2,2,1,5,3.25);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (3,3,1,4.5,2.60);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (4,4,1,4.7,3.50);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (5,5,5,4.5,3.65);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (6,6,3,5.1,3.69);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (7,7,7,3.9,3.60);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (8,8,1,4.3,3.63);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (9,9,1,4.2,3.50);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (10,9,2,4.8,3.50);
insert into cerveja(cod_cerveja,cod_marca,cod_estilo,graduacao,preco) values (11,9,3,5.0,3.50);

insert into cliente(cpf,nome,telefone,email) values ('0000000001','Gustavo Ceconelli','9875-8525','guceconelli@gmail.com');
insert into cliente(cpf,nome,telefone,email) values ('0000000002','Mateus Mourão','9883-2532','mmdfmateus@gmail.com');
insert into cliente(cpf,nome,telefone,email) values ('0000000003','João Colen','8745-9685','joaocolen7@gmail.com');
insert into cliente(cpf,nome,telefone,email) values ('0000000004','Tiago Araújo','9632-4168','tiago.araujo.neo@gmail.com');

insert into endereco(cod_cliente,cep,numero,complemento) values ('0000000001','30510-080','17','apto 101,bloco c1');