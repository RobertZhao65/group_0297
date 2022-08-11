package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import Driver.*;
import MusicUtil.PlaylistManager;
import MusicUtil.SongManager;
import UI.*;
import Commands.*;


/**
 * GUI for the login process
 */

public class LoginGUI extends JFrame{
    private final JPanel panel = new JPanel();
    private final JLabel userLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField username = new JTextField(15);
    private final JPasswordField passwordT = new JPasswordField();
    private final JButton login = new JButton("Login");
    private final JCheckBox showpassword = new JCheckBox("show password");

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

        passwordT.setBounds(150, 120, 150, 25);
        panel.add(passwordT);

        login.setBounds(140,190,70, 25);
        panel.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginaction();
            }
        });

        showpassword.setBounds(220,150, 150, 20);
        panel.add(showpassword);
        showpassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowPasswordAction(e);
            }
        });

    }

    /**
     * User can hide or see their password
     * @param e Action event
     */
    private void ShowPasswordAction(ActionEvent e){
        if (showpassword.isSelected()){
            passwordT.setEchoChar((char)0);
        }
        else{
            passwordT.setEchoChar('\u25cf');
        }
    }

    /**
     * User can login with correct credentials
     */
    public void loginaction(){
        login.addActionListener( e -> {
                    String user = username.getText();
                    String password = new String(passwordT.getPassword());
                    AccountManager AM = null;
                    try {
                        AM = new AccountManager("phase2/music/src/accounts.txt");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    assert AM != null;
                    if(AM.authenticate(user, password)){
                        JOptionPane.showMessageDialog(null, "Login Success");

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }


                }
        );
    }

    public static void main(String[] args) {
        JFrame frame = new LoginGUI();
        frame.setVisible(true);
    }



}
