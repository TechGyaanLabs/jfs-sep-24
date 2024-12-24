create table if not exists address(
    id uuid,
    city varchar(255) not null,
    state varchar(255) not null,
    country varchar(255) not null,
    created_by uuid references app_user(id),
    created_at timestamp default current_timestamp,
    updated_by uuid references app_user(id),
    updated_at timestamp default current_timestamp,
    is_deleted boolean default false,
    primary key(id)
);

alter table student
    add address_id uuid references address(id);