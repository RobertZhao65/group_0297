package Driver;

import MusicUtil.Playlist;
import MusicUtil.PlaylistManager;
import MusicUtil.Song;
import MusicUtil.SongManager;
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
    public Program(AccountManager accountManager, SongManager songManager, PlaylistManager playlistManager){
        this.running =true;
        AM = accountManager;
        SM = songManager;
        PM = playlistManager;
        location = 0;
    }

    /**
     * Checks whether program is running
     * @return true if program is running
     */
    public boolean isRunning(){
        return running;
    }

    /**
     * Stops the program from running
     */
    public void stopRunning(){
        running = false;
    }

    /**
     * Gets location of event
     * @return location
     */
    public int getLocation(){
        return location;
    }

    public void setLocation(int i){
        this.location = i;
    }

    /**
     * Display login menu of program
     */
    public void loginDisplay(){
        location = 0;
        System.out.println("you are now at the login menu");
    }

    /**
     * Display main menu of program
     */
    public void mainMenu(){
        location = 1;
        System.out.println("you are now at the main menu");
    }

    /**
     * Display all songs
     */
    public void allSongs(){
        location = 2;
        if(!SM.getAllSongs().isEmpty()){
            for(Song song : SM.getAllSongs()){
                System.out.println(song.getId() + ". " + song.artistTitleAlbum());
            }
        }
        else{
            System.out.println("there are no songs here...");
        }

        setCurrentPlaylist(PM.getAllSongs());
    }

    private void setCurrentPlaylist(Playlist playlist){
        currPlaylist = playlist;
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

    public SongManager getSongManager(){
        return this.SM;
    }

    public AccountManager getAccountManager(){
        return this.AM;
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
