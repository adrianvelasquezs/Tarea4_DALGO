package problema4;

import java.util.*;

/**
 * Main class for problem 4.
 * This class is used to test the implementation of the classes in the problem 4.
 *
 * @author Adrian Velasquez 202222737
 */
public class MainProblem4 {

    private static int getMaximumBooks( Integer factories, List<Warehouse> warehouses, List<Integer> libraries,
                                       List<Truck> trucks) {
        int totalBooks = 0;

        int w = warehouses.size();
        int l = libraries.size();
        int n = factories + w + l + 2; // calculate the total number of nodes
        int[][] graph = new int[n][n]; // make adjacency matrix
        buildGraph( graph, trucks, n, factories, w );

        totalBooks = edmondsKarp(graph, n - 1); // calculate the maximum flow

        return totalBooks;
    }

    /**
     * Build the graph with the given data. The graph is represented as an adjacency matrix.
     * @param graph the adjacency matrix
     * @param trucks the list of trucks
     * @param n the number of nodes
     * @param f the number of factories
     * @param w the number of warehouses
     */
    private static void buildGraph(int[][] graph, List<Truck> trucks, int n, int f, int w )
    {
        for ( int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MIN_VALUE);
            graph[i][i] = 0;
            if ( i < f + 1 ) {
                graph[0][i] = 0; // connect the source to the factories
            }
            if ( i > f + w + 1 ) {
                graph[i][n - 1] = 0; // connect the warehouses to the sink
            }
        }

        for (Truck truck : trucks) {
            int start = convertToIndex( truck.getStartPoint(), f, w );
            int end = convertToIndex( truck.getEndPoint(), f, w );
            List<String> middlePoints = truck.getMiddlePoints();
            if ( middlePoints.isEmpty() ) {
                graph[start][end] = truck.getCapacity(); // add the capacity of the truck
                continue;
            }
            int prev = start;
            for (String middlePoint : middlePoints) {
                int middle = convertToIndex( middlePoint, f, w );
                graph[prev][middle] = truck.getCapacity(); // add the capacity of the truck
                prev = middle;
            }
            graph[prev][end] = truck.getCapacity(); // add the capacity of the truck
        }
    }

    /**
     * Convert the string to the index of the node in the graph.
     * @param s the string to convert
     * @param f the number of factories
     * @param w the number of warehouses
     * @return the index of the node in the graph
     */
    private static int convertToIndex( String s, int f, int w )
    {
        int index = Integer.parseInt(String.valueOf(s.charAt(1)));
        if ( s.charAt(0) == 'F' ) {
            return index;
        }
        if ( s.charAt(0) == 'W' ) {
            return f + index;
        }
        return f + w + index;
    }

    /**
     * Implementation of the Edmonds-Karp algorithm to calculate the maximum flow in a graph.
     *
     * @param graph the adjacency matrix
     * @param sink  the sink node
     * @return the maximum flow
     */
    private static int edmondsKarp(int[][] graph, int sink) {
        int u, v;
        int n = graph.length;
        int[][] residualGraph = new int[n][n];

        for (u = 0; u < n; u++) {
            for (v = 0; v < n; v++) {
                residualGraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[n];
        int maxFlow = 0;

        while ( bfs(residualGraph, sink, parent) ) {
            int pathFlow = Integer.MAX_VALUE;
            for ( v = sink; v != 0; v = parent[v] ) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (v = sink; v != 0; v = parent[v]) {
                u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    /**
     * Bfs implementation to search path to sink in residual graph.
     *
     * @param residualGraph the residual graph
     * @param sink          the sink node
     * @param parent        the parent array
     * @return true if there is a path to the sink, false otherwise
     */
    private static boolean bfs(int[][] residualGraph, int sink, int[] parent) {
        boolean[] visited = new boolean[residualGraph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        parent[0] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < residualGraph.length; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    if (v == sink) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }

    /**
     * Main method to test the implementation of the classes.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        int factories = 0;
        List<Warehouse> warehouses = new ArrayList<>();
        List<Integer> libraries = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();

        // Ejemplo de datos
        factories = 2;
        warehouses.add(new Warehouse(10));
        warehouses.add(new Warehouse(10));
        libraries.add(0);
        libraries.add(0);
        libraries.add(0);
        trucks.add(new Truck(10, "F1", new ArrayList<>(List.of("W1")), "L1"));
        trucks.add(new Truck(15, "F1", "L1"));
        trucks.add(new Truck(20, "F2", new ArrayList<>(List.of("W2")), "L2"));
        trucks.add(new Truck(30, "F2", new ArrayList<>(List.of("W1")), "L3"));
        System.out.println(getMaximumBooks(factories, warehouses, libraries, trucks));
    }
}
