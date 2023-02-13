import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommandFactoryShould {

    private CommandFactory commandFactory;
    private Grid expectedGrid, actualGrid;

    @BeforeEach
    public void setUp() {
        commandFactory = new CommandFactory();
    }

    private static Stream<Arguments> getListOfRotateRightCommands() {
        return Stream.of(
                Arguments.of(List.of(CommandType.ROTATE_RIGHT), Direction.EAST),
                Arguments.of(List.of(CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT), Direction.SOUTH),
                Arguments.of(List.of(CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT), Direction.WEST),
                Arguments.of(List.of(CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT, CommandType.ROTATE_RIGHT), Direction.NORTH)
        );
    }

    @ParameterizedTest
    @MethodSource("getListOfRotateRightCommands")
    public void run_the_rotate_right_command_then_return_expected_grid(List<CommandType> commandTypeList, Direction direction){
        expectedGrid = new Grid(direction,  new Coordinate(0,0));

        actualGrid = commandFactory.run(commandTypeList);

        assertEquals(expectedGrid, actualGrid);
    }

    private static Stream<Arguments> getListOfRotateLeftCommands() {
        return Stream.of(
                Arguments.of(List.of(CommandType.ROTATE_LEFT), Direction.WEST),
                Arguments.of(List.of(CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT), Direction.SOUTH),
                Arguments.of(List.of(CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT), Direction.EAST),
                Arguments.of(List.of(CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT, CommandType.ROTATE_LEFT), Direction.NORTH)
        );
    }

    @ParameterizedTest
    @MethodSource("getListOfRotateLeftCommands")
    public void run_the_rotate_left_command_then_return_expected_grid(List<CommandType> commandTypeList, Direction direction){
        expectedGrid = new Grid(direction, new Coordinate(0,0));

        actualGrid = commandFactory.run(commandTypeList);

        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    void move() {
        expectedGrid = new Grid(Direction.NORTH, new Coordinate(0,4));

        actualGrid = commandFactory.run(List.of(CommandType.MOVE, CommandType.MOVE, CommandType.MOVE, CommandType.MOVE));

        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    void move_with_an_obstacle() {
        Obstacle obstacle = new Obstacle(0,3);
        CommandFactory commandFactory = new CommandFactory(obstacle);
        List<CommandType> commands = List.of(CommandType.MOVE, CommandType.MOVE, CommandType.MOVE, CommandType.MOVE);

        assertThrows(EncounteredObstacleException.class, () -> commandFactory.run(commands));
    }
}