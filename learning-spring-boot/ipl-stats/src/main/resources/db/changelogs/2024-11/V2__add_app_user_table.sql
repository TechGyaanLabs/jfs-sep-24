create table if not exists app_user(
    id UUID,
    username varchar(250) not null,
    password varchar(250) not null,
    role varchar(250) not null,
    constraint pk_app_user_id primary key(id)
);
