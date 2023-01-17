import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverFeatureTest {

    private MarsRover marsRover;

    public MarsRoverFeatureTest(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    @Test
    public void rover_should_move_and_rotate(){
        String commands = "RRLMML";

        Grid actualGrid = marsRover.execute(commands);

        Grid expectedGrid = new Grid("North", 2,0);

        Assertions.assertEquals(expectedGrid, actualGrid);
    }
}
