-- CREATE TABLE user (
--                       id bigint not null,
--                       name varchar(30) not null unique,
--                       description varchar(150),
--                       location varchar(100)
-- );
--
-- alter table user add constraint user_pk primary key(id);
create table product (
    pro_num bigint not null,
    name varchar(30) not null,
    price float8 not null,
    order_id bigint
);

create table order (
    id bigint not null,
    user_name varchar(30),
    address varchar(150),
    user_id bigint
);

alter table product add constraint product_pk primary key (pro_num);

alter table order add constraint order_pk primary key (id);

alter table product add constraint product_order_fk foreign key (order_id) references order (id);
