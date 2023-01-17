public class RotateLeft implements Command {
    @Override
    public Grid execute(Grid grid) {
        switch (grid.getDirection()){
            case "North": return create("West");
            case "East": return create("North");
            case "South": return create("East");
            case "West": return create("South");
        }
        throw new UnsupportedOperationException();
    }

    private Grid create(String direction) {
        return new Grid(direction, 0, 0);
    }
}
