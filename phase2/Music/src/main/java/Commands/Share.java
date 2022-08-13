package Commands;

import Driver.Program;
import UI.UIMethods;

import java.util.List;

public class Share extends Command{
    public Share(int expectedArguments, int expectedLocation) {
        super(1, 3);
    }

    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        boolean sharable;
        if (args.get(0).equals("y")){
            sharable=true;
        }else {
            sharable=false;
        }
        boolean result = p.setSharable(sharable);
        UI.share(result);
    }
}
