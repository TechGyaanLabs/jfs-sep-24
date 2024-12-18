create table if not exists team_details(
    id UUID,
    name VARCHAR(255),
    team varchar(5),
    total_amount float,
    remaining_amount float,
    total_players int,
    primary key(id)
)