package Driver;

import java.io.IOException;
import java.util.Scanner;

import Commands.CommandController;
import MusicUtil.PlaylistManager;
import MusicUtil.SongManager;
import UI.TextUI;
import UI.UIMethods;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountManager AM = new AccountManager("src/accounts.txt");
        SongManager SM = new SongManager();
        SM.initializeSongs();
        PlaylistManager PM = new PlaylistManager(SM);
        Program p = new Program(AM, SM, PM);
        Scanner in = new Scanner(System.in);
        CommandController CC = new CommandController();
        TextUI UI = new TextUI(AM, SM);
        p.loginDisplay();
        while(p.isRunning()){
            String input = in.nextLine();
            CC.executeCommand(UI, p, input);
        }
        AM.updateLog("src/accounts.txt");
    }
}
