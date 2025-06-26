public class Vehicle {
    private VehicleType type;
    private int waitTime = 0;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public void incrementWaitTime() {
        waitTime++;
    }

    public int getWaitTime() {
        return waitTime;
    }
}
