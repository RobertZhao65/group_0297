package Commands;

import Driver.Program;
import Driver.AccountManager;
import UI.UIMethods;

import java.util.List;

/**
 * This is a superclass for all necessary commands needed in the program
 */

public abstract class Command {
    private final int expectedArguments;
    private final int expectedLocation;


    public Command(int expectedArguments, int expectedLocation){
        this.expectedArguments = expectedArguments;
        this.expectedLocation = expectedLocation;
    }

    /**
     * Execute the given command line
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if invalid argument
     */
    abstract public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException;

    abstract public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException;

    /**
     * Check location of command line
     *
     * @param p program
     * @throws CommandException if command used at invalid location
     */
    public void checkLocation(Program p) throws CommandException{
        if(p.getLocation() != expectedLocation && expectedLocation != -1){
            throw new CommandException("can't use that command here");
        }
    }

    /**
     * Check whether location of command is at login menu
     *
     * @param p program
     * @throws CommandException if command used at login menu
     */
    public void checkLocationMainMenu(Program p) throws CommandException{
        if(p.getLocation() < 1){
            throw new CommandException("can't use that command here");
        }
    }

    /**
     * Check provided arguments
     *
     * @param arguments given argument
     * @throws CommandException if invalid argument
     */
    public void checkArguments(List<String> arguments) throws CommandException{
        if(arguments.size() != expectedArguments){
            throw new CommandException("wrong number of arguments provided");
        }
    }

    /**
     * Check permission to use command
     *
     * @param AM account manager
     * @throws CommandException if account manager does not have permission (not Admin account)
     */
    public void checkPerms(AccountManager AM) throws CommandException{
        if(!AM.isPermitted()){
            throw new CommandException("you don't have permission to use this command");
        }
    }
}
