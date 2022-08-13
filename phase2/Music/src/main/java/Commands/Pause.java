package Commands;

import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can pause music
 */

public class Pause extends Command{

    public Pause(){
        super(0,2);
    }

    /**
     * Pause music
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.getPlayer().togglePause();
    }
}
