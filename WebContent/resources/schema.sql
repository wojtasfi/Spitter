drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id identity,
  username varchar(25) not null,
  password varchar(25) not null,
  firstName varchar(100) not null,
  lastName varchar(100) not null,
  email varchar(50) not null,
  updateByEmail boolean not null,
  status varchar(10) not null
);

create table spittle (
  spittleId integer identity primary key,
  spitter integer not null,
  message varchar(2000) not null,
  time datetime not null,
  latitude integer not null,
  longitude integer not null,
  foreign key (spitter) references spitter(id)
);
