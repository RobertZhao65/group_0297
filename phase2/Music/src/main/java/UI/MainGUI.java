package UI;

import Driver.AccountManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.FileNotFoundException;

import Commands.CommandController;
import Driver.Program;
import MusicUtil.PlaylistManager;
import MusicUtil.Song;
import MusicUtil.SongManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainGUI extends JFrame{

    JButton control;

    JButton skipB;
    JButton skipF;
    JButton chooseSong;
    JLabel favouriteLabel;
    JRadioButton favourite;
    JLabel normalLabel;
    JRadioButton normButton;
    JLabel shuffleLabel;
    JRadioButton shuffleButton;
    JLabel repeatLabel;
    JRadioButton repeatButton;

    AccountManager AM;
    SongManager SM;
    PlaylistManager PM;
    Program p;
    CommandController CC;
    TextUI textUI;
    Boolean isPlaying = false;

    MainGUI(AccountManager am){

        control = new JButton();
        control.setBounds(110, 400, 80, 50);
        control.setText("Play");
        control.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPlaying){
                    isPlaying = false;
                    CC.executeCommand(textUI, p, "pause");
                    control.setText("play");
                } else{
                    isPlaying = true;
                    CC.executeCommand(textUI, p, "play");
                    control.setText("pause");
                }
            }
        });

        chooseSong = new JButton("Choose File");
        chooseSong.setBounds(90,100,110,50);
        chooseSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File[] files = showFileOpenDialog();
                for (File file : files) {
                    String path = file.getPath();
                    String name = path.split("/")[0];
                    String album =  "default";
                    String artist = "default";
                    String genre = "default";
                    Song song = new Song(name, album, artist, genre, path);
                    SM.addSong(song);
                    PM.addSongToPlaylist(0, AM.getActiveUser(), song);
                }
            }
        });

        skipB = new JButton("last");
        skipB.setBounds(55, 415,55,20);
        skipB.setFont(new Font("Calibri",Font.PLAIN, 10));
        skipB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CC.executeCommand(textUI,p,"backward");
            }
        });

        skipF = new JButton("next");
        skipF.setBounds(190,415,55,20);
        skipF.setFont(new Font("Calibri",Font.PLAIN, 10));
        skipF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CC.executeCommand(textUI,p,"forward");
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        favouriteLabel = new JLabel("favourite");
        favouriteLabel.setBounds(25, 285, 40, 20);
        favouriteLabel.setFont(new Font("Calibri",Font.PLAIN, 10));
        favourite = new JRadioButton();
        favourite.setBounds(30,300,17,17);
        favourite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CC.executeCommand(textUI,p,"favourite");
            }
        });

        normalLabel = new JLabel("Normal");
        normalLabel.setBounds(245, 285, 40, 20);
        normalLabel.setFont(new Font("Calibri",Font.PLAIN, 10));
        normButton = new JRadioButton("shuffle");
        normButton.setBounds(250,300,17,17);
        normButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayOrder(e);
            }
        });

        shuffleLabel = new JLabel("Shuffle");
        shuffleLabel.setBounds(245, 335, 40, 20);
        shuffleLabel.setFont(new Font("Calibri",Font.PLAIN, 10));
        shuffleButton = new JRadioButton("shuffle");
        shuffleButton.setBounds(250,350,17,17);
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayOrder(e);
            }
        });

        repeatLabel = new JLabel("Repeat");
        repeatLabel.setBounds(245, 385, 40, 20);
        repeatLabel.setFont(new Font("Calibri",Font.PLAIN, 10));
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

        this.add(chooseSong);

        this.add(normalLabel);
        this.add(normButton);
        this.add(shuffleLabel);
        this.add(shuffleButton);
        this.add(repeatLabel);
        this.add(repeatButton);

        this.add(control);
        this.add(skipB);
        this.add(skipF);

        this.add(favourite);
        this.add(favouriteLabel);

        this.setLayout(null);

        this.setSize(300,500);

        this.setVisible(true);

        AM = am;
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
        // p.loginDisplay();

    }

    /**
     * User can choose to shuffle or repeat the playlist
     * @param e Action Event
     */
    private void PlayOrder(ActionEvent e){
        if(e.getSource()==shuffleButton){
            CC.executeCommand(textUI, p, "shuffle");
        } else if (e.getSource()==repeatButton) {
            CC.executeCommand(textUI, p, "repeat");
        } else {
            //TODO: normal command
        }
    }

    /**
     * Choose the music file
     * @return file
     */
    private File[] showFileOpenDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("mp3", "mp3"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("mp3", "mp3"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFiles();
        } else{
            return  null;
        }
    }

    public static void main(String[] args){
        try {
            AccountManager am = new AccountManager("src/accounts.txt");
            MainGUI frame = new MainGUI(am);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }


    }


}