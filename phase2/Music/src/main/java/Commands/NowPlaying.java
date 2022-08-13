package Commands;

import Driver.Program;
import UI.UIMethods;

import java.util.List;

public class NowPlaying extends Command{
    public NowPlaying(){
        super(0, 2);
    }

    /**
     * Execute the given command line
     *
     * @param p program
     * @param UI the class responsible for displaying the user interface
     * @param args provided arguments and command
     * @throws CommandException if invalid argument
     */
    public void executeCommand(Program p, UIMethods UI, List<String> args) throws CommandException {
        System.out.println(p.getPlayer().displayQueue());
        //TODO: change this
    }
}
