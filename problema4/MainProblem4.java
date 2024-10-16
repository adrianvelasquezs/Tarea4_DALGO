package problema4;

import java.util.*;

/**
 * Main class for problem 4.
 * This class is used to test the implementation of the classes in the problem 4.
 *
 * @author Adrian Velasquez 202222737
 */
public class MainProblem4 {

    private static int getMaximumBooks( List<Integer> factories, List<Warehouse> warehouses, List<Library> libraries,
                                       List<Truck> trucks) {
        int totalBooks = 0;

        int f = factories.size();
        int w = warehouses.size();
        int l = libraries.size();
        int n = f + w + l; // calculate the total number of nodes
        int[][] graph = new int[n][n]; // make adjacency matrix
        buildGraph(graph, trucks, n, f, w, l);



        return totalBooks;
    }

    private static void buildGraph(int[][] graph, List<Truck> trucks, int n, int f, int w, int l)
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
        }
    }

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

    public static void main(String[] args) {
        List<Integer> factories = new ArrayList<>();
        List<Library> libraries = new ArrayList<>();
        List<Warehouse> warehouses = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();

        // Ejemplo de datos
        factories.add(1);
        factories.add(2);
        libraries.add(new Library());
        libraries.add(new Library());
        warehouses.add(new Warehouse(10));
        warehouses.add(new Warehouse(10));
        trucks.add(new Truck(10, "F1", new ArrayList<>(List.of("W1")), "L1"));
        trucks.add(new Truck(10, "F1", "L1"));
        trucks.add(new Truck(10, "F2", new ArrayList<>(List.of("W2")), "L2"));
        trucks.add(new Truck(10, "F2", new ArrayList<>(List.of("W1")), "L1"));
        System.out.println(getMaximumBooks(factories, warehouses, libraries, trucks));
    }
}
