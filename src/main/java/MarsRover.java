import java.util.List;

public class MarsRover {
    private CommandParser commandParser;
    private CommandFactory commandFactory;
    private Command command;

    public MarsRover(CommandParser commandParser, CommandFactory commandFactory, Command command) {

        this.commandParser = commandParser;
        this.commandFactory = commandFactory;
        this.command = command;
    }

    public Grid execute(String command) {
        List<CommandType> commandTypeList = commandParser.parse(command);
        List<Command> commandList = commandFactory.createCommand(commandTypeList);

        return null;
    }
}
