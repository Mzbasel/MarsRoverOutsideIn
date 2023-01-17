import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateLeftShould {

    private RotateLeft rotateLeft;
    private Grid grid, actualGrid, expectedGrid;

    @BeforeEach
    public void setup() {
        rotateLeft = new RotateLeft();
    }

    @ParameterizedTest
    @CsvSource({"North,West", "East,North", "South,East", "West,South"})
    public void rotate_right_when_given_is_north_it_should_return_east(String currentDirection, String nextDirection){
        grid = new Grid(currentDirection, 0,0);
        expectedGrid = new Grid(nextDirection, 0,0);

        actualGrid = rotateLeft.execute(grid);

        assertEquals(expectedGrid, actualGrid);
    }

}