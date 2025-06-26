package main;
import main.main.Emergency;
import main.main.Vehicle;

public class main {
    public static void main(String[] args) {
        // Initialize traffic network
        TrafficGraph graph = new TrafficGraph();
        graph.addIntersection(1);
        graph.addIntersection(2);
        graph.addRoad(1, 2, 5); // Travel time = 5

        // Create intersections
        Intersection intersection1 = new Intersection(1);

        // Add vehicles
        intersection1.addVehicle(Direction.NORTH, new Vehicle(VehicleType.REGULAR));
        intersection1.addVehicle(Direction.EAST, new Vehicle(VehicleType.PUBLIC_TRANSPORT));

        // Add emergency
        intersection1.addEmergency(new Emergency(10, 1, Direction.SOUTH));

        // Simulation loop
        for (int i = 0; i < 10; i++) {
            intersection1.updateSignal();
            intersection1.processTraffic();
            // Optionally update vehicle wait times here
        }
    }
}
