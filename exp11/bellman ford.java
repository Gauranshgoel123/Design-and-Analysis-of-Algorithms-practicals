import java.util.*;

class BellmanFord {
    // Class to represent an edge between two vertices
    class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private int vertices; // Number of vertices
    private List<Edge> edgeList; // List to store edges

    // Constructor
    public BellmanFord(int vertices) {
        this.vertices = vertices;
        edgeList = new ArrayList<>();
    }

    // Function to add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        edgeList.add(edge);
    }

    // Bellman-Ford algorithm to find the shortest path from a source vertex
    public void bellmanFord(int source) {
        // Initialize distances to all vertices as infinite except source
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edgeList) {
                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edgeList) {
            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains a negative-weight cycle.");
                return;
            }
        }

        // Print the shortest distances
        printSolution(distance, source);
    }

    // Function to print the result
    private void printSolution(int[] distance, int source) {
        System.out.println("Vertex Distance from Source " + source);
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " -> " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices in the graph
        BellmanFord graph = new BellmanFord(vertices);

        // Adding edges to the graph
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        // Running Bellman-Ford algorithm from source vertex 0
        graph.bellmanFord(0);
    }
}
