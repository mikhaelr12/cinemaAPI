create table movies(
    id bigint primary key not null ,
    title varchar(50) not null ,
    description varchar(50) not null ,
    duration time not null,
    image varchar(50) not null ,
    genre_id bigint,
    foreign key (genre_id) references genres(id)
);

alter table  movies owner to root;
create sequence movie_id_seq;
alter sequence movie_id_seq owner to root;