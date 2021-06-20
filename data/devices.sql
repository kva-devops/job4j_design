create table devices(
	id serial primary key,
	name varchar(255),
	price float
);
create table people(
	id serial primary key,
	name varchar(255)
);
create table devices_people(
	id serial primary key,
	device_id int references devices(id),
	people_id int references people(id)
)

insert into devices (name, price) values ('Iphone 5', 4900);
insert into devices (name, price) values ('Samsung Galaxy', 14000);
insert into devices (name, price) values ('Iphone X', 55000);
insert into devices (name, price) values ('Xiaomi Redmi', 35000);
insert into devices (name, price) values ('Nokia 3310', 3000);
insert into devices (name, price) values ('Motorolla RV3', 4500);
insert into devices (name, price) values ('Macbook', 50000);
insert into devices (name, price) values ('Lenovo ThinkPad', 30000);
insert into devices (name, price) values ('IpadPro', 85000);
insert into devices (name, price) values ('IpadMini', 28000);
insert into devices (name, price) values ('Digma Pad', 2600);

insert into people (name) values ('Иван');
insert into people (name) values ('Дмитрий');
insert into people (name) values ('Ксения');
insert into people (name) values ('Виктор');
insert into people (name) values ('Анатолий');

insert into devices_people (device_id, people_id) values (3, 1);
insert into devices_people (device_id, people_id) values (9, 1);
insert into devices_people (device_id, people_id) values (7, 1);

insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (11, 2);

insert into devices_people (device_id, people_id) values (4, 3);
insert into devices_people (device_id, people_id) values (10, 3);
insert into devices_people (device_id, people_id) values (7, 3);

insert into devices_people (device_id, people_id) values (1, 4);
insert into devices_people (device_id, people_id) values (5, 4);
insert into devices_people (device_id, people_id) values (8, 4);

insert into devices_people (device_id, people_id) values (6, 5);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp
	join people as p
		on dp.people_id = p.id
	join devices as d
		on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp
	join people as p
		on dp.people_id = p.id
	join devices as d
		on dp.device_id = d.id
group by p.name
having avg(d.price) > 10000;