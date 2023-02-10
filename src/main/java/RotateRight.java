public class RotateRight implements Command{

    @Override
    public Grid execute(Grid grid) {
        return switch (grid.direction()) {
            case NORTH -> new Grid(Direction.EAST, grid.coordinates());
            case EAST -> new Grid(Direction.SOUTH, grid.coordinates());
            case SOUTH -> new Grid(Direction.WEST, grid.coordinates());
            case WEST -> new Grid(Direction.NORTH, grid.coordinates());
        };
    }
}
