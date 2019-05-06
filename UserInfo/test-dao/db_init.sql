-- psql -h localhost -U wlister -d postgres -f ./dao/db_init.sql

DROP TABLE IF EXISTS users;
DROP TYPE IF EXISTS user_gender;

CREATE TYPE gender  AS ENUM('MALE', 'FEMALE');
CREATE TABLE data_user (
                           id           SERIAL PRIMARY KEY,
                           first_name   varchar(30)   NOT NULL,
                           middle_name  varchar(30)   NOT NULL,
                           last_name    varchar(30)   NOT NULL,
                           birth_date   date,
                           gender       gender  NOT NULL
);