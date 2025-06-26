public class Emergency {
    int priority; // Higher = more urgent
    int intersectionId;
    Direction direction;

    public Emergency(int priority, int intersectionId, Direction direction) {
        this.priority = priority;
        this.intersectionId = intersectionId;
        this.direction = direction;
    }
}
