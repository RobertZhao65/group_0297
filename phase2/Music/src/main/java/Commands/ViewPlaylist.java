package Commands;

import Driver.AccountManager;
import Driver.Program;
import MusicUtil.Playlist;
import MusicUtil.PlaylistManager;
import UI.UIMethods;

import java.util.List;

public class ViewPlaylist extends Command{
    public ViewPlaylist(int expectedArguments, int expectedLocation) {
        super(2, 3);
    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        AccountManager AM = p.getAccountManager();
        PlaylistManager PM = p.getPM();
        String type=args.get(0);
        String arg=args.get(1);
        List<Playlist> playlists=p.getPlaylists(type,arg);
UI.viewPlaylist(playlists);
    }
}
