--1
create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments (name) values ('Бухгалтерия');
insert into departments (name) values ('Отдел продаж');
insert into departments (name) values ('Отдел сопровождения');
insert into departments (name) values ('Транспортный отдел');
insert into departments (name) values ('Склад');

insert into employees (name, department_id) values ('Тамара Степановня', 1);
insert into employees (name, department_id) values ('Зоя Валентиновна', 1);
insert into employees (name, department_id) values ('Лидия Михайловна', 1);
insert into employees (name, department_id) values ('Ольга Николаевна', 2);
insert into employees (name, department_id) values ('Анатолий Борисович', 2);
insert into employees (name, department_id) values ('Федор Михайлович', 3);
insert into employees (name, department_id) values ('Владимир Анатольевич', 3);
insert into employees (name, department_id) values ('Степан Петрович', 4);
insert into employees (name, department_id) values ('Анастасия Павловна', 4);
insert into employees (name, department_id) values ('Константин Львович', 4);
insert into employees (name, department_id) values ('Кирилл Альбертович', 4);

--2
select *
from departments as d left join employees as e
on d.id = e.department_id;
select *
from departments as d right join employees as e
on d.id = e.department_id;
select *
from employees as e left join departments as d
on department_id = d.id;
select *
from departments as d right join employees as e
on d.id = e.department_id;
select *
from employees as e full join departments as d
on department_id = d.id;
select *
from employees as e cross join departments as d;
--3
select d.name
from departments as d left join employees as e
on d.id = e.department_id
where e.name is null;
--4
select *
from employees as e left join departments as d
on department_id = d.id;
select *
from employees as e right join departments as d
on department_id = d.id
where e.name is not null;
--5
create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
)

insert into teens (name, gender) values('Billy', 'male');
insert into teens (name, gender) values('Jimmy', 'male');
insert into teens (name, gender) values('Lisa', 'female');
insert into teens (name, gender) values('Nataly', 'female');

select t1.name as one, t2.name as two
from teens t1 cross join teens t2
where t1.gender != t2.gender;


