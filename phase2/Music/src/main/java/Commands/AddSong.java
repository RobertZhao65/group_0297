package Commands;

import Driver.Program;
import UI.UIMethods;

import java.util.List;

public class AddSong extends Command{
    public AddSong(int expectedArguments, int expectedLocation) {
        super(1, 3);
    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        Integer ID = Integer.valueOf(args.get(0));
        boolean result=p.addSong(ID);
        UI.addSong(result);
    }
}
