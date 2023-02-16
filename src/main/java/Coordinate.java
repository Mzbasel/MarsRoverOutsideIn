public record Coordinate(int X, int Y) {
    private static final int BOUNDARY = 10;

    public Coordinate(int X, int Y) {
        this.X = stickWithinBoundary(X);
        this.Y = stickWithinBoundary(Y);
    }

    private static int stickWithinBoundary(int Y) {
        return (Y % BOUNDARY + BOUNDARY) % BOUNDARY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Coordinate) obj;
        return this.X == that.X &&
                this.Y == that.Y;
    }

    @Override
    public String toString() {
        return "Coordinate[" +
                "X=" + X + ", " +
                "Y=" + Y + ']';
    }

}

