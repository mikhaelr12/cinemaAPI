create table booking_seats(
    id bigint primary key not null ,
    booking_id bigint not null ,
    seat_id bigint not null ,
    foreign key (booking_id) references bookings(id),
    foreign key (seat_id) references seats(id)
);
