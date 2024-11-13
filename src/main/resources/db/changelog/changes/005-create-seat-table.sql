create table seats(
    id bigint primary key ,
    price decimal(5,2) not null ,
    room_id bigint not null ,
    foreign key (room_id) references rooms(id)
);
alter table seats owner to root;
create sequence seat_id_seq;
alter sequence seat_id_seq owner to root;