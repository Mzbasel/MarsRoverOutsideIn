import java.util.Objects;

public record Grid(Direction direction, Coordinate coordinate) {

    public Grid(Direction direction, Coordinate coordinate) {
        this.direction = direction;
        this.coordinate = get(coordinate);
    }

    private Coordinate get(Coordinate coordinate) {
        if (isYOutOfBound(coordinate))
            return new Coordinate(coordinate.X(), 0);
        if (isXOutOfBound(coordinate))
            return new Coordinate(0, coordinate.Y());
        return coordinate;
    }

    private boolean isXOutOfBound(Coordinate coordinate) {
        return coordinate.X() > 9 || coordinate.X() < 0;
    }

    private boolean isYOutOfBound(Coordinate coordinate) {
        return coordinate.Y() > 9 || coordinate.Y() < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return direction == grid.direction && Objects.equals(coordinate, grid.coordinate);
    }

    public boolean isObstacle(Obstacle obstacle) {
        return coordinate.X() == obstacle.x() && coordinate.Y() == obstacle.y();
    }

}
