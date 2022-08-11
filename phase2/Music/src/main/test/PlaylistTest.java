import MusicUtil.Album;
import MusicUtil.PlaylistManager;
import MusicUtil.Song;
import MusicUtil.SongManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistTest {
    @Test
    public void testCreateFavourite() {
        SongManager SM = new SongManager();
        PlaylistManager PM = new PlaylistManager(SM);
        PM.CreateFavorite("Rick",false);
        assert PM.OwnerGetFavMusic("Rick").owner.equals("Rick");
    }
    @Test
    public void testCreateSong(){
        SongManager SM = new SongManager();
        PlaylistManager PM = new PlaylistManager(SM);
        Song s =new Song("Never Gonna Give You Up");
        SM.addSong(s);
        assert SM.getAllSongs().contains(s);
    }
    @Test
    public void testCreateAlbum(){
        SongManager SM = new SongManager();
        PlaylistManager PM = new PlaylistManager(SM);
        Song s = new Song("Jackpot","Jackpot","TheFatRat","Electronic","path");
        List<Song> l=new ArrayList<>();
        l.add(s);
        Album a = new Album("Jackpot","TheFatRat","Electronic",l);
        PM.CreateAlbumNoYear("Jackpot","TheFatRat","Electronic",l);
        Album b= (Album) PM.getAlbumByName("Jackpot").get(0);
        assert b.getArtist().equals("TheFatRat");
    }

}
