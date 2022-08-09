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
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args the provided command and argument
     * @throws CommandException if invalid argument or command location
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        p.allSongs();
        //TODO: change this
    }
}