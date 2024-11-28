alter table seats
drop column price;

insert into seats values(nextval('seat_id_seq'), 1),
                        (nextval('seat_id_seq'), 1),
                        (nextval('seat_id_seq'), 1),
                        (nextval('seat_id_seq'), 1)