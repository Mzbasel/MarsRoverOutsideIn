import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverFeatureShould {

    private final MarsRover marsRover;

    public MarsRoverFeatureShould() {
        CommandFactory commandFactory = new CommandFactory();
        CommandParser commandParser = new CommandParser();
        marsRover = new MarsRover(commandParser, commandFactory);
    }

    @Test
    public void move_and_rotate(){
        String commands = "RRLMML";

        Grid actualGrid = marsRover.execute(commands);

        Grid expectedGrid = new Grid(Direction.NORTH, new Coordinate(2,0));

        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    void report_the_encountered_obstacle() {
        String commands = "RMMLMM";
        Obstacle obstacle = new Obstacle(2,1);
        CommandFactory commandFactory = new CommandFactory(obstacle);
        CommandParser commandParser = new CommandParser();
        MarsRover marsRover = new MarsRover(commandParser, commandFactory);

        EncounteredObstacleException exception = assertThrows(EncounteredObstacleException.class, () ->
            marsRover.execute(commands)
        );

        assertEquals(EncounteredObstacleException.class, exception.getClass());
        assertEquals("o:northCoordinate[X=2, Y=0]", exception.getMessage());
    }

    @Test
    void wrap_up() {
        String commands = "RMMLMMMMMLMMMM";

        Grid actualGrid = marsRover.execute(commands);

        Grid expectedGrid = new Grid(Direction.WEST, new Coordinate(8,5));

        assertEquals(expectedGrid, actualGrid);
    }
}
