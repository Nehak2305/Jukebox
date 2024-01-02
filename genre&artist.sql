use jukebox;
create table genre(
genre_id int primary key,
genre_type varchar(50)
);
insert into genre values(101,'Indian pop');
insert into genre values(102,'Classical');
insert into genre values(103,'gajals');
insert into genre values(104,'Qawwali');
insert into genre values(105,'Bhajan');
insert into genre values(106,'Folk');
describe genre;
select*from genre;

create table artist(
artist_id int primary key,
artist_name varchar(50)
);
insert into artist values(1,'Badshah');
insert into artist values(2,'AP dhillon , Gurinder Gill');
insert into artist values(3,'Jagjit Singh');
insert into artist values(4,'Ghulam ali');
insert into artist values(5,'ustad sultan khan , kavitakrishna murthy');
insert into artist values(6,'Papon');
insert into artist values(7,'Adnan sami');
insert into artist values(8,'abhilipsha panda');
insert into artist values(9,'Amit Trvedi');
insert into artist values(10,'Karshan Sargathiya');
select*from artist;
select genre_id from genre where genre_type='gajals';