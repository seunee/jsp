--22/12/09

--DB 생성
create table my_board(
bno int not null auto_increment, 
title varchar(100) not null, 
writer varchar(100) not null, 
content text, 
regdate datetime default now(), 
read_count int default 0, 
image_file text, 
primary key(bno));

create table my_comment(
cno int not null auto_increment, 
bno int default -1, 
writer varchar(100) default "Unknown",
content varchar(1000) not null,
reg_at datetime default current_timestamp, 
primary key(cno));


create table my_member(
email varchar(100) not null,
pwd varchar(100) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime,
primary key(email));