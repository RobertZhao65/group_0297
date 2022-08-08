package MusicUtil;

import java.util.List;

/**
 * A history of the list of songs played previously in the current session
 */

public class History extends Playlist {

    /**
     * Constructs history
     */
    public History() {
        super();
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
        return false;
    }

    @Override
    public List<Song> getMusics() {
        return super.musics;
    }
}
