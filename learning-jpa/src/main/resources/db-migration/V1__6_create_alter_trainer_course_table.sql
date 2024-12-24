create table if not exists trainer(
    id uuid,
    name varchar(255) not null,
    email varchar(255) not null,
    mobile varchar(255) not null,
    qualification varchar(255) not null,
    created_by uuid references app_user(id),
    created_at timestamp default current_timestamp,
    updated_by uuid references app_user(id),
    updated_at timestamp default current_timestamp,
    is_deleted boolean default false,
    primary key(id)
);

create table if not exists student_course(
    student_id uuid references student(id),
    course_id uuid references course(id)
);

alter table trainer
    add trainer_id uuid references trainer(id);