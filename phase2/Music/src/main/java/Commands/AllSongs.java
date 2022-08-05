package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can see all songs at once upon logging in
 */

public class AllSongs extends Command{

    public AllSongs(){
        super(0, 1);
    }

    /**
     * Display all songs stored in the song folder
     *
     * @param AM account manager
     * @param p program
     * @param args the provided command and argument
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.allSongs();
    }

    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        // p.skipForward();
    }
}