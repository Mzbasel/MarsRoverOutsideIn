import java.util.Objects;

public record Grid(Direction direction, Coordinate coordinate) {

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
