package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can skip to the next song in the current playlist
 */

public class SkipForward extends Command{

    public SkipForward(){
        super(0,2);
    }

    /**
     * Skips to next song in current playlist
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.getPlayer().skipForward();
    }
}
