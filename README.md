create database green_eta;
use green_eta;

create table post (
	id int primary key auto_increment,
    title varchar(20) not null,
    content varchar(20) not null,
    image varchar(255),
    author_id varchar(255) not null,
    created_at timestamp default current_timestamp(),
    view int default 0
);

create table comment (
	id int primary key auto_increment,
    post_id int,
    content varchar(255) not null,
    author_id varchar(255) not null,
    created_at timestamp default current_timestamp,
    foreign key(post_id) references post(id)
);

insert into post(title,content,image,author_id,created_at)
values("안녕하세요","인사올리겠습니다",null,"송원석",now());

select * from post;
