CREATE TABLE IF NOT EXISTS employee  (
    id SERIAL primary key not null,
    nom text,
    address text,
    salary int,
    type text,
    method text,
    schedule text
);
CREATE TABLE IF NOT EXISTS mailMethod (
    ID SERIAL primary key not null,
    MAIL varchar[50]
);
CREATE TABLE IF NOT EXISTS directMethod(
    ID SERIAL primary key not null,
    FOREIGN KEY (ID) REFERENCES employee(ID)
);
CREATE TABLE IF NOT EXISTS sell(
    ID SERIAL primary key not null,
    NAME varchar[50],
    FOREIGN KEY (ID) REFERENCES employee(ID)
);
create table IF NOT EXISTS salary(
    ID serial primary key not null,
    salary int,
    foreign key (id) references employee(id)
);