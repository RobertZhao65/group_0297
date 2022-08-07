package MusicUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages playlists
 */

public class PlaylistManager {
    protected Map<String, Favourite> favourites;
    private Map<Integer, CustomPlaylist> playlists;
    protected List<Album> albums;
    private int playlistCounter = 0;
    private SongManager SM;
    private CustomPlaylist allSongs = new CustomPlaylist("", "");

    /**
     * Constructs playlist manager with initialized albums, favourites, playlists and song manager
     *
     * @param SM Song manager
     */
    public PlaylistManager(SongManager SM) {
        this.albums = new ArrayList<>();
        this.favourites = new HashMap<>();
        this.playlists = new HashMap<>();
        this.SM = SM;
        allSongs.add(SM.getAllSongs());
    }


    /**
     * Get all songs
     *
     * @return the playlist containing all songs
     */
    public Playlist getAllSongs() {
        return allSongs;
    }


    /**
     * Create playlist
     *
     * @param name     name of playlist
     * @param owner    owner of playlist
     * @param sharable whether playlist is sharable
     */
    public int CreatePlaylist(String name, String owner, boolean sharable) {
        CustomPlaylist c = new CustomPlaylist(name, owner);
        c.setSharable(sharable);
        playlists.put(playlistCounter, c);
        playlistCounter++;
        return playlistCounter - 1;
    }

    /**
     * Get playlist
     *
     * @param playlistID ID of the playlist
     * @param owner      owner of the playlist
     * @return the list songs from the playlist
     */
    public List OwnerGetPlaylist(int playlistID, String owner) {
        Favourite c = favourites.get(playlistID);
        if (c.owner.equals(owner)) {
            return c.getMusics();
        } else return null;
    }

    /**
     * Remove song from playlist
     *
     * @param playlistID ID of the playlist
     * @param owner      owner of the playlist
     * @param songID     ID of the song to be removed
     * @return true if song has been removed from playlist
     */
    public boolean removeMusicInPlaylist(int playlistID, String owner, Song songID) {
        CustomPlaylist c = playlists.get(playlistID);
        if (c.Owner.equals(owner)) {
            if (c.remove(songID)) {
                playlists.replace(playlistID, c);
                return true;
            }
        }
        return false;
    }

    /**
     * Share playlist
     *
     * @param playlistID ID of the playlist
     * @param owner      owner of the playlist
     * @param recipient  recipients of the shared playlist
     */
    public void sharePlaylist(int playlistID, String owner, String recipient) {
        CustomPlaylist c = playlists.get(playlistID);
        if (c.Owner.equals(owner)) {
            c.addRecipient(recipient);
            playlists.replace(playlistID, c);
        }
    }

    /**
     * Set playlist to public
     *
     * @param playlistID ID of the playlist
     * @param owner      owner of the playlist
     */
    public void setPlaylistPublic(int playlistID, String owner) {
        CustomPlaylist c = playlists.get(playlistID);
        c.setSharable(true);
        playlists.replace(playlistID, c);

    }

    /**
     * User can access shared playlist
     *
     * @param playlistID ID of playlist
     * @param user       user
     * @return the list of shared songs
     */
    public List othersAccessSharedPlaylist(int playlistID, String user) {
        CustomPlaylist f = playlists.get(playlistID);
        List recipients = f.getRecipients();
        if (recipients.contains(user) || f.isSharable()) {
            return f.getMusics();
        }
        return null;
    }

    public void CreateFavorite(String owner, boolean sharable) {
        return;
    }

    public Favourite OwnerGetFavMusic(String owner) {
        return null;
    }

    public List getAlbumByName(String name) {
        return null;
    }

    public List getAlbumByGenre(String genre) {
        return null;
    }

    public List getAlbumByArtist(String artist) {
        return null;
    }
}

