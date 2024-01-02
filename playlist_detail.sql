use jukebox;
create table playlist_detail(
 detail_id int not null auto_increment,
 playlist_id int,
 song_id int,
 primary key(detail_id)
);
select*from playlist_detail;
insert into playlist_detail values(playlist_id, song_id);

delete from playlist_detail;