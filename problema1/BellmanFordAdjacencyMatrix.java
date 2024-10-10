package problema1;

import java.util.List;

/**
 * Bellman Ford dijkstra implementation for the Minimum Spanning Tree problem.
 *
 * @author Adrian Velasquez
 */
public class BellmanFordAdjacencyMatrix implements AdjacencyMatrix
{
    @Override
    public int[][] createAdjacencyMatrix(List<WeightedDirectedEdge> graph )
    {
        // TODO implement Bellman Ford dijkstra
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
                    matrix[ j ][ i ] = matrix[ i ][ j ]; // the shortest path from i to j is the same as from j to i
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

    private int bellmanFord( List<WeightedDirectedEdge> graph, int i, int j, int numVertices )
    {
        // TODO implement Bellman Ford

        return -1;
    }
}
