create table screenings(
    id bigint primary key not null ,
    movie_id bigint not null ,
    room_id bigint not null ,
    screening_time time not null ,
    screening_date date not null,
    foreign key (movie_id) references movies(id),
    foreign key (room_id) references rooms(id)
);

alter table screenings owner to root;
create sequence screening_id_seq;
alter sequence screening_id_seq owner to root;