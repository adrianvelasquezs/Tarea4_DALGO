package problema1;

import java.util.List;

/**
 * Minimum Distance Matrix interface.
 *
 * @author Adrian Velasquez
 */
public interface MinimumDistanceMatrix
{
    /**
     * Creates the adjacency matrix for the graph.
     * @param graph The graph to create the adjacency matrix
     * @return The adjacency matrix for the graph
     */
    int[][] createMinimumDistanceMatrix(List<WeightedDirectedEdge> graph );

    /**
     * Finds the number of vertices in the graph.
     * @param graph The graph to find the number of vertices
     * @return The number of vertices in the graph
     */
    int findNumberOfVertices( List<WeightedDirectedEdge> graph );
}
