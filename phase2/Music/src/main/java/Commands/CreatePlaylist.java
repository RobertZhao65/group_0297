package Commands;

import Driver.AccountManager;
import Driver.Program;
import MusicUtil.PlaylistManager;
import UI.UIMethods;

import java.util.List;

public class CreatePlaylist extends Command{
    public CreatePlaylist() {
        super(1, 1);
    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        AccountManager AM = p.getAccountManager();
        PlaylistManager PM = p.getPM();
        String name = args.get(0);
        p.createPlaylist(name);
        System.out.println(name+" is now created");
    }
}
