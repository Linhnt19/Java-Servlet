create database java4_new;
go 
use java4_new;
go
CREATE TABLE Users(
    id varchar(100) PRIMARY KEY,
    password varchar(100),
    fullname nvarchar(100),
    email nvarchar(100),
    photo nvarchar(500),
    activated tinyint,
    admin tinyint
);
insert into Users(id,password,admin) values('admin','1',1),('user','2',0);

CREATE TABLE Videos(
    id varchar(100) PRIMARY KEY,
    title nvarchar(200) ,
    poster nvarchar(200),
    description nvarchar(200),
    views int,
    active tinyint
);
insert into Videos(id,title,active) values('video1', 'Video 1', 1),
    ('video2', 'Video 2', 1),('video3', 'Video 3', 0);


CREATE TABLE Favorites(
    id BIGINT PRIMARY KEY IDENTITY (1, 1),
    userid varchar(100),
    videoid varchar(100),
    likedate DATE,
    FOREIGN KEY (userid) REFERENCES Users(id),
    FOREIGN KEY (videoid) REFERENCES Videos(id)
);


insert into Favorites(userid,videoid,likedate) values
    ('admin','video1','2024-07-01'),
    ('admin','video2','2024-07-02'),
    ('user','video2','2024-07-03'),
    ('user','video3','2024-07-03');