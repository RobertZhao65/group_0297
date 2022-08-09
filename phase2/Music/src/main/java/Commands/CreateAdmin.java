package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

/**
 * Admin account can create new admin account
 */

public class CreateAdmin extends Command{

    public CreateAdmin(){
        super(2, 1);
    }

    /**
     * Create admin account with given username and password, display main menu
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid arguments and command location or account has no permission
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        AccountManager AM = p.getAccountManager();
        checkPerms(AM);
        String username = args.get(0);
        String password = args.get(1);
        if(AM.createAdminAccount(username, password)){
            UI.accountCreateSuccess();
            p.loginDisplay();
        }
        else{
            UI.accountCreateFail();
            p.loginDisplay();
        }
    }
}
