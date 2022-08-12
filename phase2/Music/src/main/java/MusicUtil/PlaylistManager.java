package MusicUtil;

import java.lang.reflect.Array;
import java.util.*;

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
        initializeAlbums();
    }

    public void initializeAlbums() {
        HashMap<String, List<Song>> sortedSongs = new HashMap<>();
        List<Song> songs = allSongs.getMusics();
        for (Song s : songs) {
            if (sortedSongs.containsKey(s.getAlbumName())) {
                List<Song> temp = sortedSongs.get(s.getAlbumName());
                temp.add(s);
                sortedSongs.replace(s.getAlbumName(), temp);
            } else {
                List<Song> temp = new ArrayList<>();
                temp.add(s);
                sortedSongs.put(s.getAlbumName(), temp);
            }
        }
        List<String> keys = new ArrayList<>(sortedSongs.keySet());
        for (String s : keys) {
            List<Song> songList = sortedSongs.get(s);
            String artist = songList.get(0).getArtist();
            String genre = songList.get(0).getGenre();
            CreateAlbumNoYear(s, artist, genre, songList);
        }
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
        c.setPlaylistID(playlistCounter);
        c.setSharable(sharable);
        playlists.put(playlistCounter, c);
        playlistCounter++;
        return playlistCounter - 1;
    }

    /**
     * Get playlist
     *
     * @param playlistID ID of the playlist
     * @param user      The user who requested the operation
     * @return the list songs from the playlist
     */
    public List getPlaylist(int playlistID, String user) {
        Favourite c = favourites.get(playlistID);
        if (c.owner.equals(user)||c.isSharable()||c.getRecipients().contains(user)) {
            return c.getMusics();
        } else return null;
    }

    /**
     * Remove song from playlist
     *
     * @param playlistID ID of the playlist
     * @param owner      owner of the playlist
     * @param song     the song to be removed
     * @return true if song has been removed from playlist
     */
    public boolean removeMusicInPlaylist(int playlistID, String owner, Song song) {
        CustomPlaylist c = playlists.get(playlistID);
        if (c.Owner.equals(owner)) {
            if (c.remove(song)) {
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
     * Set playlist to sharable or not
     *
     * @param playlistID ID of the playlist
     * @param owner      owner of the playlist
     * @param sharable decide playlist sharable or not
     */
    public boolean setPlaylistSharable(int playlistID, String owner, boolean sharable) {
        try{playlists.get(playlistID);}
            catch(Exception e){
            return false;
            }
        CustomPlaylist c = playlists.get(playlistID);
        if(c.Owner.equals(owner)){
        c.setSharable(sharable);
        playlists.replace(playlistID, c);
        return true;
        }
        return false;
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

    public List getPlaylistByName(String name, String user) {
        List<Playlist> result = new ArrayList<>();
        List<Playlist> playlists1 = new ArrayList<>(playlists.values());
        for (Playlist p : playlists1) {
            if (name.equals(p.getName())) {
                if (p.isSharable() || user.equals(p.getOwner())) {
                    result.add(p);
                }
            }
        }
        return result;
    }
    public boolean addSongToPlaylist(Integer ID,String user, Song song){
        try{
            CustomPlaylist c=playlists.get(ID);
        }catch (NullPointerException e){
            System.out.println("The playlist does not exists");
            return false;
        }
        CustomPlaylist c=playlists.get(ID);
        if (c.Owner.equals(user)){
            c.add(new ArrayList<Song>(Arrays.asList(song)));
            playlists.replace(ID,c);
            return true;
        }
        return false;
    }
    public boolean removePlaylist(Integer ID){
        if(playlists.containsKey(ID)){
            playlists.remove(ID);
            return true;
        }
        return false;
    }
    /**
     * Create an album
     *
     * @param name    name of album
     * @param artist  artist of album
     * @param genre   genre of album
     * @param year    year published
     * @param musicid list of songs
     * @return true if album has been created
     */
    public boolean CreateAlbum(String name, String artist, String genre, int year, List<Song> musicid) {
        for (Album a : albums) {
            if (name.equals(a.getName()) && artist.equals(a.getArtist())) {
                return false;
            }
        }
        Album a = new Album(name, artist, genre, year, musicid);
        albums.add(a);
        return true;
    }

    public boolean CreateAlbumNoYear(String name, String artist, String genre, List<Song> musicid) {
        for (Album a : albums) {
            if (name.equals(a.getName()) && artist.equals(a.getArtist())) {
                return false;
            }
        }
        Album a = new Album(name, artist, genre, musicid);
        albums.add(a);
        return true;
    }
    /**
     * Get an album by its name
     *
     * @param name name of the target album
     * @return the list of songs in that album
     */
    public List getAlbumByName(String name) {
        List<Album> result = new ArrayList<>();
        for (Album a : albums) {
            if (name.equals(a.getName())) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Get albums by genre
     *
     * @param genre the genre to be provided
     * @return the list of albums in that genre
     */
    public List getAlbumByGenre(String genre) {
        List<Album> result = new ArrayList<>();
        for (Album a : albums) {
            if (genre.equals(a.getGenre())) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Get albums by artist name
     *
     * @param artist artist name to be provided
     * @return the list of albums under that artist's name
     */
    public List getAlbumByArtist(String artist) {
        List<Album> result = new ArrayList<>();
        for (Album a : albums) {
            if (artist.equals(a.getArtist())) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * Remove an album
     *
     * @param artist artist of the album
     * @param name   name of the album
     * @return true if album has been removed
     */
    public boolean removeAlbum(String artist, String name) {
        for (Album a : albums) {
            if (artist.equals(a.getArtist()) && name.equals(a.getName())) {
                albums.remove(a);
                return true;
            }
        }
        return false;
    }
    /**
     * Create favourite playlist
     *
     * @param owner owner of playlist
     * @param sharable whether playlist is sharable
     */

    public void CreateFavorite(String owner, boolean sharable) {
        Favourite f = new Favourite(owner);
        f.setSharable(sharable);
        favourites.put(owner, f);
    }

    /**
     * Get favourite songs
     *
     * @param owner owner of favourite playlist
     * @return the list of favourited songs
     */
    public Favourite OwnerGetFavMusic(String owner) {
        Favourite f = favourites.get(owner);
        return f;
    }

    /**
     * Remove song from favourite playlist
     *
     * @param owner owner of favourite playlist
     * @param song the target song
     * @return true if song has been removed from favourite playlist
     */

    public boolean removeFavMusic(String owner, Song song) {
        Favourite f = favourites.get(owner);
        if (f.remove(song)) {
            favourites.replace(owner, f);
            return true;
        }
        return false;
    }

    public boolean addFavMusic(String owner, Song song){
        Favourite f =favourites.get(owner);
        if (f.add(new ArrayList<Song>(Arrays.asList(song)))){
            favourites.replace(owner,f);
            return true;
        }
        return false;
    }

    /**
     * Share the favourite playlist
     *
     * @param owner owner of the playlist
     * @param recipient recipients of the shared favorite playlist
     */
    public void shareFavorite(String owner, String recipient) {
        Favourite f = favourites.get(owner);
        f.addRecipient(recipient);
        favourites.replace(owner, f);
    }

    /**
     * Set the favourite playlist harable or not
     *
     * @param owner owner of the playlist
     * @param sharable owner's choice on favourite sharable or not
     */
    public void setFavouriteSharale(String owner, boolean sharable) {
        Favourite f = favourites.get(owner);
        f.setSharable(sharable);
        favourites.replace(owner, f);
    }

    /**
     * User can access shared favourite playlist
     *
     * @param owner owner of the favourite playlist
     * @param user user
     * @return the list of shared favourited songs
     */
    public List othersAccessSharedFav(String owner, String user) {
        Favourite f = favourites.get(owner);
        List recipients = f.getRecipients();
        if (recipients.contains(user) || f.isSharable()) {
            return f.getMusics();
        }
        return null;
    }
}

