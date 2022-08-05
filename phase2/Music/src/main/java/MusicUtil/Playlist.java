package MusicUtil;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//import jaco.mp3.player.MP3Player;

/**
 * A playlist containing songs
 */

public abstract class Playlist implements Serializable {
    /**
     * List of songs in the playlist
     */
    protected List<Song> musics;//change to musics object, a pointer toward the actual file, be minimal
    /**
     * Name of the playlist
     */
    private String name;
    /**
     * Description of the playlist
     */
    private String about = "";

    /**
     * Constructs playlist with initialized name and about
     *
     * @param name name of playlist
     * @param about description of playlist
     */
    public Playlist(String name, String about) {
        this.name = name;
        this.about = about;
    }

    /**
     * Constructs playlist with initialized name
     *
     * @param name name of playlist
     */
    public Playlist(String name) {
        this.musics = new ArrayList<>();
        this.name = name;
    }

    /**
     * Constructs playlist
     */
    public Playlist() {
        this.musics = new ArrayList<>();
    }

    /**
     * Add songs to the playlist
     *
     * @param songs list of songs to be added
     * @return true if song has been added to playlist
     */
    public abstract boolean add(List<Song> songs);//TODO: return specific reason for unable to add(String)

    /**
     * Remove songs from the playlist
     *
     * @param song song to be removed
     * @return true if song has been removed from playlist
     */
    public abstract boolean remove(Song song);//TODO: return specific reason for unable to remove(String)

    /**
     * Empty the playlist
     *
     * @return true if playlist has been emptied
     */
    public abstract boolean empty();//TODO: return specific reason for unable to empty(String)

    /**
     * Whether the playlist is sharable
     *
     * @return true if playlist is sharable
     */
    public abstract boolean isSharable();

    /**
     * Get the list of songs in the playlist
     * @return list of songs
     */
    public abstract List getMusics();

    /**
     * Get the description of the playlist
     * @return about
     */
    public String getAbout() {
        return this.about;
    }

    /**
     * Get the name of the playlist
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the playlist
     * @param name name of playlist to be provided
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the description of the playlist
     * @param about description of playlist to be provided
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Play songs from the playlist
     *
     * @param player MP3 player
     */
    /*public void play(MP3Player player) {
        for(Song song : musics){
            player.addToPlayList(new File(song.getFilepath()));
        }
        player.play();
    }*/

}
