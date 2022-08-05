package persistence;

import MusicUtil.Favourite;
import MusicUtil.Playlist;
import MusicUtil.Song;
import org.junit.Test;

import java.util.List;

/**
 * Test cases for PersistenceService. Tests whether user playlists are stored after
 * the user logs out and logs back in.
 *
 * @author Jennifer Xi
 * @version 1.0
 * @since 2022-08-03
 */
public class PersistenceServiceTest {

    @Test
    public void testPersistFavourites() {
        // Get persistenceService
        PersistenceService persistenceService = PersistenceService.getPersistenceService();
        // create new Favourite
        String playListName = "Favourites playlist";
        Favourite inFavourite = new Favourite("Jennifer");
        inFavourite.setName(playListName);
        // persist favourite using persistenceService
        persistenceService.persistPlayList(inFavourite);
        // retrieve favourite from file system by name
        Favourite outfavourite =(Favourite) persistenceService.getPlayListByName(playListName);
        // verify the retrieved favourite playlist has the same values as the
        // originally stored favourite playlist
        assert outfavourite.getName().equals(playListName);
        assert outfavourite.getOwner().equals("Jennifer");
    }
}
