package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can toggle music player's repeat status between on and off
 */

public class Repeat extends Command{

    public Repeat(){
        super(0,2);
    }

    /**
     * Turns the repeat function on and off
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.getPlayer().toggleRepeat();
    }
}
