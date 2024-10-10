package problema1;

import java.util.List;

/**
 * Floyd-Warshall dijkstra implementation for the Minimum Spanning Tree problem.
 *
 * @author Adrian Velasquez
 */
public class FloydWarshallAdjacencyMatrix implements AdjacencyMatrix
{
    private static final int INFINITY = Integer.MAX_VALUE;

    @Override
    public int[][] createAdjacencyMatrix(List<WeightedDirectedEdge> graph )
    {
        // TODO Implement Floyd-Warshall

        int[][] matrix = new int[graph.size()][3];

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
}
