package Commands;

import java.util.List;
import Driver.Program;
import Driver.AccountManager;
import UI.TextUI;
import UI.UIMethods;

/**
 * User can login to account with correct username and password
 */

public class Login extends Command {

    public Login(){
        super(2, 0);
    }

    /**
     * User logins after successful authentication
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or location of command
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        String username = args.get(0);
        String password = args.get(1);
        AccountManager AM = p.getAccountManager();
        if(AM.authenticate(username, password)){
            UI.loginSuccess();
            p.mainMenu();
        }
        else{
            UI.loginFail();
            p.loginDisplay();
        }
    }
}
