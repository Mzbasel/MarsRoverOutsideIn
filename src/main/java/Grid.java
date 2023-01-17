import java.util.Objects;

public class Grid {
    private String direction;
    private int x;
    private int y;

    public Grid(String direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return x == grid.x && y == grid.y && Objects.equals(direction, grid.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, x, y);
    }
}
