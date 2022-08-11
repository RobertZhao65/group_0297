package Commands;

import Driver.AccountManager;
import Driver.Program;
import MusicUtil.Favourite;
import MusicUtil.PlaylistManager;
import MusicUtil.Song;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

public class ViewFavourite extends Command {
    public ViewFavourite() {
        super(0, 1);
    }

//    @Override
//    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
//        checkArguments(args);
//        checkLocation(p);
//        PlaylistManager PM = p.getPM();
//        Favourite f = PM.OwnerGetFavMusic(AM.getActiveUser());
//        TextUI UI = new TextUI(AM, p.getSongManager());
//        UI.displayPlaylist(f.getMusics());
//        p.setCurrentPlaylist(f);
//    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        AccountManager AM = p.getAccountManager();
        PlaylistManager PM = p.getPM();
        Favourite f = PM.OwnerGetFavMusic(AM.getActiveUser());
        UI.displayPlaylist(f.getMusics());
        p.setCurrentPlaylist(f);
        p.setLocation(3);
    }
}
