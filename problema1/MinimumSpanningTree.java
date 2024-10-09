package problema1;

import java.util.List;

/**
 * Minimum Spanning Tree interface.
 *
 * @author Adrian Velasquez
 */
public interface MinimumSpanningTree
{
    /**
     * Create a minimum spanning tree from the given graph.
     *
     * @param graph The graph to create the minimum spanning tree from.
     * @return List<WeightedDirectedEdge> The minimum spanning tree.
     */
    List<WeightedDirectedEdge> createMST( List<WeightedDirectedEdge> graph );
}
