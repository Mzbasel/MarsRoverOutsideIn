import java.util.Objects;

public record Grid(Direction direction, Coordinates coordinates) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return direction == grid.direction && Objects.equals(coordinates, grid.coordinates);
    }

}
