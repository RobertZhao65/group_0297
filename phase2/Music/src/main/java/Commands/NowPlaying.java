package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

public class NowPlaying extends Command{
    public NowPlaying(){
        super(0, 2);
    }

    /**
     * Execute the given command line
     *
     * @param AM   account manager
     * @param p    program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {

    }

    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        System.out.println(p.getPlayer().displayQueue());
        //TODO: change this
    }
}
