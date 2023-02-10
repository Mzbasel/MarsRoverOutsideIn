import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateLeftShould {

    private RotateLeft rotateLeft;
    private Grid grid, actualGrid, expectedGrid;

    @BeforeEach
    public void setup() {
        rotateLeft = new RotateLeft();
    }

    private static Stream<Arguments> getDirections() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.WEST),
                Arguments.of(Direction.EAST, Direction.NORTH),
                Arguments.of(Direction.SOUTH, Direction.EAST),
                Arguments.of(Direction.WEST, Direction.SOUTH)
        );
    }

    @ParameterizedTest
    @MethodSource("getDirections")
    public void rotate_right_when_given_is_north_it_should_return_east(Direction startingDirection, Direction currentDirection){
        grid = new Grid(startingDirection, new Coordinates(0,0));
        expectedGrid = new Grid(currentDirection, new Coordinates(0,0));

        actualGrid = rotateLeft.execute(grid);

        assertEquals(expectedGrid, actualGrid);
    }

}