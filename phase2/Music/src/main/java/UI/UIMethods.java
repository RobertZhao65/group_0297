package UI;

import MusicUtil.Album;
import MusicUtil.Song;

import java.util.List;

public interface UIMethods {
    public void displayLoginMenu();

    public void displayMainMenu();

    public void loginSuccess();

    public void loginFail();

    public void logoutMsg();

    public void exitMsg();

    public void accountCreateSuccess();

    public void accountCreateFail();

    public void accountDeleteSuccess();

    public void accountDeleteFail();

    public void displayLoginHistory();

    public void displayAllSongs();

    public void displayPlaylist(List<Song> f);

    public void displayAlbums(List<Album> albums);
}
