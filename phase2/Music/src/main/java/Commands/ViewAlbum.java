package Commands;

import Driver.AccountManager;
import Driver.Program;
import MusicUtil.Album;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

public class ViewAlbum extends Command {
    public ViewAlbum() {
        super(2, 1);
    }

//    @Override
//    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
//        checkArguments(args);
//        checkLocation(p);
//        List<Album> albums = p.getAlbum(args);
//        TextUI UI = new TextUI(AM, p.getSongManager());
//        UI.displayAlbums(albums);
//    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        List<Album> albums = p.getAlbum(args);
        UI.displayAlbums(albums);
    }
}
