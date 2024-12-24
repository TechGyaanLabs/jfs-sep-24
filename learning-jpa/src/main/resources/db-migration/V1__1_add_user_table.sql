create table if not exists app_user(
    id uuid,
    name varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    mobile varchar(10) not null,
    primary key(id)
);

insert into app_user(id, name, password, email, mobile) values ('1', 'system-user', 'system-user@123',
'systemuser@careerit.com', '9876543210');