package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

/**
 * See the login history of account
 */

public class History extends Command{

    public History(){
        super(0,1);
    }

    /**
     * Display login history of given account
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        UI.displayLoginHistory();
        p.mainMenu();
    }
}
