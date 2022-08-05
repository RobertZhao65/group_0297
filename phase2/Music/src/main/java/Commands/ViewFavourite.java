package Commands;

import Driver.AccountManager;
import Driver.Program;
import MusicUtil.PlaylistManager;
import MusicUtil.Song;
import UI.TextUI;

import java.util.List;

public class ViewFavourite extends Command {
    public ViewFavourite(int expectedArguments, int expectedLocation) {
        super(0, 2);
    }

    @Override
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        checkPerms(AM);
        PlaylistManager PM = p.getPM();
        List<Song> f = PM.OwnerGetFavMusic(AM.getActiveUser());
        TextUI UI = new TextUI(AM, p.getSongManager());
        UI.displayPlaylist(f);
    }
}
