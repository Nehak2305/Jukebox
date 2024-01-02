import java.sql.*;
import java.util.List;

public class Song {
    int song_id;
    String song_name;
    String genre;
    String album;
    String artist_name;
    //Time duration;

    public Song(int song_id, String song_name, String genre,String artist_name,String album) {
        this.song_id = song_id;
        this.song_name = song_name;
        this.genre = genre;
        this.album = album;
        this.artist_name = artist_name;
    }
    public Song() {

    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist_name;
    }

    public void setArtist(String artist) {
        this.artist_name = artist_name;
    }

    @Override
    public String toString() {
        return "Song{" +
                "song_id=" + song_id +
                ", song_name='" + song_name + '\'' +
                ", genre='" + genre + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist_name + '\'' +
                '}';
    }
 /*   Connection con;
    public void searchSongByName(String song_name){
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("select song_id from song where song_name=?" );
            prs.setString(1,getSong_name());
            ResultSet rs=prs.executeQuery();
            System.out.println("the song is " + song_name );

            while(rs.next()){
                // return rs.getString(1);
                System.out.println(rs.getString("song_name"));
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println(e);
        }


    }*/
}

