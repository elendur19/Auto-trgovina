--liquibase formatted sql

--changeset mislav:2
insert into manufacturer (name)
values ('Audi');

insert into vehicle (first_registration, location, manufacturer_id, millage, model, power, price, variant)
values ('2018-05-21', 'Croatia', 1, 72900, 'Audi A3', 85, 21000, 'Diesel 1.6');