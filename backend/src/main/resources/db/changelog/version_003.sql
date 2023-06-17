--liquibase formatted sql

--changeset mislav:3
insert into manufacturer (date_created, date_updated, name)
 values (now(), now(), 'VW');

insert into manufacturer (date_created, date_updated, name)
 values (now(), now(), 'Toyota');

insert into vehicle (date_created, date_updated, first_registration, location, manufacturer_id, millage, model, power, price, variant)
values (now(), now(), '2023-05-21', 'Croatia', 2, 2900, 'Arteon', 195, 41000, 'Petrol 2.5');