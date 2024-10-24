package flightroutefinder;

import java.util.*;
public class FlightRouteFinder {
	// Function to find the shortest path using Dijkstra's Algorithm
    public Map<String, Integer> findShortestRoute(Graph graph, String startCity) {
        // Stores minimum distances to each city
        Map<String, Integer> distances = new HashMap<>();
        for (String city : graph.getCities()) {
            distances.put(city, Integer.MAX_VALUE);  // Initially set distances to infinity
        }
        distances.put(startCity, 0);  // Distance to start city is 0

        // Priority Queue to process cities by shortest distance
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(Route::getWeight));
        pq.add(new Route(startCity, 0));

        while (!pq.isEmpty()) {
            Route currentRoute = pq.poll();
            String currentCity = currentRoute.getDestination();
            int currentDistance = currentRoute.getWeight();

            // If we already found a shorter path to this city, skip
            if (currentDistance > distances.get(currentCity)) {
                continue;
            }

            // Process all neighboring cities
            for (Route neighbor : graph.getRoutesFromCity(currentCity)) {
                int newDist = currentDistance + neighbor.getWeight();
                if (newDist < distances.get(neighbor.getDestination())) {
                    distances.put(neighbor.getDestination(), newDist);
                    pq.add(new Route(neighbor.getDestination(), newDist));
                }
            }
        }

        return distances;
    }

    // Find the shortest path from startCity to endCity
    public int getShortestPath(Graph graph, String startCity, String endCity) {
        Map<String, Integer> distances = findShortestRoute(graph, startCity);
        return distances.getOrDefault(endCity, -1);  // Return -1 if no path found
    }

}
