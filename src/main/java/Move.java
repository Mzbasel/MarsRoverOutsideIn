public class Move implements Command {

    private Grid grid;
    private Obstacle obstacle;

    public Move(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Move() {
    }

    @Override
    public Grid execute(Grid grid) {
        this.grid = grid;
        Grid result = new Grid(grid.direction(), coordinates());
        if(obstacle != null) {
            if (result.isObstacle(obstacle))
                throw new EncounteredObstacleException(grid);
        }
        return result;
    }

    private Coordinate coordinates() {
        return switch (grid.direction()) {
            case NORTH -> new Coordinate(grid.coordinate().X(), grid.coordinate().Y() + 1);
            case SOUTH -> new Coordinate(grid.coordinate().X(), grid.coordinate().Y() - 1);
            case EAST -> new Coordinate(grid.coordinate().X() + 1, grid.coordinate().Y());
            case WEST -> new Coordinate(grid.coordinate().X() - 1, grid.coordinate().Y());
        };
    }
}
