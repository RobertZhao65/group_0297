package Commands;

import Driver.Program;
import Driver.AccountManager;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

/**
 * User can exit the program
 */

public class Exit extends Command {

    public Exit(){
        super(0, -1);
    }

    /**
     * Program stops running
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.getPlayer().setRepeat(false);
        p.getPlayer().getPlayer().stop();
        int end = p.getPlayer().getCurrQueue().size();
        p.getPlayer().setCurrIndex(end);
        p.stopRunning();
        UI.exitMsg();
    }
}
