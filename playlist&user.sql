use jukebox;
create table playlist(
playlist_id int not null auto_increment,
playlist_name varchar(50) not null,
user_name varchar(50) not null,
primary key (playlist_id)
);
select*from playlist;

select song_name from song where song_id in (select song_id from playlist_detail where playlist_id = 10);
ALTER TABLE playlist AUTO_INCREMENT=100;
delete from playlist;
insert into playlist (playlist_name,song_id)values('abcd','2,7');
ALTER TABLE playlist DROP FOREIGN KEY song_id;

select playlist_name,playlist_id from playlist where user_name='kuku';
ALTER TABLE users ADD UNIQUE (user_name);

insert into playlist values(101,'Playlist1','1,2,3');


create table users(
user_id int not null auto_increment, 
user_name varchar(50),
 playlist_id int,
 primary key(user_id)
);
ALTER TABLE users DROP foreign key playlist_id;
alter table users add passsword varchar(50);
select*from users;
update users set user_name ='Neha' where user_id =102;
DELETE FROM users WHERE user_id in (1,101);
ALTER TABLE users DROP COLUMN playlist_id;
insert into users values(1,'neha',null,'123');
drop table users;
ALTER TABLE Orders ADD FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);
delete from users;
select user_id from users where user_name='abcd' and passsword = 'abcd';
select song_name,song_id from song where song_id in (select song_id from playlist_detail where playlist_id = );