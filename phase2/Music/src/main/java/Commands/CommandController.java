package Commands;

import Driver.Program;
import Driver.AccountManager;
import UI.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Executes command accordingly with provided arguments
 */

public class CommandController {

    /**
     * Executes the provided command
     *
     * @param AM account manager
     * @param p program
     * @param input input argument
     */
    public void executeCommand(AccountManager AM, Program p, String input){
        List<String> args = getArgs(input);
        TextUI UI = new TextUI(p.getAccountManager(), p.getSongManager());
        String[] split = input.split(" ");
        try{
            Command command = Constants.COMMAND_MAP.get(split[0]);
            command.executeCommand(p, UI, args);
        }
        catch(NullPointerException e){
            System.out.println("command not found...");
        }
        catch(CommandException e){
            System.out.println(e.getMessage());
        }
    }

    private List<String> getArgs(String command){
        String[] split = command.split(" ");
        List<String> args = new ArrayList<>();
        if(split.length > 1){
            args.addAll(Arrays.asList(split).subList(1, split.length));
        }
        return args;
    }
}
