import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommandFactoryShould {

    private CommandFactory commandFactory;
    private Grid expectedGrid, actualGrid;
    @Mock
    private Command command;

    @BeforeEach
    public void setUp() {
        commandFactory = new CommandFactory(command);
    }

    private static Stream<Arguments> getListOfRotateRightCommands() {
        return Stream.of(
                Arguments.of(List.of(CommandType.ROTATE_RIGHT), "East"),
                Arguments.of(List.of(CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT), "South"),
                Arguments.of(List.of(CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT), "West"),
                Arguments.of(List.of(CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT), "North")
        );
    }

    @ParameterizedTest
    @MethodSource("getListOfRotateRightCommands")
    public void run_the_rotate_right_command_then_return_expected_grid(List<CommandType> commandTypeList, String direction){
        expectedGrid = new Grid(direction, 0, 0);

        actualGrid = commandFactory.run(commandTypeList);

        assertEquals(expectedGrid, actualGrid);
    }

    private static Stream<Arguments> getListOfRotateLeftCommands() {
        return Stream.of(
                Arguments.of(List.of(CommandType.ROTATE_LEFT), "West"),
                Arguments.of(List.of(CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT), "South"),
                Arguments.of(List.of(CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT), "East"),
                Arguments.of(List.of(CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT), "North")
        );
    }

    @ParameterizedTest
    @MethodSource("getListOfRotateLeftCommands")
    public void run_the_rotate_left_command_then_return_expected_grid(List<CommandType> commandTypeList, String direction){
        expectedGrid = new Grid(direction, 0, 0);

        actualGrid = commandFactory.run(commandTypeList);

        assertEquals(expectedGrid, actualGrid);
    }

}