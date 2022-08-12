package UI;

import Driver.AccountManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.FileNotFoundException;

import Commands.CommandController;
import Driver.Program;
import MusicUtil.PlaylistManager;
import MusicUtil.SongManager;

public class MainGUI extends JFrame{

    JButton play;
    JButton skipb;
    JButton skipf;
    JRadioButton favourite;
    JRadioButton normButton;
    JRadioButton shuffleButton;
    JRadioButton repeatButton;

    AccountManager AM;
    SongManager SM;
    PlaylistManager PM;
    Program p;
    CommandController CC;
    TextUI textUI;

    MainGUI(){

        play = new JButton();
        play.setBounds(125, 400, 50, 50);
        play.setText("P");

        skipb = new JButton();
        skipb.setBounds(105, 415,20,20);

        skipf = new JButton();
        skipf.setBounds(175,415,20,20);

        favourite = new JRadioButton();
        favourite.setBounds(30,300,17,17);
        favourite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: favourite
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        normButton = new JRadioButton("shuffle");
        normButton.setBounds(250,300,17,17);
        normButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayOrder(e);
            }
        });

        shuffleButton = new JRadioButton("shuffle");
        shuffleButton.setBounds(250,350,17,17);

        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayOrder(e);
            }
        });

        repeatButton = new JRadioButton("repeat");
        repeatButton.setBounds(250, 400, 17, 17);
        repeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayOrder(e);
            }
        });

        ButtonGroup orderGroup = new ButtonGroup();

        orderGroup.add(normButton);
        orderGroup.add(shuffleButton);
        orderGroup.add(repeatButton);

        this.add(normButton);
        this.add(shuffleButton);
        this.add(repeatButton);
        this.add(play);
        this.add(skipb);
        this.add(skipf);
        this.add(favourite);

        this.setLayout(null);

        this.setSize(300,500);

        this.setVisible(true);

        AM = null;
        try {
            AM = new AccountManager("src/accounts.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        SM = new SongManager();
        try {
            SM.initializeSongs();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        PM = new PlaylistManager(SM);
        p = new Program(AM, SM, PM);
        // this.p = p;
        CC = new CommandController();
        // this.CC = CC;
        textUI = new TextUI(AM, SM);
        // this.textUI = UI;

    }

    private void PlayOrder(ActionEvent e){
        if(e.getSource()==shuffleButton){
            CC.executeCommand(textUI, p, "shuffle");
        } else if (e.getSource()==repeatButton) {
            CC.executeCommand(textUI, p, "repeat");
        } else {
            //TODO: normal command
        }
    }

    public static void main(String[] args){
        MainGUI frame = new MainGUI();

    }


}