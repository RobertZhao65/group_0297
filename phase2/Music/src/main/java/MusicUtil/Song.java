package MusicUtil;

/**
 * A song
 */

public class Song {
    /**
     * Name of the song
     */
    private String name;
    /**
     * Name of the album that the song belongs to
     */
    private String albumName;
    /**
     * Artist of the song
     */
    private String artist;
    /**
     * Genre of the song
     */
    private String genre;
    /**
     * Path in file system
     */
    private String filepath;
    /**
     * ID of the song
     */
    private Integer id;
    /**
     * Duration of the song
     */
    private Integer duration;

    /**
     * Construct song object with initialized name, albumName, artist, genre and filepath
     *
     * @param name      name of the song
     * @param albumName name of the album the song belongs to
     * @param artist    artist of the song
     * @param genre     genre of the song
     * @param filepath  path in the file system
     */
    public Song(String name, String albumName, String artist, String genre, String filepath) {
        this.name = name;
        this.albumName = albumName;
        this.artist = artist;
        this.genre = genre;
        this.filepath = filepath;
    }

    /**
     * Construct song with initialized name
     *
     * @param name name of the song
     */
    public Song(String name) {
        this.name = name;
    }

    /**
     * Get the filepath of the song
     *
     * @return filepath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * Get the name of the song
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the artist of the song
     *
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Get the ID of the song
     *
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getGenre() {
        return genre;
    }

    /**
     * Set the name of song
     *
     * @param name name to be provided
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the ID of the song
     *
     * @param id id to be provided
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Displays the artist, name and albumName of the song
     *
     * @return the string displayed
     */
    public String artistTitleAlbum() {
        return artist + " - " + name + " (" + albumName + ")";
    }

    @Override
    public String toString() {
        return name + " by " + artist;
    }
}
