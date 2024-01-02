import java.util.Arrays;
import java.util.stream.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

import static java.lang.Class.forName;

public class SongImpl  {
    Connection con;
    List<Song> songs=new ArrayList<>();
    public SongImpl(){

    }
    public List<Song> getAllSongs() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("select * from song");
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                songs.add(new Song(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return songs;
    }

    public List<Song> getSongNameByGenre(String genre_type) {
        List<Song> songList = new ArrayList<>();
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("select song_name,song_id from song where genre_id " +
                    "= (select genre_id from genre where genre_type = ?)");
            prs.setString(1,genre_type);
            ResultSet rs=prs.executeQuery();
            int i=1;
            System.out.println("the list of songs for "+ genre_type + " is:");
            Song ss= new Song();
            while(rs.next()){
                System.out.println(i+". "+rs.getString("song_name"));
                ss.setSong_id(rs.getInt(2));
                songList.add(ss);
                i++;
                //return rs.getString(1);
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return songList;
    }

    public void getSongNameByArtist(String artist_name) {
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("select song_name from song where artist_id=" +
                    "(select artist_id from artist where artist_name = ?)");
            prs.setString(1,artist_name);

            ResultSet rs=prs.executeQuery();
            System.out.println("the list of songs for "+ artist_name + " is:");

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
    }

    public void check(String toCheckValue)
    {

        String[] arr = new String[10];
        arr[0] = "ustad sultan khan , kavitakrishna murthy";
        arr[1] = "AP dhillon , Gurinder Gill";
        arr[2] = "Jagjit Singh";
        arr[3] = "Adnan sami";
        arr[4] = "Ghulam ali";
        arr[5] = "Papon";
        arr[6] = "abhilipsha panda";
        arr[7] = "Karshan Sargathiya";
        arr[8] = "Shaan";
        arr[9] = "Amit Trvedi";
        boolean test = false;
        for (String element : arr) {
            if (element.equalsIgnoreCase(toCheckValue)) {
                test = true;
            }
        }
        if (test){
            getSongNameByArtist(toCheckValue);
        }
        else{
            System.out.println("No Song available in jukebox for selected artist");
        }

    }

}
