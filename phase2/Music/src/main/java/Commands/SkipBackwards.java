package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can return to the previous song in the current playlist
 */

public class SkipBackwards extends Command{

    public SkipBackwards(){
        super(0,2);
    }

    /**
     * Returns to previous song in current playlist
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.getPlayer().skipBackward();
    }
}
