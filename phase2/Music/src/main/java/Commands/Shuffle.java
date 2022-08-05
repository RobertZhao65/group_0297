package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can toggle music player's shuffle status between on and off
 */

public class Shuffle extends Command{

    public Shuffle(){
        super(0,2);
    }

    /**
     * Turns the shuffle function on and off
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        // p.shuffle();
    }

    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        // p.shuffle();
    }
}
