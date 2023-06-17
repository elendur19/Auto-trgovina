--liquibase formatted sql

--changeset mislav:4
insert into vehicle (date_created, date_updated, first_registration, location, manufacturer_id, millage, model, power, price, variant)
values (now(), now(), '2023-12-21', 'Japan', 3, 2900, 'Yaris', 208, 31000, 'Petrol 3.0');
insert into vehicle (date_created, date_updated, first_registration, location, manufacturer_id, millage, model, power, price, variant)
values (now(), now(), '2009-05-21', 'Germany', 2, 400900, 'Passat', 140, 25000, 'Diesel 3.0');
insert into vehicle (date_created, date_updated, first_registration, location, manufacturer_id, millage, model, power, price, variant)
values (now(), now(), '2021-11-21', 'Germany', 2, 49000, 'Arteon', 195, 38000, 'Petrol 2.8');
insert into vehicle (date_created, date_updated, first_registration, location, manufacturer_id, millage, model, power, price, variant)
values (now(), now(), '2018-04-21', 'Germany', 1, 4500, 'A7', 220, 70000, 'Petrol 3.0');
insert into vehicle (date_created, date_updated, first_registration, location, manufacturer_id, millage, model, power, price, variant)
values (now(), now(), '2021-02-11', 'Germany', 1, 3400, 'RS6', 412, 150000, 'Petrol 4.0 Bi Turbo');
insert into vehicle (date_created, date_updated, first_registration, location, manufacturer_id, millage, model, power, price, variant)
values (now(), now(), '2022-02-11', 'Germany', 1, 6400, 'RS7', 512, 190000, 'Petrol 5.0 Bi Turbo');