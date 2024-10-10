package problema1;

import java.util.*;
import java.lang.*;

/**
 * Floyd-Warshall implementation for the Minimum Distance problem.
 *
 * @author Adrian Velasquez
 */
public class FloydWarshallMinimumDistanceMatrix implements MinimumDistanceMatrix
{
    private static final int INFINITY = Integer.MAX_VALUE;

    @Override
    public int[][] createMinimumDistanceMatrix(List<WeightedDirectedEdge> graph )
    {
        // Setup initial adjacency matrix
        int numVertices = findNumberOfVertices( graph );
        int[][] matrix = new int[ numVertices ][ numVertices ];
        for ( int i = 0; i < numVertices; i++ )
        {
            Arrays.fill( matrix[i], INFINITY ); // set the matrix as infinity
            matrix[i][i] = 0; // the "distance" from a vertex to itself is 0
        }
        for ( WeightedDirectedEdge edge : graph )
        {
            matrix[ edge.getSource() ][ edge.getDestination() ] = edge.getWeight();
        }

        floydWarshall( matrix, numVertices );

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
     * Floyd-Warshall algorithm to find the minimum distance matrix for the given graph.
     * @param matrix The matrix to find the shortest path
     * @param numVertices The number of vertices in the graph
     */
    private void floydWarshall( int[][] matrix, int numVertices )
    {
        for (int k = 0; k < numVertices; k++)
        {
            // Pick all vertices as source one by one
            for (int i = 0; i < numVertices; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (int j = 0; j < numVertices; j++)
                {
                    // If vertex k is on the shortest path
                    // from i to j, then update the value of
                    // matrix[i][j]
                    if ( matrix[i][k] == INFINITY || matrix[k][j] == INFINITY ) continue; // skip if no path
                    if ( matrix[i][k] + matrix[k][j] < matrix[i][j] ) matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
    }
}
