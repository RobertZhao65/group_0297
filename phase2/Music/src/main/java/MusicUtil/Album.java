package MusicUtil;

import java.util.List;

/**
 * An album containing a list of songs
 */

public class Album extends Playlist {
    private String artist;
    private String genre;
    private int releaseYear;

    /**
     * Construct album with initialized name, artist, genre, year and songs
     *
     * @param name   name of album
     * @param artist artist of album
     * @param genre  genre of album
     * @param year   year published
     * @param songs  list of songs in the album
     */
    public Album(String name, String artist, String genre, int year, List<Song> songs) {
        super(name);
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = year;
        musics = songs;
    }

    public Album(String name, String artist, String genre, List<Song> songs) {
        super(name);
        this.artist = artist;
        this.genre = genre;
        musics = songs;
    }

    @Override
    public boolean add(List songs) {
        return false;
    }

    @Override
    public boolean remove(Song song) {
        return false;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public boolean isSharable() {
        return true;
    }

    @Override
    public List<Song> getMusics() {
        return super.musics;
    }

    /**
     * Returns the genre of album
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the artist of album
     *
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return getName() + " By " + artist;
    }
}
