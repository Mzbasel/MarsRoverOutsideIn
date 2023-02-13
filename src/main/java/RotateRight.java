public class RotateRight implements Command{

    @Override
    public Grid execute(Grid grid) {
        return switch (grid.direction()) {
            case NORTH -> new Grid(Direction.EAST, grid.coordinate());
            case EAST -> new Grid(Direction.SOUTH, grid.coordinate());
            case SOUTH -> new Grid(Direction.WEST, grid.coordinate());
            case WEST -> new Grid(Direction.NORTH, grid.coordinate());
        };
    }
}
