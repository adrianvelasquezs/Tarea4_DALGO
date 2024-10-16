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
        int n = factories + w + l; // calculate the total number of nodes
        int[][] graph = new int[n][n]; // make adjacency matrix
        buildGraph( graph, trucks, n, factories, w );



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
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
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
        int index = Integer.parseInt(String.valueOf(s.charAt(1))) - 1;
        if ( s.charAt(0) == 'F' ) {
            return index;
        }
        if ( s.charAt(0) == 'W' ) {
            return f + index;
        }
        return f + w + index;
    }

    /**
     * Main method to test the implementation of the classes.
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
