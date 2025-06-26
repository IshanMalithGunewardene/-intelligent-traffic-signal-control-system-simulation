public class TrafficQueue {
    private final int MAX_SIZE = 100;
    private Vehicle[] queue = new Vehicle[MAX_SIZE];
    private int front = -1, rear = -1;
    private Direction direction;
    private int vehicleCount = 0;
    private int totalWaitTime = 0;

    public TrafficQueue(Direction direction) {
        this.direction = direction;
    }

    public void enqueue(Vehicle vehicle) {
        if (isFull()) return;
        if (isEmpty()) front = 0;
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = vehicle;
        vehicleCount++;
    }

    public Vehicle dequeue() {
        if (isEmpty()) return null;
        Vehicle vehicle = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
        vehicleCount--;
        totalWaitTime += vehicle.getWaitTime();
        return vehicle;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public double getAverageWaitTime() {
        return vehicleCount > 0 ? (double) totalWaitTime / vehicleCount : 0;
    }
}
