package Commands;

import Driver.Program;
import UI.UIMethods;

import java.util.List;

public class RemovePlaylist extends Command{
    public RemovePlaylist(int expectedArguments, int expectedLocation) {
        super(0, 3);
    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        boolean result=p.removePlaylist();
        UI.removePlaylist(result);
    }
}
