package main;
import java.util.*;

public class TrafficGraph {
    static class Edge {
        int destination;
        int weight; // Travel time or congestion

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private Map<Integer, List<Edge>> adjacencyList = new HashMap<>();

    public void addIntersection(int node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addRoad(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    public List<Edge> getAdjacentNodes(int node) {
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }
}
