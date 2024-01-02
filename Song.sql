use jukebox;
create table song(
song_id int primary key,
song_name varchar(50),
album_name varchar(50),
duration time,
genre_id int,
 foreign key(genre_id) references genre(genre_id),
 artist_id int,
foreign key(artist_id) references artist(artist_id)
);
insert into song values(1,'Genda phool',null,null,101,1);
insert into song values(2,'Brown Munde',null,null,101,2);
insert into song values(3,'Tumko dekha to ye khayal','Sath sath',null,103,3);
insert into song values(4,'Chupke chupke','Nikaah',null,103,4);
insert into song values(5,'Albela Sajan','Hum dil de chuke sanam',null,102,5);
insert into song values(6,'moh moh k dhage','Dum lagak haisa',null,102,6);
insert into song values(7,'tere dar se na jaunga khali','Bajrangi bhaijaan',null,104,7);
insert into song values(8,'har har sambhu',null,null,105,8);
insert into song values(9,'shubhaarambh','Kai po che',null,106,9);
insert into song values(10,'Keshariya balam','Dor',null,106,10);
select*from song;
select song_name from song where genre_id = (select genre_id from genre where genre_type = 'gajals');