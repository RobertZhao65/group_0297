package MusicUtil;

import java.util.ArrayList;
import java.util.List;

public class AlbumManager extends PlaylistManager {
    public AlbumManager(SongManager SM) {
        super(SM);
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
        for (Album a : super.albums) {
            if (name.equals(a.getName()) && artist.equals(a.getArtist())) {
                return false;
            }
        }
        Album a = new Album(name, artist, genre, year, musicid);
        albums.add(a);
        return true;
    }

    public boolean CreateAlbumNoYear(String name, String artist, String genre, List<Song> musicid) {
        for (Album a : super.albums) {
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
}
