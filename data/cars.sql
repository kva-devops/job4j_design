create table body(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body (name) values ('седан');
insert into body (name) values ('универсал');
insert into body (name) values ('хетчбек');

insert into engine (name) values ('атмосферный бензин 1.4');
insert into engine (name) values ('атмосферный бензин 1.6');
insert into engine (name) values ('турбо бензин 2.0');
insert into engine (name) values ('турбо дизель 2.0');

insert into transmission (name) values ('ручная');
insert into transmission (name) values ('автоматическая');
insert into transmission (name) values ('робот');

insert into car (name, body_id, engine_id, transmission_id)
values ('Skoda Octavia', 1, 2, 2);
insert into car (name, body_id, engine_id, transmission_id)
values ('Toyota Corolla', 1, 1, 1);
insert into car (name, body_id, engine_id, transmission_id)
values ('Saab 9-5', 2, 3, 2);

--1
select c.name, b.name, e.name, t.name
from car as c
	join body as b
		on c.body_id = b.id
	join engine as e
		on c.engine_id = e.id
	join transmission as t
		on c.transmission_id = t.id;
--2
select b.name as "Неиспользуемый кузов"
from car as c right join body as b
on c.body_id = b.id
where c.id is null;

select e.name as "Неиспользуемый двигатель"
from car as c right join engine as e
on c.engine_id = e.id
where c.id is null;

select t.name as "Неиспользуемая трансмиссия"
from transmission as t left join car as c
on t.id = c.transmission_id
where c.id is null;


