package problema1;

import java.util.*;

/**
 * Bellman Ford dijkstra implementation for the Minimum Spanning Tree problem.
 *
 * @author Adrian Velasquez
 */
public class BellmanFordAdjacencyMatrix implements AdjacencyMatrix
{
    private static final int INFINITY = Integer.MAX_VALUE;

    @Override
    public int[][] createAdjacencyMatrix(List<WeightedDirectedEdge> graph )
    {
        // set up the matrix
        int numVertices = findNumberOfVertices( graph );
        int lastVertex = numVertices - 1;
        int[][] matrix = new int[ lastVertex+1 ][ lastVertex+1 ];

        // build matrix, find the shortest path from the startVertex to all other vertices
        // only need to find the shortest path from i to j once
        int i = 0;
        while( i < numVertices )
        {
            int j = i;
            while ( i<=j && j < numVertices )
            {
                if ( i == j ) matrix[ i ][ j ] = 0; // the "distance" from a vertex to itself is 0
                else
                {
                    matrix[ i ][ j ] = bellmanFord( graph, i, j, numVertices ); // find the shortest path from i to j
                    matrix[ j ][ i ] = bellmanFord( graph, j, i, numVertices ); // the shortest path from i to j is the same as from j to i
                }
                j++;
            }
            i++;
        }
        return matrix;
    }

    @Override
    public int findNumberOfVertices( List<WeightedDirectedEdge> graph )
    {
        int numVertices = 0;
        for ( WeightedDirectedEdge edge : graph )
        {
            numVertices = Math.max( numVertices, Math.max( edge.getSource(), edge.getDestination() ) );
        }
        return numVertices + 1;
    }

    /**
     * Bellman Ford algorithm to find the shortest path from startVertex to endVertex in the graph.
     * @param graph The graph to find the shortest path
     * @param startVertex The vertex to start the path
     * @param endVertex The vertex to end the path
     * @param numVertices The number of vertices in the graph
     * @return The shortest path from startVertex to endVertex
     */
    private int bellmanFord( List<WeightedDirectedEdge> graph, int startVertex, int endVertex, int numVertices )
    {
        int[] dist = new int[numVertices];
        Arrays.fill(dist, INFINITY);
        dist[startVertex] = 0;

        // Relax all edges |V| - 1 times
        for (int i = 1; i < numVertices; i++)
        {
            for (WeightedDirectedEdge edge : graph)
            {
                int u = edge.getSource();
                int v = edge.getDestination();
                int weight = edge.getWeight();
                if (dist[u] != INFINITY && dist[u] + weight < dist[v]) dist[v] = dist[u] + weight;
            }
        }

        // Check for negative-weight cycles
        for ( WeightedDirectedEdge edge : graph )
        {
            int u = edge.getSource();
            int v = edge.getDestination();
            int weight = edge.getWeight();
            if (dist[u] != INFINITY && dist[u] + weight < dist[v])
            {
                throw new IllegalArgumentException("Graph contains a negative-weight cycle");
            }
        }

        return dist[endVertex];
    }
}
