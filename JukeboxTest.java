import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JukeboxTest {
@Test

        public void CheckUser(){
        User u = new User();
        assertTrue("Welcome"+u.getUserName(),u.checkUser("Neha", "neha123"));
        assertFalse("Wrong Details provided",u.checkUser("Neha","neha"));
}
@Test
        public void createPlaylist(){
                User u1 = new User();
                u1.setUserName("Neha");
                Playlist pd=new Playlist("myplaylisttest",u1);
                pd.createPlaylist();
               assertEquals(8,u1.viewPlaylists().size());   }


}
