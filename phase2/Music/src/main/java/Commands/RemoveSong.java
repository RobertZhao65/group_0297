package Commands;

import Driver.Program;
import UI.UIMethods;

import java.util.List;

public class RemoveSong extends Command{
    public RemoveSong(int expectedArguments, int expectedLocation) {
        super(expectedArguments, expectedLocation);
    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        Integer num=Integer.valueOf(args.get(0));
        boolean result=p.removeSong(num);
        UI.removeSong(result);
    }
}
