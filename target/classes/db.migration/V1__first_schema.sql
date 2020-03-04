CREATE TABLE user (
    id bigint not null,
    name varchar(30) not null unique,
    description varchar(150),
    location varchar(100)
);

alter table user add constraint user_pk primary key(id);