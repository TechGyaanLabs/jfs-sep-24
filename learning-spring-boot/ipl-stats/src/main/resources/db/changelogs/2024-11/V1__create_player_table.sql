create table if not exists player_details(
	id UUID,
	name varchar(250) not null,
	role varchar(250) not null,
	country varchar(250) not null,
	team varchar(250) not null,
	price float not null,
	constraint pk_player_details_id primary key(id)
);
