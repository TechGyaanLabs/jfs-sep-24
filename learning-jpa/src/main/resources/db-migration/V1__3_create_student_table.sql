create table if not exists student(
    id uuid,
    name varchar(255) not null,
    email varchar(255) not null,
    mobile varchar(255) not null,
    primary key(id)
);