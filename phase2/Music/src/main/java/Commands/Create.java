package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

/**
 * User can create new account
 */

public class Create extends Command{

    public Create(){
        super(2, 0);
    }

    /**
     * Create new account with the given username and password, display login menu
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if argument or location of command is incorrect
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        AccountManager AM = p.getAccountManager();
        String username = args.get(0);
        String password = args.get(1);
        if(AM.createAccount(username, password)){
            p.createFavourite(username);
            UI.accountCreateSuccess();
            p.loginDisplay();
        }
        else{
            UI.accountCreateFail();
            p.loginDisplay();
        }
    }
}
