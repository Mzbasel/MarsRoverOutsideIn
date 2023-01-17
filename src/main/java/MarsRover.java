import java.util.List;

public class MarsRover {
    private CommandParser commandParser;
    private CommandFactory commandFactory;

    public MarsRover(CommandParser commandParser, CommandFactory commandFactory) {
        this.commandParser = commandParser;
        this.commandFactory = commandFactory;
    }

    public Grid execute(String commands) {
        List<CommandType> commandTypeList = commandParser.parse(commands);
        return commandFactory.run(commandTypeList);
    }
}
