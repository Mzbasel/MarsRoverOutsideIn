import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveShould {

    private Move move;

    @BeforeEach
    public void setUp(){
        move = new Move();
    }

    @Test
    public void move_one_to_north(){
        Grid grid = new Grid(Direction.NORTH, new Coordinate(0,0));
        Grid expectedGrid = new Grid(Direction.NORTH, new Coordinate(0,1));

        Grid actualGrid = move.execute(grid);

        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void move_one_to_south(){
        Grid grid = new Grid(Direction.SOUTH, new Coordinate(0,1));
        Grid expectedGrid = new Grid(Direction.SOUTH, new Coordinate(0,0));

        Grid actualGrid = move.execute(grid);

        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void move_one_to_east(){
        Grid grid = new Grid(Direction.EAST, new Coordinate(1,0));
        Grid expectedGrid = new Grid(Direction.EAST, new Coordinate(2,0));

        Grid actualGrid = move.execute(grid);

        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    public void move_one_to_west(){
        Grid grid = new Grid(Direction.WEST, new Coordinate(2,2));
        Grid expectedGrid = new Grid(Direction.WEST,  new Coordinate(1,2));

        Grid actualGrid = move.execute(grid);

        assertEquals(expectedGrid, actualGrid);
    }

    @Test
    void move_and_encounter_an_obstacle_then_return_the_last_state() {
        Obstacle obstacle = new Obstacle(0,1);
        Move move = new Move(obstacle);
        Grid grid = new Grid(Direction.NORTH, new Coordinate(0,0));

        assertThrows(EncounteredObstacleException.class, () -> move.execute(grid));
    }
}