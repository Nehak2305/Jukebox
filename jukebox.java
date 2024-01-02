import javax.sound.midi.Soundbank;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class jukebox {
   public  static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        boolean enter=false;
        User user = new User();
        Scanner sc = new Scanner(System.in);
        while(!enter) {
        System.out.println("WELCOME TO JUKEBOX");
        System.out.println("New User?(Y/N)");
        String newUser = sc.next();

            if ("Y".equalsIgnoreCase(newUser)) {

                System.out.println("Enter UserName");
                String userName = sc.next();
                user.setUserName(userName);
                System.out.println("Enter new password");
                String password = sc.next();
                user.setPassword(password);
                user.createAccount();
                enter = true;
            } else if ("N".equalsIgnoreCase(newUser)) {
                System.out.println("Enter UserName");
                String userName = sc.next();
                user.setUserName(userName);
                System.out.println("Enter new password");
                String password = sc.next();
                user.setPassword(password);
                enter = user.checkUser(user.getUserName(), user.getPassword());
            }
        }
        if (enter){
            int choice;
        SongImpl impl = new SongImpl();
        do {
            System.out.println("1.view and play by song list");
            System.out.println("2.view by song genres");
            System.out.println("3.view song by artists");
            System.out.println("4.Create a new personalised playlist");
            System.out.println("5.View and play your playlist");
            System.out.println("6.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    List<Song> list = new ArrayList<>();
                    list = impl.getAllSongs();
                    System.out.println("Here is the song available in catalog");
                    for (Song s : list)
                        System.out.println(s.getSong_id() +" "+ s.getSong_name());
                    System.out.println("Enter 11 for exit");
                    System.out.println("Select a song to play");
                    Scanner sc3= new Scanner(System.in);
                    int b=(sc3.nextInt());
                    if(b>0 && b<11){
                    playSong(b);}
                    else{
                        System.out.println("No song with this index");
                }
                   /* PlayMusic.filePath="C:\\Users\\Neha K\\Dropbox\\PC\\Downloads\\".concat(String.valueOf(list.get(b).getSong_id())).concat(".wav");
                    PlayMusic p =new PlayMusic();
                    p.musicController(list.get(b).getSong_id());*/

                    list.clear();
                    break;
                case 2:
                    System.out.println("Here is the genre available in catalog");
                    System.out.println("1. Indian pop");
                    System.out.println("2. Classical");
                    System.out.println("3. gajals");
                    System.out.println("4. Qawwali");
                    System.out.println("5. Bhajan");
                    System.out.println("6. Folk");
                    System.out.println(" Please select Genres by names");
                    Scanner sc5 = new Scanner(System.in);
                    String genre_Name = sc5.next();
                    list = impl.getSongNameByGenre(genre_Name);
                    System.out.println();
                    if(list!=null){
                        System.out.println("Select song by number to play song");
                        Scanner sc7 =new Scanner(System.in);
                        int l = sc7.nextInt();
                        playSong(list.get(l-1).getSong_id());
                    }
                    list.clear();
                    break;
                case 3:
                    System.out.println("Here is the artist available in catalog");
                    System.out.println("Adnan sami");
                    System.out.println("AP dhillon , Gurinder Gill");
                    System.out.println("Jagjit Singh");
                    System.out.println("Ghulam ali");
                    System.out.println("ustad sultan khan , kavitakrishna murthy");
                    System.out.println("Papon");
                    System.out.println("abhilipsha panda");
                    System.out.println("Amit Trvedi");
                    System.out.println("Karshan Sargathiya");
                    System.out.println("Shaan");
                    System.out.println("");
                    System.out.println("Enter artist name for song list");
                    Scanner sc8 = new Scanner(System.in);
                    String name="";

                    name+=sc8.nextLine();
                    impl.check(name);
                    break;
                case 4:
                    Playlist playlist = new Playlist();
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Enter your playlist Name");
                    String playlistName = sc2.next();
                    playlist.setPlaylist_name(playlistName);
                    playlist.setU(user);
                    playlist.createPlaylist();

                    System.out.println("Select songs from the list below");
                    list = impl.getAllSongs();
                    int i = 1;
                    for (Song s : list) {
                        System.out.println(i + " " + s.getSong_name());
                        i++;
                    }
                    list.clear();
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Enter song no. you want to add in playlist (separate by comma if selecting more than 1 song)");
                    String s = sc1.next();
                    String[] song_id_list = s.split(",");
                    List<Song> songList = new ArrayList<>();
                    Song songForPlaylist;
                    for (int k = 0; k < song_id_list.length; k++) {
                        songForPlaylist = new Song();
                        songForPlaylist.setSong_id(Integer.valueOf(song_id_list[k]));
                        songList.add(songForPlaylist);
                    }
                    playlist.updateSongs2Playlist(songList, playlist);

                    break;
                case 5:
                    List<Playlist> plst = user.viewPlaylists();
                    if(!plst.isEmpty()){
                        System.out.println("Select your playlist");
                        int g = 1;
                    for (Playlist pp : plst) {
                        System.out.println(g + ". " + pp.playlist_name);
                        g++;
                    }
                        System.out.println("Select playlist S.No. for songs");
                        Scanner sc6 = new Scanner(System.in);
                        int h = sc6.nextInt();
                        if(h<=plst.size()){
                            Playlist n = plst.get(h - 1);
                            List<Integer> ll=null;
                            boolean play=true;
                            while(play) {
                                ll = n.getSongForPlaylist();
                                System.out.println("Select song_id to play song");
                                Scanner sc4 = new Scanner(System.in);
                                int d = sc4.nextInt();
                                if (ll.contains(d)) {
                                    playSong(d);
                                } else {
                                    System.out.println("Wrong Song_id selected");
                                }
                                System.out.println("Want to play more song (Y/N");
                                Scanner sc7 = new Scanner(System.in);
                                String more = sc7.next();
                                if(more.equalsIgnoreCase("N")){
                                    play=false;
                                }
                            }
                        }
                        else{
                            System.out.println("Wrong index selected");
                        }
                    }
                    else{
                        System.out.println("No playlist available");
                    }
                    break;
            }
        } while (choice != 6);
    }
        }
        public static void playSong(int song_id) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            PlayMusic.filePath="C:\\Users\\Neha K\\Dropbox\\PC\\Downloads\\".concat(String.valueOf(song_id)).concat(".wav");
            PlayMusic p =new PlayMusic();
            p.musicController(song_id);
        }
}




