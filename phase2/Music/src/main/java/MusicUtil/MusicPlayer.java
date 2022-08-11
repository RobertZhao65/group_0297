package MusicUtil;

import jaco.mp3.player.MP3Player;
import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * An adapter class for the MP3 playing library that this program uses which implements features that were
 * not present in the base class.
 */
public class MusicPlayer {
    private Playlist currPlaylist;
    private List<Song> currQueue;
    private Song currSong;
    public int currIndex = 0;
    private boolean repeat = false;
    private MP3Player player;

    /**
     * Begins playing a playlist
     * @param playlist the playlist that will be played
     */
    public void startPlayback(Playlist playlist) {
        player.stop();
        currQueue = playlist.getMusics();
        do {
            while (currIndex < playlist.getMusics().size()) {
                currSong = currQueue.get(currIndex);
                File file = new File(currSong.getFilepath());
                player = new MP3Player(file);
                player.play();
                while (!player.isStopped()) {
                    continue;
                }
                currIndex++;
            }
        }
        while (repeat);
    }

    /**
     * Sets the current song to be played
     * @param song the desired song
     */
    public void setCurrSong(Song song) {
        currSong = song;
    }

    /**
     * Sets the current index of the playlist
     * @param i the desired integer index
     */
    public void setCurrIndex(int i){
        currIndex = i;
    }

    /**
     * Return the queue of songs that is currently playing
     * @return the queue of songs
     */
    public List<Song> getCurrQueue(){
        return currQueue;
    }

    /**
     * Return the MP3Player object that this instance of MusicPlayer is using to play music
     * @return the MP3Player object
     */
    public MP3Player getPlayer(){
        return player;
    }

    /**
     * Skip forward by one song in the current playlist. If the player is at the end of the playlist and this
     * method is called, it will return to the first song in the playlist.
     */
    public void skipForward() {
        if (currIndex == currQueue.size() - 1) {
            currIndex = -1;
            player.stop();
        } else {
            player.stop();
        }
    }

    /**
     * Skip backward by one song in the current playlist. If the player is at the beginning of the playlist and
     * this method is called, it will go to the last song in the playlist.
     */
    public void skipBackward() {
        if (currIndex == 0) {
            currIndex = currQueue.size() - 2;
            player.stop();
        } else {
            currIndex--;
            currIndex--;
            player.stop();
        }
    }

    /**
     * Toggles the player between being paused and playing music.
     */
    public void togglePause() {
        if (player.isPaused()) {
            player.play();
        } else {
            player.pause();
        }
    }

    /**
     * Toggles the player between repeating and not repeating music
     */
    public void toggleRepeat() {
        repeat = !repeat;
    }

    /**
     * Set the repeat status of the player
     * @param b the truth value which represents the repeat status
     */
    public void setRepeat(boolean b){
        repeat = b;
    }

    /**
     * Return a string representation of the song that is currently playing
     * @return the artist, title, and album of the song
     */
    public String currentlyPlaying() {
        return currSong.artistTitleAlbum();
    }

    /**
     * Return the pause status of the player
     * @return the pause status
     */
    public boolean isPaused() {
        return player.isPaused();
    }

    /**
     * Takes the current playlist and shuffles the songs into a random order.
     */
    public void shuffle() {
        Collections.shuffle(currQueue);
        currIndex = -1;
        player.stop();
    }

    /**
     * Return a string representation of the current playlist, as well as the player's current position
     * in the current playlist.
     * @return a string representation of the current music queue
     */
    public String displayQueue() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < currQueue.size(); i++) {
            if (i == currIndex) {
                result.append(currQueue.get(i).artistTitleAlbum()).append(" <- you are here \n");
            } else {
                result.append(currQueue.get(i).artistTitleAlbum()).append("\n");
            }
        }
        return result.toString();
    }
}
