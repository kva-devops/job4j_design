create table proffecion (
	id serial primary key,
	name varchar(255)
);
create table worker (
	id serial primary key,
	name varchar(255),
	proffecion_id int references proffecion(id)
);
insert into proffecion (name) values ('developer');
insert into proffecion (name) values ('manager');
insert into proffecion (name) values ('devops');
insert into worker (name, proffecion_id) values ('Petr', 2);
insert into worker (name, proffecion_id) values ('Ivan', 1);
insert into worker (name, proffecion_id) values ('Stepan', 1);
insert into worker (name, proffecion_id) values ('Boris', 3);

select w.id, w.name, p.name from worker as w join proffecion as p on w.proffecion_id = p.id where p.name = 'developer';
select * from worker as w join proffecion as p on w.proffecion_id = p.id;
select w.name as "Имя работника", p.name as "Специальность" from worker as w join proffecion as p on w.proffecion_id = p.id;