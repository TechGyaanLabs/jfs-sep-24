create table if not exists course(
    id uuid,
    title varchar(255) not null,
    description text,
    fee float not null default 0,
    duration int not null default 0,
    primary key(id)
);