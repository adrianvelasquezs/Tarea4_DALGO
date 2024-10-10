package problema1;

import java.util.*;

/**
 * Dijkstra implementation for the Minimum Spanning Tree problem.
 *
 * @author Adrian Velasquez
 */
public class DijkstraAdjacencyMatrix implements AdjacencyMatrix
{
    private static final int INFINITY = Integer.MAX_VALUE;

    @Override
    public int[][] createAdjacencyMatrix( List<WeightedDirectedEdge> graph )
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
                    matrix[ i ][ j ] = dijkstra( graph, i, j, numVertices ); // find the shortest path from i to j
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

    /**
     * Dijkstra algorithm to find the shortest path from startVertex to endVertex in the graph.
     * @param graph The graph to find the shortest path
     * @param startVertex The vertex to start the path
     * @param endVertex The vertex to end the path
     * @param numVertices The number of vertices in the graph
     * @return The shortest path from startVertex to endVertex
     */
    public int dijkstra(List<WeightedDirectedEdge> graph, int startVertex, int endVertex, int numVertices )
    {
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        PriorityQueue<WeightedDirectedEdge> pq = new PriorityQueue<>(Comparator.comparingInt(WeightedDirectedEdge::getWeight));

        Arrays.fill(dist, INFINITY);
        dist[startVertex] = 0;
        pq.add( new WeightedDirectedEdge(startVertex, startVertex, 0 ));

        while (!pq.isEmpty())
        {
            WeightedDirectedEdge edge = pq.poll();
            int u = edge.getDestination();

            if (visited[u]) continue; // skip if already visited
            visited[u] = true;

            for (WeightedDirectedEdge e : graph)
            {
                if ( e.getSource() == u )
                {
                    int v = e.getDestination();
                    int weight = e.getWeight();

                    if ( !visited[v] && dist[u] + weight < dist[v] )
                    {
                        dist[v] = dist[u] + weight;
                        pq.add(new WeightedDirectedEdge(u, v, dist[v]));
                    }
                }
            }
        }

        return dist[ endVertex ];
    }
}
