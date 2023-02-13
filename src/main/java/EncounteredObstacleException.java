public class EncounteredObstacleException extends RuntimeException{
    public EncounteredObstacleException(Grid grid) {
        super("o:" + grid.direction().toString().toLowerCase() + grid.coordinate().toString());
    }
}
