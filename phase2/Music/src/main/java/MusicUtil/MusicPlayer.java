package MusicUtil;

import jaco.mp3.player.MP3Player;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class MusicPlayer {
    private Playlist currPlaylist;
    private List<Song> currQueue;
    private Song currSong;
    public int currIndex = 0;
    private boolean repeat = false;
    private MP3Player player;

    public void startPlayback(Playlist playlist) {
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

    public void setCurrSong(Song song) {
        currSong = song;
    }

    public void skipForward() {
        if (currIndex == currQueue.size() - 1) {
            currIndex = -1;
            player.stop();
        } else {
            player.stop();
        }
    }

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

    public void togglePause() {
        if (player.isPaused()) {
            player.play();
        } else {
            player.pause();
        }
    }

    public void toggleRepeat() {
        repeat = !repeat;
    }

    public String currentlyPlaying() {
        return currSong.artistTitleAlbum();
    }

    public boolean isPaused() {
        return player.isPaused();
    }

    public void shuffle() {
        Collections.shuffle(currQueue);
        currIndex = -1;
        player.stop();
    }

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
