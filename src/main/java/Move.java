public class Move implements Command {

    private Grid grid;
    @Override
    public Grid execute(Grid grid) {
        this.grid = grid;
        return new Grid(grid.direction(), coordinates());
    }

    private Coordinates coordinates() {
        return switch (grid.direction()) {
            case NORTH -> new Coordinates(grid.coordinates().X(), grid.coordinates().Y() + 1);
            case SOUTH -> new Coordinates(grid.coordinates().X(), grid.coordinates().Y() - 1);
            case EAST -> new Coordinates(grid.coordinates().X() + 1, grid.coordinates().Y());
            case WEST -> new Coordinates(grid.coordinates().X() - 1, grid.coordinates().Y());
        };
    }
}
