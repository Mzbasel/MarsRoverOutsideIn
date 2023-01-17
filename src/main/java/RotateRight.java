public class RotateRight implements Command{

    @Override
    public Grid execute(Grid grid) {
        switch (grid.getDirection()){
            case "North": return create("East");
            case "East": return create("South");
            case "South": return create("West");
            case "West": return create("North");
        }
        throw new UnsupportedOperationException();
    }

    private Grid create(String direction) {
        return new Grid(direction, 0, 0);
    }
}
