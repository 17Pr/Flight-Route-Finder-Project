package flightroutefinder;
import java.util.*;
public class Graph {
	 private Map<String, List<Route>> adjList;

	    public Graph() {
	        adjList = new HashMap<>();
	    }

	    // Add a flight route between two cities
	    public void addRoute(String source, String destination, int weight) {
	        adjList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Route(destination, weight));
	        adjList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Route(source, weight)); // Assuming bidirectional flight
	    }

	    // Get the adjacency list of a city
	    public List<Route> getRoutesFromCity(String city) {
	        return adjList.getOrDefault(city, new ArrayList<>());
	    }

	    // Get all cities
	    public Set<String> getCities() {
	        return adjList.keySet();
	    }
	}

	class Route {
	    String destination;
	    int weight;

	    public Route(String destination, int weight) {
	        this.destination = destination;
	        this.weight = weight;
	    }

	    public String getDestination() {
	        return destination;
	    }

	    public int getWeight() {
	        return weight;
	    }

}
