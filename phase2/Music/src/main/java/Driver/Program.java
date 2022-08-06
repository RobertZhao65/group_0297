package Driver;

import MusicUtil.*;

import java.util.List;
// import jaco.mp3.player.MP3Player;

/**
 * Main program
 */

public class Program {
    private boolean running;
    private AccountManager AM;
    private int location;

    private SongManager SM;

    // private MP3Player player = new MP3Player();

    private Playlist currPlaylist;
    private PlaylistManager PM;

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
                System.out.println(song.getId() + ". " + song.artistTitleAlbum());
            }
        } else {
            System.out.println("there are no songs here...");
        }

        setCurrentPlaylist(PM.getAllSongs());
    }

    public void setCurrentPlaylist(Playlist playlist) {
        currPlaylist = playlist;
    }

    public void chooseSong(Integer num) {
        List<Song> songs = currPlaylist.getMusics();
        if(num>songs.size()|| num<1){
            System.out.println("Please insert the correct number");
        }else{
            //TODO: finish the operation for set the music selected to current song
        }
    }

//    /**
//     * Allows MP3 player to play song
//     */
//    public void play(){
//        currPlaylist.play(player);
//    }
//
//    /**
//     * Allows MP3 player to pause song
//     */
//    public void pause(){
//        player.pause();
//    }
//
//    /**
//     * Allows MP3 player to stop song
//     */
//    public void stop(){
//        player.stop();
//    }

    /**
     * Displays login message
     */
    public void loginMsg() {
        System.out.println("logged in as " + AM.getActiveUser());
    }

    /**
     * Displays logout message
     */
    public void logoutMsg() {
        System.out.println("logging out of " + AM.getActiveUser());
    }

    /**
     * Displays login failed message
     */
    public void loginFail() {
        System.out.println("login failed");
    }

    /**
     * Displays exit program message
     */
    public void exitMsg() {
        System.out.println("exiting program");
    }

    /**
     * Displays new account created successfully message
     */
    public void createSuccess() {
        System.out.println("account created successfully");
    }

    /**
     * Displays create new account failed message
     */
    public void createFail() {
        System.out.println("an account with this username already exists");
    }

    /**
     * Displays account deleted message
     */
    public void deleteSuccess() {
        System.out.println("account deleted successfully");
    }

    /**
     * Displays account already deleted message
     */
    public void deleteFail() {
        System.out.println("account couldn't be found");
    }

    /**
     * Displays login history of account
     */
    public void getLoginHistory() {
        System.out.println(AM.getUserLoginHistory(AM.getActiveUser()));
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
//    //TODO: rework this
//
//    /**
//     * Toggles the music player's repeat status between on and off
//     */
//    public void repeat(){
//        if(player.isRepeat()){
//            System.out.println("music is no longer repeating");
//            player.setRepeat(false);
//        }
//        else{
//            System.out.println("music is now repeating");
//            player.setRepeat(true);
//        }
//    }
//
//    //TODO: rework this
//
//    /**
//     * Toggles the music player's shuffle status between on and off
//     */
//    public void shuffle(){
//        if(player.isShuffle()){
//            System.out.println("music is no longer being shuffled");
//            player.setShuffle(false);
//        }
//        else{
//            System.out.println("music is now being shuffled");
//            player.setShuffle(true);
//        }
//    }
//
//    /**
//     * Skips to the next song in the current playlist
//     */
//    public void skipForward(){
//        player.skipForward();
//    }
//
//    /**
//     * Returns to the previous song in the current playlist
//     */
//    public void skipBackwards(){
//        player.skipBackward();
//    }
}
