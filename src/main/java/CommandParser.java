import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandParser {

    private final List<CommandType> commandTypeList;
    private final Map<Character, CommandType> commandTypes;

    public CommandParser() {
        commandTypeList = new ArrayList<>();
        commandTypes = Map.of('R', CommandType.ROTATE_RIGHT,
                'L', CommandType.ROTATE_LEFT,
                'M', CommandType.MOVE);
    }

    public List<CommandType> parse(String commands) {
        for (char command: commands.toCharArray()) {
            commandTypeList.add(commandTypes.get(command));
        }
        return commandTypeList;
    }
}
