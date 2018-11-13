create table person (
  id int auto_increment primary key,
  name varchar(255) not null,
  role varchar(255) not null,
);

insert into person values (default, 'Code Orange', 'dev');
insert into person values (default, 'Michael McNichol', 'slacker');
