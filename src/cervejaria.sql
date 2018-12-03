create domain status as varchar
	default 'AGUARDANDO'
	check (value in ('ENVIADO','CANCELADO','AGUARDANDO'));

create table estilo(
	cod_estilo integer primary key not null,
	nm_estilo varchar not null
);

--drop table estilo cascade;
--drop table marca cascade;
--drop table cerveja cascade;
--drop table cliente cascade;
--drop table endereco cascade;
--drop table estoque cascade;
--drop table pedido cascade;
create table marca (
	cod_marca integer primary key not null,
	nm_marca varchar not null
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

alter table pedido
	add column entrega status;

alter table pedido
	add column cod_pedido int primary key;

create or replace function addPedido(varchar,integer,float,float)
	returns void as $$
	declare
		lastIndex integer;
	begin
		select into lastIndex max(cod_pedido) from pedido;
		if lastIndex is null then
			lastIndex = 0;
		end if;
		lastIndex = lastIndex + 1;
		raise notice '%',lastIndex;
		insert into pedido(cod_cliente,cod_cerveja,quantidade,valor_pedido,cod_pedido)
			values ($1,$2,$3,$4,lastIndex);
	end;
	$$ language 'plpgsql'

create table endereco (
	cod_cliente varchar primary key not null,
	cep varchar,
	numero varchar,
	complemento text,
	constraint cod_cliente_fk foreign key (cod_cliente)
		references cliente(cpf)
		on update restrict on delete restrict
);

-----------------------TRIGGERS CERVEJA-----------------------------------
create sequence cod_cerveja increment by 1 start with 1;
--drop sequence cod_cerveja;
--select nextval('cod_cerveja')
		

create or replace function addCodCerveja_AtualizaEstoque()
	returns trigger as $$
	BEGIN
		update cerveja
		set cod_cerveja = nextval('cod_cerveja')
		where preco = new.preco
		and cod_estilo = new.cod_estilo
		and graduacao = new.graduacao;
		insert into estoque(cod_cerveja,quantidade) values (currval('cod_cerveja'),0);
		return null;
	END
	$$
	language 'plpgsql';


CREATE TRIGGER "addCodCerveja_AtualizaEstoque" AFTER INSERT
   ON public.cerveja FOR EACH ROW
   EXECUTE PROCEDURE public.addCodCerveja_AtualizaEstoque();


--select * from cerveja
--insert into cerveja(cod_cerveja, cod_marca, cod_estilo, graduacao, preco) values (56565, 1, 1, 5.9, 1000.0)



-----------------------TRIGGERS ESTILO-----------------------------------
create sequence cod_estilo increment by 1 start with 1;
--drop sequence cod_estilo;
--select nextval('cod_estilo')
		

create or replace function addCodEstilo()
	returns trigger as $$
	BEGIN
		update estilo
		set cod_estilo = nextval('cod_estilo')
		where nm_estilo = new.nm_estilo;
		return null;
	END
	$$
	language 'plpgsql';


CREATE TRIGGER "addCodEstilo" AFTER INSERT
   ON public.estilo FOR EACH ROW
   EXECUTE PROCEDURE public.addcodestilo();


--select * from estilo
--insert into estilo(cod_estilo, nm_estilo) values (431, 'Butecão')



-----------------------TRIGGERS MARCA-----------------------------------
create sequence cod_marca increment by 1 start with 1;
--drop sequence cod_marca;
--select nextval('cod_marca')
		

create or replace function addCodMarca()
	returns trigger as $$
	BEGIN
		update marca
		set cod_marca = nextval('cod_marca')
		where cod_marca = new.cod_marca;
		return null;
	END
	$$
	language 'plpgsql';


CREATE TRIGGER "addCodMarca" AFTER INSERT
   ON public.marca FOR EACH ROW
   EXECUTE PROCEDURE public.addcodmarca();


--select * from marca
--insert into marca(cod_marca, nm_marca) values (431, 'Colorado2')



-----------------------TRIGGERS PEDIDO-----------------------------------
create or replace function updateEstoque()
	returns trigger as $$
	declare
		x float;
		y endereco%rowtype;
	begin
		select into x quantidade from estoque where cod_cerveja = new.cod_cerveja;
		if new.quantidade > x then
			raise exception 'Quantidade indisponível no estoque';
			return old;
		end if;
		
		select into y * from endereco where cod_cliente = new.cod_cliente;
		raise notice '%',y;
		if y is null then
			raise exception 'Cliente não possui endereço cadastrado';
			return old;
		end if;
		
		update estoque set quantidade = quantidade - new.quantidade where estoque.cod_cerveja = new.cod_cerveja;
		return new;
	end;
	$$ language 'plpgsql';


CREATE TRIGGER updateestoque
    BEFORE INSERT
    ON public.pedido
    FOR EACH ROW
    EXECUTE PROCEDURE public.updateestoque();
	
	


-----------------------POPULANDO O BANCO-----------------------------------

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

create or replace view cervejas as
	select c.cod_cerveja,m.nm_marca,et.nm_estilo,c.graduacao,c.preco,e.quantidade from cerveja c
		natural join marca m
		natural join estilo et
		left join estoque e on e.cod_cerveja = c.cod_cerveja
		order by cod_cerveja;


