package UI;
import MusicUtil.Album;
import MusicUtil.Song;

import javax.swing.*;
import java.util.List;

public class GraphicUI implements UIMethods{
    private static JLabel userLabel;
    private static JTextField username;
    private static JLabel passwordLabel;
    private static JTextField password;
    private static JButton login;
    private static JLabel success;

    public static void main(String[] args){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("Login to Music Player");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        username = new JTextField(15);
        username.setBounds(100, 20, 180,25);
        panel.add(username);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50,80, 25);
        panel.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(100, 50, 180, 25);
        panel.add(password);

        login = new JButton("Login");
        login.setBounds(115,80,150, 25);

        panel.add(login);

        JButton create = new JButton("Create Account");
        create.setBounds(115, 110, 150, 25);
        panel.add(create);
        frame.setVisible(true);
    }


    public void displayLoginMenu() {

    }

    public void displayMainMenu() {

    }

    /**
     * Display the message which indicates that the user's login attempt was successful
     */
    public void loginSuccess() {
    }

    /**
     * Display the message which indicates that the user's login attempt was failed
     */
    public void loginFail() {

    }

    /**
     * Display the message which indicates that the user has logged out successfully
     */
    public void logoutMsg() {

    }

    /**
     * Display the message which indicates that the program is closing
     */
    public void exitMsg() {

    }

    /**
     * Display the message which indicates that the user's account creation attempt was successful
     */
    public void accountCreateSuccess() {

    }

    /**
     * Display the message which indicates that the user's account creation attempt was failed
     */
    public void accountCreateFail() {

    }

    /**
     * Display the message which indicates that the user's account deletion attempt was successful
     */
    public void accountDeleteSuccess() {

    }

    /**
     * Display the message which indicates that the user's account deletion attempt was failed
     */
    public void accountDeleteFail() {

    }

    /**
     * Display the currently logged-in user's login history
     */
    public void displayLoginHistory() {

    }

    public void displayAllSongs() {

    }

    @Override
    public void displayPlaylist(List<Song> playlist) {
    }

    @Override
    public boolean displayAlbums(List<Album> albums) {
        return false;
    }
}
