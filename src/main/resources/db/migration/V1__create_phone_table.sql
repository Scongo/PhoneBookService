CREATE SEQUENCE phone_book_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1;


CREATE TABLE phone_book
(
    id                  INT PRIMARY KEY DEFAULT nextval('phone_book_id_seq'::regclass),
    contact_name        VARCHAR(100),
    contact_lastName     VARCHAR(100),
    contact_number       VARCHAR(100),
    CONSTRAINT user_lastName UNIQUE (contact_name)
);
