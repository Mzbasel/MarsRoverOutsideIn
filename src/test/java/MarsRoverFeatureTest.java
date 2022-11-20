import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverFeatureTest {

    CommandParser commandParser = new CommandParser();

    CommandFactory commandFactory = new CommandFactory();

    private Command command = null;

    @Test
    public void rover_should_move_and_rotate(){
        String commands = "RRLMML";
        MarsRover marsRover = new MarsRover(commandParser, commandFactory, command);

        Grid actualGrid = marsRover.execute(commands);

        Grid expectedGrid = new Grid("North", 2,0);

        Assertions.assertEquals(expectedGrid, actualGrid);
    }
}
