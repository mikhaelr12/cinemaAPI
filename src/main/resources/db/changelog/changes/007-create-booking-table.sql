create table bookings(
    id bigint primary key not null ,
    user_id bigint not null ,
    screening_id bigint not null ,
    total_price decimal(5,2) not null ,
    foreign key (user_id) references users(id),
    foreign key (screening_id) references screenings(id)
);

alter table bookings owner to root;
create sequence booking_id_seq;
alter sequence booking_id_seq owner to root;