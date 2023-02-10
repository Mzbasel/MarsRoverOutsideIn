import java.util.List;
import java.util.Map;

public class CommandFactory {
    private Grid grid;
    private final Map<CommandType, Command> commands;

    public CommandFactory() {
        grid = new Grid(Direction.NORTH, new Coordinates(0,0));
        commands = Map.of(CommandType.ROTATE_RIGHT, new RotateRight(),
                CommandType.ROTATE_LEFT, new RotateLeft(),
                CommandType.MOVE, new Move());
    }

    public Grid run(List<CommandType> commandTypeList) {
        for (CommandType commandType: commandTypeList) {
            grid = commands.get(commandType).execute(grid);
        }
        return grid;
    }
}
