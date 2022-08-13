package UI;

import Driver.AccountManager;
import MusicUtil.Album;
import MusicUtil.Playlist;
import MusicUtil.Song;
import MusicUtil.SongManager;

import java.util.List;

/**
 * Text-based UI
 */

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
        int i=1;
        if (!playlist.isEmpty()) {
            for (Song s : playlist) {
                System.out.println(i+". "+s.getId() + ". " + s.artistTitleAlbum());
                i++;
            }
        } else {
            System.out.println("This playlist is empty...");
        }
    }

    @Override
    public boolean displayAlbums(List<Playlist> albums) {
        try {
            albums.isEmpty();
        } catch (NullPointerException e) {
            System.out.println("There's no matching result...");
            return false;
        }
        int i=1;
        for (Playlist a : albums) {
            System.out.println(i+". "+a.toString());
            i++;
        }
        return true;
    }

    @Override
    public void share(boolean result) {
        if(result==true){
            System.out.println("The sharable status has changed");
        }else {
            System.out.println("The sharable status can not be changed, you can only change the playlists that you own");
        }
    }

    @Override
    public void viewPlaylist(List<Playlist> playlists) {
        try{
            playlists.isEmpty();
        }catch (NullPointerException e){
            System.out.println("There's no matched playlist or you don't have access to it");
        }
        int i=1;
        for(Playlist p: playlists){
            System.out.println(i+". " +p.toString());
            i++;
        }
    }

    @Override
    public void removePlaylist(boolean result) {
        if(result == true){
            System.out.println("The playlist has been removed");
        }else {
            System.out.println("This playlist cannot be removed");
        }
    }

    @Override
    public void removeSong(boolean result) {
        if(result == true){
            System.out.println("The song has been removed");
        }else {
            System.out.println("This song cannot be removed");
        }
    }

    @Override
    public void addSong(boolean result) {
        if(result == true){
            System.out.println("The song has been added");
        }else {
            System.out.println("This song cannot be added");
        }
    }
}
