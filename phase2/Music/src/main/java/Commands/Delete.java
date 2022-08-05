package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.TextUI;
import UI.UIMethods;

import java.util.List;

/**
 * Admin account can delete account
 */

public class Delete extends Command{

    public Delete(){
        super(1, 1);
    }

    /**
     * Admin account deletes the account with given username, displays main menu
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if non-Admin account or invalid arguments and command location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException {
        checkArguments(args);
        checkLocation(p);
        checkPerms(AM);
        String username = args.get(0);
        TextUI UI = new TextUI(AM, p.getSongManager());
        if(AM.deleteAccount(username)){
            UI.accountDeleteSuccess();
            p.mainMenu();
        }
        else{
            UI.accountDeleteFail();
            p.mainMenu();
        }
    }

    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        AccountManager AM = p.getAccountManager();
        checkPerms(AM);
        String username = args.get(0);
        if(AM.deleteAccount(username)){
            UI.accountDeleteSuccess();
            p.mainMenu();
        }
        else{
            UI.accountDeleteFail();
            p.mainMenu();
        }
    }
}
