package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import Driver.*;


/**
 * GUI for the login process
 */

public class LoginGUI extends JFrame{

    AccountManager AM;
    private final JPanel panel = new JPanel();
    private final JLabel createL = new JLabel("Create or login account:");
    private final JLabel userLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField username = new JTextField(15);
    private final JPasswordField passwordT = new JPasswordField();
    private final JButton login = new JButton("Login");
    private final JButton create = new JButton("Create new account");
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

        createL.setBounds(7, 7, 200, 140);
        panel.add(createL);

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

        create.setBounds(100, 220, 150, 25);
        panel.add(create);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createaction();
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

        AM = null;
        try {
            AM = new AccountManager("phase2/music/src/accounts.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
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

                    if(AM.authenticate(user, password)){
                        JOptionPane.showMessageDialog(null, "Login Success");
                        this.show(false);
                        new MainGUI(AM);
                        // this.show(true)
                        // this.;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                        username.setText("");
                        passwordT.setText("");

                    }

                }
        );
    }

    /**
     * User can create new account with username and password
     */
    public void createaction(){
        create.addActionListener(e -> {
            String user = username.getText();
            String password = new String(passwordT.getPassword());
            AM.createAccount(user, password);
                    try {
                        AM.updateLog("phase2/music/src/accounts.txt");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Account created");
            new MainGUI(AM);
        }
        );
    }


    public static void main(String[] args) {
        JFrame frame = new LoginGUI();
        frame.setVisible(true);
    }



}
