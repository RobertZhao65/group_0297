package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.UIMethods;

import java.util.List;

/**
 * User can return to main menu
 */

public class MainMenu extends Command{

    public MainMenu(){
        super(0,0);
    }

    /**
     * Display the main menu of program
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument or command location (login menu)
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocationMainMenu(p);
        p.mainMenu();
    }
}
