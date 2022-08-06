package UI;
import javax.swing.*;

public class GraphicUI implements UIMethods{
    private JFrame frame;
    public void displayWindow(){
        frame.setSize(1920,1080);
        frame.setLayout(null);
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
}
