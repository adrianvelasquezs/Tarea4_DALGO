package problema4;

import java.util.*;
import java.io.*;

/**
 * Main class for problem 4.
 * This class is used to test the implementation of the classes in the problem 4.
 *
 * @author Adrian Velasquez 202222737
 */
public class MainProblem4 {

    /**
     * Load the data from the files and calculate the maximum number of books that can be transported.
     *
     * @param trucksFile     the file with the trucks data
     * @param warehousesFile the file with the warehouses data
     * @return the maximum number of books that can be transported
     * @throws IOException if there is an error reading the files or if the data provided is not consistent
     */
    private static int loadMaximumBooks( String trucksFile, String warehousesFile  ) throws IOException
    {
        int factories = 0;
        List<Warehouse> warehouses = new ArrayList<>();
        List<Integer> libraries = new ArrayList<>();
        List<Truck> trucks = new ArrayList<>();

        // =============================================================================================================
        // Load trucks, warehouses and factories
        FileReader fReader = new FileReader( trucksFile );
        BufferedReader inF = new BufferedReader(fReader);
        String line = inF.readLine();
        while (line != null) {
            String[] data = line.split(" ");

            int capacity = Integer.parseInt(data[0]);
            String first = data[1];
            List<String> middlePoints = new ArrayList<>();
            String last = data[data.length - 1];

            if ( data.length > 2 ){
                middlePoints.addAll(Arrays.asList(data).subList(2, data.length - 1));
                Truck t = new Truck(capacity, first, middlePoints, last);
                trucks.add( t );
            } else {
                Truck t = new Truck(capacity, first, last);
                trucks.add( t );
            }
            // Check if the factories, warehouses and libraries are in the data
            // Update the data structures accordingly
            int index;
            index = Integer.parseInt(String.valueOf(first.charAt(1)));
            if ( first.charAt(0) == 'F' && index > factories )
                factories = index;
            index= Integer.parseInt(String.valueOf(last.charAt(1)));
            if ( last.charAt(0) == 'L' && index > libraries.size() )
                libraries.add(0);
            for ( String point : middlePoints )
            {
                char firstChar = point.charAt(0);
                index = Integer.parseInt(String.valueOf(point.charAt(1)));
                switch ( firstChar )
                {
                    case 'F':
                        factories = Math.max(factories, index);
                        break;
                    case 'W':
                        if ( index > warehouses.size() ) warehouses.add(new Warehouse(0));
                        break;
                    case 'L':
                        if ( index > libraries.size() ) libraries.add(0);
                        break;
                }
            }
            line = inF.readLine();
        }

        // =============================================================================================================
        // Load warehouses capacities
        FileReader wReader = new FileReader( warehousesFile );
        BufferedReader inW = new BufferedReader(wReader);
        line = inW.readLine();
        int capacity = Integer.parseInt(line);
        int i = 0;
        while (line != null) {
            capacity = Integer.parseInt(line);
            warehouses.get(i).setCapacity(capacity);
            line = inW.readLine();
            i++;
        }

        return getMaximumBooks(factories, warehouses, libraries, trucks);
    }

    /**
     * Calculate the maximum number of books that can be transported.
     *
     * @param factories   the number of factories
     * @param warehouses  the list of warehouses
     * @param libraries   the list of libraries
     * @param trucks      the list of trucks
     * @return the maximum number of books that can be transported
     */
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
            if ( i <= f + 1 ) {
                graph[0][i] = Integer.MAX_VALUE; // connect the source to the factories
            }
            if ( i > f + w + 1 ) {
                graph[i][n - 1] = Integer.MAX_VALUE; // connect the warehouses to the sink
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
     * @param args the command line arguments
     *             args[0] the file with the trucks data
     *             args[1] the file with the warehouses data
     */
    public static void main(String[] args) {
        try {
            System.out.println(loadMaximumBooks( args[0], args[1] ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
