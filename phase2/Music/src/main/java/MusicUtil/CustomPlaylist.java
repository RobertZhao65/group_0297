package MusicUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A customizable playlist
 */

public class CustomPlaylist extends Playlist {
    /**
     * Whether the playlist is sharable
     */
    private boolean sharable;
    /**
     * Owner of the playlist
     */
    public final String Owner;
    /**
     * Recipients of the playlist
     */
    private List<String> recipients;

    /**
     * Constructs a custom playlist with initialized name and owner
     *
     * @param name name of playlist
     * @param Owner owner of playlist
     */
    public CustomPlaylist(String name, String Owner) {
        super(name);
        this.sharable = false;
        this.Owner = Owner;
        this.recipients = new ArrayList<>();
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
        return sharable;
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
    public List<Song> getMusics() {
        return super.musics;
    }

    /**
     * Get recipients of the custom playlist
     *
     * @return the list of recipients
     */
    public List<String> getRecipients() {
        return recipients;
    }

    /**
     * Add recipients to custom playlist
     *
     * @param recipient the recipient to be added
     */
    public void addRecipient(String recipient) {
        if (!recipients.contains(recipient)) {
            recipients.add(recipient);
        }
    }

    /**
     * Remove recipients from custom playlist
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
