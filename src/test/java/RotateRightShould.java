import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RotateRightShould {

    private RotateRight rotateRight;
    private Grid grid, actualGrid, expectedGrid;

    @BeforeEach
    public void setup() {
        rotateRight = new RotateRight();
    }

    @ParameterizedTest
    @CsvSource({"North,East", "East,South", "South,West", "West,North"})
    public void rotate_right_when_given_is_north_it_should_return_east(String currentDirection, String nextDirection){
        grid = new Grid(currentDirection, 0,0);
        expectedGrid = new Grid(nextDirection, 0,0);

        actualGrid = rotateRight.execute(grid);

        assertEquals(expectedGrid, actualGrid);
    }
}