package UI;

import Driver.AccountManager;
import MusicUtil.Album;
import MusicUtil.Song;
import MusicUtil.SongManager;

import java.util.List;

public class TextUI implements UIMethods {
    private AccountManager AM;
    private SongManager SM;

    public TextUI(AccountManager AM, SongManager SM) {
        this.AM = AM;
        this.SM = SM;
    }

    public void displayLoginMenu() {
        System.out.println("You are now at the login menu");
    }

    public void displayMainMenu() {
        System.out.println("You are now at the main menu");
    }

    public void loginSuccess() {
        System.out.println("Logged in as " + AM.getActiveUser());
    }

    public void loginFail() {
        System.out.println("Login failed");
    }

    public void logoutMsg() {
        System.out.println("Logging out of " + AM.getActiveUser());
    }

    public void exitMsg() {
        System.out.println("Exiting program");
    }

    public void accountCreateSuccess() {
        System.out.println("Account created successfully");
    }

    public void accountCreateFail() {
        System.out.println("An account with this username already exists");
    }

    public void accountDeleteSuccess() {
        System.out.println("Account deleted successfully");
    }

    public void accountDeleteFail() {
        System.out.println("Account couldn't be found");
    }

    public void displayLoginHistory() {
        System.out.println(AM.getUserLoginHistory(AM.getActiveUser()));
    }

    public void displayAllSongs() {
        if (!SM.getAllSongs().isEmpty()) {
            for (Song song : SM.getAllSongs()) {
                System.out.println(song.getId() + ". " + song.artistTitleAlbum());
            }
        } else {
            System.out.println("there are no songs here...");
        }
    }

    @Override
    public void displayPlaylist(List<Song> playlist) {
        try {
            playlist.isEmpty();
        } catch (NullPointerException e) {
            System.out.println("This playlist does not exists...");
            return;
        }
        if (!playlist.isEmpty()) {
            for (Song s : playlist) {
                System.out.println(s.getId() + ". " + s.artistTitleAlbum());
            }
        } else {
            System.out.println("This playlist is empty...");
        }
    }

    @Override
    public void displayAlbums(List<Album> albums) {
        try {
            albums.isEmpty();
        } catch (NullPointerException e) {
            System.out.println("There's no matching result...");
            return;
        }

        for (Album a : albums) {
            System.out.println(a.toString());

        }
    }
}
