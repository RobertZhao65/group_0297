package UI;

import javax.swing.*;


/**
 * GUI for the login process
 */

public class LoginGUI extends JFrame{
    private final JPanel panel = new JPanel();
    private final JLabel userLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField username = new JTextField(15);
    private final JPasswordField password = new JPasswordField();
    private final JButton login = new JButton("Login");

    /**
     * Constructor, creates login window and initializes program
     */
    public LoginGUI(){
        setContentPane(panel);
        setTitle("Login to Music Player");
        setSize(400, 350);
        panel.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        userLabel.setBounds(45, 90, 70, 25);
        panel.add(userLabel);

        passwordLabel.setBounds(45, 120,70, 25);
        panel.add(passwordLabel);

        username.setBounds(150, 90, 150,25);
        panel.add(username);

        password.setBounds(150, 120, 150, 25);
        panel.add(password);

        login.setBounds(140,170,70, 25);
        panel.add(login);

    }

    public static void main(String[] args) {
        JFrame frame = new LoginGUI();
        frame.setVisible(true);
    }

    


}
