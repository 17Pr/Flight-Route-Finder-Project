package flightroutefinder;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
        graph.addRoute("New York", "London", 400);
        graph.addRoute("New York", "Paris", 350);
        graph.addRoute("London", "Berlin", 200);
        graph.addRoute("Berlin", "Tokyo", 600);
        graph.addRoute("Paris", "Tokyo", 700);
        graph.addRoute("New York", "Tokyo", 900);
        
        // Create flight route finder
        FlightRouteFinder finder = new FlightRouteFinder();

        // Find the shortest route from New York to Tokyo
        int distance = finder.getShortestPath(graph, "New York", "Tokyo");
        if (distance != -1) {
            System.out.println("The shortest distance from New York to Tokyo is: " + distance + " miles.");
        } else {
            System.out.println("No route found from New York to Tokyo.");
        }
    }

	}


