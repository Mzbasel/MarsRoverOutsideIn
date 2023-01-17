import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    private List<CommandType> commandTypeList;

    public CommandParser() {
        commandTypeList = new ArrayList<>();
    }

    public List<CommandType> parse(String commands) {
        for (char command: commands.toCharArray()) {
            if(command == 'R')
                commandTypeList.add(CommandType.ROTATE_RIGHT);
            if(command == 'L')
                commandTypeList.add(CommandType.ROTATE_LEFT);
            if(command == 'M')
                commandTypeList.add(CommandType.MOVE);
        }
        return commandTypeList;
    }
}
