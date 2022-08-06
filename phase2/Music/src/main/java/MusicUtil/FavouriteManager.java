package MusicUtil;

import java.util.List;

public class FavouriteManager extends PlaylistManager{
    /**
     * Constructs playlist manager with initialized albums, favourites, playlists and song manager
     *
     * @param SM Song manager
     */
    public FavouriteManager(SongManager SM) {
        super(SM);
    }

    /**
     * Create favourite playlist
     *
     * @param owner owner of playlist
     * @param sharable whether playlist is sharable
     */
    @Override
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
    @Override
    public Favourite OwnerGetFavMusic(String owner) {
        Favourite f = favourites.get(owner);
        return f;
    }

    /**
     * Remove song from favourite playlist
     *
     * @param owner owner of favourite playlist
     * @param songID ID of the target song
     * @return true if song has been removed from favourite playlist
     */

    public boolean removeFavMusic(String owner, Song songID) {
        Favourite f = favourites.get(owner);
        if (f.remove(songID)) {
            favourites.replace(owner, f);
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
     * Set the favourite playlist to public
     *
     * @param owner owner of the playlist
     */
    public void setFavouritePublic(String owner) {
        Favourite f = favourites.get(owner);
        f.setSharable(true);
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
