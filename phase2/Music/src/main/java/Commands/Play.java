package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can play the currently displayed playlist from beginning to end
 */

public class Play extends Command{

    public Play(){
        super(0,2);
    }

    /**
     * Plays playlist
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        Runnable task = () -> {
            p.getPlayer().startPlayback(p.getCurrPlaylist());
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
