package problema1;

/**
 * Weighted directed edge class.
 *
 * @author Adrian Velasquez
 */
public class WeightedDirectedEdge
{
    private final int source;
    private final int destination;
    private final int weight;

    /**
     * Create a new weighted directed edge.
     * @param source The source node.
     * @param destination The destination node.
     * @param weight The weight of the edge.
     */
    public WeightedDirectedEdge(int source, int destination, int weight )
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Get the source node.
     * @return The source node.
     */
    public int getSource()
    {
        return source;
    }

    /**
     * Get the destination node.
     * @return The destination node.
     */
    public int getDestination()
    {
        return destination;
    }

    /**
     * Get the weight of the edge.
     * @return The weight of the edge.
     */
    public int getWeight()
    {
        return weight;
    }

}
