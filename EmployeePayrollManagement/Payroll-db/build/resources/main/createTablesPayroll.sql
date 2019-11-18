CREATE TABLE employee(
    id SERIAL primary key not null,
    nom text,
    address text,
    salary int,
    type text,
    method text,
    schedule text,
    emp

);
CREATE TABLE mailMethod(
    ID SERIAL primary key not null,
    MAIL varchar[50]
);
CREATE TABLE directMethod(
    ID SERIAL primary key not null,
    FOREIGN KEY (ID) REFERENCES employee(ID)
);
CREATE TABLE sell(
    ID SERIAL primary key not null,
    NAME varchar[50],
    FOREIGN KEY (ID) REFERENCES employe(ID)
);
create table salary(
    ID serial primary key not null,
    salary int,
    foreign key (id) references employe(id)
);