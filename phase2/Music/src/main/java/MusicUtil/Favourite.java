package MusicUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A playlist containing the list of songs marked as favourite
 */

public class Favourite extends Playlist {
    /**
     * Whether the playlist is sharable
     */
    private boolean sharable;
    /**
     * Owner of the playlist
     */
    public final String owner;
    /**
     * Recipients of the playlist
     */
    private List<String> recipients;

    /**
     * Constructs a favourite playlist with initialized owner
     *
     * @param owner owner of the playlist
     */
    public Favourite(String owner) {
        super();
        this.sharable = false;
        this.owner = owner;
        this.recipients = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    /**
     * Set whether playlist is sharable, false by default
     *
     * @param sharable whether playlist is sharable
     */
    public void setSharable(boolean sharable) {
        this.sharable = sharable;
    }

    @Override
    public boolean add(List<Song> songs) {
        super.musics.addAll(songs);
        return true;
    }

    @Override
    public boolean remove(Song musicid) {
        return (super.musics.remove(musicid));
    }

    @Override
    public boolean empty() {
        super.musics.clear();
        return true;
    }

    @Override
    public boolean isSharable() {
        return this.sharable;
    }

    @Override
    public List getMusics() {
        if (sharable) {
            return super.musics;
        }
        return null;
    }

    /**
     * Get recipients of favourite playlist
     *
     * @return the list of recipients
     */
    public List<String> getRecipients() {
        return recipients;
    }

    /**
     * Add recipients to favourite playlist
     *
     * @param recipient the recipient to be added
     */
    public void addRecipient(String recipient) {
        if (!recipients.contains(recipient)) {
            recipients.add(recipient);
        }
    }

    /**
     * Remove recipients from favourite playlist
     *
     * @param recipient the recipient to be removed
     * @return true if target recipient has been successfully removed
     */
    public boolean removeRecipient(String recipient) {
        if (recipient.contains(recipient)) {
            return recipients.remove(recipient);
        }
        return false;
    }
}
