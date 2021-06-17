--insert role
insert into role (name) values ('guest');
insert into role (name) values ('client');
insert into role (name) values ('aministrator');

--insert rules
insert into rules (name, read, write, delete) 
values ('read', true, false, false);
insert into rules (name, read, write, delete)
values ('readWrite', true, true, false);
insert into rules (name, read, write, delete)
values ('readWriteDelete', true, true, true);

--insert role_rules_id
insert into role_rules (role_id, rules_id) values (1, 1);
insert into role_rules (role_id, rules_id) values (2, 2);
insert into role_rules (role_id, rules_id) values (3, 3);

--insert users
insert into users (name, role_rules_id) values ('Ivan', 1);
insert into users (name, role_rules_id) values ('Petr', 2);
insert into users (name, role_rules_id) values ('Alex', 3);

--insert category
insert into category (name) values ('notebook');
insert into category (name) values ('pc');
insert into category (name) values ('smartphone');

--insert state
insert into state (name) values ('processing');
insert into state (name) values ('ready');

--insert commentary
insert into commentary (comment, users_id) 
values ('Hello world', 1);

--insert attachment
insert into attachment (name, users_id) 
values ('/some/path/to/file', 1);

--insert new item
insert into item (
	name, users_id, category_id, state_id, commentary_id, attachment_id
) values (
	'Lenovo G500', 1, 1, 1, 1, 1
);

