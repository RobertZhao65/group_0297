package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

public class ChooseSong extends Command{
    public ChooseSong(){
        super(1,3);
    }
    @Override
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        Integer a = Integer.valueOf(args.get(0));
        p.chooseSong(a);
    }
}
