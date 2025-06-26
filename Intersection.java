package main;
import java.util.*;

public class Intersection {
    private int id;
    private Map<Direction, TrafficQueue> queues = new EnumMap<>(Direction.class);
    private EmergencyHeap emergencyHeap = new EmergencyHeap();
    private Direction currentGreen = null;

    public Intersection(int id) {
        this.id = id;
        for (Direction dir : Direction.values()) {
            queues.put(dir, new TrafficQueue(dir));
        }
    }

    public void addVehicle(Direction dir, Vehicle vehicle) {
        queues.get(dir).enqueue(vehicle);
    }

    public void addEmergency(Emergency emergency) {
        emergencyHeap.addEmergency(emergency);
    }

    public void updateSignal() {
        Emergency emergency = emergencyHeap.getHighestPriority();
        if (emergency != null) {
            currentGreen = emergency.direction;
            return;
        }

        // Normal scheduling: Find direction with longest wait time
        Direction nextGreen = Direction.NORTH;
        double maxWait = queues.get(nextGreen).getAverageWaitTime();

        for (Direction dir : Direction.values()) {
            if (dir == currentGreen) continue;
            double wait = queues.get(dir).getAverageWaitTime();
            if (wait > maxWait) {
                maxWait = wait;
                nextGreen = dir;
            }
        }
        currentGreen = nextGreen;
    }

    public void processTraffic() {
        if (currentGreen == null) return;
        Vehicle vehicle = queues.get(currentGreen).dequeue();
        // Process vehicle movement (can print or log here)
    }
}
