import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class User {
    String userName;
    int user_id;
    String password;

    List<Playlist> PlyList;


    public User(String userName, int user_id, String password, List<Playlist> plyList) {
        this.userName = userName;
        this.user_id = user_id;
        this.password = password;
        PlyList = plyList;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Playlist> getPlyList() {
        return PlyList;
    }

    public void setPlyList(List<Playlist> plyList) {
        PlyList = plyList;
    }

    Connection con;
    List<User> users = new ArrayList<>();

    public void createAccount() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("insert into users (user_name,passsword) values(?,?)");
            prs.setString(1, getUserName());
            prs.setString(2, getPassword());
            int rows = prs.executeUpdate();
            if (rows > 0) {
                System.out.println("Account created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String userName, String password) {
        boolean enter=false;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("select user_id from users where user_name=? and passsword = ?");
            prs.setString(1, userName);
            prs.setString(2,password);
            ResultSet rs = prs.executeQuery();
            if(rs.next()){
                System.out.println("Welcome "+getUserName());
                enter = true;
            }
            else{
                System.out.println("Wrong Details provided");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return enter;
    }

    public List<Playlist> viewPlaylists() {
        Playlist p;
        List<Playlist> listOfPlaylist = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "neha@23");
            PreparedStatement prs = con.prepareStatement("select playlist_name,playlist_id from playlist where user_name=?");
            prs.setString(1, getUserName());
            ResultSet rs = prs.executeQuery();
           // int i = 0;
                System.out.println("Playlist for " + getUserName() + " is as below");

                while (rs.next()) {
                    p = new Playlist();
                    p.setPlaylist_name(rs.getString(1));
                    p.setPlaylist_id(rs.getInt(2));
                    listOfPlaylist.add(p);
                }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listOfPlaylist;
    }
}
