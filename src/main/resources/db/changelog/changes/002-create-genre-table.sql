create table genres(
    id bigint primary key not null,
    name varchar(50)
);
alter table genres owner to root;
create sequence genre_id_seq;
alter sequence genre_id_seq owner to root;