import java.util.List;

public class CommandFactory {

    private Command command;
    private Grid grid;

    public CommandFactory(Command command) {
        this.command = command;
        grid = new Grid("North", 0, 0);
    }

    public Grid run(List<CommandType> commandTypeList) {
        for (CommandType commandType: commandTypeList) {
            switch (commandType){
                case ROTATE_RIGHT: command = new RotateRight(); break;
                case ROTATE_LEFT: command = new RotateLeft(); break;
            }
            grid = command.execute(grid);
        }
        return grid;
    }
}
