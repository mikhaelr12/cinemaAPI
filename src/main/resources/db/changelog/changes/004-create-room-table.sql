create table rooms(
    id bigint primary key
);
alter table rooms owner to root;
create sequence room_id_seq;
alter sequence room_id_seq owner to root;