import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverFeatureTest {

    private MarsRover marsRover;
    private CommandFactory commandFactory;
    private CommandParser commandParser;

    public MarsRoverFeatureTest() {
        commandFactory = new CommandFactory();
        commandParser = new CommandParser();
        marsRover = new MarsRover(commandParser, commandFactory);
    }

    @Test
    public void rover_should_move_and_rotate(){
        String commands = "RRLMML";

        Grid actualGrid = marsRover.execute(commands);

        Grid expectedGrid = new Grid(Direction.NORTH, new Coordinates(2,0));

        Assertions.assertEquals(expectedGrid, actualGrid);
    }
}
