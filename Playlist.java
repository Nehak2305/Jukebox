import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
public class Playlist {
    int playlist_id;
    String playlist_name;
    List <Song> list =new ArrayList<>();
    User u;
    public Playlist(int playlist_id, String playlist_name,List<Song> list,User u) {
        this.playlist_id = playlist_id;
        this.playlist_name = playlist_name;
        this.list = list;
        this.u=u;
    }
    public Playlist(String playlist_name,User u) {
        this.playlist_name = playlist_name;
        this.u=u;
    }
    public Playlist(){

    }




    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }
    public List<Song> getList(){
        return list; }
    public void setList(List<Song> list) {
        this.list = list;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    Connection con;

    @Override
    public String toString() {
        return "Playlist{" +
                "playlist_id=" + playlist_id +
                ", playlist_name='" + playlist_name + '\'' +
                ", list=" + list +
                ", user_id=" + u +
                ", con=" + con +
                '}';
    }

    public boolean createPlaylist() {
        boolean created= false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("insert into playlist (playlist_name,user_name) values(?,?)");
            //prs.setInt(1, getPlaylist_id());
            prs.setString(1, getPlaylist_name());
            prs.setString(2, u.getUserName());
            int rows = prs.executeUpdate();
            if (rows > 0) {
                System.out.println("Playlist created");
                created = true;
            }
            else {
                created = false;
            }

        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return created;
    }

    public void updateSongs2Playlist(List<Song> list, Playlist pl) {

        int rows;
        try {
            PreparedStatement p;
            for (Song s : list) {
                p = con.prepareStatement("insert into playlist_detail (playlist_id,song_id) values" +
                        "((select playlist_id from playlist where playlist_name = (?)),?)");
                p.setString(1, pl.getPlaylist_name());
                p.setInt(2, s.getSong_id());
                rows = p.executeUpdate();
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<Integer>    getSongForPlaylist() {
        List<Integer> songList= new ArrayList<> ();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs=con.prepareStatement("select song_name,song_id from song where song_id in " +
                    "(select song_id from playlist_detail where playlist_id = ?)");
            prs.setInt(1,getPlaylist_id());
            ResultSet rs=prs.executeQuery();

           while(rs.next()){
               System.out.println(rs.getInt(2)+" "+rs.getString(1));
               songList.add(rs.getInt(2));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();}
        catch(SQLException e){
            System.out.println(e);
        }
        return songList;
    }


}
