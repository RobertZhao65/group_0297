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
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        TextUI UI = new TextUI(AM, p.getSongManager());
        UI.logoutMsg();
        // p.stop();
        p.loginDisplay();
    }

    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        UI.logoutMsg();
        // p.stop();
        p.loginDisplay();
    }
}
