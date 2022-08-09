package Commands;

import Driver.Program;
import Driver.AccountManager;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

/**
 * User can logout of current account
 */

public class Logout extends Command {

    public Logout(){
        super(0,1);
    }

    /**
     * User logouts, returns to login menu
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        UI.logoutMsg();
        // p.stop();
        p.loginDisplay();
    }
}
