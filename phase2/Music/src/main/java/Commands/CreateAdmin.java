package main.java.Commands;

import main.java.Driver.Program;
import main.java.UI.TextUI;
import main.java.Driver.AccountManager;

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
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid arguments and command location or account has no permission
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        checkPerms(AM);
        String username = args.get(0);
        String password = args.get(1);
        TextUI UI = new TextUI(AM, p.getSongManager());
        if(AM.createAdminAccount(username, password)){
            UI.accountCreateSuccess();
            p.mainMenu();
        }
        else{
            UI.accountCreateFail();
            p.mainMenu();
        }
    }
}
