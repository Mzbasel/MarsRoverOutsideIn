import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserShould {

    private CommandParser commandParser;
    private List<CommandType> actualListOfCommands, expectedListOfCommands;

    @BeforeEach
    public void setUp() {
        commandParser = new CommandParser();
        actualListOfCommands = new ArrayList<>();
        expectedListOfCommands = new ArrayList<>();
    }

    @Test
    public void parse_string_rotate_right_command_to_an_enum_type_and_return_a_list(){
        String command = "R";
        expectedListOfCommands = List.of(CommandType.ROTATE_RIGHT);

        actualListOfCommands = commandParser.parse(command);

        assertEquals(expectedListOfCommands, actualListOfCommands);
    }

    @Test
    public void parse_string_rotate_left_command_to_an_enum_type_and_return_a_list(){
        String command = "L";
        expectedListOfCommands = List.of(CommandType.ROTATE_LEFT);

        actualListOfCommands = commandParser.parse(command);

        assertEquals(expectedListOfCommands, actualListOfCommands);
    }

    @Test
    public void parse_string_move_command_to_an_enum_type_and_return_a_list(){
        String command = "M";
        expectedListOfCommands = List.of(CommandType.MOVE);

        actualListOfCommands = commandParser.parse(command);

        assertEquals(expectedListOfCommands, actualListOfCommands);
    }

    @Test
    public void parse_multiple_commands_to_an_enum_type_and_return_a_list(){
        String command = "RLMML";
        expectedListOfCommands = List.of(CommandType.ROTATE_RIGHT, CommandType.ROTATE_LEFT, CommandType.MOVE, CommandType.MOVE, CommandType.ROTATE_LEFT);

        actualListOfCommands = commandParser.parse(command);

        assertEquals(expectedListOfCommands, actualListOfCommands);
    }

}