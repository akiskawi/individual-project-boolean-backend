create table exercises (
    id serial not null,
    reps integer,
    rpe integer,
    sets integer,
    workout_id integer not null,
    name varchar(255),
    primary key (id)
);
create table goals (
    id serial not null,
    weight float(53),
    body_fat varchar(255),
    primary key (id)
);
create table stats (
    height float(53),
    id serial not null,
    weight float(53),
    body_fat varchar(255),
    primary key (id)
);
create table users (
    goal_id integer unique,
    id serial not null,
    stats_id integer unique,
    email varchar(255) unique,
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
);
create table workouts (
    day smallint check (day between 0 and 6),
    id serial not null,
    user_id integer not null,
    name varchar(255),
    primary key (id)
);
alter table if exists exercises
   add constraint FK3dr0elb30wvc59xnqo67l38dd
   foreign key (workout_id)
   references workouts;
alter table if exists users
   add constraint FK6hs0ga5xds5v12mlu2rww7eal
   foreign key (goal_id)
   references goals;
alter table if exists users
   add constraint FK6trvygn0nf1m9ro0kbqwob6qf
   foreign key (stats_id)
   references stats;
alter table if exists workouts
   add constraint FKpf8ql3wbw2drijbk1ugfvki3d
   foreign key (user_id)
   references users;