CREATE TABLE user (
    /*id                INTEGER NOT NULL default nextval('department_id_seq'), */
                            id                BIGSERIAL NOT NULL,
                            name              VARCHAR(30) not null unique,
                            description       VARCHAR(150),
                            location          VARCHAR(100)
);

ALTER TABLE user ADD CONSTRAINT department_pk PRIMARY KEY ( id );

CREATE TABLE order (
    /*id              INTEGER NOT NULL default nextval('employee_id_seq'),*/
                          id              BIGSERIAL NOT NULL,
                          name            VARCHAR(30) not null unique,
                          time            VARCHAR(150),
                          user_id         bigint NOT NULL
);

ALTER TABLE order ADD CONSTRAINT order_pk PRIMARY KEY ( id );

CREATE TABLE product (
    /*id             INTEGER NOT NULL default nextval('account_id_seq'),*/
                         id             BIGSERIAL NOT NULL,
                         name           VARCHAR(30),
                         price          float8,
                         oid            bigint NOT NULL
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( id );

ALTER TABLE order
    ADD CONSTRAINT order_user_fk FOREIGN KEY ( user_id )
        REFERENCES user ( id );

ALTER TABLE product
    ADD CONSTRAINT product_order_fk FOREIGN KEY ( oid )
        REFERENCES order ( id );