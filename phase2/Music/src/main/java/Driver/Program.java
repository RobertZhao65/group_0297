package Driver;

import MusicUtil.*;

import java.util.List;

/**
 * Main program
 */

public class Program {
    private boolean running;
    private AccountManager AM;
    private int location;
    private SongManager SM;
    private Playlist currPlaylist;
    private List<Playlist> playlists;
    private PlaylistManager PM;
    private MusicPlayer player = new MusicPlayer();

    /**
     * Initializes program
     *
     * @param accountManager
     * @param songManager
     * @param playlistManager
     */
    public Program(AccountManager accountManager, SongManager songManager, PlaylistManager playlistManager) {
        this.running = true;
        AM = accountManager;
        SM = songManager;
        PM = playlistManager;
        location = 0;
    }

    /**
     * Checks whether program is running
     *
     * @return true if program is running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Stops the program from running
     */
    public void stopRunning() {
        running = false;
    }

    /**
     * Gets location of event
     *
     * @return location
     */
    public int getLocation() {
        return location;
    }

    public MusicPlayer getPlayer() {
        return player;
    }

    public void setLocation(int i) {
        this.location = i;
    }

    /**
     * Display login menu of program
     */
    public void loginDisplay() {
        location = 0;
        System.out.println("you are now at the login menu");
    }

    /**
     * Display main menu of program
     */
    public void mainMenu() {
        location = 1;
        System.out.println("you are now at the main menu");
    }

    /**
     * Display all songs
     */
    public void allSongs() {
        location = 2;
        if (!SM.getAllSongs().isEmpty()) {
            for (Song song : SM.getAllSongs()) {
                int num = song.getId() + 1;
                System.out.println(num + ". " + song.artistTitleAlbum());
            }
        } else {
            System.out.println("there are no songs here...");
        }

        setCurrentPlaylist(PM.getAllSongs());
    }

    public void setCurrentPlaylist(Playlist playlist) {
        currPlaylist = playlist;
    }

    public Playlist getCurrPlaylist() {
        return currPlaylist;
    }

    public void setPlaylistSet(List playlists) {
        this.playlists = playlists;
    }

    public void chooseSong(Integer num) {
        List<Song> songs = currPlaylist.getMusics();
        if (num > songs.size() || num < 1) {
            System.out.println("Please insert the correct number");
        } else {
            player.setCurrSong(songs.get(num - 1));
            location = 4;
            System.out.println("You have selected " + songs.get(num - 1).artistTitleAlbum());
        }
    }

    public SongManager getSongManager() {
        return this.SM;
    }

    public PlaylistManager getPM() {
        return this.PM;
    }

    public void createFavourite(String user) {
        PM.CreateFavorite(user, false);
    }
    public void createPlaylist(String name){
        PM.CreatePlaylist(name, AM.getActiveUser(),false);
    }

    public AccountManager getAccountManager() {
        return this.AM;
    }

    public List<Album> getAlbum(List<String> args) {
        String type = args.get(0);
        String keyword = args.get(1);
        switch (type) {
            case "name":
                return PM.getAlbumByName(keyword);
            case "genre":
                return PM.getAlbumByGenre(keyword);
            case "artist":
                return PM.getAlbumByArtist(keyword);
            default:
                System.out.println("The type of keyword is incorrect...");
        }
        return null;
    }

    public List<Playlist> getPlaylists(List<String> args){
        return null;//TODO
    }

    public void choosePlaylist(Integer num) {
        if (num > playlists.size() || num < 1) {
            System.out.println("Please insert the correct number");
        } else {
            currPlaylist = playlists.get(num - 1);
            location = 3;
            System.out.println("You are now in " + currPlaylist);
        }
    }
    public boolean setSharable(boolean sharable){
        if (currPlaylist instanceof Favourite){
            if (currPlaylist.getOwner().equals(AM.getActiveUser())){
                PM.setFavouriteSharale(AM.getActiveUser(), sharable);
                return true;
            }
        } else if (currPlaylist instanceof Playlist) {
            Integer id=currPlaylist.getPlaylistID();
            return PM.setPlaylistSharable(id, AM.getActiveUser(), sharable);
        }
        return true;
    }
}
