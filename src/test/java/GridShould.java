import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridShould {

    @Test
    void warp_up_from_north() {
        Grid grid = new Grid(Direction.NORTH, new Coordinate(0,10));
        Grid expectedGrid = new Grid(Direction.NORTH, new Coordinate(0,0));

        assertEquals(expectedGrid, grid);
    }

    @Test
    void wrap_up_from_south() {
        Grid grid = new Grid(Direction.SOUTH, new Coordinate(0,-1));
        Grid expectedGrid = new Grid(Direction.SOUTH, new Coordinate(0,0));

        assertEquals(expectedGrid, grid);
    }

    @Test
    void wrap_up_from_east() {
        Grid grid = new Grid(Direction.EAST, new Coordinate(10,0));
        Grid expectedGrid = new Grid(Direction.EAST, new Coordinate(0,0));

        assertEquals(expectedGrid, grid);
    }

    @Test
    void wrap_up_from_west() {
        Grid grid = new Grid(Direction.WEST, new Coordinate(-1,0));
        Grid expectedGrid = new Grid(Direction.WEST, new Coordinate(0,0));

        assertEquals(expectedGrid, grid);
    }

}